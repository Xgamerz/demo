package com.example.demo.controller;

import com.example.demo.models.Command;
import com.example.demo.service.ClientService;
import com.example.demo.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class CommandController {

    @Autowired
    private CommandService commandService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/listCommands")
    public String commands(Model model) {
        try {
            Object items = commandService.getAll();
            model.addAttribute("commands", items);
        } catch (Exception ex) {
            //model.addAttribute("exception", ex);
            //return "error"; //view
            new RuntimeException("listCommands exception");
        }
        return "command/list"; //view
    }

    @GetMapping("/editCommand")
    public String edit(@RequestParam(name = "id", required = true, defaultValue = "") String id, Model model) {
        try {
            Object item = commandService.getById(id);
            model.addAttribute("command", item);
            model.addAttribute("clients", clientService.getAll());
        } catch (Exception ex) {
            //model.addAttribute("exception", ex);
            //return "error"; //view
            new RuntimeException("editCommand exception");
        }
        return "command/edit"; //view
    }

    @GetMapping("/createCommand")
    public String create(Model model) {
        try {
            Command item = new Command();
            item.setId(UUID.randomUUID().toString());
            model.addAttribute("command", item);
            model.addAttribute("clients", clientService.getAll());
        } catch (Exception ex) {
            //model.addAttribute("exception", ex);
            //return "error"; //view
            new RuntimeException("createCommand exception");
        }
        return "command/create"; //view
    }

    @PostMapping("/confirmCommand")
    public String edit(@Valid Command item, BindingResult bindingResult, Model model) {
        try {
            if (item.getId() == null || item.getId().isEmpty()) {
                item.setId(UUID.randomUUID().toString());
            }
            commandService.save(item);
        } catch (Exception ex) {
            //model.addAttribute("exception", ex);
            //return "error"; //view
            new RuntimeException("confirmCommand exception");
        }
        return "redirect:/listCommands"; //view
    }
}
