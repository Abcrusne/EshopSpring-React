import React from 'react';

const ProductAdminFormComponent = ({
  handleChange,
  handleSubmit,
  ...otherProps
}) => {
  const { title, image, description, price, quantity } = otherProps;
  return (
    <div>
      <form className="container my-5" onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="productTitle">Title</label>
          <input
            onChange={handleChange}
            type="text"
            className="form-control"
            id="productTitle"
            name="title"
            value={title}
          />
        </div>
        <div className="form-group">
          <label htmlFor="productImage">Image</label>
          <input
            onChange={handleChange}
            type="text"
            className="form-control"
            id="productImage"
            name="image"
            value={image}
          />
        </div>
        <div className="form-group">
          <label htmlFor="productDescription">Description</label>
          <textarea
            onChange={handleChange}
            className="form-control"
            id="productDescription"
            rows="3"
            name="description"
            value={description}
          ></textarea>
        </div>
        <div className="row">
          <div className="form-group col-6">
            <label htmlFor="productPrice">Price</label>
            <input
              onChange={handleChange}
              type="text"
              className="form-control"
              id="productPrice"
              name="price"
              value={price}
            />
          </div>
          <div className="form-group col-6">
            <label htmlFor="productQuantity">Quantity</label>
            <input
              onChange={handleChange}
              type="text"
              className="form-control"
              id="productQuantity"
              name="quantity"
              value={quantity}
            />
          </div>
        </div>
        <button type="submit" className="btn btn-primary">
          Save
        </button>
      </form>
    </div>
  );
};
export default ProductAdminFormComponent;
