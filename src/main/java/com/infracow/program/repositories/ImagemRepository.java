package com.infracow.program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infracow.program.models.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {
}
