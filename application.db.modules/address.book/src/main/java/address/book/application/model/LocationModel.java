package address.book.application.model;

import java.io.Serializable;

import address.book.model.Addresses;

public interface LocationModel extends Serializable {
	
	String getLocation();
	
	void setLocation(String location);
	
	String getSelectedCountryName();
	
	void setSelectedCountryName(String selectedCountryName);
	
	Addresses getAddress();
	
	void setAddress(Addresses address);

}
