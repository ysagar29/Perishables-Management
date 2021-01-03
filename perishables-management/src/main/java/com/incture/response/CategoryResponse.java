package com.incture.response;

import java.util.List;

public class CategoryResponse {

	List<CategoryDetailsResponse> categorydetails;

	public List<CategoryDetailsResponse> getCategoryDetails() {
		return categorydetails;
	}

	public void setDetails(List<CategoryDetailsResponse> items) {
		this.categorydetails = items;
	}
}
