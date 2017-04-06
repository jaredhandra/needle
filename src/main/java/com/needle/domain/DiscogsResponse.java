package com.needle.domain;

import java.util.ArrayList;

public class DiscogsResponse {
	private ArrayList<Release> releases;
	private DiscogsPagination discogsPagination;

	public ArrayList<Release> getReleases() {
		return releases;
	}

	public void setReleases(ArrayList<Release> releases) {
		this.releases = releases;
	}

	public DiscogsPagination getDiscogsPagination() {
		return discogsPagination;
	}

	public void setDiscogsPagination(DiscogsPagination discogsPagination) {
		this.discogsPagination = discogsPagination;
	} 
}
