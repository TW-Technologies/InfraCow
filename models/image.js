import mongoose from "mongoose";

const imageSchema = new mongoose.Schema({
  name: String,
  metadados: String,
  captureDate: Date,
  extension: String,
  additionalInformation: String,
  localCapture: String,
  heatmap: [[Number]],
});

const Image = mongoose.model("Image", imageSchema);

export default Image;
