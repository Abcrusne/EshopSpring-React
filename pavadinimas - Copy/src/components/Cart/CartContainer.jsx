import React, { useContext, useEffect, useState } from 'react';
import axios from 'axios';
import ServicesContext from '../../context/ServicesContext';
import CartComponent from './CartComponent';
import myUrl from '../../AppConfig';

const CartContainer = () => {
  const { userCartService } = useContext(ServicesContext);

  const [currentUser, setCurrentUser] = useState(
    userCartService.getCurrentUser()
  );
  const [userProducts, setUserProducts] = useState([]);

  userCartService.updateCurrentUser = () =>
    setCurrentUser(userCartService.getCurrentUser());

  useEffect(() => {
    axios
      .get(`${myUrl}/api/users/${currentUser}/cart-products`)
      .then((response) => {
        setUserProducts(response.data);
      })
      .catch((err) => console.log(err));
  }, [currentUser, userCartService]);

  const deleteFromCart = (e) => {
    console.log(e.target.type);
    console.log(e.target);
    axios
      .delete(
        `${myUrl}/api/users/${currentUser}/cart-products/${e.target.value}`
      )
      // .then(() => {
      //   axios
      //     .get(`${myUrl}/api/users/${currentUser}/cart-products`)
      .then((response) => {
        setUserProducts(response.data);
        userCartService.setCartCount(response.data.length);
        userCartService.updateCartCount();
      })
      .catch((err) => console.log(err));
  };

  const totalOfCart = userProducts.reduce((total, userProducts) => {
    return total + userProducts.price;
  }, 0);

  return (
    <CartComponent
      deleteFromCart={deleteFromCart}
      currentUser={currentUser}
      userProducts={userProducts}
      totalOfCart={totalOfCart}
    />
  );
};

export default CartContainer;
