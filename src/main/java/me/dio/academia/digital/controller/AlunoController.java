package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @Autowired
    private MatriculaServiceImpl matriculaService;

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)String dataDeNascimento){

        return service.getAll(dataDeNascimento);
    }

    @PostMapping
    public Aluno create (@RequestBody AlunoForm form){
        Aluno aluno = service.create(form);
        matriculaService.create(aluno);
        return aluno;
    }

    @GetMapping("/avaliacoes/{id}")
    public List<AvaliacaoFisica> getAllAvaliacaoFisica(@PathVariable Long id){
        return service.getAllAvaliacoes(id);
    }
    @PutMapping
    public Aluno update(@RequestBody AlunoUpdateForm form){
        return service.update(form);
    }

    @DeleteMapping("/{id}")
    public void Aluno(@PathVariable Long id){
        service.delete(id);
    }
}
