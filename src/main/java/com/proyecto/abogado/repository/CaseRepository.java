package com.proyecto.abogado.repository;

import com.proyecto.abogado.model.CaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository<CaseModel, Long> {
}