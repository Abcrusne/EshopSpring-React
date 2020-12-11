import React, { Component } from 'react';
//import React, { useEffect, useState } from 'react';
import axios from 'axios';
import ProductCardComponent from '../Product/ProductCardComponent';
import img from '../../img/samsung-big.jpg';
import myUrl from '../../AppConfig';

class ProductListContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      products: {},
    };
  }

  componentDidMount() {
    axios
      .get(`${myUrl}/api/products`)
      .then((products) => {
        this.setState({ products });
      })
      .catch((err) => {
        console.log(err);
      });
  }

  render() {
    const { data } = this.state.products;

    if (data) {
      return (
        <div className="container mt-4">
          <div className="row d-flex justify-content-center">
            {data.map(({ id, ...otherProps }) => (
              <ProductCardComponent
                key={id}
                id={id}
                itemImg={img}
                {...otherProps}
              />
            ))}
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
  }
}
export default ProductListContainer;
