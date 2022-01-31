package com.cardealership.entity;
	
	public class Seller {
		
		private String firstName;
		private String lastName;
		private String email;
		private String password;
		private String username;
		
		public String getAdministrator() {
			return "administrator";
		}
		
		public String getAdminPassword() {
			return "password";
		}
		

		private int rating;
		
		
		public Seller() {

			setFirstName(firstName);
			setLastName(lastName);
			setEmail(email);
			setPassword(password);
			setUsername(username);
			setRating(rating);
		}
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}
		}
