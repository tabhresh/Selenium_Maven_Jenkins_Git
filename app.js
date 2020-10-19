const express = require('express');
const app = express();
const mongoose = require('mongoose');
const path = require('path')
const cors = require('cors')
require('dotenv').config();

// routes
const authRoutes = require('../routes/auth');
const categoryRoutes = require('../routes/category')
const serviceRoutes = require('../routes/service')
const cartRoutes = require('../routes/cart')

// admin routes
const adminRoutes = require('../routes/admin/auth')
const startingDataRoutes = require('../routes/admin/startingData')

// middleware
app.use(express.json());
app.use(cors())
app.use('/public', express.static(path.join(path.dirname(__dirname),'uploads/')))
app.use('/gabsip', authRoutes);
app.use('/gabsip', adminRoutes);
app.use('/gabsip', categoryRoutes)
app.use('/gabsip', serviceRoutes)
app.use('/gabsip', cartRoutes)
app.use('/gabsip', startingDataRoutes)

mongoose.connect(
    process.env.DB_CONNECTION,
    {
      useNewUrlParser: true,
      useUnifiedTopology: true,
      useCreateIndex: true,
      useFindAndModify: false,
    },
    () => console.log('connected to database')
);

app.listen(process.env.PORT, () => {
    console.log(`Server running on port ${process.env.PORT}`)
});