import mongoose from "mongoose";

const animalSchema = new mongoose.Schema({
  name: String,
  weight: Number,
  age: Number,
  idSensor: String,
  idCode: String,
});

const Animal = mongoose.model("Animal", animalSchema);

export default Animal;