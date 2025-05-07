import { ObjectId } from "mongodb";
import animalService from "../services/animalService.js";
import Animal from "../models/animal.js";

const getAllAnimals = async (req, res) => {
  try {
    const animals = await animalService.getAll();
    res.status(200).json({ animals: animals });
  } catch (error) {
    console.log(error);
    res.status(500).json({ error: "Erro interno do servidor" });
  }
};

const createAnimal = async (req, res) => {
  try {
    const { name, weight, age, idSensor, idCode } = req.body;
    await animalService.Create(name, weight, age, idSensor, idCode);
    res.status(201);
  } catch (error) {
    console.log(error);
    res.status(500).json({ error: "Erro interno do servidor " });
  }
};

const deleteAnimal = async (req, res) => {
  try {
    if (ObjectId.isValid(req.params.id)) {
      const id = req.params.id;
      animalService.Delete(id);
      res.sendStatus(204);
    } else {
      res.sendStatus(400);
    }
  } catch (error) {
    console.log(error);
    res.status(500).json({ error: "Erro interno do servidor" });
  }
};

const updateAnimal = async (req, res) => {
  try {
    if (ObjectId.isValid(req.params.id)) {
      const id = req.params.id;
      const { name, weight, age, idSensor, idCode } = req.body;
      const animal = await animalService.Update(
        id,
        name,
        weight,
        age,
        idSensor,
        idCode
      );
      res.status(200).json({ animal });
    } else {
      res.sendStatus(400);
    }
  } catch (error) {
    console.log(error);
    res.sendStatus(500)
  }
};

const getOneAnimal = async (req, res) => {
  try {
    if (ObjectId.isValid(req.params.id)) {
      const id = req.params.id;
      const animal = await animalService.getOne(id);
      if (!animal) {
        res.sendStatus(404);
      } else {
        res.status(200).json({ animal });
      }
    } else {
      res.sendStatus(400);
    }
  } catch (error) {
    console.log(error);
    res.sendStatus(500)
  }
};

export default {
  getAllAnimals,
  createAnimal,
  deleteAnimal,
  updateAnimal,
  getOneAnimal,
};
