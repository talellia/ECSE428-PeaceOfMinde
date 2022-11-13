import React from 'react'

import './buyer-worker-hover.css'
import PropTypes from 'prop-types'


const BuyerWorkerHover = (props) => {
  return (
    <div className="buyer-worker-hover-container">
      <div className={`buyer-worker-hover-component23 ${props.rootClassName} `}>
        <img
          alt="Rectangle10I551"
          src="/playground_assets/rectangle10i551-029-200h.png"
          className="buyer-worker-hover-rectangle10"
        />
        <span className="buyer-worker-hover-text">
          <span>Buyer</span>
        </span>
      </div>
      <div className={`buyer-worker-hover-component24 ${props.rootClassName} `}>
        <img
          alt="Rectangle11I551"
          src="/playground_assets/rectangle11i551-fijg-200h.png"
          className="buyer-worker-hover-rectangle11"
        />
        <span className="buyer-worker-hover-text2">
          <span>Sitter</span>
        </span>
      </div>
    </div>
  )
}

BuyerWorkerHover.defaultProps = {
  rootClassName: '',
}

BuyerWorkerHover.propTypes = {
  rootClassName: PropTypes.string,
}
export default BuyerWorkerHover
