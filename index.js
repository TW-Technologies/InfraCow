import express from "express";
import mongoose from "mongoose";
// import mongoose from "./config/db-connection.js" - Retirar fora da fatec para teste
import Animal from "./models/animal.js";
import Sensor from "./models/sensor.js";
import User from "./models/user.js";
import animalRoutes from "./routes/animalRoutes.js";
import sensorRoutes from "./routes/sensorRoutes.js";
import userRoutes from "./routes/userRoutes.js";

const app = express();
app.use(express.urlencoded({ extended: false }));
app.use(express.json());

app.use(Animal);
app.use(Sensor);
app.use(User);

mongoose.connect("mongodb://127.0.0.1:27017/infracow");

app.use("/", animalRoutes);
app.use("/", sensorRoutes);
app.use("/", userRoutes)

const port = 4000;
app.listen(port, (error) => {
  if (error) {
    console.log(error);
  } else {
    console.log(`API rodando em http://localhost:${port}`);
  }
});
