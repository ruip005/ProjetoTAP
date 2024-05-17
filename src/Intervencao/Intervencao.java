// IntervencaoBase.java
package exercicios.exercicio_animais.src.Intervencao;

import exercicios.exercicio_animais.src.Animal;
import exercicios.exercicio_animais.src.Veterinario;

public abstract class Intervencao {
    public enum InterventionType {
        VACINACAO, CONSULTA, CIRURGIA
    }

    protected Veterinario veterinario;
    protected Animal animal;
    protected double distancia;
    protected InterventionType interventionType;

    public Intervencao(Veterinario veterinario, Animal animal, double distancia, InterventionType interventionType) {
        this.veterinario = veterinario;
        this.animal = animal;
        this.distancia = distancia;
        this.interventionType = interventionType;
    }

    public abstract double calcularCusto();
    public abstract double calcularDuracao();
    public abstract String getTipoIntervencao();
}