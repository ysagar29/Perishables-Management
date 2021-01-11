package com.incture.controllers;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.incture.dos.Zartmas;
import com.incture.payload.RepackPayload;
import com.incture.response.CategoryResponse;
import com.incture.response.ItemDetailsResponse;
import com.incture.response.ResponseJson;
import com.incture.service.ZartmasService;

@RestController
@RequestMapping("/Zartmas")
public class ZartmasController 
{
	@Autowired
	 ZartmasService services;

	@PostMapping("/saveOrUpdate")
	public void saveOrUpdate(@RequestBody Zartmas zartmas) {
		services.saveOrUpdate(zartmas);
	}

	@PostMapping("/count/{articleNumber}&{plant}&{storageLoc}&{period}&{date}&{soldQtyInLastPeriod}")
	public ResponseEntity<? > findById(@PathVariable String articleNumber,@PathVariable String plant,@PathVariable String storageLoc,@PathVariable String period,@PathVariable Date date,@PathVariable String soldQtyInLastPeriod) {
		return services.findProductDetailsAndUpdateZcount(articleNumber,plant, storageLoc,period,date,soldQtyInLastPeriod);
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable String id) {
		return services.deleteById(id);
	}

	@GetMapping("/list")
	public List<Zartmas > listAll() {
		return services.listAll();
	}
	
	@PostMapping("/caseFillUp/{articleNumber}&{plant}&{storageLocation}&{totalWeight}")
	public ResponseEntity<?> caseFillUp(@PathVariable String articleNumber , @PathVariable String plant ,@PathVariable String storageLocation,@PathVariable String totalWeight){
		return services.caseFillUp(articleNumber, plant, storageLocation,totalWeight);
	}
	
	@GetMapping("/getItemDetailsOfForecast/{articleNumber}&{plant}&{date}")
	public ResponseEntity<?> foreCastDetails(@PathVariable String articleNumber , @PathVariable String plant ,@PathVariable Date date){
		return services.getItemDetailsOfForecast(articleNumber,plant,date);
	}
	
    @Transactional
    @ResponseBody
	@PostMapping("/repack")//{articleNumber}&{plant}&{storageLocation}&{totalWeight}")//&{valueOfTotalValuatedStock}")
	public ResponseEntity<?> repackArticle(@RequestBody RepackPayload details){// , @PathVariable String plant ,@PathVariable String storageLocation,@PathVariable String totalWeight){  //,@PathVariable String valueOfTotalValuatedStock){
		return services.repackArticle(details);
	}

    @ResponseBody
	@PostMapping("/DestroyDiscardReturn")//articleNumber}&{plant}&{storageLocation}&{totalWeight}")
	public ResponseEntity<ResponseJson> DestroyDiscardReturn(@RequestBody RepackPayload details){//@PathVariable String articleNumber , @PathVariable String plant ,@PathVariable String storageLocation,@PathVariable String totalWeight){
		return services.destroyDiscardReturnArticle(details);//articleNumber, plant, storageLocation, totalWeight);
	}
	
	@GetMapping("itemdetails/{articleNumber}")
	public ResponseEntity<?> Items(@PathVariable String articleNumber){//, @PathVariable String plant ,@PathVariable String storageLocation,@PathVariable String totalWeight){
	             ItemDetailsResponse item = services.getItemDetails(articleNumber);
	             
	             if(item !=null ){
	             //if(item.getItemDetails() != null && !item.getItemDetails().isEmpty()  ){
	            	return new ResponseEntity<ItemDetailsResponse>(item,HttpStatus.OK) ;
	             }else {
	            	 return new ResponseEntity<String>("No reccords found in Inventory or Article ",HttpStatus.OK) ;
	             }
	             
	}
	
	@GetMapping("categoryDisplay/{category}")
	public CategoryResponse categories(@PathVariable String category){
		return services.display(category);
	}
	
	@GetMapping("caseFillUpDetails/{category}")
	public ResponseEntity<?> displayCaseFillUpDetails(@PathVariable String category){
		return services.findByCategory(category);
	}
	

}