import express from "express";
const animalRoutes = express.Router();
import animalController from "../controllers/animalController.js";

animalRoutes.get("/animals", animalController.getAllAnimals);

animalRoutes.post("/animals", animalController.createAnimal);

export default animalRoutes;
