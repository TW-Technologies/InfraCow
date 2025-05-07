import mongoose from "mongoose";

const sensorSchema = new mongoose.Schema({
  name: String,
  captureDate: String,
  additionalInformation: String,
  localCapture: String,
  heatmap: [[Number]],
});

const Sensor = mongoose.model("Image", sensorSchema);

export default Sensor;