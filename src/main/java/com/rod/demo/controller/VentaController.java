package com.rod.demo.controller;

import com.rod.demo.dao.VentaRepository;
import com.rod.demo.service.VentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VentaController {

    private final VentaService ventaService;
    private final VentaRepository repository;

    public VentaController(VentaService ventaService, VentaRepository ventaRepository){
        this.repository=ventaRepository;
        this.ventaService = ventaService;
    }

    @GetMapping("/")
    public String carga() {
        return "carga";
    }

    @PostMapping("/cargar")
    public String carga(@RequestParam("archivos") MultipartFile file) {
        ventaService.save(file);

        return "redirect:/listado";
    }

    @GetMapping("/listado")
    public String getListado(Model modelo) {
        modelo.addAttribute("totalCountries", repository.countDistinctCountry());
        modelo.addAttribute("totalRegions", repository.countDistinctRegion());
        modelo.addAttribute("totalItemTypes", repository.countDistinctItemTypes());
        modelo.addAttribute("totalSalesChannels", repository.countDistinctSalesChannel());
        modelo.addAttribute("totalOrderPriorities", repository.countDistinctOrderPriority());
        return "listado";
    }

    @RequestMapping(value="/download")
    public String download( RedirectAttributes ms) {
        ventaService.crearCSV();
        ms.addFlashAttribute("mensaje", "Archivo exportado correctamente.");
        return "redirect:/listado";
    }


}
