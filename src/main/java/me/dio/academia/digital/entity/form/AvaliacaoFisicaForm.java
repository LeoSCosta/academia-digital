package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisicaForm {

  private Long alunoId;

  private double peso;

  private double altura;

    public AvaliacaoFisica toAvaliacaoFisica() {
      AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
      avaliacaoFisica.setPeso(this.peso);
      avaliacaoFisica.setAltura(this.altura);
      return avaliacaoFisica;
    }
}
