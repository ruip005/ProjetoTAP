package exercicios.exercicio_animais.src;

import java.util.HashMap;

public class Cliente extends Pessoa {
    HashMap <Integer, Cliente> clientes = new HashMap<>();
    HashMap <Integer, Animal> animais = new HashMap<>();
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

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
        veterinario.adicionarCliente(this);
    }
    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
        animal.setCliente(this);
    }

    public Animal getAnimal() {
        return animal;
    }

    public HashMap<Integer, Animal> getAnimais() {
        return animais;
    }
}