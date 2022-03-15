package Util;

/**
 * The class used to model a business
 */
public class Business {
    
	
	private String id, alias, name, image_url, price;
	private int reviewcount;
	private boolean isClosed;
	private double rating;
	private double [] coordinates; //how to parse out in here?
	private String [] categories, location, transactions;
	

    public Business(String id, String name, String image_url, String price,
    		int reviewcount, boolean isClosed, double rating, double [] coordinates, String [] categories, String [] location, String [] transactions) {
        //TODO Initialization code
    	
    	this.id = id;
    	this.alias = alias;
    	this.name = name;
    	this.image_url = image_url;
    	this.price = price;
    	this.reviewcount = reviewcount;
    	this.isClosed = isClosed;
    	this.rating = rating;
    	this.coordinates = coordinates;
    	this.categories = categories;
    	this.location = location;
    	this.transactions = transactions;
    	
    	
    }

    
    //TODO Add Getters (No Setters as the business does not change in our assignment once constructed)
//    "id": "SLxKy00itrk-ta8r8zCzTA",
//    "alias": "easy-street-burgers-los-angeles",
//    "name": "Easy Street Burgers",
//    "image_url": "https://s3-media2.fl.yelpcdn.com/bphoto/kkJ9A3hFzwOPLYHxqkrrrQ/o.jpg",
//    "is_closed": false,
//    "url": "https://www.yelp.com/biz/easy-street-burgers-los-angeles?adjust_creative=TO1fKtEL34_ZeUgitrVpAQ&utm_campaign=yelp_api_v3&utm_medium=api_v3_business_search&utm_source=TO1fKtEL34_ZeUgitrVpAQ",
//    "review_count": 206,
//    "categories": [
//                   {
//                       "alias": "burgers",
//                       "title": "Burgers"
//                   }
//               ],
//               "rating": 4.5,
//               "coordinates": {
//                   "latitude": 34.088796,
//                   "longitude": -118.308573
//               },
//               "transactions": [
//                   "delivery"
//               ],
//               "price": "$$",
//               "location": {
//                   "address1": "1000 N Western Ave",
//                   "address2": "",
//                   "address3": null,
//                   "city": "Los Angeles",
//                   "zip_code": "90029",
//                   "country": "US",
//                   "state": "CA",
//                   "display_address": [
//                       "1000 N Western Ave",
//                       "Los Angeles, CA 90029"
//                   ]
//    
    
    public String getID() {
    	
    	return this.id;
    }
    
	 public String getAlias() {
	    	
	    	return this.alias;
	    }
	 
	 public String getName() {
	    	
	    	return this.name;
	    }
	 
	 public String getImageURL() {
	    	
	    	return this.image_url;
	    }
	 
	 public boolean getIsClosed() {
		 
		 return this.isClosed;
	 }
	 
	 
	 public int getReviewCount() {
		 
		 return this.reviewcount;
	 }
	 
	public double getRating() {
			 
			 return this.rating;
		 }
	
	public String getPrice() {
		 
		 return this.price;
	 }
	
	public double [] getCoord() {
		
		return this.coordinates;
	}
	
	public String [] getLoc() {
		
		return this.location;
	}
	public String [] getTrans() {
			
			return this.transactions;
		}

}

