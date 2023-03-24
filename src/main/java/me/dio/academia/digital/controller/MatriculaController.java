package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl matriculaService;

    @GetMapping
    public List<Matricula> getAll(){
        return matriculaService.getAll();
    }
    @GetMapping("/{id}")
    public Matricula getById(@PathVariable Long id){
        return matriculaService.get(id);
    }

    @DeleteMapping
    public void delete(Long id){
        matriculaService.delete(id);
    }
}
