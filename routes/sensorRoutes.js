import express from "express";
const sensorRoutes = express.Router();
import sensorController from "../controllers/sensorController.js";

sensorRoutes.get("/sensors", sensorController.getAllSensors);

sensorRoutes.post("/sensors", sensorController.createSensor);

sensorRoutes.delete("/sensors/:id", sensorController.deleteSensor);

sensorRoutes.put("/sensors/:id", sensorController.updateSensor);

sensorRoutes.get("/sensors/:id", sensorController.getOneSensor);

export default sensorRoutes;
