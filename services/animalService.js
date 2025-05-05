import Animal from "../models/animal.js";

class animalService {
  async getAll() {
    try {
      const animals = await Animal.find();
      return animals;
    } catch (error) {
      console.log(error);
    }
  }

  async Create(name, weight, age, image, idCode) {
    try{
      const newAnimal = new Animal({
        name,
        weight,
        age,
        image, 
        idCode
      })
      await newAnimal.save()
    } catch(error){
      console.log(error)
    }
  } 
}



export default new animalService();
