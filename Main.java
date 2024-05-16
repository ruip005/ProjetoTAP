package exercicios.exercicio_animais;
import java.util.Scanner;
import exercicios.exercicio_animais.src.*;
public class Main {
    public static void main(String[] args) {
        Veterinario vet = new Veterinario("João", 123456789, "ruirr31@gmail.com", 123456789, 123456789);
        Veterinario.adicionarVeterinario(vet);
        Cliente cliente1 = new Cliente("Rui", 123456789, "rda@gmail.com", 123456789, "Rua", 1, 1234, "Porto");
        Cliente.adicionarCliente(cliente1);
        Animal animal1 = new Animal("Rex", "Cão", 10, Animal.Genero.MACHO, 1);
        Animal.adicionarAnimal(animal1);
        Veterinario.adicionarAnimalVeterinario(1, 1);
        try {
            System.out.println("Qual seria o ID do cliente?");
            int idCli = scanner.nextInt();
            Cliente cliente = Cliente.getClienteByID(idCli);
            if (cliente == null) {
                System.out.println("O cliente solicitado não existe.");
                return;
            }
            System.out.println("Animais do cliente " + cliente.getNome() + ":");
            Cliente.getAnimaisCliente(idCli).forEach((idAnimal) -> {
                Animal animal = Animal.getAnimalById(idAnimal);
                System.out.println("ID: " + animal.getIdAnimal() + " | Nome: " + animal.getNome() + " | Espécie: " + animal.getEspecie() + " | Peso: " + animal.getPeso() + "kg | Sexo: " + animal.getSexoAnimal() + " | Dono: " + animal.getDono());
            });
            System.out.println("- - - - - - - - - - - -");
        } catch (Exception e){
            System.out.println("ERRO: "+e);
        }
    }
}
