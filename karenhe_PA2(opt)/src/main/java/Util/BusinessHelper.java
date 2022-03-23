package Util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;


public class BusinessHelper {
	
	

	private static ArrayList<Business> all;
	  HashMap<String, Business> BusinessMap = new HashMap<>();
	//private static ArrayList<TimefallShelter> shelters;
  
    static boolean format = false;
    
	private void readFile(String fileName) throws IOException {
		System.out.println("Reading file");
		
		try {
		    // create Gson instance
		    Gson gson = new Gson();

		    // create a reader
		    
		    Reader reader = new FileReader(fileName);
		   all = new Gson().fromJson(reader, new TypeToken<List<Business>>() {}.getType());
    
		    System.out.println("Successful!");

		     
//		
		 
		  
//		    
		   for(int i = 0; i <all.size(); i++) {
			  
		   Business temp = all.get(i);
//			
			  BusinessMap.put(temp.getID(), temp);
			  System.out.println(temp.getID());
			   
		   }

		    reader.close();

		}  catch (JsonParseException ex) {
			System.out.println(fileName + " can't be parsed.");
			this.readFile(fileName);
		} catch(NullPointerException ex) {
			System.out.println(fileName + " has no fields.");
			this.readFile(fileName);
		} catch(IllegalArgumentException ex) {
			System.out.println(fileName + " could not accepted fields.");
			this.readFile(fileName);
		}
		catch (IOException e) {
			System.out.println("Stream is corrupted.  Please try again.");
			this.readFile(fileName);
		}
	}
	
	public static void main(String[] args) throws IOException {
	BusinessHelper solution = new BusinessHelper();
		
	// File file = new File("restaurant_data.json");
	
		solution.readFile("restaurant_data.json");
	
	//	System.out.println(BusinessMap.);
		
	}
	
	
	
	

}
