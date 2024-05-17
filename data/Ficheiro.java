package exercicios.exercicio_animais.data;

import exercicios.exercicio_animais.src.*;
import exercicios.exercicio_animais.src.Intervencao.Intervencao;

public class Ficheiro {
    String []ficheiros = {"Operacoes.txt", "Animal.txt", "Veterinario.txt", "Cliente.txt"};

    // Se os arquivos não existirem, cria-os
    public void criarFicheiros() {
        for (String ficheiro : ficheiros) {
            try {
                java.io.File file = new java.io.File(ficheiro);
                if (!file.exists()) {
                    java.io.PrintWriter output = new java.io.PrintWriter(file);
                    output.close();
                }
            } catch (java.io.IOException e) {
                System.out.println("Erro ao criar ficheiro: " + e);
            }
        }
    }

    // Escrever Veterinarios, Animais, Clientes e Intervenções nos respetivos ficheiros
    public void escreverFicheiros(Veterinario[] veterinarios, Animal[] animais, Cliente[] clientes, Operacao[] operacoes) {
        try {
            java.io.PrintWriter output = new java.io.PrintWriter(ficheiros[2]);
            for (Veterinario veterinario : veterinarios) {

                output.println(veterinario.hashCode() + "," + veterinario.getNome() + "," + veterinario.getTelefone() + "," + veterinario.getEmail() + "," + veterinario.getNif() + "," + veterinario.getIdOrdemVeterinarios()+ ";");
            }
            output.close();
        } catch (java.io.IOException e) {
            System.out.println("Erro ao escrever no ficheiro: " + e);
        }

        try {
            java.io.PrintWriter output = new java.io.PrintWriter(ficheiros[1]);
            for (Animal animal : animais) {
                output.println(animal.hashCode() + "," + animal.getNome() + "," + animal.getEspecie() + "," + animal.getPeso() + "," + animal.getSexoAnimal() + ";");
            }
            output.close();
        } catch (java.io.IOException e) {
            System.out.println("Erro ao escrever no ficheiro: " + e);
        }

        try {
            java.io.PrintWriter output = new java.io.PrintWriter(ficheiros[3]);
            for (Cliente cliente : clientes) {
                output.println(cliente.getNome() + ";" + cliente.getNif());
            }
            output.close();
        } catch (java.io.IOException e) {
            System.out.println("Erro ao escrever no ficheiro: " + e);
        }

        try {
            java.io.PrintWriter output = new java.io.PrintWriter(ficheiros[0]);
            for (Operacao operacao : operacoes) {
                output.println(operacao.hashCode() + "," + operacao.getDataOp() + "," + operacao.getIntervencao() + "," + operacao.getCusto() + "," + operacao.getDuracao() + "," + operacao.getIdVeterinario() + "," + operacao.getIdAnimal() + "," + operacao.getIdCliente() + ";");
            }
            output.close();
        } catch (java.io.IOException e) {
            System.out.println("Erro ao escrever no ficheiro: " + e);
        }
    }

}
