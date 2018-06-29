package com.campspot.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //String fileName = "test-case.json";
        
        Gson gson = new Gson();
        
        BufferedReader br = null;
        
        if(args.length == 0) {
        		System.out.println("No arguments were given.");
        }
        else if(args.length > 1) {
        	System.out.println("Too many arguments were given.");
        }
        else {

	        	try{
	        		//br = new BufferedReader(new FileReader(fileName));
	        		br = Files.newBufferedReader(Paths.get(args[0]));
	        		
	        		CampSiteSearch campSiteJson = gson.fromJson(br, CampSiteSearch.class);
	        		
	        		Driver driver = new Driver(campSiteJson);
	        		
	        		driver.run();
	
	        	}
	        	catch(IOException e) {
	        		e.printStackTrace();
	        	}
        }
   
    }
    
}
