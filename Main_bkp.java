package exercicios.exercicio_animais;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import exercicios.exercicio_animais.src.*;
import exercicios.exercicio_animais.src.Intervencao.Intervencao;

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

    public static String transformarData(String data){
        String formattedDate = "";
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
        } catch (ParseException e) {
            System.out.println("Data inválida, por favor insira uma data válida [dd/MM/yyyy]");
            String newDate = transformarData(scanner.nextLine());
            return newDate;
        } catch (Exception e){
            System.out.println("ERRO: "+e);
        }
        // Return DIA/MES/ANO
        return formattedDate;
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
                    menuVeterinario();
                } catch (NullPointerException nul){
                    System.out.println("ERRO: "+nul);
                    menuVeterinario();
                }
                break;
            case 2 : //Mostar todos os Veterinários
                try {
                    Veterinario.getVeterinarios().forEach((id, vet) -> {
                        System.out.println("ID: " + vet.getIdVet() + " | Nome: " + vet.getNome() + " | Telefone: " + vet.getTelefone() + " | Email: " + vet.getEmail() + " | NIF: " + vet.getNif() + " | Ordem: " + vet.getIdOrdemVeterinarios());
                    });
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                    menuVeterinario();
                }
                break;
            case 3: //Mostrar o Veterinário e seus animais
                try {
                    Veterinario.getAllVeterinarioAnimais().forEach((vetId, animalId) -> {
                        System.out.printf("ID do Veterinário: %d | Nome do Veterinário: %s | Id do Animal: %d | Nome do Animal:", Veterinario.getVeterinarioById(vetId).getIdVet(), Veterinario.getVeterinarioById(vetId).getNome(), Animal.getAnimalById(vetId).getIdAnimal(), Animal.getAnimalById(vetId).getNome());
                    });
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                }
            case 4: //Mostrar o Veterinário e o Cliente
                try {
                    Veterinario.getAllVeterinarioClientes().forEach((vetId, cliId) -> {
                        System.out.printf("ID do Veterinário: %d | Nome do Veterinário: %s | Id do Cliente: %d | Nome do Cliente:", Veterinario.getVeterinarioById(vetId).getIdVet(), Veterinario.getVeterinarioById(vetId).getNome(), Cliente.getClienteByID(vetId).getIdCli(), Cliente.getClienteByID(vetId).getNome());
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

    public void escolherCliente(int value){
        switch (value) {
            case 1: // Listar todos clientes e os seus animais
                try {
                    Cliente.getAllClienteAnimais().forEach((cliId, animalId) -> {
                        System.out.printf("ID do Cliente: %d | Nome do Cliente: %s | Id do Animal: %d | Nome do Animal:", Cliente.getClienteByID(cliId).getIdCli(), Cliente.getClienteByID(cliId).getNome(), Animal.getAnimalById(cliId).getIdAnimal(), Animal.getAnimalById(cliId).getNome());
                    });
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                    menuCliente();
                }
                break;
            case 2: // Listar clientes e os seus animais com id especifico
                try {
                    System.out.println("Qual seria o ID do cliente?");
                    int idCli = transformarNumero(scanner.nextLine());
                    Cliente cliente = Cliente.getClienteByID(idCli);
                    if (cliente == null) {
                        System.out.println("O cliente solicitado não existe.");
                        return;
                    }
                    System.out.println("Animais do cliente " + cliente.getNome() + ":");
                    Cliente.getAnimaisCliente(idCli).forEach((idAnimal) -> {
                        Animal animal = Animal.getAnimalById(idAnimal);
                        System.out.println("ID: " + animal.getIdAnimal() + " | Nome: " + animal.getNome() + " | Espécie: " + animal.getEspecie() + " | Peso: " + animal.getPeso() + "kg | Sexo: " + animal.getSexoAnimal() + " | Dono: " + animal.getDono()+ " - "+Cliente.getClienteByID(animal.getDono()).getNome());
                    });
                    System.out.println("- - - - - - - - - - - -");
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                    menuCliente();
                }
                break;
            case 3:
                break;
            default:
        }
    }

    public void escolherAnimal(int value){
        switch (value){
            case 1: // Listar os animes e os seus donos
                try {
                    Animal.getAnimais().forEach((id, animal) -> {
                        System.out.println("ID do Animal: " + animal.getIdAnimal() + " | Nome do Animal: " + animal.getNome() + " | ID do Dono: " + animal.getDono() + " | Nome do Dono: " + Cliente.getClienteByID(animal.getDono()).getNome());
                    });
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                    menuAnimal();
                }
                break;
            case 2:
                break;
            case 3:
                break;
            default:
        }
    }

    public void escolherOperacao(int value){
        switch (value){
            case 1: // Listar os tipos de interven¸c˜ao veterin´aria que a cl´ınica realiza
                try {
                    Intervencao.InterventionType[] interventionTypes = Intervencao.InterventionType.values();
                    System.out.println("- - - - - Intervenções - - - - -");
                    System.out.printf("1 - ", interventionTypes[0]);
                    System.out.printf("2 - ", interventionTypes[1]);
                    System.out.printf("3 - ", interventionTypes[2]);
                } catch (Exception e) {
                    System.out.println("ERRO: " + e);
                    menuVeterinario();
                }
                break;
            case 2: // (g) Listar, por tipo, todas as interven¸c˜oes numa determinada data;
                System.out.println("Qual é a data de início?");
                //Date dataInicio = transformarData(scanner.nextLine());
                //Operacao.listarIntervalo();

                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
        }
    }
}
