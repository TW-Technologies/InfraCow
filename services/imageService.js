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
  async Create(
    name,
    captureDate,
    additionalInformation,
    localCapture,
    heatmap
  ) {
    try {
      const newImage = new Image({
        name,
        captureDate,
        additionalInformation,
        localCapture,
        heatmap,
      });
      await newImage.save();
    } catch (error) {
      console.log(error);
    }
  }
  async Delete(id) {
    try {
      await Image.findByIdAndDelete(id);
      console.log(`A imagem com a id: ${id} foi deletado`);
    } catch (error) {
      console.log(error);
    }
  }
  async Update(
    id,
    name,
    captureDate,
    additionalInformation,
    localCapture,
    heatmap
  ) {
    try {
      const updatedImage = await Image.findByIdAndUpdate(
        id,
        {
          name,
          captureDate,
          additionalInformation,
          localCapture,
          heatmap,
        },
        { new: true }
      );
      console.log(`Dados da Imagem com a id: ${id} alterados com sucesso`);
      return updatedImage;
    } catch (error) {
      console.log(error);
    }
  }
  async getOne(id) {
    try {
      const image = await Image.findOne({ _id: id });
      return image;
    } catch (error) {
      console.log(error);
    }
  }
}

export default new imageService();
