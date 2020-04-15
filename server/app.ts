import express from "express";
import path from "path";
var db = require("./db/db")
// Set up the express app
const app = express();
// Get all movies
app.get('/api/v1/movies', (req: any, res: any) => {
    res.status(200).send({
        message: 'retrieved movies',
        movies: db.movies
    })
});

app.use('/images', express.static('db/images'))
const PORT = 5000

app.listen(PORT, () => {
    console.log(`server running on port ${PORT}`)
});