package exercicios.exercicio_animais.src;

import exercicios.exercicio_animais.src.*;
import exercicios.exercicio_animais.src.Intervencao.Intervencao;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ficheiro {
    private static String[] ficheiros = {"Veterinarios.txt", "VeterinarioClientes.txt", "VeterinarioAnimais.txt", "Operacoes.txt", "Clientes.txt", "ClientesAnimais.txt", "Animais.txt"};

    // Se os arquivos não existirem, cria-os
    public static void criarFicheiros() {
        for (String ficheiro : ficheiros) {
            try {
                java.io.File file = new java.io.File("data/"+ficheiro);
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

    public static <K, V> void escreverFicheiro(HashMap<K, V> map, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (entry.getValue() instanceof Veterinario){
                    Veterinario vet = (Veterinario) entry.getValue();
                    writer.write(entry.getKey().toString() + ":" + vet.getNome() + ":" + vet.getTelefone() + ":" + vet.getEmail() + ":" + vet.getNif() + ":" + vet.getIdOrdemVeterinarios() + "\n");
                } else if (entry.getValue() instanceof Cliente){
                    Cliente cliente = (Cliente) entry.getValue();
                    writer.write(entry.getKey().toString() + ":" + cliente.getNome() + ":" + cliente.getTelefone() + ":" + cliente.getEmail() + ":" + cliente.getNif() + ":" + cliente.getNomeRua() + ":" + cliente.getnPorta() + ":" + cliente.getCp() + ":" + cliente.getLocalidade() + "\n");
                } else if (entry.getValue() instanceof Animal){
                    Animal animal = (Animal) entry.getValue();
                    writer.write(entry.getKey().toString() + ":" + animal.getNome() + ":" + animal.getEspecie() + ":" + animal.getPeso() + ":" + animal.getSexoAnimal() + ":" + animal.getDono() + "\n");
                } else if (entry.getValue() instanceof Intervencao){
                    Intervencao intervencao = (Intervencao) entry.getValue();
                    writer.write(entry.getKey().toString() + ":" + intervencao.getVeterinario() + ":" + intervencao.getAnimal() + ":" + intervencao.getDistancia() + "\n");
                } else if (entry.getValue() instanceof Operacao){
                    Operacao operacao = (Operacao) entry.getValue();
                    String newHora = operacao.getHora().toString();
                    // 09:00 -> 09-00
                    newHora = newHora.replace(":", "-");
                    writer.write(entry.getKey().toString() + ":" + operacao.getDataOp() + ":" + newHora + ":" + operacao.getIntervencao() + ":" + operacao.getIdVeterinario() + ":" + operacao.getIdAnimal() + ":" + operacao.getIdCliente() + ":" + operacao.getCusto() + ":" + operacao.getDuracao() + "\n");
                } else
                writer.write(entry.getKey().toString() + ":" + entry.getValue().toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no ficheiro: " + e);
        }
    }

    // Guardar dados no ficheiro
    public static <K, V> HashMap<K, V> carregarDados(String fileName) {
        HashMap<K, V> map = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                if (fileName.contains("data/Veterinarios.txt")) {
                    Veterinario vet = new Veterinario(parts[1], Integer.parseInt(parts[2]), parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                    Veterinario.adicionarVeterinario(vet);
                    map.put((K) parts[0], (V) vet);
                } else if (fileName.contains("data/Clientes.txt")) {
                    Cliente cliente = new Cliente(parts[1], Integer.parseInt(parts[2]), parts[3], Integer.parseInt(parts[4]), parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7]), parts[8]);
                    Cliente.adicionarCliente(cliente);
                    map.put((K) parts[0], (V) cliente);
                } else if (fileName.contains("data/Animais.txt")) {
                    Animal animal = new Animal(parts[1], parts[2], Float.parseFloat(parts[3]), Animal.Genero.valueOf(parts[4]), Integer.parseInt(parts[5]));
                    Animal.adicionarAnimal(animal);
                    map.put((K) parts[0], (V) animal);
                } else if (fileName.contains("data/Operacoes.txt")) {
                    LocalTime hora = LocalTime.parse(parts[2].replace("-", ":"));
                    Operacao operacao = new Operacao(LocalDate.parse(parts[1]), hora, Intervencao.InterventionType.valueOf(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]), Double.parseDouble(parts[7]), Double.parseDouble(parts[8]));
                    Operacao.adicionarOperacao(operacao);
                    map.put((K) parts[0], (V) operacao);
                } else if(fileName.contains("data/VeterinarioClientes.txt")) {
                    Veterinario.adicionarClienteVeterinario(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                    map.put((K) parts[0], (V) parts[1]);
                } else if(fileName.contains("data/VeterinarioAnimais.txt")) {
                    Veterinario.adicionarAnimalVeterinario(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                    map.put((K) parts[0], (V) parts[1]);
                } else if(fileName.contains("data/ClientesAnimais.txt")) {
                    Cliente.adicionarAnimalCliente(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                    map.put((K) parts[0], (V) parts[1]);
                } else {
                    map.put((K) parts[0], (V) parts[1]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao carregar dados do ficheiro: " + e);
        }
        return map;
    }
}

