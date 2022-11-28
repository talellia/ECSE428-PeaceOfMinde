import React from 'react'
import ReactDOM from 'react-dom'
import { BrowserRouter as Router, Route } from 'react-router-dom'

import './style.css'
import Desktop1 from './views/desktop1'
import Desktop2 from './views/desktop2'
import Account from './views/account'

const App = () => {
  return (
    <Router>
      <div>
        <Route component={Desktop1} exact path="/" />
        <Route component={Desktop2} exact path="/home" />
        <Route component={Account} exact path="/account" />
      </div>
    </Router>
  )
}

ReactDOM.render(<App />, document.getElementById('app'))
