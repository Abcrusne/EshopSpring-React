import React from 'react';

const LoginComponent = ({
  currentUser,
  username,
  handleLogin,
  handleLogout,
  handleChange,
}) => {
  if (currentUser === undefined) {
    console.log('current user is undefined');
    return (
      <form className="navbar-form form-inline ml-1" onSubmit={handleLogin}>
        <input
          onChange={handleChange}
          className="form-control mb-mr-md-1"
          type="text"
          name="username"
          placeholder="Username"
          value={username}
          required
        />
        <button className="btn btn-dark " type="submit">
          Login{' '}
        </button>
      </form>
    );
  } else {
    console.log('current user is defined');
    return (
      <div className="form-inline">
        <span className="form-control mr-sm-2 ml-md-3" type="text">
          Hi {currentUser}!
        </span>
        <button className="btn btn-outline-dark" onClick={handleLogout}>
          Logout
        </button>
      </div>
    );
  }
};

export default LoginComponent;
