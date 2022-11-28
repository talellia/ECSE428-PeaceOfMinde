module.exports = {
  build: {
    env: require('./prod.env'),
    host: 'eventregistration-frontend-123.herokuapp.com',
    port: 444,
    backendHost: 'eventregistration-backend-123.herokuapp.com',
    backendPort: 443,
    //...
  },
  dev: {
    env: require('./dev.env'),
    host: '127.0.0.1',
    port: 8087,
    backendHost: 'eventregistration-backend-123.herokuapp.com',
    backendPort: 443,
    //...
  }
}