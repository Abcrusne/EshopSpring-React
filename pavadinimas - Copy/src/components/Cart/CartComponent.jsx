import React from 'react';
import img from '../../img/samsung-small.jpg';
import { Link } from 'react-router-dom';
// import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
// import {faTrashAlt} from '@fortawesome/free-solid-svg-icons';

const CartComponent = ({ userProducts, currentUser, deleteFromCart }) => {
  if (userProducts.length > 0) {
    return (
      <div className="container mt-6">
        <table className="table">
          <thead>
            <tr>
              <th scope="col">Image</th>
              <th scope="col">Title</th>
              <th scope="col"></th>
            </tr>
          </thead>
          {userProducts.map(({ id, title }) => (
            <tbody key={id}>
              <tr>
                <td>
                  <img
                    src={img}
                    className="card-img-top"
                    style={{ width: 50, height: 50 }}
                    alt={title}
                  />
                </td>
                <td>{title}</td>
                <td>
                  <button
                    className="btn btn-danger"
                    onClick={deleteFromCart}
                    value={id}
                  >
                    Delete from cart
                  </button>
                </td>
              </tr>
            </tbody>
          ))}
        </table>
      </div>
    );
  } else {
    return (
      <div className="d-flex justify-content-center">
        {currentUser !== undefined ? (
          <div className="text-center">
            <h5> You do not have any products in your cart.</h5>
            <Link to={'/'} className="btn btn-dark">
              Back
            </Link>
          </div>
        ) : (
          <h5> Please Login!</h5>
        )}
      </div>
    );
  }
};
export default CartComponent;
