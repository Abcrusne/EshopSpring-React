package it.akademija.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import it.akademija.model.Product;

@RestController
@ApiOperation(value = "RestService")
public class RestService {

	@Autowired
	private Set<Product> products;
//
//	@Autowired
//	private List<User> users;

	@RequestMapping("/productsCollection")
	public void getProductsCollection() {
		products.stream().map(p -> p.getTitle()).forEach(System.out::println);
	}

//	@RequestMapping("/findUsersByName")
//	public User findByFirstnameAndLastname(String firstname, String lastname)
//
//	{
//		for (User user : users)
//			if (user.getFirstName().equals(firstname) && user.getLastName().equals(lastname)) {
//				return user;
//			}
//		return null;
//	}
//
//	@RequestMapping("/findOldestUser")
//	public User findOldestUser() {
//		return Collections.max(users, Comparator.comparingInt(u -> u.getAge()));
//	}

}
