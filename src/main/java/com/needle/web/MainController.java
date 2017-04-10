package com.needle.web;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.needle.domain.Release;
import com.needle.service.MainService;

@RestController
public class MainController {
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public class ResourceNotFoundException extends RuntimeException {
		public ResourceNotFoundException(String message) {
	        super(message);
	    }
	}
    
    @RequestMapping("/searchrelease")
    public ArrayList<Release> searchRelease(@RequestParam(value="searchParam") String searchParam){
    	System.out.println("Endpoint: searchrelease hit");
    	ArrayList<Release> response = null;
		response = MainService.searchRelease(searchParam);
		if(!response.isEmpty()) {
			return response;
		} else {
			throw new ResourceNotFoundException("No results found, please search another artist."); 
		}
		
    }
}