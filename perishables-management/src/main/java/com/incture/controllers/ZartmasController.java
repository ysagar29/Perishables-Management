package com.incture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incture.dos.Zartmas;
import com.incture.response.ItemResponse;
import com.incture.response.ZartmasResponseWO;
import com.incture.service.ZartmasService;

@RestController
@RequestMapping("/Zartmas")
public class ZartmasController 
{
	@Autowired
	private ZartmasService services;

	@PostMapping("/saveOrUpdate")
	public void saveOrUpdate(@RequestBody Zartmas zartmas) {
		services.saveOrUpdate(zartmas);
	}

	@GetMapping("/findById/{id}&{currentWeight}&{plant}&{storageLoc}")
	public ResponseEntity<? > findById(@PathVariable String id, @PathVariable String currentWeight,@PathVariable String plant,@PathVariable String storageLoc) {
		return services.findProductDetailsAndUpdateZinventory(id, currentWeight, plant, storageLoc);
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable String id) {
		return services.deleteById(id);
	}

	@GetMapping("/list")
	public List<Zartmas > listAll() {
		return services.listAll();
	}
	
	@GetMapping("/caseFillUp/{articleNumber}&{plant}&{storageLocation}&{totalValuatedStock}&{totalWeight}&{valueOfTotalValuatedStock}")
	public ResponseEntity<?> caseFillUp(@PathVariable String articleNumber , @PathVariable String plant ,@PathVariable String storageLocation,@PathVariable String totalValuatedStock,@PathVariable String totalWeight,@PathVariable String valueOfTotalValuatedStock){
		return services.caseFillUp(articleNumber, plant, storageLocation, totalValuatedStock, totalWeight, valueOfTotalValuatedStock);
	}
	
	
	@GetMapping("/repack/{articleNumber}&{plant}&{storageLocation}&{totalWeight}")//&{valueOfTotalValuatedStock}")
	public ResponseEntity<?> repackArticle(@PathVariable String articleNumber , @PathVariable String plant ,@PathVariable String storageLocation,@PathVariable String totalWeight){  //,@PathVariable String valueOfTotalValuatedStock){
		return services.repackArticle(articleNumber, plant, storageLocation, totalWeight);
	}
	
	
	//repack and destroy article
	/*@GetMapping("/Repack/{articleNumber}&{plant}&{storageLocation}&{totalWeight}")
	public ResponseEntity<?> repackArticle1(@PathVariable String articleNumber , @PathVariable String plant ,@PathVariable String storageLocation,@PathVariable String totalWeight){
		return services.repackArticle(articleNumber, plant, storageLocation, totalWeight);
	}*/
	
	
	@GetMapping("/DestroyDiscardReturn/{articleNumber}&{plant}&{storageLocation}&{totalWeight}")
	public ResponseEntity<String> DestroyDiscardReturn(@PathVariable String articleNumber , @PathVariable String plant ,@PathVariable String storageLocation,@PathVariable String totalWeight){
		return services.destroyDiscardReturnArticle(articleNumber, plant, storageLocation, totalWeight);
	}
	

	@GetMapping("itemdetails/{articleNumber}")
	public ItemResponse Items(@PathVariable String articleNumber){//, @PathVariable String plant ,@PathVariable String storageLocation,@PathVariable String totalWeight){
		return services.getItemDetails(articleNumber);//, plant, storageLocation, totalWeight);
	}
	

}
