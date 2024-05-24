package com.example.bankmanagement.controller;

import com.example.bankmanagement.models.Savings;
import com.example.bankmanagement.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/savings")
public class SavingsController {

    @Autowired
    private SavingsService savingsService;

    @GetMapping
    public String listSavings(Model model) {
        List<Savings> savingsList = savingsService.findAll();
        model.addAttribute("savingsList", savingsList);
        return "savings/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("savings", new Savings());
        return "savings/add";
    }

    @PostMapping("/add")
    public String addSavings(@ModelAttribute Savings savings) {
        savingsService.save(savings);
        return "redirect:/savings";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Savings> savings = savingsService.findById(id);
        if (savings.isPresent()) {
            model.addAttribute("savings", savings.get());
            return "savings/edit";
        } else {
            return "redirect:/savings";
        }
    }

    @PostMapping("/edit/{id}")
    public String editSavings(@PathVariable Long id, @ModelAttribute Savings savings) {
        savings.setId(id);
        savingsService.save(savings);
        return "redirect:/savings";
    }

    @GetMapping("/delete/{id}")
    public String deleteSavings(@PathVariable Long id) {
        savingsService.deleteById(id);
        return "redirect:/savings";
    }

    @GetMapping("/search")
    public String searchSavings(@RequestParam("query") String query, Model model) {
        List<Savings> savingsList = savingsService.search(query);
        model.addAttribute("savingsList", savingsList);
        return "savings/lists";
    }

    @GetMapping("/stats")
    public String showStatistics(Model model) {
        // Logic to get statistics
        model.addAttribute("statistics", new Object()); // Replace with actual statistics object
        return "savings/stats";
    }
}
