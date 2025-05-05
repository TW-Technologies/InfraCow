import mongoose from "mongoose";

const animalSchema = new mongoose.Schema({
  name: String,
  weight: Number,
  age: Number,
  image: String,
  idCode: String,
});

const Animal = mongoose.model("Animal", animalSchema);

export default Animal;
