package com.example.demo.service;

import com.example.demo.models.Client;
import com.example.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Collection<Client> getAll() {

        return clientRepository.findAll();
    }

    @Override
    public void save(Client item) {
        clientRepository.save(item);
    }

    @Override
    public void delete(Client item) {
        clientRepository.delete(item);
    }

    @Override
    //@Transactional
    public void deleteById(String id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client getById(String id) {

        return clientRepository.findById(id).orElse(null);
    }
}
