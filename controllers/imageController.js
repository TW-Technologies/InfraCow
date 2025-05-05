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

const createImage = async (req,res) => {
  try{
    const {name, metadados, captureDate, extension, additionalInformation, localCapture, heatmap} = req.body
    await imageService.Create(name, metadados, captureDate, extension, additionalInformation, localCapture, heatmap)
    res.status(201)
  } catch(error){
    console.log(error)
    res.status(500).json({ error: "Erro interno do servidor "})
  }
}

export default { getAllImages, createImage };
