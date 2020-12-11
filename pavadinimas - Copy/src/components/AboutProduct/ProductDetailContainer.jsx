import React, { useContext, useEffect, useState } from 'react';
import axios from 'axios';
import myUrl from '../../AppConfig';
import ProductDetailsComponent from './ProductDetailComponent';
import ServicesContext from '../../context/ServicesContext';

const ProductDetailContainer = (props) => {
  const { userCartService } = useContext(ServicesContext);
  const [currentUser, setCurrentUser] = useState(
    userCartService.getCurrentUser()
  );
  const [product, setProduct] = useState(null);

  userCartService.updateCurrentUser = () =>
    setCurrentUser(userCartService.getCurrentUser());

  useEffect(() => {
    axios
      //`https://itpro2017.herokuapp.com/api/products`
      .get(`${myUrl}/api/products/${props.match.params.id}`)

      .then((res) => setProduct(res.data))
      .catch((err) => console.log(err));
  }, [props.match.params.id]);

  const addToCart = () => {
    axios
      .post(`${myUrl}/api/users/${currentUser}/cart-products`, {
        id: product.id,
        image: product.image || '',
        title: product.title,
      })
      .then(() => {
        axios
          .get(`${myUrl}/api/users/${currentUser}/cart-products`)
          .then((res) => {
            userCartService.setCartCount(res.data.length);
            userCartService.updateCartCount();
          });
      })
      .catch((err) => console.log(err));
  };

  if (product !== null) {
    const { id, image, title, ...otherProps } = product;
    console.log(id);
    return (
      <div className="container">
        <div key={id}>
          <ProductDetailsComponent
            id={id}
            currentUser={currentUser}
            userCartService={userCartService}
            image={image}
            addToCart={addToCart}
            title={title}
            {...otherProps}
          />
        </div>
      </div>
    );
  } else {
    return (
      <div className="text-center">
        <div className="spinner-border m-5 text-dark" role="status">
          <span className="sr-only">Loading...</span>
        </div>
      </div>
    );
  }
};

export default ProductDetailContainer;
