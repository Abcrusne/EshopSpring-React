import React from 'react';
import { Switch, Route } from 'react-router-dom';

import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import NavBar from './components/Navbar/NavBarComponent.jsx';
import ProductListContainer from './components/Product/ProductListContainer';
import ProductDetailContainer from './components/AboutProduct/ProductDetailContainer';
import ProductAdminFormContainer from './components/ProductAdmin/ProductAdminFormContainer';
import AdminListContainer from './components/ProductAdmin/AdminListContainer';
import CartContainer from './components/Cart/CartContainer';
import NoMatch from './components/NoMatch/NoMatch';

const App = (props) => (
  <div>
    <NavBar />
    <Switch>
      <Route exact path="/" component={ProductListContainer} />
      <Route path="/products" component={ProductListContainer} />
      <Route path="/product/:id" component={ProductDetailContainer} />
      <Route path="/admin/products/new" component={ProductAdminFormContainer} />
      <Route path="/admin/products/:id" component={ProductAdminFormContainer} />
      <Route path="/admin/products" component={AdminListContainer} />
      <Route path="/users/:username/cart-products" component={CartContainer} />
      <Route path="*" component={NoMatch} />
      <Route component={NoMatch} />
    </Switch>
    {props.children}
  </div>
);

export default App;
