package com.cardealership.entity;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public class Car {
	
	private String make;
	private String model;
	private int year;
	private int mileage;
	private String sold;
	private String description;
	private MultipartFile picture;
	private String image;
	private String color;
	private double price;
	private String fuelType;
	private LocalDate postedDate;
	private String fourWheel;
	private String seller;
	private String buyer;
	private LocalDate soldDate; 
	private String discounted;
	private int id;
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getSold() {
		return sold;
	}
	public void setSold(String sold) {
		this.sold = sold;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public LocalDate getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}
	public String getFourWheel() {
		return fourWheel;
	}
	public void setFourWheel(String fourWheel) {
		this.fourWheel = fourWheel;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public LocalDate getSoldDate() {
		return soldDate;
	}
	public void setSoldDate(LocalDate soldDate) {
		this.soldDate = soldDate;
	}
	public String getDiscounted() {
		return discounted;
	}
	public void setDiscounted(String discounted) {
		this.discounted = discounted;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}