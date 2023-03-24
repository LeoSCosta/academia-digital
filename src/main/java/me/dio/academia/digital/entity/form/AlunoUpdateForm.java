package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlunoUpdateForm {

  private Long id;

  private String nome;

  private String bairro;

  private LocalDate dataDeNascimento;

  public Aluno update(Aluno aluno) {
    aluno.setNome(this.nome);
    aluno.setBairro(this.bairro);
    aluno.setDataDeNascimento(this.dataDeNascimento);
    return aluno;
  }
}
