import animalService from "../services/animalService.js";

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
    const { name, weight, age, image, idCode } = req.body;
    await animalService.Create(name, weight, age, image, idCode);
    res.status(201)
  } catch (error) {
    console.log(error);
    res.status(500).json({ error: "Erro interno do servidor " });
  }
};

export default { getAllAnimals, createAnimal };
