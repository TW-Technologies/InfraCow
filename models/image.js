import mongoose from "mongoose";

const imageSchema = new mongoose.Schema({
  name: String,
  captureDate: String,
  additionalInformation: String,
  localCapture: String,
  heatmap: [[Number]],
});

const Image = mongoose.model("Image", imageSchema);

export default Image;