import express from "express";
const imageRoutes = express.Router();
import imageController from "../controllers/imageController.js";

imageRoutes.get("/images", imageController.getAllImages);

imageRoutes.post("/images", imageController.createImage);

export default imageRoutes;
