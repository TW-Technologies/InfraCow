import { ObjectId } from "mongodb";
import imageService from "../services/imageService.js";

const getAllImages = async (req, res) => {
  try {
    const images = await imageService.getAll();
    res.status(200).json({ images: images });
  } catch (error) {
    console.log(error);
    res.status(500).json({ error: "Erro interno do servidor" });
  }
};

const createImage = async (req, res) => {
  try {
    const { name, captureDate, additionalInformation, localCapture, heatmap } =
      req.body;
    await imageService.Create(
      name,
      captureDate,
      additionalInformation,
      localCapture,
      heatmap
    );
    res.status(201);
  } catch (error) {
    console.log(error);
    res.status(500).json({ error: "Erro interno do servidor " });
  }
};

const deleteImage = async (req, res) => {
  try {
    if (ObjectId.isValid(req.params.id)) {
      const id = req.params.id;
      imageService.Delete(id);
      res.sendStatus(204);
    } else {
      res.sendStatus(400);
    }
  } catch (error) {
    console.log(error);
    res.status(500).json({ error: "Erro interno do servidor" });
  }
};

const updateImage = async (req, res) => {
  try {
    if (ObjectId.isValid(req.params.id)) {
      const id = req.params.id;
      const {
        name,
        captureDate,
        additionalInformation,
        localCapture,
        heatmap,
      } = req.body;
      const image = await imageService.Update(
        id,
        name,
        captureDate,
        additionalInformation,
        localCapture,
        heatmap
      );
      res.status(200).json({ image });
    } else {
      res.sendStatus(400);
    }
  } catch (error) {
    console.log(error);
    res.sendStatus(500);
  }
};

const getOneImage = async (req, res) => {
  try {
    if (ObjectId.isValid(req.params.id)) {
      const id = req.params.id;
      const image = await imageService.getOne(id);
      if (!image) {
        res.sendStatus(404);
      } else {
        res.status(200).json({ image });
      }
    } else {
      res.sendStatus(400);
    }
  } catch (error) {
    console.log(error);
    res.sendStatus(500).json({ error: "Erro interno do servidor" });
  }
};

export default {
  getAllImages,
  createImage,
  deleteImage,
  updateImage,
  getOneImage,
};
