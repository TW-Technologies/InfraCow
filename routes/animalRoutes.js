import express from "express";
const animalRoutes = express.Router();
import animalController from "../controllers/animalController.js";
import Auth from '../middleware/Auth.js'

animalRoutes.get("/animals", Auth.Authorization ,animalController.getAllAnimals);

animalRoutes.post("/animals", Auth.Authorization, animalController.createAnimal);

animalRoutes.delete("/animals/:id", Auth.Authorization,animalController.deleteAnimal);

animalRoutes.put("/animals/:id", Auth.Authorization, animalController.updateAnimal);

animalRoutes.get("/animals/:id", Auth.Authorization, animalController.getOneAnimal);

export default animalRoutes;
