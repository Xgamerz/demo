package com.example.demo.controller;

import com.example.demo.models.Command;
import com.example.demo.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class CommandController {

    @Autowired
    private CommandService commandService;

    @GetMapping("/listCommands")
    public String commands(Model model) {
        Object items = commandService.getAll();
        model.addAttribute("commands", items);
        return "command/list"; //view
    }

    @GetMapping("/editCommand")
    public String edit(@RequestParam(name = "id", required = true, defaultValue = "") String id, Model model) {
        Object item = commandService.getById(id);
        model.addAttribute("command", item);
        return "command/edit"; //view
    }

    @GetMapping("/createCommand")
    public String create(Model model) {
        Command item = new Command();
        item.setId(UUID.randomUUID().toString());
        model.addAttribute("command", item);
        return "command/create"; //view
    }

    @PostMapping("/confirmCommand")
    public String edit(@Valid Command item, Model model) {
        if (item.getId() == null || item.getId().isEmpty()) {
            item.setId(UUID.randomUUID().toString());
        }

        commandService.save(item);
        //model.addAttribute("command", item);
        return "redirect:/listCommands"; //view
    }
}
