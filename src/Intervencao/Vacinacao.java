// Vacinacao.java
package exercicios.exercicio_animais.src.Intervencao;

import exercicios.exercicio_animais.src.Animal;
import exercicios.exercicio_animais.src.Veterinario;

public class Vacinacao extends Intervencao {

    public Vacinacao(Veterinario veterinario, Animal animal, double distancia) {
        super(veterinario, animal, distancia);
    }

    @Override
    public double calcularCusto() { // Este método é comum a todas as intervenções, irá ser reescrito nas subclasses
        double custo = animal.getPeso() < 10 ? 50 : 100;
        if (distancia > 0) {
            custo += 40 + distancia;
        }
        return custo;
    }

    @Override
    public double calcularDuracao() { // Este método é comum a todas as intervenções, irá ser reescrito nas subclasses
        return 0.5;
    }

    public String getTipoIntervencao(){
        return "Vacinação";
    }
}