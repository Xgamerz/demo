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
        try {
            Object items = clientService.getAll();
            model.addAttribute("clients", items);
        } catch (Exception ex) {
            //model.addAttribute("exception", ex);
            //return "error"; //view
            new RuntimeException("listClients exception");
        }
        return "client/list"; //view
    }

    @GetMapping("/editClient")
    public String edit(@RequestParam(name = "id", required = true, defaultValue = "") String id, Model model) {
        try {
            Object item = clientService.getById(id);
            model.addAttribute("client", item);
        } catch (Exception ex) {
            //model.addAttribute("exception", ex);
            //return "error"; //view
            new RuntimeException("editClient exception");
        }
        return "client/edit"; //view
    }

    @GetMapping("/createClient")
    public String create(Model model) {
        try {
            //todo
        } catch (Exception ex) {
            //model.addAttribute("exception", ex);
            //return "error"; //view
            new RuntimeException("createClient exception");
        }
        return "client/create"; //view
    }
}
