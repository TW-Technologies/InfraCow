import express from "express";
const sensorRoutes = express.Router();
import sensorController from "../controllers/sensorController.js";
import Auth from '../middleware/Auth.js'

sensorRoutes.get("/sensors", Auth.Authorization, sensorController.getAllSensors);

sensorRoutes.post("/sensors", Auth.Authorization, sensorController.createSensor);

sensorRoutes.delete("/sensors/:id", Auth.Authorization, sensorController.deleteSensor);

sensorRoutes.put("/sensors/:id", Auth.Authorization, sensorController.updateSensor);

sensorRoutes.get("/sensors/:id", Auth.Authorization, sensorController.getOneSensor);

export default sensorRoutes;
