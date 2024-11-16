package com.infracow.program.repositories;

import com.infracow.program.models.Analise;
import com.infracow.program.models.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Long> {

    @Query("SELECT a from Analise a WHERE a.imagem.id = :imagemId ORDER BY a.dataAnalise DESC ")
    List<Analise> findLastAnaliseByImage(@Param("imagemId") Long analiseId);

    default Analise getLastAnaliseByImage(Long imagemId){
        if(imagemId == null){
            return null;
        }
        List<Analise> analises = findLastAnaliseByImage(imagemId);
        return analises.isEmpty() ? null : analises.get(0);
    }

}
