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
  }, [currentUser]);

  const deleteFromCart = (e) => {
    axios
      .delete(
        `${myUrl}/api/users/${currentUser}/cart-products/${e.target.value}`
      )
      .then(() => {
        axios
          .get(`${myUrl}/api/users/${currentUser}/cart-products`)
          .then((response) => {
            setUserProducts(response.data);
            userCartService.setCartCount(response.data.length);
            userCartService.updateCartCount();
          })
          .catch((err) => console.log(err));
      });
  };

  return (
    <CartComponent
      deleteFromCart={deleteFromCart}
      currentUser={currentUser}
      userProducts={userProducts}
    />
  );
};

export default CartContainer;
