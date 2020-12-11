import React, { useContext, useEffect, useState } from 'react';
import axios from 'axios';

import ServicesContext from '../../context/ServicesContext';
import CartSummaryComponent from '../Cart/CartSummaryComponent';

import myUrl from '../../AppConfig';

const CartSummaryContainer = () => {
  const { userCartService } = useContext(ServicesContext);
  const [currentUser, setCurrentUser] = useState(
    userCartService.getCurrentUser()
  );
  const [cartCount, setCartCount] = useState(userCartService.getCartCount());

  userCartService.updateCurrentUser = () =>
    setCurrentUser(userCartService.getCurrentUser());

  userCartService.updateCartCount = () =>
    setCartCount(userCartService.getCartCount());
  useEffect(() => {
    if (currentUser !== undefined) {
      // .get(
      // `https://itpro2017.herokuapp.com/api/users/${currentUser}/cart-products`
      axios
        //.get(`${myUrl}/api/users/${currentUser}/cart-products`)
        .get(
          `${myUrl}/api/users/${currentUser}/cart-products`)
        .then((response) => {
          userCartService.setCartCount(response.data.length());
          userCartService.updateCartCount();
        })
        .catch((err) => console.log(err));
    }
  }, [currentUser, cartCount, userCartService]);

  return <CartSummaryComponent cartCount={cartCount} />;
};

export default CartSummaryContainer;
