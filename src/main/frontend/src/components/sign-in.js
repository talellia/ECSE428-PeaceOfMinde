import React from 'react'

import './sign-in.css'

const SignIn = (props) => {
  return (
    <div className="sign-in-container">
      <div className="sign-in-sign-in">
        <img
          src="/playground_assets/rectangle61010-qfqa-500h.png"
          alt="Rectangle61010"
          className="sign-in-rectangle6"
        />
        <span className="sign-in-text">
          <span>Welcome to Peace Of Minde</span>
        </span>
        <img
          src="/playground_assets/rectangle51010-63ll-900w.png"
          alt="Rectangle51010"
          className="sign-in-rectangle5"
        />
        <img
          src="/playground_assets/vector11010-46y.svg"
          alt="Vector11010"
          className="sign-in-vector1"
        />
        <span className="sign-in-text02">
          <span>Sign In</span>
        </span>
        <div className="sign-in-component21">
          <img
            src="/playground_assets/rectangle7i101-uso-800w.png"
            alt="Rectangle7I101"
            className="sign-in-rectangle7 input"
          />
          <span className="sign-in-text04">
            <span>UserName</span>
          </span>
        </div>
        <div className="sign-in-component22">
          <img
            src="/playground_assets/rectangle7i101-cgh7-800w.png"
            alt="Rectangle7I101"
            className="sign-in-rectangle71 input"
          />
          <span className="sign-in-text06">
            <span>Password</span>
          </span>
        </div>
        <button className="sign-in-button">
          <img
            src="/playground_assets/rectangle9i101-b8wm-800w.png"
            alt="Rectangle9I101"
            className="sign-in-rectangle9"
          />
          <span className="sign-in-text08">
            <span>Sign In</span>
          </span>
        </button>
      </div>
    </div>
  )
}

export default SignIn
