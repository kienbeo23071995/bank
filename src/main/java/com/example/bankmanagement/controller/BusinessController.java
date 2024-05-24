package com.example.bankmanagement.controller;

import com.example.bankmanagement.models.BusinessContract;
import com.example.bankmanagement.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping
    public String listBusinessContracts(Model model) {
        List<BusinessContract> businessList = businessService.findAll();
        model.addAttribute("businessList", businessList);
        return "business/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("businessContract", new BusinessContract());
        return "business/add";
    }

    @PostMapping("/add")
    public String addBusinessContract(@ModelAttribute BusinessContract businessContract) {
        businessService.save(businessContract);
        return "redirect:/business";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<BusinessContract> businessContract = businessService.findById(id);
        if (businessContract.isPresent()) {
            model.addAttribute("businessContract", businessContract.get());
            return "business/edit";
        } else {
            return "redirect:/business";
        }
    }

    @PostMapping("/edit/{id}")
    public String editBusinessContract(@PathVariable Long id, @ModelAttribute BusinessContract businessContract) {
        businessContract.setId(id);
        businessService.save(businessContract);
        return "redirect:/business";
    }

    @GetMapping("/delete/{id}")
    public String deleteBusinessContract(@PathVariable Long id) {
        businessService.deleteById(id);
        return "redirect:/business";
    }

    @GetMapping("/search")
    public String searchBusinessContracts(@RequestParam("query") String query, Model model) {
        List<BusinessContract> businessList = businessService.search(query);
        model.addAttribute("businessList", businessList);
        return "business/list";
    }

    @GetMapping("/stats")
    public String showStatistics(Model model) {
        // Logic to get statistics
        model.addAttribute("statistics", new Object()); // Replace with actual statistics object
        return "business/stats";
    }
}
