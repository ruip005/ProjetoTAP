package exercicios.exercicio_animais;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       // fix me
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
            return null;
        } catch (NullPointerException m) {
            return null;
        }
    }

    public String transformarString(String value) {
        try {
            String newValue = value.trim();
            if (newValue.isEmpty()) {
                return null;
            }
            return newValue;
        } catch (Exception e) {
            return null;
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
            case 1:
                System.out.println("Adicionar Veterinário");
                scanner.nextLine();
                break;

            case 2 :
                System.out.println("Mostrar todos os Veterinários");
                scanner.nextLine();
                break;

            case 3:
                System.out.println("Mostrar o Veterinário de um Animal");
                
        }
    }
}
