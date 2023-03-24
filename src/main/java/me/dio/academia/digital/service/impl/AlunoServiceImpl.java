package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository repository;



    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = form.toAluno();
        return repository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        if (dataDeNascimento == null){
            return repository.findAll();
        }
        return repository.findByDataDeNascimento(LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER));
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        return null;
    }

    @Override
    public Aluno update(AlunoUpdateForm form) {
        if(repository.findById(form.getId()).isPresent()){
            Aluno aluno = repository.findById(form.getId()).get();
            aluno = form.update(aluno);
            repository.save(aluno);
        };
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacoes(Long id) {
        if(repository.findById(id).isPresent()){
            return repository.findById(id).get().getAvaliacoes();
        }
        return null;
    }
}
