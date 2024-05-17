// IntervencaoBase.java
package exercicios.exercicio_animais.src.Intervencao;

import exercicios.exercicio_animais.src.Animal;
import exercicios.exercicio_animais.src.Veterinario;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Intervencao {
    public enum InterventionType {
        VACINACAO, CONSULTA, CIRURGIA
    }

    protected Veterinario veterinario;
    protected Animal animal;
    protected double distancia;
    public Intervencao(Veterinario veterinario, Animal animal, double distancia) {
        this.veterinario = veterinario;
        this.animal = animal;
        this.distancia = distancia;
    }


    public abstract double calcularCusto();
    public abstract double calcularDuracao();
    public abstract InterventionType getTipoIntervencao();
    public int calcularKms(int distancia){
        int value = Math.abs(distancia);
        if (value == 0){
            return 0;
        } else {
            return 40+value;
        }
    }
}
