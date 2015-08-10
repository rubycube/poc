package com.demo.mysearch.model;

public class User {
	
	private String id;
	private String name;
	private String username;
	private String email;
	private AddressC address;
	public AddressC getAddress() {
		return address;
	}
	public void setAddress(AddressC address) {
		this.address = address;
	}
	private String phone;
	private String website;
	private CompanyC company;
	
	public class CompanyC {
		private String name;
		private String catchPhrase;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCatchPhrase() {
			return catchPhrase;
		}
		public void setCatchPhrase(String catchPhrase) {
			this.catchPhrase = catchPhrase;
		}
		public String getBs() {
			return bs;
		}
		public void setBs(String bs) {
			this.bs = bs;
		}
		private String bs;
	}
	
	public class AddressC {
		private String street;
		private String suite;
		private String city;
		private String zipcode;
		private GeoC geo;
		
		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getSuite() {
			return suite;
		}

		public void setSuite(String suite) {
			this.suite = suite;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getZipcode() {
			return zipcode;
		}

		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}

		public GeoC getGeo() {
			return geo;
		}

		public void setGeo(GeoC geo) {
			this.geo = geo;
		}

		public class GeoC {
			private String lat;
			private String lng;
			public String getLat() {
				return lat;
			}
			public void setLat(String lat) {
				this.lat = lat;
			}
			public String getLng() {
				return lng;
			}
			public void setLng(String lng) {
				this.lng = lng;
			}
		}
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public CompanyC getCompany() {
		return company;
	}
	public void setCompany(CompanyC company) {
		this.company = company;
	}
	
	
}
