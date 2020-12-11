package it.akademija.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import it.akademija.dao.CartProductDAO;
import it.akademija.model.CartProduct;
import it.akademija.model.CreateCartProductCommand;

@RestController
@Api(value = "cart products")
@RequestMapping(value = "/api/users/{username}/cart-products")
public class CartController {

	private final CartProductDAO cartProductDao;

	@Autowired
	public CartController(CartProductDAO cartProductDao) {
		this.cartProductDao = cartProductDao;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get products", notes = "Returns all products")
	public Set<CartProduct> getProducts(@PathVariable String username) {

		return cartProductDao.getCartProducts(username);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Add product to cart", notes = "Adds product to user cart")
	public void addCartProduct(@PathVariable String username, @RequestBody CreateCartProductCommand cmd) {
		int id = cmd.getId();
		String title = cmd.getTitle();
		String image = cmd.getImage();

		cartProductDao.addCartProduct(username, new CartProduct(id, title, image));
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete product", notes = "Removes product from user cart")
	public Set<CartProduct> deleteProduct(@PathVariable String username, @PathVariable int id) {

		return cartProductDao.deleteCartProduct(username, id);
	}

}
