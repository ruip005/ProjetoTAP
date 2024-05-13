// IntervencaoBase.java
package exercicios.exercicio_animais.src.Intervencao;

import exercicios.exercicio_animais.src.Animal;
import exercicios.exercicio_animais.src.Veterinario;

public abstract class Intervencao { // Criar uma classe abstrata Intervencao, com 3 subclasses (Vacinacao, Consulta e Cirurgia)
    protected Veterinario veterinario;
    protected Animal animal;
    protected double distancia;

    public Intervencao(Veterinario veterinario, Animal animal, double distancia) {
        this.veterinario = veterinario;
        this.animal = animal;
        this.distancia = distancia;
    }

    // Uma classe abstrata é uma classe que não pode ser instanciada, ou seja, não é possível criar um objeto a partir dela.
    public abstract double calcularCusto(); // Este metodo deve ser implementado nas subclasses
    public abstract double calcularDuracao(); // Este metodo deve ser implementado nas subclasses
}