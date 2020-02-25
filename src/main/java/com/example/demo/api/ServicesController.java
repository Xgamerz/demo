package com.example.demo.api;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.models.*;
import com.example.demo.service.*;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
Rest api to be used on other platformes (moblie desktop ...)
 */
@RestController
public class ServicesController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CommandService commandService;

    /*
    call service who delete clients
    @param id to define client who will be deleted
     */
    @DeleteMapping("/deleteClient")
    public boolean deleteClient(@RequestParam(value = "id", defaultValue = "") String id) {
        clientService.deleteById(id);
        return true;
    }

    /*
    call service who delete commands
    @param id to define client who will be deleted
     */
    @DeleteMapping("/deleteCommand")
    public boolean deleteCommand(@RequestParam(value = "id", defaultValue = "") String id) {
        commandService.deleteById(id);
        return true;
    }

    /*
    call service who get all clients
     */
    @GetMapping("/getClients")
    public Collection<Client> getClients() {
        return clientService.getAll();
    }

    /*
    call service who get all commands
     */
    @GetMapping("/getCommands")
    public Collection<Command> getCommands() {
        return commandService.getAll();
    }

    /*
    call service who edit clients
    @param item is client to be saved
     */
    @PutMapping("/putClient")
    @ResponseBody
    public Client editClient(@RequestBody Client item) {
        clientService.save(item);
        return item;
    }

    /*
    call service who add clients
    @param item is client to be added
     */
    @PostMapping("/postClient")
    @ResponseBody
    public Client addClient(@RequestBody Client item) {
        item.setId(UUID.randomUUID().toString()); //init new id of item before add to database
        clientService.save(item);
        return item;
    }
}