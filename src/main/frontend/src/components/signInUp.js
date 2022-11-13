import React from 'react'
import PropTypes from 'prop-types'

import './signInUp.css'

const SignInUp = (props,) => {
  return (
    <div id="select2" className={`signIn-signUp-container ${props.rootClassName} `}>
      <div className="signIn-signUp-component22">
        <img
          alt="Rectangle10I551"
          src="/playground_assets/rectangle10i551-eqxn.svg"
          className="signIn-signUp-rectangle10"
        />
        <div  className="signIn-signUp-component17 button" onClick={signInclick}>
          <img
            id="signInClickRectangel1"
            alt="Rectangle10I551"
            src="/playground_assets/rectangle10i551-b89q-400w.png"
            className="signIn-signUp-rectangle101"
          />
          <b id="signInClicktxt1" className="signIn-signUp-text">sign In</b>
        </div>
        <div className="signIn-signUp-component16 button" onClick={signUpclick}>
          <img
            id="signUpClickRectangel1"
            alt="Rectangle11I551"
            src="/playground_assets/rectangle11i551-gmtd-400w.png"
            className="signIn-signUp-rectangle11"
          />
          <b  id="signUpClicktxt1" className="signIn-signUp-text1">
            <span>sign Up</span>
          </b>
        </div>
      </div>
    </div>
  )
}

function signInclick(){
  document.getElementById("select2").style.visibility = "hidden";
  document.getElementById("signinbox1").style.visibility = "visible";

}
function signUpclick(){
  document.getElementById("select2").style.visibility = "hidden";
  document.getElementById("signupbox1").style.visibility = "visible";
}

SignInUp.defaultProps = {
  rootClassName: '',
}

SignInUp.propTypes = {
  rootClassName: PropTypes.string,
}

export default SignInUp
