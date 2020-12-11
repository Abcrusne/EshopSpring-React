import React from 'react';
import { Link } from 'react-router-dom';
import img from '../../img/samsung-big.jpg';

const ProductCardComponent = ({ id, itemImg, ...otherProps }) => {
  console.log('Product Card: ', id);
  //const { title, description, price, quantity } = otherProps;
  return (
    <div className="card col-12 col-md-6 col-lg-4 my-3">
      <img src={img} className="card-img-top" alt={otherProps.title} />
      <div className="card-body ">
        <h5 className="card-title">Title: {otherProps.title}</h5>
        <p className="card-text">Description: {otherProps.description}</p>
        <p>Price: {otherProps.price}</p>
        <p className="card-quantity">
          Quantity in Stock:{' '}
          {otherProps.quantity <= 0 ? 'Out of stock' : 'In stock'}{' '}
        </p>
        <Link to={`/product/${id}`} className="btn btn-dark">
          More info
        </Link>
      </div>
    </div>
  );
};
export default ProductCardComponent;
