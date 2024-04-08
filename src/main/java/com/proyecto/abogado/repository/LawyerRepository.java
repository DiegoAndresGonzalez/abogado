package com.proyecto.abogado.repository;

import com.proyecto.abogado.model.LawyerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LawyerRepository extends JpaRepository<LawyerModel,Long> {

    Optional<LawyerModel> findByDni(String dni);
    LawyerModel findRoleByDni(String dni);
}
