import React from 'react';
import { Link } from 'react-router-dom';

import img from '../../img/samsung-big.jpg';

const ProductDetailsComponent = ({
  title,
  image,
  description,
  price,
  quantity,
  currentUser,
  addToCart,
}) => {
  return (
    <div>
      <div className="media">
        <img
          className="align-self-start mr-3"
          src={img}
          alt={title}
          style={{
            height: '25rem',
          }}
        />
        <div className="media-body mt-3">
          <h5 className="mt-0">{title}</h5>
          <p>Description: {description}</p>
          <p>Price: {price} €</p>
          <p>Quantity: {quantity} </p>
        </div>
      </div>
      <div className="row ml-5 mt-3">
        {currentUser !== undefined ? (
          <button className="btn btn-primary mr-1" onClick={addToCart}>
            Add to cart
          </button>
        ) : (
          <div> alert(You need to login to add products to your cart.)</div>
        )}
        <Link to={'/'} className="btn btn-outline-dark">
          Go back
        </Link>
      </div>
    </div>
  );
};

export default ProductDetailsComponent;
