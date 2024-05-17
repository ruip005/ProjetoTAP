// Cirurgia.java
package exercicios.exercicio_animais.src.Intervencao;

import exercicios.exercicio_animais.src.Animal;
import exercicios.exercicio_animais.src.Veterinario;

public class Cirurgia extends Intervencao {
    protected InterventionType interventionType = InterventionType.CIRURGIA;
    public Cirurgia(Veterinario veterinario, Animal animal, double distancia) {
        super(veterinario, animal, distancia);
    }

    @Override
    public double calcularCusto() { // Este método é comum a todas as intervenções, irá ser reescrito nas subclasses
        double custo = animal.getPeso() < 10 ? 200 : 400;
        if (distancia > 0) {
            custo += 40 + distancia;
        }
        return custo;
    }

    @Override
    public double calcularDuracao() { // Este método é comum a todas as intervenções, irá ser reescrito nas subclasses
        return 2;
    }

    public InterventionType getTipoIntervencao(){
        return interventionType;
    }
}