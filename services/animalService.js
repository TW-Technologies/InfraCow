import Animal from "../models/Animals.js";

class animalService {
  async getAll() {
    try {
      const animals = await Animal.find();
      return animals;
    } catch (error) {
      console.log(error);
    }
  }

  async Create(name, weight, age, idSensor, idCode) {
    try {
      const newAnimal = new Animal({
        name,
        weight,
        age,
        idSensor,
        idCode,
      });
      await newAnimal.save();
    } catch (error) {
      console.log(error);
    }
  }
  async Delete(id) {
    try {
      await Animal.findByIdAndDelete(id);
      console.log(`Animal com a id: ${id} foi deletado`);
    } catch (error) {
      console.log(error);
    }
  }
  async Update(id, name, weight, age, idSensor, idCode) {
    try {
      const updateAnimal = await Animal.findByIdAndUpdate(
        id,
        {
          name,
          weight,
          age,
          idSensor,
          idCode,
        },
        { new: true }
      );
      console.log(`Dados do animal com a id: ${id} alterados com sucesso`);
      return updateAnimal;
    } catch (error) {
      console.log(error);
    }
  }
  async getOne(id) {
    try {
      const animal = await Animal.findOne({ _id: id });
      return animal;
    } catch (error) {
      console.log(error);
    }
  }
}

export default new animalService();
