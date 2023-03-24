package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        if(alunoRepository.findById(form.getAlunoId()).isPresent()){
            AvaliacaoFisica avaliacaoFisica = form.toAvaliacaoFisica();
            avaliacaoFisica.setAluno(alunoRepository.findById(form.getAlunoId()).get());
            return avaliacaoFisicaRepository.save(avaliacaoFisica);
        }
        return null;
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        if (avaliacaoFisicaRepository.findById(id).isPresent()){
            return avaliacaoFisicaRepository.findById(id).get();
        }
        return null;
    }
    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        if (alunoRepository.findById(id).isPresent() && avaliacaoFisicaRepository.findById(formUpdate.getId()).isPresent()){
            AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(formUpdate.getId()).get();
            avaliacaoFisica = formUpdate.update(avaliacaoFisica);
            return avaliacaoFisicaRepository.save(avaliacaoFisica);
        }
        return null;
    }
    @Override
    public void delete(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}
