package com.infracow.program.services;

import com.infracow.program.models.Imagem;
import com.infracow.program.repositories.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository repository;

    public Imagem addImagem(String path, Imagem obj, MultipartFile file) throws IOException {
        //Inserir Imagem na pasta
        Path folderPath = Path.of(path);
        Path filePath = folderPath.resolve(obj.getNome() + "." + obj.getExtensao());

        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        System.out.println(filePath.toString());

        //Inserir dados de imagem no banco de dados
        return repository.save(obj);
    }

    public List<Imagem> getImages(){
        return repository.findAll();
    }

}
