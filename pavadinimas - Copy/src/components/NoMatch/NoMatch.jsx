import React from 'react';

const NoMatch = (props) => {
  const goApp = () => props.history.push('/');
  return (
    <div className="text-center ">
      <h5>Route did not match.</h5>
      <button className="btn btn-dark ml-3" onClick={goApp}>
        Go Home
      </button>
    </div>
  );
};

export default NoMatch;
