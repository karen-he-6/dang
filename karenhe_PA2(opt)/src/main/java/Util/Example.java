
	package Util;

	import java.util.List;
	import javax.annotation.Generated;
	import com.google.gson.annotations.Expose;
	import com.google.gson.annotations.SerializedName;

	@Generated("jsonschema2pojo")
	public class Example {

	@SerializedName("businesses")
	@Expose
	private List<Business> businesses = null;

	public List<Business> getBusinesses() {
	return businesses;
	}

	public void setBusinesses(List<Business> businesses) {
	this.businesses = businesses;
	}

	}