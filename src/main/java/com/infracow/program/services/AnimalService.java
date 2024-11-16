package com.infracow.program.services;

import com.infracow.program.models.Analise;
import com.infracow.program.models.Animal;
import com.infracow.program.models.Imagem;
import com.infracow.program.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    @Autowired
    private ImagemService imagemService;

    @Autowired
    private AnaliseService analiseService;

    public List<Animal> getAnimais() {
        return repository.findAll();
    }

    public List<Animal> getAnimaisWithImages() {
        return repository.findAllWithImages();
    }

    public Animal getAnimalById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Animal Não Encontrado"));
    }

    public List<Analise>  getAnimalsAnalisesByDate(LocalDateTime startDate, LocalDateTime endDate) {
        return repository.findAnimalsAnalisesByDate(startDate, endDate);
    }

    public int[] getPizzaDashboardDataOfAnimals(Animal[] animaisList) {
        //Dashboard - DATA
        /*Declaração de array com tamanho 3 ["quantidade de animais com indicio de drb",
        "quantidade de anmimais saudáveis", "quantidade de animais não analisados"]*/
        int[] data_graficoPizzaRelacaoTotal = new int[3];
        int qtd_animaisInfectado = 0, qtd_animaisSaudaveis = 0, qtd_anaimaisNaoAnalisados = 0;

        for (int i = 0; i < animaisList.length; i++) {
            Imagem lastImagem = imagemService.getLastImageByAnimal(animaisList[i].getId());
            Analise lastImagemAnalise = analiseService.getLastAnaliseByImage(lastImagem.getId());
            switch (lastImagemAnalise.getResultadosAnalise()) {
                case "infectado":
                    qtd_animaisInfectado++;
                    break;
                case "saudavel":
                    qtd_animaisSaudaveis++;
                    break;
                default:
                    qtd_anaimaisNaoAnalisados++;
                    break;
            }
        }
        data_graficoPizzaRelacaoTotal[0] = qtd_animaisInfectado;
        data_graficoPizzaRelacaoTotal[1] = qtd_animaisSaudaveis;
        data_graficoPizzaRelacaoTotal[2] = qtd_anaimaisNaoAnalisados;
        return data_graficoPizzaRelacaoTotal;
    }

    public int countAnimalsWithAnalysesInPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        List<Analise> allAnalises = repository.findAnimalsAnalisesByDate(startDate, endDate);

        // Map para armazenar a última análise por animal
        Map<Long, Analise> latestAnalysesByAnimal = new HashMap<>();

        for (Analise analise : allAnalises) {
            Long animalId = analise.getImagem().getAnimal().getId();
            Analise existingAnalise = latestAnalysesByAnimal.get(animalId);

            // Verifica se esta análise é mais recente
            if (existingAnalise == null || analise.getDataAnalise().after(existingAnalise.getDataAnalise())) {
                latestAnalysesByAnimal.put(animalId, analise);
            }
        }

        // Retorna a quantidade de animais com pelo menos uma análise no período
        return latestAnalysesByAnimal.size();
    }

    public int[] getGraficoColunaDataIndíciosMensais(Animal[] animaisList) {
        //Dashboard - DATA

        //Data atual
        LocalDateTime dataAtual = LocalDateTime.now();
        int mesAtual = dataAtual.getMonthValue();
        int anoAtual = dataAtual.getYear();

        /*Declaração de array com tamanho um para cada mês*/
        int[] data_GraficoColunaIndíciosMensais = new int[mesAtual];


        for (int i = 0; i < mesAtual; i++) {
            for (Animal animal : animaisList) {
                LocalDateTime startDate = LocalDateTime.of(anoAtual, i + 1, 1, 0, 0);
                LocalDateTime endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

                // Busca o total de animais infectados para o mês atual
                data_GraficoColunaIndíciosMensais[i] = countAnimalsWithAnalysesInPeriod(startDate, endDate)     ;
            }
        }

        return data_GraficoColunaIndíciosMensais;
    }
}
