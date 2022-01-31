package com.cardealership.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cardealership.entity.Car;



@Service
public class carService {
	
	
	static ArrayList<Car> cars = new ArrayList<Car>();
	static List<Integer> ids = new ArrayList<Integer>();
	Random rand = new Random();
	
	@Autowired
	ServletContext servletContext;

	
	public int uniqueId() {
		int id = rand.nextInt(100000);
		if(ids.contains(id)){
			 uniqueId();
		}
			return id;	
	}
	
	public void addNewCar(Car car) {
		cars.add(car);
	}
	
	public ArrayList<Car> findByMake(String make){
		ArrayList<Car> someCars= new ArrayList<Car>();
		for(Car car: cars) {
			if(car.getMake().equalsIgnoreCase(make)&&car.getSold() != "Sold") {
			someCars.add(car);
			}
		}
		return someCars;
	}
	
	public ArrayList<Car> findByModel(String model){
		ArrayList<Car> someCars= new ArrayList<Car>();
		for(Car car: cars) {
			if(car.getModel().equalsIgnoreCase(model)&&car.getSold() != "Sold") {
			someCars.add(car);
			}
		}
		return someCars;
	}
	
	public ArrayList<Car> findByYear(int year){
		ArrayList<Car> someCars= new ArrayList<Car>();
		for(Car car: cars) {
			if(car.getYear()>=(year)&&car.getSold() != "Sold") {
			someCars.add(car);
			}
		}
		return someCars;
	}
	
	public ArrayList<Car> findByPrice(double price){
		ArrayList<Car> someCars= new ArrayList<Car>();
		for(Car car: cars) {
			if(car.getPrice()<=(price)&&car.getSold() != "Sold") {
			someCars.add(car);
			}
		}
		return someCars;
	}
	
	
	public ArrayList<Car> findByMileage(int mileage){
		ArrayList<Car> someCars= new ArrayList<Car>();
		for(Car car: cars) {
			if(car.getMileage()<= mileage&&car.getSold() != "Sold") {
			someCars.add(car);
			}
		}
		return someCars;
	}
	
	public ArrayList<Car> findBySeller(String username){
		ArrayList<Car> someCars= new ArrayList<Car>();
		for(Car car: cars) {
			if(car.getSeller().equalsIgnoreCase(username)&&car.getSold() != "Sold") {
			someCars.add(car);
			}
		}
		return someCars;
	}
	
	public ArrayList<Car> findBySoldStatus(String sold){
		ArrayList<Car> someCars= new ArrayList<Car>();
		ArrayList<Car> soldCars=cars;
		Collections.reverse(soldCars);
		for(Car car: soldCars) {
			if(car.getSold() == (sold)) {
			someCars.add(car);
			}
		}
		return someCars;
	}
	
	public ArrayList<Car> findByFuelType(String fuel){
		ArrayList<Car> someCars= new ArrayList<Car>();
		for(Car car: cars) {
			if(car.getFuelType().equalsIgnoreCase(fuel)) {
			someCars.add(car);
			}
		}
		return someCars;
	}
	public ArrayList<Car> findByFw(String fw){
		ArrayList<Car> someCars= new ArrayList<Car>();
		for(Car car: cars) {
			if(car.getFourWheel().equalsIgnoreCase(fw)) {
			someCars.add(car);
			}
		}
		return someCars;
	}
	
	public ArrayList<Car> displayAvailable(){
		ArrayList<Car> someCars= new ArrayList<Car>();
		ArrayList<Car> availableCars=cars;
		Collections.reverse(availableCars);
		for(Car car: cars) {
			if(car.getSold() =="For Sale" && !someCars.contains(car)) {
			someCars.add(car);
			}
		}
		return someCars;
	}
	
	public ArrayList<Car> displayAll(){
		inventoryDayLimit();
		return cars;
	}
	
	public ArrayList<Car> findAllMatches(Car vehicle){
		double price =vehicle.getPrice(); 
		String make =vehicle.getMake(); 
		String model = vehicle.getModel(); 
		int year = vehicle.getYear(); 
		String fuel = vehicle.getFuelType();
		String fw = vehicle.getFourWheel();
		String seller = vehicle.getSeller();
		String sold = vehicle.getSold();
	
		ArrayList<Car> someCars= new ArrayList<Car>();
		
			for(Car car: cars) {
				if(!car.getSold().equalsIgnoreCase(sold)) {
					if(make != null) {
						someCars.addAll(findByMake(make));
						}
					if(model != null) {
						someCars.addAll(findByModel(model));
						}
					if(fuel != null ) {
						someCars.addAll(findByFuelType(fuel));
						}
					if(fw != null) {
						someCars.addAll(findByFw(fw));
						}
					if(seller != null) {
						someCars.addAll(findBySeller(seller));
						}
					if(year > 0) {
						someCars.addAll(findByYear(year));
						}
					if(price > 0) {
						someCars.addAll(findByPrice(price));
						}
					}
				}
			return someCars;
	}
//	{price}-{make}-{model}-{year}-{seller}
	public Car findOne(int id) {
		Car oneCar = new Car();
		for(Car car:cars) {
			if(car.getId()==id) {
				oneCar = car; 
			}
		}
		return oneCar;
	}
	public void inventoryDayLimit() {
		LocalDate now = LocalDate.now();
		for(Car car:cars) {
			if(ChronoUnit.DAYS.between(car.getPostedDate(), now) >= 120) {
				car.setPrice(car.getPrice()-(car.getPrice()*0.1));
				car.setDiscounted("Discounted 10%");
			}
		}
	}
	@SuppressWarnings("null")
	public void addPic(MultipartFile picture) {
		if(picture != null || picture.isEmpty()) {
			String picName = servletContext.getRealPath("/")+"resources\\images\\"+ picture.getOriginalFilename();
			try {
			picture.transferTo(new File(picName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}