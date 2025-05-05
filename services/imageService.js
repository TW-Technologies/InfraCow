import Image from "../models/image.js";

class imageService {
  async getAll() {
    try {
      const images = await Image.find();
      return images;
    } catch (error) {
      console.log(error);
    }
  }
  async Create(name, metadados, captureDate, extension, additionalInformation, localCapture, heatmap){
    try{
      const newImage = new Image({
        name,
        metadados,
        captureDate,
        extension,
        additionalInformation,
        localCapture,
        heatmap
      })
      await newImage.save()
    } catch(error){
      console.log(error)
    }
  }
}

export default new imageService();