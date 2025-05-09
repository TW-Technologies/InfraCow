import express from "express";
import mongoose from "mongoose";
// import mongoose from "./config/db-connection.js" - Retirar fora da fatec para teste
import Bovino from "./models/Bovinos.js";
import Measurement from "./models/Measurement.js";
import User from "./models/Users.js";
import bovinoRoutes from "./routes/bovinoRoutes.js";
import userRoutes from "./routes/userRoutes.js";
import measurementRoutes from "./routes/measurementRoutes.js";

const app = express();
app.use(express.urlencoded({ extended: false }));
app.use(express.json());

mongoose.connect("mongodb://127.0.0.1:27017/infracow");

app.use("/", bovinoRoutes);
app.use("/", measurementRoutes);
app.use("/", userRoutes)

const port = 4000;
app.listen(port, (error) => {
  if (error) {
    console.log(error);
  } else {
    console.log(`API rodando em http://localhost:${port}`);
  }
});