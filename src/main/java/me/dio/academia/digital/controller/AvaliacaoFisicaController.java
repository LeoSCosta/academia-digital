package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @GetMapping
    public List<AvaliacaoFisica> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public AvaliacaoFisica getById(@PathVariable Long id){
        return service.get(id);
    }

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm avaliacaoFisicaForm){
        return service.create(avaliacaoFisicaForm);
    }

    @PutMapping("/{id}")
    public AvaliacaoFisica update(@RequestBody AvaliacaoFisicaUpdateForm form, @PathVariable Long id){
        return service.update(id,form);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Long id){
        service.delete(id);
    }




}
