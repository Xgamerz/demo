package com.example.demo.repositories;


import com.example.demo.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/*
client repository
 */
public interface ClientRepository extends JpaRepository<Client, String> {

    //Client findByName(String name);

    /*
    execute native sql query to select all clients
     */
    @Query(value = "SELECT * FROM tb_client", nativeQuery = true)
    List<Client> findClients();
}