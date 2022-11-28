import React from 'react'
import PropTypes from 'prop-types'
import { useHistory } from "react-router-dom"

import './menu.css'

const Menu = (props) => {
  const history = useHistory();

  const Home = () => {
    history.push("/home")
  }
  const Profile = () => {
    history.push("/profile")
  }
  const Account = () => {
    history.push("/account")
  }
  const Logout = () => {
    history.push("/")
  }

  return (
    <div className={`menu-container ${props.rootClassName}`}>
      <div className="component-component37">
        <img
          src="/playground_assets/rectangle101141-79l.svg"
          alt="Rectangle101141"
          className="component-rectangle10"
        />
        <span className="component-text04">
          <span>Welcome Name</span>
        </span>
        <img
          src="/playground_assets/rectangle128614-he4-200h.png"
          alt="Rectangle128614"
          className="component-rectangle12"
        />
        <button className="component-component17" onClick={Home}>
          <div
            className="component-rectangle101 button"
          />
          <span className="component-text06">
            <span>Home page</span>
          </span>
        </button>
        <button className="component-component26"onClick={Profile}>
          <div
            className="component-rectangle111"
          />
          <span className="component-text02">
            <span>Profile</span>
          </span>
        </button>
        <button className="component-component27" onClick={Account}>
          <div
            className="component-rectangle11"
          />
          <span className="component-text">
            <span>Account</span>
          </span>
        </button>
        <button className="component-component16" onClick={Logout}>
          <div
            className="component-rectangle112"
          />
          <span className="component-text08">
            <span>Log Out</span>
          </span>
        </button>

      </div>
    </div>
  )
}


Menu.defaultProps = {
  rootClassName: '',
}

Menu.propTypes = {
  rootClassName: PropTypes.string,
}

export default Menu
