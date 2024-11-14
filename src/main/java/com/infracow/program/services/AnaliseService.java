package com.infracow.program.services;

import com.infracow.program.models.Analise;
import com.infracow.program.repositories.AnaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {

    @Autowired
    private AnaliseRepository repository;

    public Analise analiseAdd(Analise analise){
        return repository.save(analise);
    }


}
