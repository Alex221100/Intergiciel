package com.Data.Repository;

import com.Data.Entity.GlobalDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPostgreRepository extends JpaRepository<GlobalDAO, Integer> {

    Optional<GlobalDAO> findById(Integer Id);
}
