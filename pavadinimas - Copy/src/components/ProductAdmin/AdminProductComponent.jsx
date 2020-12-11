import React from 'react';
import { Link } from 'react-router-dom';
import img from '../../img/samsung-small.jpg';

const AdminProductComponent = ({ id, image, title }) => (
  <tbody>
    <tr>
      <th scope="row">{id}</th>
      <td>
        <img
          src={img}
          className="card-img-top"
          style={{ width: 50, height: 50 }}
          alt={title}
        />
      </td>
      <td>
        <Link to={`/admin/products/${id}`}>{title} </Link>
      </td>
    </tr>
  </tbody>
);

export default AdminProductComponent;
