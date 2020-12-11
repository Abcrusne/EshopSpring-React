import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import myUrl from '../../AppConfig';
import img from '../../img/samsung-big.jpg';

import AdminProductComponent from './AdminProductComponent';

class AdminListContainer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      products: [],
    };
  }

  componentDidMount() {
    axios
      .get(`${myUrl}/api/products`)
      .then((product) => {
        this.setState({ products: product });
      })
      .catch((err) => {
        console.log(err);
      });
  }

  render() {
    const { data } = this.state.products;
    if (data) {
      console.log(data);
      return (
        <div className="container mt-5">
          <Link to={`/admin/products/new`} className="btn btn-primary mb-5">
            Add new product
          </Link>
          <table className="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Image</th>
                <th scope="col">Title</th>
              </tr>
            </thead>
            {data.map(({ id, image, ...otherProps }) => (
              <AdminProductComponent
                key={id}
                id={id}
                image={img}
                {...otherProps}
              />
            ))}
          </table>
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
export default AdminListContainer;
