import Sensor from "../models/sensor.js";

class sensorService {
  async getAll() {
    try {
      const sensors = await Sensor.find();
      return sensors;
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
      const newSensor = new Sensor({
        name,
        captureDate,
        additionalInformation,
        localCapture,
        heatmap,
      });
      await newSensor.save();
    } catch (error) {
      console.log(error);
    }
  }
  async Delete(id) {
    try {
      await Sensor.findByIdAndDelete(id);
      console.log(`O sensor com a id: ${id} foi deletado`);
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
      const updatedSensor = await Sensor.findByIdAndUpdate(
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
      console.log(`Dados do Sensor com a id: ${id} alterados com sucesso`);
      return updatedSensor;
    } catch (error) {
      console.log(error);
    }
  }
  async getOne(id) {
    try {
      const sensor = await Sensor.findOne({ _id: id });
      return sensor;
    } catch (error) {
      console.log(error);
    }
  }
}

export default new sensorService();
