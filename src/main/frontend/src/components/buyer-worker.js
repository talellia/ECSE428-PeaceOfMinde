import React from 'react'
import PropTypes from 'prop-types'
import { useDetectClickOutside } from 'react-detect-click-outside';


import './buyer-worker.css'

const BuyerWorker = (props,) => {
  return (
    <div id="select1" className={`buyer-worker-container ${props.rootClassName} `}>
      <div className="buyer-worker-component22">
        <img
          alt="Rectangle10I551"
          src="/playground_assets/rectangle10i551-eqxn.svg"
          className="buyer-worker-rectangle10"
        />
        <div className="buyer-worker-component17 button">
          <img
            alt="Rectangle10I551"
            src="/playground_assets/rectangle10i551-b89q-400w.png"
            className="buyer-worker-rectangle101"
          />
          <b className="buyer-worker-text">Buyer</b>
        </div>
        <div className="buyer-worker-component16 button">
          <img
            alt="Rectangle11I551"
            src="/playground_assets/rectangle11i551-gmtd-400w.png"
            className="buyer-worker-rectangle11"
          />
          <b className="buyer-worker-text1">
            <span>Sitter</span>
          </b>
        </div>
      </div>
    </div>
  )
}

BuyerWorker.defaultProps = {
  rootClassName: '',
}

BuyerWorker.propTypes = {
  rootClassName: PropTypes.string,
}

export default BuyerWorker
