package it.akademija.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import it.akademija.model.CartProduct;
import it.akademija.model.CreateCartProductCommand;
import it.akademija.service.CartProductService;

@RestController
@Api(value = "cart products")
@RequestMapping(value = "/api/users/{username}/cart-products")
public class CartController {

//	private final CartProductDAO cartProductDao;
//
//	@Autowired
//	public CartController(CartProductDAO cartProductDao) {
//		this.cartProductDao = cartProductDao;
//	}

	private CartProductService cartService;

	public CartController(CartProductService cartService) {
		super();
		this.cartService = cartService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get products", notes = "Returns all products")
	public List<CartProduct> getProducts(@PathVariable String username) {

		return cartService.getCartProducts(username);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Add product to cart", notes = "Adds product to user cart")
	public void addCartProduct(@PathVariable final String username, @RequestBody CreateCartProductCommand cmd) {
		int id = cmd.getId();
		String title = cmd.getTitle();
		String image = cmd.getImage();

		cartService.addCartProduct(username, new CartProduct(id, title, image));
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete product", notes = "Removes product from user cart")
	public List<CartProduct> deleteProduct(@PathVariable final String username, @PathVariable int id) {
		cartService.deleteCartProduct(username, id);
		return cartService.getCartProducts(username);
	}

}
