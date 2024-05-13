// Animal.java
package exercicios.exercicio_animais.src;

import java.util.HashMap;

enum Sexo {
    MACHO, FEMEA
}

public abstract class Animal {
    HashMap <Integer, Animal> animais = new HashMap<>();
    HashMap <Integer, Cliente> clientes = new HashMap<>();
    private String nome;
    private String especie;
    private Sexo sexoAnimal;
    private float peso;

    public Animal (){
    }

    public Animal (String nome, String especie, float peso, Sexo sexoAnimal){
        this.nome = nome;
        this.especie = especie;
        this.peso = peso;
        this.sexoAnimal = sexoAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Sexo getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(Sexo sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public Integer lastId() {
        return animais.size();
    }

    public void adicionarAnimal(Animal animal) {
        animais.put(lastId()+1, animal);
    }

    public HashMap<Integer, Animal> getAnimais() {
        return animais;
    }

    public void setCliente(Cliente cliente) {
        clientes.put(cliente.lastId(), cliente);
    }

    public HashMap<Integer, Cliente> getClientes() {
        return clientes;
    }
}
