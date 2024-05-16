package exercicios.exercicio_animais;
import java.util.Scanner;
import exercicios.exercicio_animais.src.*;
public class Main {
    public static void main(String[] args) {
        Veterinario vet = new Veterinario("João", 123456789, "ruirr31@gmail.com", 123456789, 123456789);
        Veterinario.adicionarVeterinario(vet);
        Veterinario vet2 = new Veterinario("Maria", 123456789, "maria@gmail.com", 123456789, 123456789);
        Cliente cliente = new Cliente("Rui", 123456789, "ruy@gmail.com", 123456789, "Rua", 1, 1234, "Porto");
        Cliente.adicionarCliente(cliente);
        Veterinario.adicionarClienteVeterinario(vet.getIdVet(), cliente.getIdCli());
        try {
            System.out.println("Qual é o ID do Veterinário?");
            Integer idVet = scanner.nextInt(); // Cuidar da excepção
            if (Veterinario.getVetById(idVet) == null) {
                System.out.println("Veterinário não existe");
                return;
            }
            System.out.println("Clientes do Veterinário " + Veterinario.getVetById(idVet).getNome() + ":");
            Veterinario.getClientesVeterinario(idVet).forEach((id) -> {
                System.out.println(Cliente.getClienteByID(id).getNome());
            });
        } catch (Exception e){
            System.out.println("ERRO: "+e);
        }
    }
}
