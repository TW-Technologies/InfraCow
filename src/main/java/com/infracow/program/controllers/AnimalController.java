package com.infracow.program.controllers;

import com.infracow.program.models.Analise;
import com.infracow.program.models.Animal;
import com.infracow.program.models.Imagem;
import com.infracow.program.services.AnaliseService;
import com.infracow.program.services.AnimalService;
import com.infracow.program.services.ImagemService;
import com.infracow.program.utils.Util;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.expression.Arrays;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService service;

    //Path of Images Folder
    String folderPath = "src/main/resources/images/analyses";

    @GetMapping("/animais")
    public ModelAndView getAnimais() {
        ModelAndView model = new ModelAndView("resultados");

        //Lista de animais
        List<Animal> listaAnimais = service.getAnimaisWithImages();
        //List to array
        Animal[] arrayAnimais = listaAnimais.toArray(new Animal[0]);

        //Ordenando A lista de animais
        Util.mergeSort(arrayAnimais, arrayAnimais.length);

        //Dashboard Data:
        int[] data_graficoPizzaRelacaoTotal = service.getPizzaDashboardDataOfAnimals(arrayAnimais);
        int[] data_graficoColunaCasosMensais = service.getGraficoColunaDataIndíciosMensais(arrayAnimais);
        for(int dado : data_graficoPizzaRelacaoTotal ){
            System.out.println("aaa"+ dado);
        }
        model.addObject("data_graficoPizzaRelacaoTotal", data_graficoPizzaRelacaoTotal);
        model.addObject("data_graficoColunaCasosMensais",  data_graficoColunaCasosMensais);

        model.addObject("animais", arrayAnimais);
        model.addObject("url", folderPath);
        return model;
    }

}
