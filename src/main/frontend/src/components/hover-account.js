import React from 'react'

import PropTypes from 'prop-types'

import './hover-account.css'

const HoverAccount = (props) => {
  return (
    <div id="button1Hover" className={`hover-account-container ${props.rootClassName} `}>
      <div className="hover-account-component4">
        <img
          alt="Rectangle3I274"
          src="/playground_assets/rectangle3i274-qu7p-200h.png"
          className="hover-account-rectangle3"
        />
        <div className="hover-account-frameiconperson">
          <div className="hover-account-group">
            <img
              alt="VectorI274"
              src="/playground_assets/vectori274-qhcm.svg"
              className="hover-account-vector"
            />
            <img
              alt="VectorI274"
              src="/playground_assets/vectori274-nwv7.svg"
              className="hover-account-vector1"
            />
          </div>
        </div>
        <div className="hover-account-frameiconmenu">
          <div className="hover-account-group1">
            <img
              alt="VectorI274"
              src="/playground_assets/vectori274-pwl.svg"
              className="hover-account-vector2"
            />
            <img
              alt="VectorI274"
              src="/playground_assets/vectori274-us3k.svg"
              className="hover-account-vector3"
            />
            <img
              alt="VectorI274"
              src="/playground_assets/vectori274-i95r.svg"
              className="hover-account-vector4"
            />
          </div>
        </div>
      </div>
    </div>
  )
}

HoverAccount.defaultProps = {
  rootClassName: '',
}

HoverAccount.propTypes = {
  rootClassName: PropTypes.string,
}

export default HoverAccount
