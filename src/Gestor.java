// Gestor.java
package exercicios.exercicio_animais.src;

import java.util.HashMap;

public class Gestor {
    public void imprimirVeterinarios() {
        HashMap<Integer, Veterinario> veterinarios = Veterinario.getVeterinarios(); // Instanciar a classe Veterinario para aceder ao método getVeterinarios

        for (Veterinario veterinario : veterinarios.values()) {
            System.out.println(veterinario.getNome());
        }
    }
}