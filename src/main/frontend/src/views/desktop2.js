import React from 'react'

import { Helmet } from 'react-helmet'

import HoverAccount from '../components/hover-account'
import Menu from '../components/menu'

import './desktop2.css'

const Desktop2 = (props) => {
  return (
    <div className="desktop1-container">
      <Helmet>
        <title>exported project</title>
      </Helmet>
      <div className="desktop1-desktop1">
        <img
          alt="Rectangle113"
          src="/playground_assets/rectangle113-0kxs-1900w.png"
          className="desktop1-rectangle1"
        />
        <img
          alt="logonobackground124"
          src="/playground_assets/logonobackground124-zy7l-200h.png"
          className="desktop1-logonobackground1"
        />
        <button id="button1"
        onMouseDown={changecssHover} className="desktop1-component3 button">
          <img
            alt="Rectangle3I252"
            src="/playground_assets/rectangle3i252-737m-200h.png"
            className="desktop1-rectangle3"
          />
          <div className="desktop1-frameiconperson">
            <div className="desktop1-group">
              <img
                alt="VectorI252"
                src="/playground_assets/vectori252-2z6v.svg"
                className="desktop1-vector"
              />
              <img
                alt="VectorI252"
                src="/playground_assets/vectori252-dkd9.svg"
                className="desktop1-vector1"
              />
            </div>
          </div>
          <div className="desktop1-frameiconmenu">
            <div className="desktop1-group1">
              <img
                alt="VectorI252"
                src="/playground_assets/vectori252-4ew.svg"
                className="desktop1-vector2"
              />
              <img
                alt="VectorI252"
                src="/playground_assets/vectori252-ywgl.svg"
                className="desktop1-vector3"
              />
              <img
                alt="VectorI252"
                src="/playground_assets/vectori252-ncq.svg"
                className="desktop1-vector4"
              />
            </div>
          </div>
        </button>
        <div onClick={closemenue}>
          <HoverAccount  id="button1Hover" rootClassName="hover-account-root-class-name"></HoverAccount>
        </div>
      </div>
      <Menu rootClassName="menu-root-class-name"></Menu>
    </div>
  )
}

function changecssHover(){
  document.getElementById("button1").style.visibility = "hidden";
  document.getElementById("button1Hover").style.visibility = "visible";
}

function closemenue(){
  document.getElementById("button1").style.visibility = "visible";
  document.getElementById("button1Hover").style.visibility = "hidden";
}


export default Desktop2
