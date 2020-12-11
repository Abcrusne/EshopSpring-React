import React, { useContext, useState } from 'react';
import { NavLink } from 'react-router-dom';
import ServicesContext from '../../context/ServicesContext';
import CartSummaryContainer from '../Cart/CartSummaryContainer';
import LoginContainer from '../Login/LoginContainer';

const NavBar = () => {
  const { userCartService } = useContext(ServicesContext);
  const [currentUser, setCurrentUser] = useState(
    userCartService.getCurrentUser()
  );
  userCartService.updateCurrentUser = () =>
    setCurrentUser(userCartService.getCurrentUser());
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="container">
        <ul className="nav navbar-nav mr-auto">
          <li className="nav-item active">
            <NavLink className="nav-link" exact to="/">
              Home
            </NavLink>
          </li>
          <li className="nav-item active">
            <NavLink className="nav-link" to={`/admin/products`}>
              Admin
            </NavLink>
          </li>
          <LoginContainer />
        </ul>
        <ul className="nav navbar-nav navbar-right">
          <li className="nav-item active">
            <NavLink
              className="nav-link"
              to={`/users/${currentUser}/cart-products`}
            >
              <CartSummaryContainer />
            </NavLink>
          </li>
        </ul>
      </div>
    </nav>
  );
};
export default NavBar;
