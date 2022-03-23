package Util;


//import com.google.gson.*;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;


/**
 * A class that pretends to be the Yelp API
 */
public class RestaurantDataParser {
    private static Boolean ready = false;

    /**
     * Initializes the DB with json data
     *
     * @param responseString the Yelp json string
     * @throws SQLException 
     */
    public static void Init(String responseString) throws SQLException {
    	 String db = "jdbc:mysql://localhost:3306/Program_2";
		 String user = "root";
		 String pwd = "karenhe105";
		 Connection conn = null;
		 PreparedStatement restDeets = null;
		 PreparedStatement rateDeets = null;
		 PreparedStatement restaurant = null;
		 PreparedStatement cat = null;
	      
		 //making the queries
		 String category = "INSERT INTO Category(category_name, restaurant_id) VALUES (?,?)";
		 String restDetails = "INSERT INTO Restaurant_details(image, address, phone_no, price, yelp_url) VALUES (?,?,?,?,?)";
		 String ratingDetails = "INSERT INTO Rating_details(review_count, rating) VALUES (?,?)";
		 String restArray = "INSERT INTO Restaurant (restaurant_id, restuarant_name, details_id, rating_id) VALUES (?,?,?,?)";
      
		 if (ready) {
            return;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db, user, pwd);
            restDeets = conn.prepareStatement(restDetails);
            rateDeets = conn.prepareStatement(ratingDetails);
            restaurant = conn.prepareStatement(restArray);
            cat = conn.prepareStatement(category);
            //TODO check if you've done the initialization
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ready = true;
        
        Gson gson = new Gson();
        
        
        //TODO get businessHelper array from json
        //TODO iterate the businessHelper array and insert every business into the DB
       
        
        //put into sql all the data
        //use buisness helper as wrapper class - because it contains list of business objects
        
//        st.executeUpdate("INSERT INTO Restaurant (restaurant_id, restaurant_name, details_id, ratings_id) VALUES ('"
//				+ restaurant_id + "', '" + restaurant_name + "', '" + details_id + "', '" + ratings_id + "')");
    }

    public static Business getBusiness(String id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //TODO return business based on id
        return null;
    }

    /**
     * @param keyWord    the search keyword
     * @param sort       the sort option (price, review count, rating)
     * @param searchType search in category or name
     * @return the list of business matching the criteria
     */
    public static ArrayList<Business> getBusinesses(String keyWord, String sort, String searchType) {
        ArrayList<Business> busisnesses = new ArrayList<Business>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //TODO get list of business based on the param 
        //call getBusiness in here
        return busisnesses;

    }
}

//Code adapted from https://stackoverflow.com/questions/23070298/get-nested-json-object-with-gson-using-retrofit
//class BusinessDeserializer implements JsonDeserializer<BusinessHelper> {
//    @Override
//    public BusinessHelper deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
//        JsonElement content = je.getAsJsonObject();
//        return new Gson().fromJson(content, BusinessHelper.class);
//    }
//    
//    Gson gson = new GsonBuilder()
//    		.excludeFieldsWithoutExposeAnnotation()
//    		.registerTypeAdapter(Business.class, new MyDeserializer2())
//    		.create();
//}