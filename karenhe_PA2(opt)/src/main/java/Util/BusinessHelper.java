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
		 
		    HashMap<Integer, Business> BusinessMap = new HashMap<>();
//		    
		   for(int i = 0; i <all.size(); i++) {
			  
//			   if (shelterMap.containsKey(shelters.get(i)) == true) { //check if there are no duplicates
//				  throw new IOException();
//			  }
//			
//			   if(shelters.get(i).getPhone().replaceAll(" ", "").matches(phoneMask) == false) {
//					throw new IllegalArgumentException();
//				}
//			   if(shelters.get(i).getGuid().replaceAll(" ", "").matches(guidMask) == false) {
//					throw new IllegalArgumentException();
//				}
//			   if(shelters.get(i).getChiralFrequency() < 0) {
//				   throw new IllegalArgumentException();
//			   }
		   Business temp = all.get(i);
//			
			  BusinessMap.put(i, temp);
			   
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
	
		
	}
	
	
	
	

}
