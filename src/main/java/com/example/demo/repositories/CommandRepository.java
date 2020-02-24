package com.example.demo.repositories;


import com.example.demo.models.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommandRepository extends JpaRepository<Command, String> {

    @Query(value = "SELECT * FROM tb_command", nativeQuery = true)
    List<Command> findAll();
}