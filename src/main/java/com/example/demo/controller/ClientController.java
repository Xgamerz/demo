package com.example.demo.controller;

import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/listClients")
    public String clients(Model model) {
        Object items = clientService.getAll();
        model.addAttribute("clients", items);
        return "client/list"; //view
    }

    @GetMapping("/editClient")
    public String edit(@RequestParam(name = "id", required = true, defaultValue = "") String id, Model model) {
        Object item = clientService.getById(id);
        model.addAttribute("client", item);
        return "client/edit"; //view
    }

    @GetMapping("/createClient")
    public String create(Model model) {
        return "client/create"; //view
    }
}
