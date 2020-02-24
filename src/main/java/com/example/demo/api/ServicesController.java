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

@RestController
public class ServicesController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CommandService commandService;

    @DeleteMapping("/deleteClient")
    public boolean deleteClient(@RequestParam(value = "id", defaultValue = "") String id) {
        clientService.deleteById(id);
        return true;
    }

    @DeleteMapping("/deleteCommand")
    public boolean deleteCommand(@RequestParam(value = "id", defaultValue = "") String id) {
        commandService.deleteById(id);
        return true;
    }

    @GetMapping("/getClient")
    public Client getClient(@RequestParam(value = "name", defaultValue = "World") String name) {
        //Optional<Client> item;
        Client item = clientService.getById("test");
        //item = Optional.of(new Client());
        //Client client = item.get();
        item.setFirstName(name);
        return item;
    }

    @GetMapping("/getClients")
    public Collection<Client> getClients() {
        return clientService.getAll();
    }

    @GetMapping("/getCommands")
    public Collection<Command> getCommands() {
        return commandService.getAll();
    }

    @PutMapping("/putClient")
    @ResponseBody
    public Client putClient(@RequestBody Client item) {
        clientService.save(item);
        return item;
    }

    @PostMapping("/postClient")
    @ResponseBody
    public Client postClient(@RequestBody Client item) {
        item.setId(UUID.randomUUID().toString());
        clientService.save(item);
        return item;
    }
}