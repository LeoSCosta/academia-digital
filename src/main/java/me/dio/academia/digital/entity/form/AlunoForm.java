package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlunoForm {

  private String nome;

  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

    public Aluno toAluno() {
      Aluno aluno = new Aluno();
      aluno.setNome(this.nome);
      aluno.setCpf(this.cpf);
      aluno.setBairro(this.bairro);
      aluno.setDataDeNascimento(this.dataDeNascimento);
      return aluno;
    }


}
