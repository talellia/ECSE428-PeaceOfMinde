import React from 'react'
import PropTypes from 'prop-types'
import { useState } from 'react';
import axios from 'axios'
import JQuery from 'jquery'

import './sign-in.css'

let $ = JQuery

const SignIn = (props) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  // for buyer
  async function fetchQuotes(){
    var x = (`/person/buyer/login` + $.param({userName:username, password: password}));
    var y = `http://localhost:8080` +  x;
    const res = await axios.post(y)
    .catch(e => {
      var errorMsg = e.message
      console.log(errorMsg)
    });
    console.log(y)
    return res.data;
    
  };

  //ToDo: is statement checking if it's buyer or sitter
  const handleSubmit = (event) => {
    event.preventDefault();
    alert(`Values are:\n 
      UserName: ${username}\n
      Password: ${password}`);
      fetchQuotes();
  }
  return (
    <div id="signinbox1" className={`sign-in-container ${props.rootClassName} `}>
      <div className="sign-in-sign-in">
        <img
          alt="Rectangle61010"
          src="/playground_assets/rectangle61010-qfqa-500h.png"
          className="sign-in-rectangle6"
        />
        <span className="sign-in-text">
          <span>Welcome to Peace Of Minde</span>
        </span>
        <img
          alt="Rectangle51010"
          src="/playground_assets/rectangle51010-63ll-900w.png"
          className="sign-in-rectangle5"
        />
        <button onClick={closeall}>
        <img
          alt="Vector11010"
          src="/playground_assets/vector11010-46y.svg"
          className="sign-in-vector1"
        />
        </button>
        <span className="sign-in-text02">
          <span>Sign In</span>
        </span>
        <div className="sign-in-component21">
          <input
            type="text"
            value={username}
            alt="Rectangle7I101"
            src="/playground_assets/rectangle7i101-uso-800w.png"
            className="sign-in-rectangle7 input"
            onChange={(e) => setUsername(e.target.value)}
          />
          <span className="sign-in-text04">
            <span>UserName</span>
          </span>
        </div>
        <div className="sign-in-component22">
          <input 
            type="text"
            value={password}
            alt="Rectangle7I101"
            src="/playground_assets/rectangle7i101-cgh7-800w.png"
            className="sign-in-rectangle71 input"
            onChange={(e) => setPassword(e.target.value)}
          />
          <span className="sign-in-text06">
            <span>Password</span>
          </span>
        </div>
        <button onClick={handleSubmit} onMouseDown={signInclick} type="submit" className="sign-in-button">
          <img
            id="submitsignrectange"
            alt="Rectangle9I101"
            src="/playground_assets/rectangle9i101-b8wm-800w.png"
            className="sign-in-rectangle9"
          />
          <span id="submitsignText" className="sign-in-text08">
            <span>Sign In</span>
          </span>
        </button>
      </div>
    </div>
  )
}

function signInclick(){
  document.getElementById("submitsignrectange").style.backgroundColor = "#2977ff";
  document.getElementById("submitsignText").style.color = "white";
}
function closeall(){
    document.getElementById("button1").style.visibility = "visible";
    document.getElementById("button1Hover").style.visibility = "hidden";
    document.getElementById("select1").style.visibility = "hidden";
    document.getElementById("select2").style.visibility = "hidden";
    document.getElementById("buyerClickRectangel1").style.backgroundColor = "";
    document.getElementById("buyerClicktxt1").style.color = "black";
    document.getElementById("sitterClickRectangel1").style.backgroundColor = "";
    document.getElementById("sitterClicktxt1").style.color = "black";
    document.getElementById("signUpClickRectangel1").style.backgroundColor = "";
    document.getElementById("signUpClicktxt1").style.color = "black";
    document.getElementById("signUpClickRectangel1").style.backgroundColor = "";
    document.getElementById("signUpClicktxt1").style.color = "black";
    document.getElementById("signInClickRectangel1").style.backgroundColor = "";
    document.getElementById("signInClicktxt1").style.color = "black";
    document.getElementById("signinbox1").style.visibility = "hidden";
}

SignIn.defaultProps = {
  rootClassName: '',
}

SignIn.propTypes = {
  rootClassName: PropTypes.string,
}

export default SignIn
