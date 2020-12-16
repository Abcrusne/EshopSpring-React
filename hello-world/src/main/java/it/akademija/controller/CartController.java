package it.akademija.controller;

import java.util.List;
import java.util.stream.Collectors;

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
	@Autowired
	private CartProductService cartService;

	@Autowired
	public CartController(CartProductService cartService) {
		super();
		this.cartService = cartService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get products", notes = "Returns all products")
	public List<CreateCartProductCommand> getProducts(@PathVariable String username) {

		return cartService.getCartProducts(username).stream()
				.map(p -> new CreateCartProductCommand(p.getId(), p.getTitle(), p.getProductDetails().getImage(),
						p.getProductDetails().getDescription(), p.getPrice(), p.getQuantity()))
				.collect(Collectors.toList());
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Add product to cart", notes = "Adds product to user cart")
	public List<CreateCartProductCommand> addCartProduct(@PathVariable final String username,
			@RequestBody CreateCartProductCommand cmd) {

		return cartService.addCartProduct(username, cmd).stream()
				.map(p -> new CreateCartProductCommand(p.getId(), p.getTitle(), p.getProductDetails().getImage(),
						p.getProductDetails().getDescription(), p.getPrice(), p.getQuantity()))
				.collect(Collectors.toList());
	}

	// path = "/{id}/{cartId}"
	@RequestMapping(path = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Delete product", notes = "Removes product from user cart")
	public List<CreateCartProductCommand> deleteProduct(@PathVariable final String username, @PathVariable Long id) {
		return cartService.deleteCartProduct(username, id).stream()
				.map(p -> new CreateCartProductCommand(p.getId(), p.getTitle(), p.getProductDetails().getImage(),
						p.getProductDetails().getDescription(), p.getPrice(), p.getQuantity()))
				.collect(Collectors.toList());
	}

}
