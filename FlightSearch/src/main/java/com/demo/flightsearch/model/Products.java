package com.demo.flightsearch.model;

import java.util.ArrayList;

public class Products {

	private Productdetails productdetails;
	
	
	public Productdetails getProductdetails() {
		return productdetails;
	}



	public void setProductdetails(Productdetails productdetails) {
		this.productdetails = productdetails;
	}



	public static class Productdetails {

		private int id;
		private String name;
		private ArrayList<String> model;
		private String description;
		private String price;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public ArrayList<String> getModel() {
			return model;
		}

		public void setModel(ArrayList<String> model) {
			this.model = model;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}
	}

}
