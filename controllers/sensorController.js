import { ObjectId } from "mongodb";
import sensorService from "../services/sensorService.js";

const getAllSensors = async (req, res) => {
  try {
    const sensors = await sensorService.getAll();
    res.status(200).json({ sensors: sensors });
  } catch (error) {
    console.log(error);
    res.status(500).json({ error: "Erro interno do servidor" });
  }
};

const createSensor = async (req, res) => {
  try {
    const { name, captureDate, additionalInformation, localCapture, heatmap } =
      req.body;
    await sensorService.Create(
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

const deleteSensor = async (req, res) => {
  try {
    if (ObjectId.isValid(req.params.id)) {
      const id = req.params.id;
      sensorService.Delete(id);
      res.sendStatus(204);
    } else {
      res.sendStatus(400);
    }
  } catch (error) {
    console.log(error);
    res.status(500).json({ error: "Erro interno do servidor" });
  }
};

const updateSensor = async (req, res) => {
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
      const sensor = await sensorService.Update(
        id,
        name,
        captureDate,
        additionalInformation,
        localCapture,
        heatmap
      );
      res.status(200).json({ sensor });
    } else {
      res.sendStatus(400);
    }
  } catch (error) {
    console.log(error);
    res.sendStatus(500);
  }
};

const getOneSensor = async (req, res) => {
  try {
    if (ObjectId.isValid(req.params.id)) {
      const id = req.params.id;
      const sensor = await sensorService.getOne(id);
      if (!sensor) {
        res.sendStatus(404);
      } else {
        res.status(200).json({ sensor });
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
  getAllSensors,
  createSensor,
  deleteSensor,
  updateSensor,
  getOneSensor,
};
