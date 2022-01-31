package com.cardealership.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cardealership.entity.Buyer;
import com.cardealership.entity.Car;
import com.cardealership.entity.Seller;
import com.cardealership.service.buyerService;
import com.cardealership.service.carService;
import com.cardealership.service.sellerService;


@Controller
public class CardealershipController {
	
	@Autowired
	ServletContext servletContext;
	sellerService sellerService = new sellerService();
	carService carServices = new carService();
	buyerService buyerService = new buyerService();

	@GetMapping("/index")
	public String welcome(Model model) {
		return "index";
	}
	@GetMapping("/seller")
	public String seller(Model model) {
		return "seller-page";
	}

	@GetMapping("/seller-signup")
	public ModelAndView signUp(Model model) {
		model.addAttribute("msg", "hello");
		return new ModelAndView("seller-signup", "seller", new Seller());
	}

	@PostMapping("/seller-signup")
	public String handleSignUp(Model model, @ModelAttribute("seller") Seller seller) {
		sellerService.saveSeller(seller);
		model.addAttribute("newSeller", seller);
		return "seller-login";
	}

	@GetMapping("/seller-login")
	public String handleLogin(@ModelAttribute("seller") Seller seller, Model model) {
		model.addAttribute("seller", seller);
		return "seller-login";
	}

	@PostMapping("/authenticate")
	String authenticate(@ModelAttribute("seller") Seller seller, HttpSession session, Model model,
			@ModelAttribute("car") Car car) {

		Seller vendor = sellerService.findByUsername(seller.getUsername());
		ArrayList<Car> cars = carServices.findBySeller(seller.getUsername());
		if (vendor.getUsername().equals(seller.getAdministrator())
				&& vendor.getPassword().equals(seller.getAdminPassword())) {
			model.addAttribute("sales", carServices.displayAll());
			return "report";
		}
		if (vendor.getPassword().equals(seller.getPassword())) {
			vendor.setRating(5);
			sellerService.saveSeller(vendor);
			session.setAttribute("seller", vendor);
			model.addAttribute("seller", vendor);
			model.addAttribute("sales", cars);
			return "seller-home";
		} else {
			model.addAttribute("error", "Invalid Credentials");
		}

		return "login";
	}

	@PostMapping("/add-car")
	public String addNewCar(@ModelAttribute("seller") Seller seller, HttpSession session, Model model,
			@ModelAttribute("car") Car car) {
		car.setSold("For Sale");
		LocalDate date = LocalDate.now();
		car.setPostedDate(date);
		car.setDiscounted("Normal Price");
		car.setId(carServices.uniqueId());

		carServices.addNewCar(car);
		MultipartFile picture = car.getPicture();

		carServices.addPic(picture);
		car.setImage(picture.getOriginalFilename());
		Seller vendor = (Seller) session.getAttribute("seller");
		car.setSeller(vendor.getUsername());
		ArrayList<Car> cars = carServices.findBySeller(vendor.getUsername());
		session.setAttribute("seller", vendor);
		model.addAttribute("seller", vendor);
		model.addAttribute("sales", cars);
		return "seller-home";
	}

	@GetMapping("/buyer")
	public String buyer(Model model, @ModelAttribute("car") Car car) {
		ArrayList<Car> cars = carServices.displayAvailable();
		model.addAttribute("sales", cars);
		return "buyer-page";
	}

	@GetMapping("/logout")
	public String buyer(HttpSession session, Model model) {
		session.removeAttribute("seller");
		return "index";
	}

	@PostMapping("/search-cars")
	public String search(Model model, @ModelAttribute("car") Car car) {
		ArrayList<Car> cars = carServices.findAllMatches(car);
		model.addAttribute("sales", cars);
		return "search";
	}

	@PostMapping("/buyer-signup-{id}")
	public String buyer(@ModelAttribute("buyer") Buyer buyer, Model model, @PathVariable int id) {
		buyerService.addNewBuyer(buyer);
		Car sale = carServices.findOne(id);
		sale.setBuyer(buyer.getEmail());
		sale.setSold("Sold");
		sale.setSoldDate(LocalDate.now());
		model.addAttribute("buyer", buyer);
		model.addAttribute("sale", sale);

		return "congrats";
	}

	@GetMapping("/buycar-{id}")
	public String purchase(HttpSession session, @PathVariable int id, @ModelAttribute("buyer") Buyer buyer,
			Model modelo) {
		Car sale = new Car();
		sale = carServices.findOne(id);
		modelo.addAttribute("sale", sale);
		return "buyer-form";
	}
	
}