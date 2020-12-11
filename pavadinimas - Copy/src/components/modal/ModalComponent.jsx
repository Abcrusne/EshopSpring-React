import React from 'react';

const Modal = ({ productId, title, deleteFromCart }) => (
  <div
    className="modal fade"
    id="staticBackdrop"
    data-backdrop="static"
    data-keyboard="false"
    tabIndex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
  >
    <div className="modal-dialog modal-dialog-centered">
      <div className="modal-content">
        <div className="modal-header">
          <h5 className="modal-title" id="staticBackdropLabel">
            {title}
          </h5>
          <button
            type="button"
            className="close"
            data-dismiss="modal"
            aria-label="Close"
          >
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div className="modal-body">Are you sure you want to remove item?</div>
        <div className="modal-footer">
          <button
            type="button"
            data-toggle="modal"
            className="btn btn-primary"
            data-dismiss="modal"
            onClick={deleteFromCart}
            value={productId}
          >
            Yes
          </button>
          <button
            type="button"
            className="btn btn-secondary"
            data-dismiss="modal"
          >
            No
          </button>
        </div>
      </div>
    </div>
  </div>
);

export default Modal;
