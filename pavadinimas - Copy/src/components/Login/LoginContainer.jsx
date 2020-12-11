import React, { useState, useContext } from 'react';
import axios from 'axios';
import { useHistory } from 'react-router';

import ServicesContext from '../../context/ServicesContext.js';
import LoginComponent from '../Login/LoginComponent';
import myUrl from '../../AppConfig';

const LoginContainer = () => {
  const { userCartService } = useContext(ServicesContext);
  const history = useHistory();

  const [currentUser, setCurrentUser] = useState(
    userCartService.getCurrentUser()
  );
  const [username, setUsername] = useState('');

  userCartService.updateCurrentUser = () =>
    setCurrentUser(
      userCartService.getCurrentUser(),
      console.log(userCartService.getCurrentUser())
    );

  const handleChange = (e) => {
    setUsername(e.target.value);
  };
  const handleLogin = (e) => {
    e.preventDefault();
    const name = e.target.username.value;
    userCartService.setCurrentUser(name);
    userCartService.updateCurrentUser();
    setUsername('');

    axios
      .post(`${myUrl}/api/users/`, {
        username: name,
      })
      .then(() =>
        axios
          .get(`${myUrl}/api/users/${name}/cart-products`)
          .then((response) => {
            userCartService.setCartCount(response.data.length);
            userCartService.updateCartCount();
          })
          .catch((err) => console.log(err))
      )
      .then(() => history.push('/'));
  };
  const handleLogout = (e) => {
    e.preventDefault();
    userCartService.setCurrentUser(undefined);
    setCurrentUser(undefined);
    userCartService.updateCurrentUser();
    userCartService.setCartCount(0);
    userCartService.updateCartCount();

    history.push('/');
  };
  return (
    <LoginComponent
      handleChange={handleChange}
      handleLogin={handleLogin}
      handleLogout={handleLogout}
      currentUser={currentUser}
      username={username}
    />
  );
};

export default LoginContainer;
