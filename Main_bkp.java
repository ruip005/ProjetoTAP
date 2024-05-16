package exercicios.exercicio_animais;
import java.util.Scanner;
import exercicios.exercicio_animais.src.*;
public class Main_bkp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();
    }
    public static void menuVeterinario(){
        System.out.println("- - - - - -Menu de Veterinários- - - - - -");
        System.out.println("1- Adicionar um Veterinário.");
        System.out.println("2- Mostrar todos os veterinários.");
        System.out.println("3- Mostrar o Veterinário de um Animal.");
        System.out.println("4-Mostrar o Veterinário e o Cliente de um Animal. ");
        System.out.println("5- Mostrar todas as invervenções de um Veterinário de uma determinada data.");
        System.out.println("0-Sair.");
    }

    public static void menuCliente(){
        System.out.println("- - - - - -Menu de Clientes- - - - - -");
        System.out.println("1- Adicionar um Cliente.");
        System.out.println("2- Mostrar todos os Clientes.");
        System.out.println("3- Mostrar o Cliente de um Animal.");
        System.out.println("4- Emitir um recibo de pagamento.");
        System.out.println("0- Sair.");
    }


    public static void menuAnimal(){
        System.out.println("- - - - - -Menu de Animais- - - - - -");
        System.out.println("1- Adicionar um Animal.");
        System.out.println("2- Mostrar todos os Animais.");
        System.out.println("3- Mostrar o Animal de um Cliente.");
        System.out.println("4- Mostrar o Animal e o Veterinário de um Cliente.");
        System.out.println("0-Sair.");
    }

    public static void menuOperacao(){
        System.out.println("- - - - - -Menu de Operações- - - - - -");
        System.out.println("1- Adicionar uma Intervenção.");
        System.out.println("2- Mostrar todas as Intervenções.");
        System.out.println("3- Mostrar a Intervenção de um Animal.");
        System.out.println("4- Mostrar a Intervenção e o Veterinário de um Animal.");
        System.out.println("5- Agendar uma intervenção e apresentar o seu custo.");
        System.out.println("6- Mostrar todas as invervenções de um Animal de uma determinada data.");
    }

    public static void menuPrincipal(){
        System.out.println("- - - - - -Menu Principal- - - - - -");
        System.out.println("1- Menu de Veterinários.");
        System.out.println("2- Menu de Clientes.");
        System.out.println("3- Menu de Animais.");
        System.out.println("4- Menu de Operações.");
        System.out.println("0- Sair.");

        try {
            Integer opcao = transformarNumero(scanner.nextLine());
            while (opcao == null){
                System.out.println("ERRO: Por favor insira apenas números!");
                opcao = transformarNumero(scanner.nextLine());
            }
            escolher(opcao);
        } catch (NullPointerException nul){
            System.out.println("ERRO: "+nul);
            menuPrincipal();
        }
    }

    // Utils
    public static Integer transformarNumero(String value){
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Número inválido. Tente novamente.");
            String newValue = scanner.nextLine();
            return transformarNumero(newValue);
        } catch (NullPointerException m) {
            System.out.println("Número inválido. Tente novamente.");
            String newValue = scanner.nextLine();
            return transformarNumero(newValue);
        }
    }

    public static String transformarString(String value) {
        try {
            String newValue = value.trim();
            if (newValue.isEmpty()) {
                System.out.println("Valor inválido. Tente novamente.");
                newValue = scanner.nextLine();
                return transformarString(newValue);
            }
            return newValue;
        } catch (Exception e) {
            System.out.println("Valor inválido. Tente novamente.");
            String newValue = scanner.nextLine();
            return transformarString(newValue);
        }
    }

    public static void escolher(Integer value){
        switch (value) {
            case 1:
                menuVeterinario();
                break;
            case 2:
                menuCliente();
                break;
            case 3:
                menuAnimal();
                break;
            case 4:
                menuOperacao();
                break;
            case 0:
                System.out.println("Até á próxima...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                menuPrincipal();
        }
    }

    public static void escolherVeterinario(int Value){
        switch (Value){
            case 1: // Adicionar veterinario
                try {
                    System.out.println("Qual é o nome do Veterinário?");
                    String nome = transformarString(scanner.nextLine());
                    System.out.println("Qual é o telefone do Veterinário?");
                    Integer telefone = transformarNumero(scanner.nextLine());
                    System.out.println("Qual é o email do Veterinário?");
                    String email = transformarString(scanner.nextLine());
                    System.out.println("Qual é o NIF do Veterinário?");
                    Integer nif = transformarNumero(scanner.nextLine());
                    System.out.println("Qual é a ordem do Veterinário?");
                    Integer ordem = transformarNumero(scanner.nextLine());
                    Veterinario veterinario = new Veterinario(nome, telefone, email, nif, ordem);
                    veterinario.adicionarVeterinario(veterinario);
                    System.out.println("Veterinário adicionado com sucesso!\n");
                } catch (NullPointerException nul){
                    System.out.println("ERRO: "+nul);
                    menuVeterinario();
                }
                break;
            case 2 : //Mostar todos os Veterinários
                try {
                    Veterinario.getVeterinarios().forEach((k, v) -> {
                        System.out.println("ID: "+v.getIdVet()+" | Nome: "+v.getNome()+" | Telefone: "+v.getTelefone()+" | Email: "+v.getEmail()+" | NIF: "+v.getNif()+" | Ordem: "+v.getIdOrdemVeterinarios());
                    });
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                    menuVeterinario();
                }
                break;
            case 3: //Mostrar o Veterinário e seus animais
                try{
                    System.out.println("Qual é o ID do Animal?");
                    Integer id = transformarNumero(scanner.nextLine());
                    System.out.println("Veterinário: "+Veterinario.getVeterinarioById(id).getNome()+", tem os seguintes animais:");
                    Veterinario.getAnimaisVeterinario(id).forEach(a -> {
                        System.out.println("ID: "+Animal.getAnimalById(a).hashCode()+" | Nome: "+Animal.getAnimalById(a).getNome()+" | Espécie: "+Animal.getAnimalById(a).getEspecie()+" | Peso: "+Animal.getAnimalById(a).getPeso()+" | Sexo: "+Animal.getAnimalById(a).getSexoAnimal());
                    });
                } catch (NullPointerException e){
                    System.out.println("ERRO: "+e);
                    menuVeterinario();
                }
            case 4: //Mostrar o Veterinário e o Cliente
                try {
                    System.out.println("Qual é o ID do Veterinário?");
                    Integer idVet = transformarNumero(scanner.nextLine());
                    if (Veterinario.getVetById(idVet) == null) {
                        System.out.println("Veterinário não existe");
                        menuVeterinario();
                    }
                    System.out.println("Clientes do Veterinário " + Veterinario.getVetById(idVet).getNome() + ":");
                    Veterinario.getClientesVeterinario(idVet).forEach((id) -> {
                        System.out.println(Cliente.getClienteByID(id).getNome());
                    });
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                    menuVeterinario();
                }
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                menuVeterinario();
        }
    }
}
