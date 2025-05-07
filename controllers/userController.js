import userService from "../services/userService.js";
import UserService from "../services/userService.js";
import jwt from "jsonwebtoken";
const jwtSecret = "infracowsecret";

const createUser = async (req, res) => {
  try {
    const { name, email, password } = req.body;
    await userService.Create(name, email, password);
    res.sendStatus(201);
  } catch (error) {
    console.log(error);
    res.sendStatus(500);
  }
};

const loginUser = async(req,res) => {
  try {
    const { email, password} = req.body
    if (email != undefined) {
      const user = await userService.getOne(email)
      if (user != undefined){
        if (user.password == password) {
          jwt.sign(
            { id: user._id, email: user.email},
            jwtSecret,
            { expiresIn: "72h"},
            (err, token) => {
              if (err) {
                res.status(400);
                res.json({ err: "Falha interna"})
              } else {
                res.status(200)
                res.json({ token: token})
              }
            }
          )
        } else {
          res.status(401)
          res.json ({ err: "Credências inválidas!"})
        }
      } else {
        res.status(404)
        res.json ({ err: "O e-mail enviado não foi encontrado"})
      }
    } else {
      res.status(400)
      res.json ({ err: "O e-mail enviado é inválido"})
    }
  } catch(error) {
    console.log(error)
    res.sendStatus(500)
  }
}

export default { createUser, loginUser };
