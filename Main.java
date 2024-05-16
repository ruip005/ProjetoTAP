package exercicios.exercicio_animais;
import java.util.Scanner;
import exercicios.exercicio_animais.src.*;
public class Main {
    public static void main(String[] args) {
        Veterinario vet = new Veterinario("João", 123456789, "ruirr31@gmail.com", 123456789, 123456789);
        Veterinario.adicionarVeterinario(vet);
        Cliente cliente = new Cliente("Rui", 123456789, "rda@gmail.com", 123456789, "Rua", 1, 1234, "Porto");
        Cliente.adicionarCliente(cliente);
        Animal animal = new Animal("Rex", "Cão", 10, Animal.Genero.MACHO, 1);
        Animal.adicionarAnimal(animal);
        Veterinario.adicionarAnimalVeterinario(1, 1);
        try {
            System.out.println("Qual é o ID do Veterinário?");
            Integer idVet = scanner.nextInt(); // Cuidar da excepção
            if (Veterinario.getVetById(idVet) == null) {
                System.out.println("Veterinário não existe");
                return;
            }
            System.out.println("Animais do Veterinário " + Veterinario.getVetById(idVet).getNome() + ":");
            Veterinario.getAnimaisVeterinario(idVet).forEach((idAnimal) -> {
                Animal animal1 = Animal.getAnimalById(idAnimal);
                System.out.println("ID: " + animal1.getIdAnimal() + " | Nome: " + animal1.getNome() + " | Espécie: " + animal1.getEspecie() + " | Peso: " + animal1.getPeso() + "kg | Sexo: " + animal1.getSexoAnimal() + " | Dono: " + animal1.getDono()+" - "+Cliente.getClienteByID(animal1.getDono()).getNome());
            });
        } catch (Exception e){
            System.out.println("ERRO: "+e);
        }
    }
}
