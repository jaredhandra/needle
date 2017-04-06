package com.needle.domain;

import java.util.ArrayList;
import java.util.Map;

public class DiscogsPagination {
	private String per_page;
	private String pages;
	private String page;
	private String items;
	
	public String getPerPage() {
		return per_page;
	}
	public void setPerPage(String per_page) {
		this.per_page = per_page;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
}
