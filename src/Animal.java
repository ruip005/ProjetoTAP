// Animal.java
package exercicios.exercicio_animais.src;

import java.util.HashMap;

public class Animal {
    public enum Genero {
        MACHO, FEMEA
    }
    private static HashMap <Integer, Animal> animais = new HashMap<>();
    private static Integer nextId = 1;
    private Integer idAnimal;
    private String nome;
    private String especie;
    private Genero genero;
    private float peso;

    public Animal (){
    }

    public Animal (String nome, String especie, float peso, Genero sexoAnimal){
        this.nome = nome;
        this.especie = especie;
        this.peso = peso;
        this.genero = sexoAnimal;
        this.idAnimal = nextId++;
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

    public Genero getSexoAnimal() {
        return genero;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setSexoAnimal(Genero sexoAnimal) {
        this.genero = sexoAnimal;
    }

    public void adicionarAnimal(Animal animal) {
        animais.put(animal.idAnimal, animal);
    }

    public HashMap<Integer, Animal> getAnimais() {
        return animais;
    }

    public static Animal getAnimalById(int id) { // Verificar se a chave existe no HashMap | static para poder ser acedido por outras classes
        if (animais.containsKey(id)) {
            return animais.get(id);
        } else {
            return null;
        }
    }
}
