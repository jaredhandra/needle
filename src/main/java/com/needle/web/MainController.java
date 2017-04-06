package com.needle.web;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.needle.domain.Release;
import com.needle.service.MainService;

@RestController
public class MainController {
    
    @RequestMapping("/searchrelease")
    public ArrayList<Release> searchRelease(@RequestParam(value="searchParam") String searchParam){
    	System.out.println("Endpoint: searchrelease hit");
    	ArrayList<Release> response = null;
		response = MainService.searchRelease(searchParam);
		return response;
    }
}