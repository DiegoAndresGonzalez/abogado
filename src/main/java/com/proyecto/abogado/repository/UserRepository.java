package com.proyecto.abogado.repository;

import com.proyecto.abogado.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {

    Optional<UserModel> findByDni(String dni);
    UserModel findRoleByDni(String dni);
}
