import express from "express";
const imageRoutes = express.Router();
import imageController from "../controllers/imageController.js";

imageRoutes.get("/images", imageController.getAllImages);

imageRoutes.post("/images", imageController.createImage);

imageRoutes.delete("/images/:id", imageController.deleteImage);

imageRoutes.put("/images/:id", imageController.updateImage);

imageRoutes.get("/images/:id", imageController.getOneImage);

export default imageRoutes;
