package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.AvaliacaoFisica;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AvaliacaoFisicaUpdateForm {

  private Long id;
  private double peso;

  private double altura;

    public AvaliacaoFisica update(AvaliacaoFisica avaliacaoFisica) {
      avaliacaoFisica.setPeso(this.peso);
      avaliacaoFisica.setAltura(this.altura);
      return avaliacaoFisica;
    }
}
