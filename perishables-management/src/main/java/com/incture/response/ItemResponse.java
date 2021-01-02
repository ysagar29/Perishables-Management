package com.incture.response;

import java.util.List;

public class ItemResponse {

	List<ItemDetailsResponse> itemdetails;

	public List<ItemDetailsResponse> getItemDetails() {
		return itemdetails;
	}

	public void setDetails(List<ItemDetailsResponse> items) {
		this.itemdetails = items;
	}
}
