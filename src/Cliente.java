package exercicios.exercicio_animais.src;

import java.util.ArrayList;
import java.util.HashMap;

public class Cliente extends Pessoa {
    private static HashMap <Integer, Cliente> clientes = new HashMap<>();
    private static HashMap<Integer, ArrayList<Integer>> clienteAnimais = new HashMap<Integer, ArrayList<Integer>>();
    private Veterinario veterinario;
    private Animal animal;
    private String nomeRua;
    private Integer nPorta;
    private Integer cp;
    private String localidade;

    public Cliente (String nome, Integer telefone, String email, Integer nif, String nomeRua, Integer nPorta, Integer cp, String localidade) {
        super(nome, telefone, email, nif);
        this.nomeRua = nomeRua;
        this.nPorta = nPorta;
        this.cp = cp;
        this.localidade = localidade;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public Integer getnPorta() {
        return nPorta;
    }

    public void setnPorta(Integer nPorta) {
        this.nPorta = nPorta;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Integer lastId() {
        return clientes.size();
    }
    public void adicionarCliente(Cliente cliente) {
        clientes.put(lastId()+1, cliente);
    }

    public HashMap<Integer, Cliente> getClientes() {
        return clientes;
    }

    public static void adicionarAnimalCliente(Integer idCliente, Integer idAnimal) {
        if (clientes.containsKey(idCliente) == false) {
            System.out.println("Cliente não existe");
            return;
        }
        if (Animal.getAnimalById(idAnimal) == null) { // Verificar se o animal existe (método estático)
            System.out.println("Animal não existe");
            return;
        }
        if (clienteAnimais.containsKey(idCliente)) {
            ArrayList<Integer> animais = clienteAnimais.get(idCliente);
            animais.add(idAnimal);
            clienteAnimais.put(idCliente, animais);
        } else {
            ArrayList<Integer> animais = new ArrayList<>();
            animais.add(idAnimal);
            clienteAnimais.put(idCliente, animais);
        }
    }

    public static ArrayList<Integer> getAnimaisCliente(Integer idCliente) {
        if (clienteAnimais.containsKey(idCliente)) {
            return clienteAnimais.get(idCliente);
        } else {
            return null;
        }
    }


    
    public static Cliente getClienteByID(int id) {
        if (clientes.containsKey(id)) { // Verificar se a chave existe no HashMap | static para poder ser acedido por outras classes
            return clientes.get(id);
        } else {
            return null;
        }
    }
}