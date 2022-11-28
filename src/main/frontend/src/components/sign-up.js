import React from 'react'
import PropTypes from 'prop-types'
import { useState } from 'react';
import axios from 'axios'
import JQuery from 'jquery'

let $ = JQuery

var frontendUrl = 'http://' + '127.0.0.1' + ':' + ':8087'
var backendUrl = 'http://' + '127.0.0.1' + ':' + ':8080'

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

import './sign-up.css'

const SignUp = (props) => {
  
  const [firstName, setfirstName] = useState("");
  const [userName, setuserName] = useState("");
  const [aboutMe, setaboutMe] = useState("");
  const [password, setpassword] = useState("");
  const [address, setaddress] = useState("");
  const [rePassword,setrePassword] = useState("");
  const [lastName, setlastName] = useState("");

  // for buyer
 async function fetchQuotes(){
    var x = (`/person/buyer/register/` + $.param({firstName:'firstName', lastName:'lastName',userName:'userName', password: 'password', email: 'email', residentialAddress:'address', about:'aboutMe'}));
    var y = `http://localhost:8080` +  x;
    const res = await axios.post(`http://localhost:8080/person/buyer/register/`,null)
    .catch(e => {
      var errorMsg = e.message
      console.log(e)
    });
    console.log(res)
    return res.data;
  };

  //ToDo: is statement checking if it's buyer or sitter
  const handleSubmit = (event) => {
    event.preventDefault();
    alert(`Values are: \n 
    FirstName: ${firstName}\n
    LastName: ${lastName}\n
    UserName: ${userName}\n
    Password: ${password}\n
    re-Password: ${rePassword}\n
    Address: ${address}\n
    About Me: ${aboutMe}`);
    //createBuyer();
    fetchQuotes();
  }
  return (
    <div id="signupbox1" className={`sign-up-container ${props.rootClassName} `}>
      <div className="sign-up-sign-up">
        <img
          alt="Rectangle6I106"
          src="/playground_assets/rectangle6i106-h209-900w.png"
          className="sign-up-rectangle6"
        />
        <img
          alt="Rectangle5I106"
          src="/playground_assets/rectangle5i106-o5h9-900w.png"
          className="sign-up-rectangle5"
        />
        <button onClick={closeall}>
        <img
          alt="Vector1I106"
          src="/playground_assets/vector1i106-2nqm.svg"
          className="sign-up-vector1"
        />
        </button>
        <span className="sign-up-text">
          <span>Sign Up</span>
        </span>
        <span className="sign-up-text02">
          <span>Welcome to Peace Of Minde</span>
        </span>
        <div className="sign-up-component7">
          <input
            type="text"
            value={firstName}
            alt="Rectangle7I106"
            src="/playground_assets/rectangle7i106-kdrs-800w.png"
            className="sign-up-rectangle7 input"
            onChange={(e) => setfirstName(e.target.value)}

          />
          <span className="sign-up-text04">
            <span>First Name</span>
          </span>
        </div>
        <div className="sign-up-component10">
        <input
            type="text"
            value={userName}
            alt="Rectangle7I106"
            src="/playground_assets/rectangle7i106-4f3i-800w.png"
            className="sign-up-rectangle71 input"
            onChange={(e) => setuserName(e.target.value)}
          />
          <span className="sign-up-text06">
            <span>UserName</span>
          </span>
        </div>
        <div className="sign-up-component9">
          <input
            type="text"
            value={password}
            alt="Rectangle7I106"
            src="/playground_assets/rectangle7i106-75i8-800w.png"
            className="sign-up-rectangle72 input"
            onChange={(e) => setpassword(e.target.value)}      
          />
          <span className="sign-up-text08">
            <span>Password</span>
          </span>
        </div>
        <div className="sign-up-component13">
          <input
            type="text"
            value={aboutMe}
            alt="Rectangle7I106"
            src="/playground_assets/rectangle7i106-obwp-800w.png"
            className="sign-up-rectangle73 textarea"
            onChange={(e) => setaboutMe(e.target.value)} 
          />
          <span className="sign-up-text10">
            <span>About Me</span>
          </span>
        </div>
        <div className="sign-up-component12">
          <input
            type="text"
            value={address}
            alt="Rectangle7I106"
            src="/playground_assets/rectangle7i106-rwqp-800w.png"
            className="sign-up-rectangle74 input"
            onChange={(e) => setaddress(e.target.value)} 
          />
          <span className="sign-up-text12">
            <span>Residential Address</span>
          </span>
        </div>
        <div className="sign-up-component11">
          <input
            type="text"
            value={rePassword}
            alt="Rectangle7I106"
            src="/playground_assets/rectangle7i106-mh6a-800w.png"
            className="sign-up-rectangle75 input"
            onChange={(e) => setrePassword(e.target.value)} 
          />
          <span className="sign-up-text14">
            <span>Re-Password</span>
          </span>
        </div>
        <div className="sign-up-component8">
        <input
            type="text"
            value={lastName}
            alt="Rectangle7I106"
            src="/playground_assets/rectangle7i106-y5k6-800w.png"
            className="sign-up-rectangle76 input"
            onChange={(e) => setlastName(e.target.value)} 
          />
          <span className="sign-up-text16">
            <span>Last Name</span>
          </span>
        </div>
        <button onClick={handleSubmit} onMouseDown={signUpclick} className="sign-up-button button">
          <img
            id="submitsignrectange2"
            alt="Rectangle9I106"
            src="/playground_assets/rectangle9i106-g97-800w.png"
            className="sign-up-rectangle9"
          />
          <span id="submitsignText2" className="sign-up-text18">
            <span>Sign Up</span>
          </span>
        </button>
      </div>
    </div>
  )
}

function signUpclick(){
  document.getElementById("submitsignrectange2").style.backgroundColor = "#2977ff";
  document.getElementById("submitsignText2").style.color = "white";
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
  document.getElementById("signupbox1").style.visibility = "hidden";
}

function createBuyer(){
  var x = (`/person/buyer/register` + $.param({email: "email", password: "password"}));
  AXIOS.post(`/person/buyer/register`,$.param({email: "email", password: "password"}))
  .then(response => {
    // JSON responses are automatically parsed.
    this.response = response.data
    this.errorLogin =''
  })
  .catch(e => {
    var errorMsg = e.message
    console.log(errorMsg)
  });
  console.log(AXIOS.headers);
}




SignUp.defaultProps = {
  rootClassName: '',
}

SignUp.propTypes = {
  rootClassName: PropTypes.string,
}

export default SignUp
