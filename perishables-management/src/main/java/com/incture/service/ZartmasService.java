package com.incture.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.incture.dos.Zartmas;
import com.incture.dos.Zcount;
import com.incture.dos.Zinventory;
import com.incture.dos.Zvend;
import com.incture.payload.CasefillUpPayload;
import com.incture.payload.CountPayload;
import com.incture.payload.RepackPayload;
import com.incture.repository.ZartmasRepository;
import com.incture.repository.ZcountRepository;
import com.incture.repository.ZinventoryRepository;
import com.incture.repository.ZvendRepository;
import com.incture.response.CategoryDetailsResponse;
import com.incture.response.CategoryResponse;
import com.incture.response.ItemDetailsResponse;
import com.incture.response.ItemResponse;
import com.incture.response.ResponseJson;
import com.incture.utils.PersishableManagementConstants;

@Service
public class ZartmasService 
{
	@Autowired
	private ZartmasRepository repo;

	@Autowired 
	private ZinventoryRepository invRepo;
	
	@Autowired
	private ZcountRepository countRepo;
	
	private static int periodCounter = 1;
	
	@Autowired 
	private ZvendRepository zvendRepo;
	
	
	   @Autowired
	   EntityManager entityManager;
	   
	public List<Zartmas> listAll() 
	{
		return repo.findAll();
	}
	
	
	public ResponseEntity<?>  saveOrUpdate(Zartmas zartmas) {
		// TODO Auto-generated method stub
		repo.saveAndFlush(zartmas);
		
		
		return new ResponseEntity<String>("SuccessFully created ",HttpStatus.OK);
	}
	
	public  Optional<Zartmas> findById(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
	
	
	public String deleteById(String id) {
		
	           repo.deleteById(id);
				return "deleted";
	}
	
	// count service 
	//item details
    @SuppressWarnings("deprecation")
	public ResponseEntity<?> findProductDetailsAndUpdateZcount(CountPayload details) throws ParseException {//String articleId,String plant,String storageLocation,String period,Date date,String soldQuantityInLastPeriod){
    	
    	// find the articale or product details based on product id 
    	String articleId=details.getArticleNumber();
        String plant=details.getPlant();
        String storageLocation=details.getStorageLocation();
        String date=details.getDate();
        String period=details.getPeriod();
        
        
    Optional<Zartmas> zartmas  =  repo.findById(articleId);
    	 
    	System.err.println("zartmas "+zartmas );
    	 if(zartmas.isPresent()) {
    		 List<Zcount> listOfCount = new ArrayList<Zcount>();
    		 
    		 // check data present in zinventory table for the article
    		 Zinventory zinventory = invRepo.findByArticleNumberAndPlantAndStorageLoc(articleId, plant, storageLocation);
    		 // if present than
    		 java.util.Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
    		 
    		 Zcount countCheckForScannedQty =  countRepo.findByArticleNumberAndPlantAndSortedDate(articleId,plant, period, parsedDate);
    		
    		 System.err.println("countCheckForScannedQty "+countCheckForScannedQty);
    		 
    		 if(zinventory != null ){	
    			 
    			 System.err.println("zinventory "+zinventory);
    				
    					

    	    			 BigDecimal weightAfterCount = zinventory.getWeightPerUnit().multiply(new BigDecimal(details.getSoldQuantityInLastPeriod())).subtract(zinventory.getTotWeight());
    	    			 zinventory.setTotWeight(weightAfterCount);

    	    			 
    	    			 BigDecimal salk3 = weightAfterCount.multiply( zinventory.getStndPrice());
    	    			 
    	    			 zinventory.setValTotValuatedStck(salk3);
    	    			 zinventory.setTotValuatedStck(zinventory.getTotValuatedStck().subtract(new BigDecimal(details.getSoldQuantityInLastPeriod())));
    	    Zinventory  updatedZinventory = new Zinventory();
    	    updatedZinventory   =invRepo.save(zinventory);
    	    			 
    			 // create a reccord in ZACTION table 
    			 Zcount count = new Zcount();
    		
    			 count.setArticleNumber(articleId);
    			 count.setPlant(plant);
    			 count.setStorageLocation(storageLocation);
    			 count.setDate(parsedDate);
    			 count.setScannedDate(new Date());
    			 count.setPeriod(period);
    			 LocalTime  localTime = LocalTime.now();
    			 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
    			 
    			
    	     	 count.setTime(localTime.format(dateTimeFormatter));
    			 System.out.println("hi");
    			 if(count.getPeriod()!=null){
    			 if(count.getPeriod().contains("P1")||count.getPeriod().contains("P2")||count.getPeriod().contains("P3")||count.getPeriod().contains("P4")){
    			 count.setPeak("X");
    			 }else {
    				 count.setPeak("0");
    			 }}
    			 count.setOptimumQty(new BigDecimal("100.00"));
    			 count.setSoldQty(new BigDecimal(details.getSoldQuantityInLastPeriod()));
    			 count.setBeginningBOHQty(updatedZinventory.getTotValuatedStck());
    			 if(countCheckForScannedQty!=null ){
    			 count.setScannedQty(countCheckForScannedQty.getScannedQty().add(new BigDecimal("1")));
    			 }else {
    				 count.setScannedQty(new BigDecimal("1")); 
    			 }
    			 count.setForecastQty(new BigDecimal("5.00"));
    			int projectedBOHQty = count.getScannedQty().intValue()- count.getForecastQty().intValue();
    			 count.setProjectedBOHQty(new BigDecimal(projectedBOHQty));
    			 int projectedReqQunatity = count.getOptimumQty().intValue()-count.getProjectedBOHQty().intValue();
    			 count.setProjectedReqQty(new BigDecimal(projectedReqQunatity));
    			 count.setReorderPt(updatedZinventory.getMinSafetyStck());
    			 count.setUnitQty(updatedZinventory.getUnitQty());
    			 if(projectedReqQunatity < updatedZinventory.getMinSafetyStck().intValue()){
    			 count.setReplenIndicator("0");
    			 }else {
    				 count.setReplenIndicator("X");
    			 }
    			 countRepo.save(count);
    			 System.err.println("count "+count);
    				 ResponseJson RJson=new ResponseJson();
     		    	RJson.setMessage("Success !");
     		    	RJson.setCount(count);
    			 return new ResponseEntity<ResponseJson>(RJson, HttpStatus.OK);
    		 }else { 
    			 ResponseJson RJson=new ResponseJson();
    		    	RJson.setMessage("Not found !!");
    		    	return new ResponseEntity<ResponseJson>( RJson ,HttpStatus.OK);
    		 }
    	 }else {
    		 ResponseJson RJson=new ResponseJson();
		    	RJson.setMessage("Article or Product not found in table ");
    		 //check if the article is not there in the table , so return no article 
    		 return new ResponseEntity<>(RJson,HttpStatus.OK); 
    	 }
    	 
    	 //return new ResponseEntity<List<Zinventory>>(zinventory,HttpStatus.OK);
    }
    
    
public void scheduledUpdateZcount(){
	
	
	// find all the details of todays 
	List<Zcount> listOfCount = new ArrayList<Zcount>();

	List<Zinventory> listOfZinventory = null;
			//invRepo.findAllByOrderByAtricleDateDsc();
	 if(listOfZinventory != null || !listOfZinventory.isEmpty() ){
		 
			for(int i=0 ; i<listOfZinventory.size();i++) {
		 // create a reccord in ZACTION table 
		 Zcount count = new Zcount();
	
		 count.setArticleNumber(listOfZinventory.get(i).getArticleNumber());
		 count.setPlant(listOfZinventory.get(i).getPlant());
		 count.setStorageLocation(listOfZinventory.get(i).getStorageLoc());
		 //java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date.toString());
		// count.setDate();
		 count.setPeriod("P"+setPeriodBasedOnScannedDate(new Date()));
		 LocalTime  localTime = LocalTime.now();
		 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
		 
		
  	 count.setTime(localTime.format(dateTimeFormatter));
		 System.out.println("hi");
		 if(count.getPeriod().contains("P1")||count.getPeriod().contains("P2")||count.getPeriod().contains("P3")||count.getPeriod().contains("P4")){
		 count.setPeak("X");
		 }else {
			 count.setPeak("0");
		 }
		 count.setOptimumQty(new BigDecimal("500.00"));
		 count.setSoldQty(new BigDecimal("100.00"));
		 count.setBeginningBOHQty(listOfZinventory.get(0).getTotValuatedStck());
		 count.setScannedQty(new BigDecimal("1"));
		 count.setForecastQty(new BigDecimal("100.00"));
		int projectedBOHQty = count.getScannedQty().intValue() - count.getForecastQty().intValue();
		 count.setProjectedBOHQty(new BigDecimal(projectedBOHQty));
		 int projectedReqQunatity = count.getOptimumQty().intValue()-count.getProjectedBOHQty().intValue();
		 count.setProjectedReqQty(new BigDecimal(projectedReqQunatity));
		 count.setReorderPt(listOfZinventory.get(0).getMinSafetyStck());
		 count.setReplenIndicator("X");
		 countRepo.save(count);
		 listOfCount.add(count);
			}
		 
    	}
    }
    
    
    
    
	
    public static int setPeriodBasedOnScannedDate(Date scannedDate){
    	
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		String formattedDate = dateFormat.format(scannedDate).toString();
		System.err.println(formattedDate);
	 System.err.println("scannedDate "+scannedDate);
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
	System.err.println(localTime.format(dateTimeFormatter).substring(6));
		String timePeriod = localTime.format(dateTimeFormatter).substring(6);
		    String hours   = localTime.format(dateTimeFormatter).substring(0,2);
		System.err.println("hours "+hours);
		int currentHour = Integer.parseInt(hours);
    	 //if scanned date is more than 6 than see the differenece in the value. 
   if(timePeriod.equals("AM")){
	   if(currentHour==PersishableManagementConstants.initialPointOfPeriod){
		   periodCounter = 1;
		 return  PersishableManagementConstants.initialPeriodcounter;
	   }
	   else {
		  return ++periodCounter; 
	   }
   }else {
    	return ++periodCounter;
    }
}
    
    //zcount table 
   public ResponseEntity<?> caseFillUp(CasefillUpPayload details)//String articleNumber , String plant ,String storageLocation,String totalWeight){
   {
	   String articleNumber=details.getArticleNumber(); 
	   String plant =details.getPlant();
	   String storageLocation=details.getStorageLocation();
	   Zinventory zInventory = invRepo.findByArticleNumberAndPlantAndStorageLoc(articleNumber, plant, storageLocation);
	   List <Zcount> zcount  = countRepo.findByarticleNumber(articleNumber);
	     if(zcount != null && !zcount.isEmpty()){
	    	 
	    	 zcount.stream().forEach(c->{
	    		 if(c.getPeriod().equals("P1")){
	    			 c.setReplenRequiredQuantity(c.getProjectedReqQty().intValue()); 	
	    		 }else {
	    			if(c.getReplenIndicator().equals("X")){
	    				 zInventory.setTotValuatedStck(c.getProjectedReqQty());
	    				 c.setReplenRequiredQuantity(c.getProjectedReqQty().intValue());
	    			}
	    		 }
	    	 });
	    	 countRepo.saveAll(zcount);
	      		 BigDecimal totalvaluatedstck=zInventory.getTotValuatedStck();	
	      		zInventory.setTotWeight(zInventory.getWeightPerUnit().multiply(totalvaluatedstck)); //change weight
	 	        BigDecimal newweight=zInventory.getTotWeight();
	 	      //change total valuated stock
	 	    	BigDecimal stndprice=zInventory.getStndPrice();
	 	    	BigDecimal Totalweight=zInventory.getTotWeight();
	 	    	zInventory.setValTotValuatedStck(stndprice.multiply(Totalweight));
	      	  
	    	  
	    	   invRepo.save(zInventory);
	    	   ResponseJson json = new ResponseJson();
	    	   
	    	   json.setMessage("Success");
	     return new ResponseEntity<ResponseJson>(json,HttpStatus.OK);
	     }	   
	     ResponseJson json = new ResponseJson();
  	   
  	   json.setMessage("Article Number not found in Zcount");
	   return new ResponseEntity<ResponseJson>(json,HttpStatus.OK);
   }
   
   

   public ResponseEntity<?> repackArticle(RepackPayload details)
   {
   String articleNumber=details.getArticleNumber();
   String plant=details.getPlant();
   String storageLocation=details.getStorageLoc();
    String weight=details.getTotWeight().toString();
    
    Zinventory inventoryList=  invRepo.findByArticleNumberAndPlantAndStorageLoc(articleNumber, plant, storageLocation);
    if(inventoryList!= null)
    {
    	
    		//i.setTotWeight(new BigDecimal(weight));
    	 	BigDecimal stndprice=inventoryList.getStndPrice();
	    	BigDecimal totalweightToBeSubFromOriginalWeight =inventoryList.getWeightPerUnit().subtract(new BigDecimal(weight));
	    	BigDecimal totalWeight = inventoryList.getTotWeight().subtract(totalweightToBeSubFromOriginalWeight);
	    	inventoryList.setTotWeight(totalWeight);
	    	inventoryList.setValTotValuatedStck(stndprice.multiply(totalWeight));
	    	
	    	System.out.println("done!!");
    
    	invRepo.save(inventoryList);
	    
	    	System.err.println("check end ");
	     //return new ResponseEntity<String>("Success in update of inventory upon repack",HttpStatus.OK);
	    	ResponseJson RJson=new ResponseJson();
	    	RJson.setMessage("Success");
	    	
	     	invRepo.save(inventoryList);
	    	return new ResponseEntity(RJson, HttpStatus.OK);
	    }else {
	    	
	    	ResponseJson RJson=new ResponseJson();
	    	RJson.setMessage("Not found !!");
	    	return new ResponseEntity<ResponseJson>(HttpStatus.OK);
	    	//return new ResponseEntity<String>("Not found Article in inventory" , HttpStatus.OK);
	    	
	    }//loose wt
	    //update total weight
   }
   
   @SuppressWarnings("unchecked")
@Transactional
     public ResponseEntity<ResponseJson> destroyDiscardReturnArticle(RepackPayload details){//String articleNumber,String plant, String storageLocation , String weight){	   
	   	 
	   String articleNumber=details.getArticleNumber();
	   String plant=details.getPlant();
	   String storageLocation=details.getStorageLoc();
	    String weight=details.getTotWeight().toString();
	   
	   Zinventory inventoryList=  invRepo.findByArticleNumberAndPlantAndStorageLoc(articleNumber, plant, storageLocation);
	   
	   if(inventoryList!= null )
	    {
	    	
	    	BigDecimal totalvaluatedstck=inventoryList.getTotValuatedStck();	
	       //change weight
	        BigDecimal newweight=inventoryList.getTotWeight().subtract( new BigDecimal(weight));
	        inventoryList.setTotWeight(newweight);
	        BigDecimal TotalValuatedStock=totalvaluatedstck.subtract(new BigDecimal(1));
	        inventoryList.setTotValuatedStck(TotalValuatedStock);//change total valuated stock
	    	BigDecimal stndprice=inventoryList.getStndPrice();
	    	BigDecimal Totalweight=inventoryList.getTotWeight();
	    	//BigDecimal valTotValuatedstock=stndprice.multiply(Totalweight);
	    	inventoryList.setValTotValuatedStck(stndprice.multiply(Totalweight));	 	   
	    	System.out.println("b");
	    
	    	
	    	
	    	invRepo.save(inventoryList);
	    	ResponseJson RJson=new ResponseJson();
	    	RJson.setMessage("Success");
	    	
	    	return new ResponseEntity(RJson, HttpStatus.OK);
	    	
	    }else {
	    	ResponseJson RJson=new ResponseJson();
	    	RJson.setMessage("Not found !!");
	    	return new ResponseEntity<ResponseJson>(HttpStatus.OK);
	    }   
  }   
   
   
   
   
  
  
   //categorywise display articles
   public CategoryResponse display(String category) 
  	{
  		CategoryResponse categoryresponse=new CategoryResponse();
  		List<CategoryDetailsResponse> categorydetailsresponses=null;
  		CategoryDetailsResponse categorydetailsresponse=null;
  		
  		String hql = "SELECT W.articleNumber,W.materialGroupDesc, W.materialDesc, T.minSafetyStck,T.totValuatedStck "
  				+ "From com.incture.dos.Zartmas W  inner join com.incture.dos.Zinventory T on W.articleNumber = T.articleNumber where W.materialGroupDesc = : category";
  		
  		
  		
  		@SuppressWarnings("rawtypes")
  		Query query = entityManager.createQuery(hql);
  		 query.setParameter("category", category);
  		@SuppressWarnings({ "deprecation", "unchecked" })
  		List <Object[]>results = ((org.hibernate.query.Query) query).list();
  	
  		
  		categorydetailsresponses=new ArrayList();
  		
  		
  		for(Object[] obj :results)
  		{
  		    categorydetailsresponse=new CategoryDetailsResponse();
  			categorydetailsresponse.setArticleNumber(obj[0].toString());
  			categorydetailsresponse.setMaterialGroupDesc(obj[1].toString());
  			categorydetailsresponse.setMaterialDesc(obj[2].toString());
  			categorydetailsresponse.setMinSafetyStck(obj[3].toString());
  			categorydetailsresponse.setTotValuatedStck(obj[4].toString());
  			 BigDecimal minSafetyStck = (BigDecimal)obj[3];
  			 BigDecimal  totValuatedStck = (BigDecimal)obj[4];
  			 
  			 int totValuatedStckInteger = totValuatedStck.intValue();
  		     int minSafetyStckValue = minSafetyStck.intValue();
  			 
  			 if(totValuatedStckInteger>=minSafetyStckValue){
  				categorydetailsresponse.setCriticalStckQtyCheck(false);
  				categorydetailsresponse.setAvailableStckQtyCheck(true);
  			 }else {
  				categorydetailsresponse.setCriticalStckQtyCheck(true);
  				categorydetailsresponse.setAvailableStckQtyCheck(false);
  			 }
  			
  			
  			categorydetailsresponses.add(categorydetailsresponse);
  		}
  	
  		categoryresponse.setDetails(categorydetailsresponses);
  		return categoryresponse;
  	
  	} 
   
   
   
   //item details
   public ItemDetailsResponse getItemDetails(String articlenumber) 
	{
		ItemResponse itemresponse=new ItemResponse();
		List<ItemDetailsResponse> itemdetailsresponses=null;
		ItemDetailsResponse itemdetailsresponse=null;
		
		String hql = "SELECT W.articleNumber,W.materialGroupDesc, W.materialDesc, T.minSafetyStck,T.totValuatedStck ,T.totWeight, T.unitWeight ,T.unitQty ,T.unitCurrency , Z.vendorAccNumber ,T.valTotValuatedStck "
				+ "From com.incture.dos.Zartmas W ,com.incture.dos.Zinventory T , com.incture.dos.Zvend Z where W.articleNumber = T.articleNumber  AND  Z.articleNumber = W.articleNumber AND W.articleNumber = : articlenumber ";
			
		@SuppressWarnings("rawtypes")
		Query query = entityManager.createQuery(hql);
		 query.setParameter("articlenumber", articlenumber);
		@SuppressWarnings({ "deprecation", "unchecked" })
		List <Object[]>results = ((org.hibernate.query.Query) query).list();
		if(results!=null && !results.isEmpty()){
		itemdetailsresponses=new ArrayList();
		
		
		for(Object[] obj :results)
		{
		
		    itemdetailsresponse=new ItemDetailsResponse();
			//Object[] fields = (Object[]) obj;
			itemdetailsresponse.setArticleNumber(obj[0].toString());
			itemdetailsresponse.setMaterialGroupDesc(obj[1].toString());
			BigDecimal minstck=(BigDecimal) obj[3];
			BigDecimal totalvaluatedstck=(BigDecimal) obj[4];
			itemdetailsresponse.setMinSafetyStck(minstck);
			itemdetailsresponse.setTotValuatedStck(totalvaluatedstck);
			itemdetailsresponse.setVendorAccNumber(obj[9].toString());
			itemdetailsresponse.setMaterialDesc(obj[2].toString());
			
			itemdetailsresponse.setTotWeight((BigDecimal)obj[5]);
			if(obj[6]!=null)
			{
			itemdetailsresponse.setUnitofWeight(obj[6].toString());
			}
			if(obj[7]!=null)
			{
			itemdetailsresponse.setMinSafetyStckUnit(obj[7].toString());
			}
			if(obj[8]!=null)
			{
			itemdetailsresponse.setValTotValuatedStckUnit(obj[8].toString());
			}if(obj[10]!=null){
				itemdetailsresponse.setValTotValuatedStck((BigDecimal)obj[10]);	
			}
			
			itemdetailsresponses.add(itemdetailsresponse);
		}
	
		itemresponse.setDetails(itemdetailsresponses);
		}
		return itemdetailsresponse;
	
	}
   
   
   public ResponseEntity<?> findByCategory(String materialGroupDesc){
	   List<CaseFillUpDto> caseFillUpListDto = new ArrayList<CaseFillUpDto>();
	 
		// call zarticle to get details based on category
	List<Zartmas> listOfZarticle = repo.findByMaterialGroupDesc(materialGroupDesc);
		// call zinventory to get details based on article 
	if(listOfZarticle != null && !listOfZarticle.isEmpty()){
		listOfZarticle.stream().forEach(a -> {
			List<Zinventory> listOfZinventory = invRepo.findByarticleNumber(a.getArticleNumber());
			if(listOfZinventory!=null && !listOfZinventory.isEmpty()){
				listOfZinventory.stream().forEach(i-> {
					 CaseFillUpDto 	caseFillUp = new CaseFillUpDto();
					 caseFillUp.setBoh(i.getTotValuatedStck().toString());
					 caseFillUp.setMaterialDescription(a.getMaterialDesc());
					 caseFillUp.setStandardPrice(i.getStndPrice().toString());
					 caseFillUp.setPlant(i.getPlant());
					 caseFillUp.setStorageLocation(i.getStorageLoc());
					 caseFillUp.setArticleNumber(i.getArticleNumber());
					 caseFillUpListDto.add(caseFillUp);
				});
			}
		});
		// club the details and send it 
		if(caseFillUpListDto != null && !caseFillUpListDto.isEmpty()){
		
		return new ResponseEntity<List<CaseFillUpDto>>(caseFillUpListDto,HttpStatus.OK);
		}else {
			ResponseJson responseJson =  new ResponseJson();
			responseJson.setMessage("No Article Found In Inventory !");
			return new ResponseEntity<ResponseJson>(responseJson,HttpStatus.OK);
			}
		}
	       ResponseJson responseJson =  new ResponseJson();
	       responseJson.setMessage("Not Found Article !");
	       return new ResponseEntity<ResponseJson>(responseJson,HttpStatus.OK);
	}
   
   
   // get item details for forecast
   public ResponseEntity<?> getItemDetailsOfForecast(String articleNumber,String plant,Date date){
	   
	 List<Zcount> list =   countRepo.findByArticleNumberAndPlantAndDate(articleNumber,plant,date);
	 
	 System.err.println( "list" + list);
	 
	 if(list != null && !list.isEmpty()){
		 
		 return new ResponseEntity<List<Zcount>>(list,HttpStatus.OK);
	 }else {
			ResponseJson responseJson =  new ResponseJson();
			responseJson.setMessage("No Article Found In Zcount ! for "+"Date" +date);
			return new ResponseEntity<ResponseJson>(responseJson,HttpStatus.OK);
			}
	 
   }

}