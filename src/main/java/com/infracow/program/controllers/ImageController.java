package com.infracow.program.controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import javax.imageio.ImageIO;

import com.infracow.program.models.Analise;
import com.infracow.program.models.Animal;
import com.infracow.program.services.AnaliseService;
import com.infracow.program.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.infracow.program.models.Imagem;
import com.infracow.program.models.dto.ImagemDTO;
import com.infracow.program.services.ImagemService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/imagem")
public class ImageController {

    @Autowired
    private ImagemService service;

    @Autowired
    private AnaliseService analiseService;

    @Autowired
    private AnimalService animalService;

    //Path of Images Folder
    String folderPath = "src/main/resources/images/analyses";

    @GetMapping("/cadastroImagem")
    public ModelAndView imagemInsert() {
        ModelAndView model = new ModelAndView("imagemCadastro");
        model.addObject("listaAnimais", animalService.getAnimais());
        return model;
    }

    @PostMapping("/addImagem")
    public String addImagem(@ModelAttribute ImagemDTO imagemDTO) throws IOException {

        MultipartFile imageFile = imagemDTO.getArquivo(); // Captura o arquivo de imagem do DTO
        String comentarioExtra = imagemDTO.getComentarioExtra();

        if (imageFile == null) {
            return "redirect:/imagem/cadastroImagem";
        }

        if (!imageFile.isEmpty()) {
            String fileName = imageFile.getOriginalFilename().substring(0, imageFile.getOriginalFilename().lastIndexOf("."));
            String contentType = imageFile.getContentType();
            String extensao = imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().lastIndexOf(".") + 1);

            //Tamanho da Imagem em Bytes
            long fileSize = imageFile.getSize();
            //Data e Horario do upload
            LocalDateTime dataCaptura = LocalDateTime.now();
            // Metadados - Width and Height
            BufferedImage bfImage = ImageIO.read(imageFile.getInputStream());
            int largura = 0;
            int altura = 0;
            if (bfImage != null) {
                largura = bfImage.getWidth();
                altura = bfImage.getHeight();
            }
            // Id do animal - Recupera animal com esse ID
            Long id_animal = (Long) imagemDTO.getIdAnimal();
            Animal animal = animalService.getAnimalById(id_animal);


            //Instanciar imagem e salvar os dados para o banco de dados
            Imagem imagem = new Imagem();
            imagem.setNome(fileName);
            imagem.setExtensao(extensao);
            imagem.setDataCaptura(dataCaptura);
            imagem.setInformacoesAdicionaisAnimal(comentarioExtra);
            imagem.setMetadados("width: " + String.valueOf(largura) + "height: " + String.valueOf(altura));
            imagem.setAnimal(animal);

            //Passa o caminho da pasta e a imagem - Salva imagem inserted
            Imagem lastImageAdded = service.addImagem(folderPath, imagem, imageFile);
            Long lastIdAdded = lastImageAdded.getId();
            System.out.println("Último ID inseted:" + lastIdAdded);

            //Criar Mockup de Análise da Imagem e salvar
            Analise analise = new Analise();
            analise.setImagem(lastImageAdded);
            analise.setDataAnalise(new Date());
            analise.setResultadosAnalise("infectado");
            analiseService.analiseAdd(analise);

        } else {
            return "redirect:/imagem/cadastroImagem";
        }
        return "redirect:/imagem/cadastroImagem";
    }

}
