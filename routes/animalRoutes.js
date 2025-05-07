import express from "express";
const animalRoutes = express.Router();
import animalController from "../controllers/animalController.js";

animalRoutes.get("/animals", animalController.getAllAnimals);

animalRoutes.post("/animals", animalController.createAnimal);

animalRoutes.delete("/animals/:id", animalController.deleteAnimal);

animalRoutes.put("/animals/:id", animalController.updateAnimal);

animalRoutes.get("/animals/:id", animalController.getOneAnimal);

export default animalRoutes;
