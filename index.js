// *******************************************************************
// SETUP
// *******************************************************************



// import express module and set up port
const express = require('express')
const app = express()
const PORT = process.env.PORT || 5000

// Static files
app.use(express.static('/frontend/public'))
app.use('/css',express.static(__dirname + '/frontend/public/css'))
app.use('/js',express.static(__dirname + '/frontend/public/js'))
app.use('/img',express.static(__dirname + '/frontend/public/img'))

// Set views
app.set('views', './frontend/views')
app.set('view engine', 'ejs')

app.get('', (req,res) =>{
  res.render('index')
})
app.get('/about', (req,res) =>{
  res.render('about')
})


//listen on port 5000
app.listen(PORT, () => console.info(`listening on port ${PORT}`))
