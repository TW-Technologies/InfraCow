import express from "express";
import mongoose from "mongoose";
import Animal from "./models/animal.js";
import Image from "./models/image.js";
import animalRoutes from './routes/animalRoutes.js'
import imageRoutes from './routes/imageRoutes.js'
const app = express();

app.use(express.urlencoded({ extended: false }));
app.use(express.json());

mongoose.connect("mongodb://127.0.0.1:27017/infracow")

app.use("/", animalRoutes)
app.use("/", imageRoutes)

const port = 4000;
app.listen(port, (error) => {
  if (error) {
    console.log(error);
  } else {
    console.log(`API rodando em http://localhost:${port}`);
  }
});
