package com.needle.web;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.needle.domain.Release;
import com.needle.domain.TweetObject;
import com.needle.service.MainService;

import twitter4j.TwitterException;

@RestController
public class MainController {
	
	@SuppressWarnings("serial")
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class ResourceNotFoundException extends RuntimeException {
		public ResourceNotFoundException(String message) {
	        super(message);
	    }
	}
    
    @RequestMapping("/searchrelease")
    public ArrayList<Release> searchRelease(@RequestParam(value="searchParam") String searchParam){
    	System.out.println("Endpoint: searchrelease");
    	ArrayList<Release> response = null;
		response = MainService.searchRelease(searchParam);
		if(!response.isEmpty()) {
			return response;
		} else {
			throw new ResourceNotFoundException("No results found, please search another artist."); 
		}
    }
    
    @RequestMapping("/getreleaseinfo")
    public String getReleaseInfo(@RequestParam(value="id") String id){
    	System.out.println("Endpoint: getreleaseinfo");
    	String response = null;
    	response = MainService.getReleaseInfo(id);
    	return response;
    }
    
    @RequestMapping("/posttweet")
    public void postTweet(@RequestBody TweetObject tweet) throws TwitterException{
    	System.out.println("Endpoint: posttweet");
    	MainService.postTweet(tweet);
    }
    
}