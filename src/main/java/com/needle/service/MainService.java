package com.needle.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.needle.domain.DiscogsPagination;
import com.needle.domain.Release;
import com.needle.domain.TweetObject;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class MainService {
	
//	public static Twitter getConfiguration(){
//		ConfigurationBuilder cb=new ConfigurationBuilder();
//		cb.setDebugEnabled(true);
//		cb.setOAuthConsumerKey();
//		cb.setOAuthConsumerSecret("");
//		cb.setOAuthAccessToken("");
//		cb.setOAuthAccessTokenSecret("");
//		TwitterFactory tf = new TwitterFactory(cb.build());
//		Twitter twitter = tf.getInstance();
//		return twitter;
//	}
	
	public static Map executeGet(String targetURL){
		String auth = "&key=EWHgYYhEfdiQjOIpZHdO&secret=lYwZOfDrOrSEGOFyWtnRpSDFCTUIIwQx";
		String url = targetURL + auth;
		RestTemplate restTemplate = new RestTemplate();
		Map response = restTemplate.getForObject(url, Map.class);
		return response;
	}

	public static ArrayList<Release> searchRelease(String searchParam) {
		Map response = null;
		ArrayList<Release> rel = null;
		String targetURL = "https://api.discogs.com/database/search?artist=" + searchParam + "&format=vinyl";
		
		try {
			System.out.println(targetURL);
			response = executeGet(targetURL);
			Map pag = (Map) response.get("pagination");
			DiscogsPagination disPag = new DiscogsPagination();
			disPag.setItems(pag.get("items").toString());
			disPag.setPage(pag.get("page").toString());
			disPag.setPages(pag.get("pages").toString());
			disPag.setPerPage(pag.get("per_page").toString());
			
			rel = (ArrayList<Release>) response.get("results");
		} catch (Exception e){
			e.printStackTrace();
		}

		return rel;
	}

	public static String getReleaseInfo(String id) {
		String targetURL = "https://api.discogs.com/releases/" + id;
		String release = "";
		Map response = null;
		
		try {
			System.out.println(targetURL);
			RestTemplate restTemplate = new RestTemplate();
			release = restTemplate.getForObject(targetURL, String.class);
		} catch (Exception e){
			e.printStackTrace();
		}
		return release;
	}

	public static void postTweet(TweetObject tweet) throws TwitterException{
		TwitterFactory tf = new TwitterFactory();
		Twitter twitter = tf.getInstance();
		Status status = twitter.updateStatus("I\'m listening to " + tweet.getArtist() + " - " + tweet.getTitle() + " on vinyl. \nCheck in at needle.io \n" + tweet.getUri());
	}
}
