package com.campspot.app;

import java.io.BufferedReader;
import java.io.FileReader; //Left in for testing
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;

/**
 * Main class for project, used for opening json file
 * processing of the file is done in the Driver class
 * @author Brian Stamm 
 */
public class App 
{
    /**
     * main method, needs file name to function		
     * @param args takes one argument, location of file to process
     */
	public static void main( String[] args )
    {
		/* used for testing */
        //String fileName = "test-case.json";
        
        Gson gson = new Gson();
        
        BufferedReader br = null;
        
        /* Only takes one argument, prints out message notifying */
        if(args.length == 0) {
        		System.out.println("No arguments were given.");
        }
        else if(args.length > 1) {
        		System.out.println("Too many arguments were given.");
        }
        else {

	        	try{
	        		/* Used for testing */
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
