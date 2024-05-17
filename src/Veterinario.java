package exercicios.exercicio_animais.src;

import exercicios.exercicio_animais.src.Intervencao.Intervencao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Veterinario extends Pessoa {
    private static HashMap<Integer, Veterinario> veterinarios = new HashMap<>(); // static para poder ser acedido por Gestor
    private static HashMap<Integer, ArrayList<Integer>> veterinarioClientes = new HashMap<Integer, ArrayList<Integer>>();
    private static HashMap<Integer, ArrayList<Integer>> veterinarioAnimais = new HashMap<Integer, ArrayList<Integer>>();
    private static Integer nextId = 1;
    private Integer idOrdemVeterinarios;
    private Integer idVet;
    public Veterinario(String nome, Integer telefone, String email, Integer nif, Integer idOrdemVeterinarios) {
        super(nome, telefone, email, nif);
        this.idOrdemVeterinarios = idOrdemVeterinarios;
        this.idVet = nextId++;
    }

//Mostrar todas as operacoes de um Veterinário de uma determoperacoes



    public Integer getIdOrdemVeterinarios() {
        return idOrdemVeterinarios;
    }

    public Integer getIdVet() {
        return idVet;
    }

    public static Veterinario getVetById(Integer id){
    return veterinarios.get(id);
    }

    public void setIdOrdemVeterinarios(Integer idOrdemVeterinarios) {
        this.idOrdemVeterinarios = idOrdemVeterinarios;
    }

    public static void adicionarVeterinario(Veterinario veterinario) {
        veterinarios.put(veterinario.idVet, veterinario);
    }
    public static HashMap<Integer, Veterinario> getVeterinarios() { // static para poder ser acedido por Gestor
        return veterinarios;
    }

    public static void adicionarClienteVeterinario(Integer idVeterinario, Integer idCliente) {
        if (veterinarios.containsKey(idVeterinario) == false) {
            System.out.println("Veterinário não existe");
            return;
        }
        if (Cliente.getClienteByID(idCliente) == null) { // Verificar se o cliente existe (método estático
            System.out.println("Cliente não existe");
            return;
        }
        if (veterinarioClientes.containsKey(idVeterinario)) {
            ArrayList<Integer> clientes = veterinarioClientes.get(idVeterinario);
            clientes.add(idCliente);
            veterinarioClientes.put(idVeterinario, clientes);
        } else {
            ArrayList<Integer> clientes = new ArrayList<>();
            clientes.add(idCliente);
            veterinarioClientes.put(idVeterinario, clientes);
        }
    }

    public static ArrayList<Integer> getClientesVeterinario(Integer idVeterinario) {
        if (veterinarioClientes.containsKey(idVeterinario)) {
            return veterinarioClientes.get(idVeterinario);
        } else {
            return null;
        }
    }

    public static Veterinario getVeterinarioById(int id) { // Verificar se a chave existe no HashMap | static para poder ser acedido por outras classes
        if (veterinarios.containsKey(id)) {
            return veterinarios.get(id);
        } else {
            return null;
        }
    }

    public static void adicionarAnimalVeterinario(Integer idVeterinario, Integer idAnimal) {
        if (veterinarios.containsKey(idVeterinario) == false) {
            System.out.println("Veterinário não existe");
            return;
        }
        if (Animal.getAnimalById(idAnimal) == null) { // Verificar se o animal existe (método estático)
            System.out.println("Animal não existe");
            return;
        }
        if (veterinarioAnimais.containsKey(idVeterinario)) {
            ArrayList<Integer> animais = veterinarioAnimais.get(idVeterinario);
            animais.add(idAnimal);
            veterinarioAnimais.put(idVeterinario, animais);
        } else {
            ArrayList<Integer> animais = new ArrayList<>();
            animais.add(idAnimal);
            veterinarioAnimais.put(idVeterinario, animais);
        }
    }

    public static ArrayList<Integer> getAnimaisVeterinario(Integer idVeterinario) {
        if (veterinarioAnimais.containsKey(idVeterinario)) {
            return veterinarioAnimais.get(idVeterinario);
        } else {
            return null;
        }
    }

    public static HashMap<Integer, ArrayList<Integer>> getAllVeterinarioAnimais() {
        return veterinarioAnimais;
    }

    public static HashMap<Integer, ArrayList<Integer>> getAllVeterinarioClientes() {
        return veterinarioClientes;
    }

}