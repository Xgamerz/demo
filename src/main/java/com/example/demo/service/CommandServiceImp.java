package com.example.demo.service;

import com.example.demo.models.Client;
import com.example.demo.models.Command;
import com.example.demo.repositories.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CommandServiceImp implements CommandService {

    @Autowired
    private CommandRepository commandRepository;

    @Override
    public Collection<Command> getAll() {

        return commandRepository.findAll();
    }

    @Override
    public void save(Command item) {

        commandRepository.save(item);
    }

    @Override
    public void delete(Command item) {

        commandRepository.delete(item);
    }

    @Override
    public void deleteById(String id) {

        commandRepository.deleteById(id);
    }

    @Override
    public Command getById(String id) {

        return commandRepository.findById(id).orElse(null);
    }
}