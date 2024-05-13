package exercicios.exercicio_animais.src;

import java.util.HashMap;

public class Veterinario extends Pessoa {
    private static HashMap<Integer, Veterinario> veterinarios = new HashMap<>(); // static para poder ser acedido por Gestor
    private HashMap<Integer, Cliente> clientes = new HashMap<>();
    private Integer idOrdemVeterinarios;

    public Veterinario(String nome, Integer telefone, String email, Integer nif, Integer idOrdemVeterinarios) {
        super(nome, telefone, email, nif);
        this.idOrdemVeterinarios = idOrdemVeterinarios;
    }

    public Integer getIdOrdemVeterinarios() {
        return idOrdemVeterinarios;
    }

    public void setIdOrdemVeterinarios(Integer idOrdemVeterinarios) {
        this.idOrdemVeterinarios = idOrdemVeterinarios;
    }

    public Integer lastId() {
        return veterinarios.size();
    }

    public void adicionarVeterinario(Veterinario veterinario) {
        veterinarios.put(lastId()+1, veterinario);
    }
    public static HashMap<Integer, Veterinario> getVeterinarios() { // static para poder ser acedido por Gestor
        return veterinarios;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.put(cliente.hashCode(), cliente);
    }

    public HashMap<Integer, Cliente> getClientes() {
        return clientes;
    }
}