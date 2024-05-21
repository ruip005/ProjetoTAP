package exercicios.exercicio_animais;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import exercicios.exercicio_animais.src.Ficheiro;
import exercicios.exercicio_animais.src.*;
import exercicios.exercicio_animais.src.Intervencao.Cirurgia;
import exercicios.exercicio_animais.src.Intervencao.Consulta;
import exercicios.exercicio_animais.src.Intervencao.Intervencao;
import exercicios.exercicio_animais.src.Intervencao.Vacinacao;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Ficheiro.criarFicheiros();
        Ficheiro.carregarDados("data/Veterinarios.txt");
        Ficheiro.carregarDados("data/Clientes.txt");
        Ficheiro.carregarDados("data/Animais.txt");
        Ficheiro.carregarDados("data/Operacoes.txt");
        Ficheiro.carregarDados("data/VeterinarioClientes.txt");
        Ficheiro.carregarDados("data/VeterinarioAnimais.txt");
        Ficheiro.carregarDados("data/ClientesAnimais.txt");
        menuPrincipal();
    }
    public static void menuVeterinario(){
        System.out.println("- - - - - -Menu de Veterinários- - - - - -");
        System.out.println("1- Adicionar um Veterinário.");
        System.out.println("2- Mostrar todos os veterinários.");
        System.out.println("3- Mostrar os Veterinários e os seus Animais."); // Edited
        System.out.println("4- Mostrar os Veterinários e os seus Cliente & Animal. "); // Edited
        System.out.println("5- Mostrar todas as intervenções de um Veterinário de uma determinada data.");
        System.out.println("0- Voltar.");

        try {
            Integer opcao = transformarNumero(scanner.nextLine());
            while (opcao == null){
                System.out.println("ERRO: Por favor insira apenas números!");
                opcao = transformarNumero(scanner.nextLine());
            }
            escolherVeterinario(opcao);
        } catch (NullPointerException nul){
            System.out.println("ERRO: "+nul);
            menuVeterinario();
        }
    }

    public static void menuCliente(){
        System.out.println("- - - - - -Menu de Clientes- - - - - -");
        System.out.println("1- Adicionar um Cliente."); // TO DO - Perguntar se é preciso adicionar animais
        System.out.println("2- Mostrar todos os Clientes."); // TO DO - Não pergunta no enunciado mas convem fazer
        System.out.println("3- Mostrar o Cliente de um Animal.");
        System.out.println("4- Listar os animais de um cliente especifico.");
        System.out.println("5- Emitir um recibo de pagamento."); // TO DO - Fazer o recibo + iva
        System.out.println("0- Voltar.");

        try {
            Integer opcao = transformarNumero(scanner.nextLine());
            while (opcao == null){
                System.out.println("ERRO: Por favor insira apenas números!");
                opcao = transformarNumero(scanner.nextLine());
            }
            escolherCliente(opcao);
        } catch (NullPointerException nul){
            System.out.println("ERRO: "+nul);
            menuCliente();
        }
    }


    public static void menuAnimal(){
        System.out.println("- - - - - -Menu de Animais- - - - - -");
        System.out.println("1- Adicionar um Animal.");
        System.out.println("2- Mostrar todos os Animais."); // TO DO - Não pergunta no enunciado mas convem fazer
        System.out.println("3- Mostrar o Animal de um Cliente."); // TO DO - Pergunta duplicada
        System.out.println("4- Mostrar os Animais de um Cliente."); // TO DO - Pergunta duplicada Edited
        System.out.println("5- Apagar um Animal.");
        System.out.println("0- Voltar.");

        try {
            Integer opcao = transformarNumero(scanner.nextLine());
            while (opcao == null){
                System.out.println("ERRO: Por favor insira apenas números!");
                opcao = transformarNumero(scanner.nextLine());
            }
            escolherAnimal(opcao);
        } catch (NullPointerException nul){
            System.out.println("ERRO: "+nul);
            menuAnimal();
        }
    }

    public static void menuOperacao(){
        System.out.println("- - - - - -Menu de Operações- - - - - -");
        System.out.println("1- Adicionar uma Intervenção.");
        System.out.println("2- Mostrar todas as Intervenções.");
        System.out.println("3- Mostrar as Intervenção de um Animal.");
        System.out.println("4- Mostrar as intervenções numa determinada data.");
        System.out.println("5- Mostrar as Intervenção de um Veterinário.");
        System.out.println("6- Mostrar as Intervenção de um Veterinário numa determinada data.");
        System.out.println("7- Mostrar as intervenções passadas de um animal.");
        System.out.println("8- Mostrar as intervenções de hoje de um animal.");
        System.out.println("9- Mostrar as intervenções agendadas de um animal.");
        System.out.println("10- Mostrar as intervenções por animal e por cliente as faturações passadas");
        System.out.println("11- Mostrar as intervenções por animal e por cliente as faturações agendadas");
        System.out.println("0- Voltar.");

        try {
            Integer opcao = transformarNumero(scanner.nextLine());
            while (opcao == null){
                System.out.println("ERRO: Por favor insira apenas números!");
                opcao = transformarNumero(scanner.nextLine());
            }
            escolherOperacao(opcao);
        } catch (NullPointerException nul){
            System.out.println("ERRO: "+nul);
            menuOperacao();
        }
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
    /*public static String transformarHora(String hora) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        format.setLenient(false);
        try {
            Date time = format.parse(hora); // Verificar se a hora é válida
            return format.format(time);
        } catch (ParseException e) {
            System.out.println("Hora inválida, por favor insira uma hora válida [HH:mm]");
            String newTime = transformarHora(scanner.nextLine());
            return newTime;
        }
    }*/
    public static String transformarHora(String hora) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        format.setLenient(false);
        try {
            Date time = format.parse(hora); // Verificar se a hora é válida
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(time);
            int minutes = calendar.get(Calendar.MINUTE);
            if (minutes != 0 && minutes != 30) {
                throw new ParseException("A hora deve ser inteira ou meia hora", 0);
            }
            return format.format(time);
        } catch (ParseException e) {
            System.out.println("Hora inválida, por favor insira uma hora válida [HH:mm] (apenas horas inteiras ou meias horas são aceitas)");
            String newTime = transformarHora(scanner.nextLine());
            return newTime;
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

    public static String transformarData(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            Date date = format.parse(data); // Verificar se a data é válida
            return format.format(date);
        } catch (ParseException e) {
            System.out.println("Data inválida, por favor insira uma data válida [dd/MM/yyyy]");
            String newDate = transformarData(scanner.nextLine());
            return newDate;
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
                saveAll();
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
            case 0:
                menuPrincipal();
                break;
            case 1: // Adicionar veterinario
                try {
                    System.out.println("Qual é o nome do Veterinário?");
                    String nome = transformarString(scanner.nextLine());
                    System.out.println("Qual é o telefone do Veterinário?");
                    Integer telefone = transformarNumero(scanner.nextLine());
                    while (telefone<91000000||telefone>999999999){
                        System.out.println("Número inválido. Por favor insira um número válido.");
                        telefone = transformarNumero(scanner.nextLine());
                    }
                    System.out.println("Qual é o email do Veterinário?");
                    String email = transformarString(scanner.nextLine());
                    while (!email.contains("@") || !email.contains(".")) {
                        System.out.println("Email inválido. Por favor insira um email válido.");
                        email = transformarString(scanner.nextLine());
                    }
                    System.out.println("Qual é o NIF do Veterinário?");
                    Integer nif = transformarNumero(scanner.nextLine());
                    while(nif<10000000||nif>999999999){
                        System.out.println("Número inválido");
                        nif = transformarNumero(scanner.nextLine());
                    }
                    System.out.println("Qual é a ordem do Veterinário?");
                    Integer ordem = transformarNumero(scanner.nextLine());
                    Veterinario veterinario = new Veterinario(nome, telefone, email, nif, ordem);
                    Veterinario.adicionarVeterinario(veterinario);
                    System.out.println("Veterinário adicionado com sucesso!\n");
                    menuVeterinario();
                } catch (NullPointerException nul){
                    System.out.println("ERRO: "+nul);
                } finally {
                    menuVeterinario();
                    saveAll();
                }
                break;
            case 2 : //Mostar todos os Veterinários
                try {
                    Veterinario.getVeterinarios().forEach((id, vet) -> {
                        System.out.println("ID: " + vet.getIdVet() + " | Nome: " + vet.getNome() + " | Telefone: " + vet.getTelefone() + " | Email: " + vet.getEmail() + " | NIF: " + vet.getNif() + " | Ordem: " + vet.getIdOrdemVeterinarios());
                    });
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                }
                finally {
                    menuVeterinario();
                }
                break;
            case 3: //Mostrar o Veterinário e seus animais
                try {
                    Veterinario.getAllVeterinarioAnimais().forEach((vetId, animalId) -> {
                        System.out.printf("ID do Veterinário: %d | Nome do Veterinário: %s | Id do Animal: %d | Nome do Animal:", Veterinario.getVeterinarioById(vetId).getIdVet(), Veterinario.getVeterinarioById(vetId).getNome(), Animal.getAnimalById(vetId).getIdAnimal(), Animal.getAnimalById(vetId).getNome());
                    });
                    System.out.println("- - - - - - - Fim - - - - - - -");
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                }
                finally {
                    menuVeterinario();
                }
            case 4: //Mostrar o Veterinário e o Cliente
                try {
                    Veterinario.getAllVeterinarioClientes().forEach((vetId, cliId) -> {
                        System.out.printf("ID do Veterinário: %d | Nome do Veterinário: %s | Id do Cliente: %d | Nome do Cliente:", Veterinario.getVeterinarioById(vetId).getIdVet(), Veterinario.getVeterinarioById(vetId).getNome(), Cliente.getClienteByID(vetId).getIdCli(), Cliente.getClienteByID(vetId).getNome());
                    });
                    System.out.println("- - - - - - - Fim - - - - - - -");
                } catch (Exception e) {
                    System.out.println("ERRO: " + e);

                } finally {
                    menuVeterinario();
                }
                break;
            case 5: //Mostrar todas as intervenções de um Veterinário de uma determinada data.
                try {
                    Intervencao.InterventionType[] tiposIntervencao = Intervencao.InterventionType.values();
                    System.out.println("Qual seria o tipo de intervenção? [VACINACAO, CONSULTA, CIRURGIA]");
                    String tipoIntervencao = scanner.nextLine().toUpperCase();
                    while (!tipoIntervencao.equals(tiposIntervencao[0].toString()) && !tipoIntervencao.equals(tiposIntervencao[1].toString()) && !tipoIntervencao.equals(tiposIntervencao[2].toString())) {
                        System.out.println("Tipo de intervenção inválido, por favor insira um tipo de intervenção válido [VACINACAO, CONSULTA, CIRURGIA]");
                        tipoIntervencao = scanner.nextLine().toUpperCase();
                    }
                    System.out.println("Qual é o ID do veterinário?");
                    int idVeterinario = transformarNumero(scanner.nextLine());
                    Veterinario vet = Veterinario.getVeterinarioById(idVeterinario);
                    if (vet == null) {
                        System.out.println("Veterinário não encontrado!");
                        return;
                    }
                    System.out.println("Qual é a data da procura? [dd/MM/yyyy]");
                    LocalDate dataMarcada = LocalDate.parse(transformarData(scanner.nextLine()), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Operacao.listarIntervencoes(Intervencao.InterventionType.valueOf(tipoIntervencao), idVeterinario, dataMarcada);
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                } finally {
                    menuVeterinario();
                }
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                menuVeterinario();
        }
    }

    public static void escolherCliente(int value){
        switch (value) {
            case 1: // Adicionar Clientes
                try {
                    System.out.println("Qual é o nome do Cliente?");
                    String nome = transformarString(scanner.nextLine());
                    System.out.println("Qual é o telefone do Cliente?");
                    Integer telefone = transformarNumero(scanner.nextLine());
                    while (telefone<91000000||telefone>999999999){
                        System.out.println("Número inválido. Por favor insira um número válido.");
                        telefone = transformarNumero(scanner.nextLine());
                    }
                    System.out.println("Qual é o email do Cliente?");
                    String email = transformarString(scanner.nextLine());
                    while (!email.contains("@") || !email.contains(".")) {
                        System.out.println("Email inválido. Por favor insira um email válido.");
                        email = transformarString(scanner.nextLine());
                    }
                    System.out.println("Qual é o NIF do Cliente?");
                    Integer nif = transformarNumero(scanner.nextLine());
                    while (nif<91000000||nif>999999999){
                        System.out.println("Número inválido");
                        nif = transformarNumero(scanner.nextLine());
                    }
                    System.out.println("Qual é o nome da Rua do Cliente?");
                    String nomeRua = transformarString(scanner.nextLine());
                    System.out.println("Qual é o número da Casa do Cliente?");
                    Integer nPorta = transformarNumero(scanner.nextLine());
                    System.out.println("Qual é o CP do Cliente?");
                    Integer cp = transformarNumero(scanner.nextLine());
                    while (cp<1000||cp>9999){
                        System.out.println("Número invlaido .----");
                        cp = transformarNumero(scanner.nextLine());
                    }
                    System.out.println("Qual é o nome da Localidade do Cliente?");
                    String localidade = transformarString(scanner.nextLine());
                    Cliente cliente = new Cliente(nome, telefone, email, nif, nomeRua,nPorta,cp,localidade);
                    Cliente.adicionarCliente(cliente);
                    System.out.println("Deseja adicionar um animal? [S/N]");
                    String resposta = scanner.nextLine().toUpperCase();
                    while (!resposta.equals("S") && !resposta.equals("N")){ // fix me
                        System.out.println("Resposta inválida. Por favor insira uma resposta válida [S/N]");
                        resposta = scanner.nextLine().toUpperCase();
                    }
                    if (resposta.equals("S")) {
                        escolherAnimal(1);
                    } else {
                        menuCliente();
                    }
                    saveAll();
                } catch (NullPointerException nul){
                System.out.println("ERRO: "+nul);
                menuCliente();
                }
                break;
            case 2: // Mostrar todos os clientes
                try {
                    Cliente.getClientes().forEach((id, cli) -> {
                        System.out.println("ID: " + cli.getIdCli() + " | Nome: " + cli.getNome() + " | Telefone: " + cli.getTelefone() + " | Email: " + cli.getEmail() + " | NIF: " + cli.getNif() + " | Morada: " + cli.getNomeRua() + ", " + cli.getnPorta() + " | CP: " + cli.getCp() + " | Localidade: " + cli.getLocalidade());
                    });
                    System.out.println("- - - - - - - Fim - - - - - - -");
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                } finally {
                    menuCliente();
                }
                break;
            case 3: // Listar todos clientes e os seus animais
                try {
                    Cliente.getAllClienteAnimais().forEach((cliId, animalId) -> {
                        System.out.printf("ID do Cliente: %d | Nome do Cliente: %s | Id do Animal: %d | Nome do Animal:", Cliente.getClienteByID(cliId).getIdCli(), Cliente.getClienteByID(cliId).getNome(), Animal.getAnimalById(cliId).getIdAnimal(), Animal.getAnimalById(cliId).getNome());
                    });
                    System.out.println("- - - - - - - Fim - - - - - - -");
                } catch (Exception e){
                    System.out.println("ERRO: "+e);

                } finally {
                    menuCliente();
                }
                break;
            case 4: // Listar clientes e os seus animais com id especifico
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
                    System.out.println("- - - - - - - Fim - - - - - - -");
                } catch (Exception e){
                    System.out.println("ERRO: "+e);

                }
                 finally {
                    menuCliente();
                }
                break;
            case 5: //Emitir um recibo de pagamento. | FIX ME !!!
                try{
                    System.out.println("Qual é o ID do Cliente?");
                    int idCli = transformarNumero(scanner.nextLine());
                    Cliente cliente = Cliente.getClienteByID(idCli);
                   if (cliente== null){
                       System.out.println("O cliente não existe.");
                       return;

                   }
                    System.out.println("Qual é o ID do Animal?");
                   int idAnimal= transformarNumero(scanner.nextLine());
                   Animal animal= Animal.getAnimalById(idAnimal);
                   if(animal== null){
                       System.out.println("O animal não existe.");
                       return;

                   }
                    System.out.println("Qual é o ID da Operação?");
                   int idOperacao = transformarNumero(scanner.nextLine());
                   Operacao operacao = Operacao.getOperacaoById(idOperacao);
                   if (operacao==null){
                       System.out.println("A operação soliticada não existe.");
                       return;
                   }
                    System.out.println("O valor da operação é de :"+operacao.getCusto());

                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                } finally {
                    menuCliente();
                }
                break;
            case 0 :
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                menuCliente();
        }
    }

    public static void escolherAnimal(int value){
        switch (value){
            case 1: // Adicionra um Animal
                try {
                    System.out.println("Qual é o nome do Animal?");
                    String nome = transformarString(scanner.nextLine());
                    System.out.println("Qual é a espécie do Animal?");
                    String especie = transformarString(scanner.nextLine());
                    System.out.println("Qual é o peso do Animal?");
                    float peso = Float.parseFloat(scanner.nextLine());
                    System.out.println("Qual é o sexo do Animal? [MACHO, FEMEA]");
                    String sexoAnimal = transformarString(scanner.nextLine().toUpperCase());
                    while (!sexoAnimal.equals("MACHO") && !sexoAnimal.equals("FEMEA")){
                        System.out.println("Sexo inválido, por favor insira um sexo válido [MACHO, FEMEA]");
                        sexoAnimal = transformarString(scanner.nextLine().toUpperCase());
                    }
                    System.out.println("Qual é o ID do Dono?");
                    int dono = transformarNumero(scanner.nextLine());
                    Cliente cliente = Cliente.getClienteByID(dono);
                    if (cliente == null){
                        System.out.println("Essa pessoa não foi encontrada!");
                        return;
                    }
                    Animal animal = new Animal(nome, especie, peso, Animal.Genero.valueOf(sexoAnimal), dono);
                    Animal.adicionarAnimal(animal);
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                } finally {
                    menuAnimal();
                    saveAll();
                }
                break;
            case 2: //Mostrar todos os Animais.
                try{
                    Animal.getAnimais().forEach((id, animal) -> {
                        System.out.println((" ID:"+ animal.getIdAnimal()+ "Nome:" + animal.getNome()+ "Espécie :" + animal.getEspecie()+ "Peso:" + animal.getPeso()+ "Sexo:"+ animal.getSexoAnimal()+ " Dono:" + animal.getDono() + "-" + Cliente.getClienteByID(animal.getDono()).getNome()));
                    });
                    System.out.println("- - - - - - - Fim - - - - - - -");
                }catch (Exception e){
                    System.out.println("ERRO: "+e);
                }
                finally{
                    menuAnimal();
                }
                break;
            case 3: // Listar os animais e os seus donos
                try {
                    Animal.getAnimais().forEach((id, animal) -> {
                        System.out.println("ID do Animal: " + animal.getIdAnimal() + " | Nome do Animal: " + animal.getNome() + " | ID do Dono: " + animal.getDono() + " | Nome do Dono: " + Cliente.getClienteByID(animal.getDono()).getNome());
                    });
                    System.out.println("- - - - - - - Fim - - - - - - -");
                } catch (Exception e){
                    System.out.println("ERRO: "+e);

                }
                finally {
                    menuAnimal();
                }
                break;
            case 4: //Mostrar o ou varios Animal de um cliente.
               try{
                   System.out.println("Qual é o ID do Cliente?");
                   int idCli = transformarNumero(scanner.nextLine());
                   Cliente cliente = Cliente.getClienteByID(idCli);
                   if (cliente == null){
                       System.out.println("O Cliente que procura não existe.");
                       return;
                   }
                   System.out.println("O(s) animal(is) do Cliente "+ cliente.getNome()+":");
                   Cliente.getAnimaisCliente(idCli).forEach((idAnimal)->{
                       Animal animal = Animal.getAnimalById(idAnimal);
                       System.out.printf("ID: %d | Nome: %s | Espécie: %s | Peso: %.2fkg | Sexo: %s | Dono: [%d] - %s\n", animal.getIdAnimal(), animal.getNome(), animal.getEspecie(), animal.getPeso(), animal.getSexoAnimal(), animal.getDono(), Cliente.getClienteByID(animal.getDono()).getNome());
                        });
                   System.out.println("- - - - - - - Fim - - - - - - -");
                } catch(Exception e){
                   System.out.println("ERRO: "+e);
               } finally {
                   menuAnimal();
               }
                break;
            case 5: // Apagar o animal dos dicionarios
                try {
                    System.out.println("Qual é o ID do Animal?");
                    int idAnimal = transformarNumero(scanner.nextLine());
                    Animal animal = Animal.getAnimalById(idAnimal);
                    if (animal == null){
                        System.out.println("O Animal que procura não existe.");
                        return;
                    }
                    Animal.apagarAnimal(idAnimal);
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                } finally {
                    menuAnimal();
                    saveAll();
                }
                break;
            case 0:
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                menuAnimal();
        }
    }

    public static void escolherOperacao(int value){
        switch (value){
            case 1: //Adicionar uma Inervenção
                try {
                    Intervencao.InterventionType []tiposIntervencao = Intervencao.InterventionType.values();
                    System.out.println("Qual seria o tipo de intervenção? [VACINACAO, CONSULTA, CIRURGIA]");
                    String tipoIntervencao = transformarString(scanner.nextLine().toUpperCase());
                    while(!tipoIntervencao.equals(tiposIntervencao[0].toString()) && !tipoIntervencao.equals(tiposIntervencao[1].toString()) && !tipoIntervencao.equals(tiposIntervencao[2].toString())){
                        System.out.println("Tipo de intervenção inválido, por favor insira um tipo de intervenção válido [VACINACAO, CONSULTA, CIRURGIA]");
                        tipoIntervencao = transformarString(scanner.nextLine().toUpperCase());
                    }
                    System.out.println("Qual seria a data da intervenção? [dd/MM/yyyy]");
                    LocalDate dataMarcada = LocalDate.parse(transformarData(scanner.nextLine()), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    System.out.println("Qual seria a hora da intervenção? [HH:mm]");
                    LocalTime horaMarcada = LocalTime.parse(transformarHora(scanner.nextLine()), DateTimeFormatter.ofPattern("HH:mm"));
                    System.out.println("Qual seria a distância da intervenção? [km] (Se não houver distância, insira 0)");
                    int distancia = transformarNumero(scanner.nextLine());
                    while(distancia < 0){
                        System.out.println("Distância inválida, por favor insira uma distância válida [km]");
                        distancia = transformarNumero(scanner.nextLine());
                    }
                    System.out.println("Qual seria o id do veterinário?");
                    int idVeterinario = transformarNumero(scanner.nextLine());
                    System.out.println("Qual seria o id do animal?");
                    int idAnimal = transformarNumero(scanner.nextLine());
                    Veterinario vetOp = Veterinario.getVetById(idVeterinario);
                    Animal animalOp = Animal.getAnimalById(idAnimal);
                    if (vetOp == null || animalOp == null){
                        System.out.println("Veterinário ou animal não existem");
                        return;
                    }
                    Intervencao intervencao;
                    if (tipoIntervencao.equals(tiposIntervencao[0].toString())){
                        intervencao = new Vacinacao(vetOp, animalOp, distancia);
                    } else if (tipoIntervencao.equals(tiposIntervencao[1].toString())){
                        intervencao = new Consulta(vetOp, animalOp, distancia);
                    } else {
                        intervencao = new Cirurgia(vetOp, animalOp, distancia);
                    }
                    Operacao operacao = new Operacao(dataMarcada, horaMarcada, intervencao.getTipoIntervencao(), idVeterinario, idAnimal, Cliente.getClientIdByAnimalId(idAnimal), intervencao.calcularCusto(), intervencao.calcularDuracao());
                    Operacao.adicionarOperacao(operacao);
                } catch (Exception a){
                    System.out.println("ERRO: "+a);
                } finally {
                    menuOperacao();
                    saveAll();
                }
                break;
            case 2:// Listar os tipos de interven¸c˜ao veterin´aria que a cl´ınica realiza
                try {
                    Intervencao.InterventionType[] interventionTypes = Intervencao.InterventionType.values();
                    System.out.println("- - - - - Intervenções - - - - -");
                    System.out.printf("1 - ", interventionTypes[0]);
                    System.out.printf("2 - ", interventionTypes[1]);
                    System.out.printf("3 - ", interventionTypes[2]);
                } catch (Exception e) {
                    System.out.println("ERRO: " + e);

                }finally {
                    menuVeterinario();
                }
                break;
            case 3://Mostrar a Intervenção de um Animal. | FIX ME !!!
                try{
                    System.out.println("Qual é o ID do Animal?");
                    int idAnimal= transformarNumero(scanner.nextLine());
                    Animal animal = Animal.getAnimalById(idAnimal);
                    if (animal== null){
                        System.out.println("O Animal não existe.");
                    }
                    Operacao.listarIntervencoes(idAnimal);
                }catch(Exception e){
                    System.out.println("ERRO:" +e);
                }
                finally {
                    menuOperacao();
                }
                break;
            case 4: // Listar, por tipo, todas as interven¸c˜oes numa determinada data;
                try {
                    Intervencao.InterventionType[] tiposIntervencao = Intervencao.InterventionType.values();
                    System.out.println("Qual seria o tipo de intervenção? [VACINACAO, CONSULTA, CIRURGIA]");
                    String tipoIntervencao = scanner.nextLine().toUpperCase();
                    while (!tipoIntervencao.equals(tiposIntervencao[0].toString()) && !tipoIntervencao.equals(tiposIntervencao[1].toString()) && !tipoIntervencao.equals(tiposIntervencao[2].toString())) {
                        System.out.println("Tipo de intervenção inválido, por favor insira um tipo de intervenção válido [VACINACAO, CONSULTA, CIRURGIA]");
                        tipoIntervencao = scanner.nextLine().toUpperCase();
                    }
                    System.out.println("Qual é a data da procura? [dd/MM/yyyy]");
                    LocalDate dataMarcada = LocalDate.parse(transformarData(scanner.nextLine()), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Operacao.listarIntervencoes(Intervencao.InterventionType.valueOf(tipoIntervencao), dataMarcada);
                } catch (ParseException e){
                    System.out.println("ERRO: "+e);
                } finally {
                    menuOperacao();
                }
                break;
            case 5: // Listar, por tipo, todas as interven¸c˜oes de um veterin´ario
                try {
                    Intervencao.InterventionType[] tiposIntervencao = Intervencao.InterventionType.values();
                    System.out.println("Qual seria o tipo de intervenção? [VACINACAO, CONSULTA, CIRURGIA]");
                    String tipoIntervencao = scanner.nextLine().toUpperCase();
                    while (!tipoIntervencao.equals(tiposIntervencao[0].toString()) && !tipoIntervencao.equals(tiposIntervencao[1].toString()) && !tipoIntervencao.equals(tiposIntervencao[2].toString())) {
                        System.out.println("Tipo de intervenção inválido, por favor insira um tipo de intervenção válido [VACINACAO, CONSULTA, CIRURGIA]");
                        tipoIntervencao = scanner.nextLine().toUpperCase();
                    }
                    System.out.println("Qual é o ID do veterinário?");
                    int idVeterinario = transformarNumero(scanner.nextLine());
                    Veterinario vet = Veterinario.getVeterinarioById(idVeterinario);
                    if (vet == null) {
                        System.out.println("Veterinário não encontrado!");
                        return;
                    }
                    Operacao.listarIntervencoes(Intervencao.InterventionType.valueOf(tipoIntervencao), idVeterinario);
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                } finally {
                    menuOperacao();
                }
                break;
            case 6: //  Listar, por tipo, todas as interven¸c˜oes de um veterin´ario numa determinada
                try {
                    Intervencao.InterventionType[] tiposIntervencao = Intervencao.InterventionType.values();
                    System.out.println("Qual seria o tipo de intervenção? [VACINACAO, CONSULTA, CIRURGIA]");
                    String tipoIntervencao = scanner.nextLine().toUpperCase();
                    while (!tipoIntervencao.equals(tiposIntervencao[0].toString()) && !tipoIntervencao.equals(tiposIntervencao[1].toString()) && !tipoIntervencao.equals(tiposIntervencao[2].toString())) {
                        System.out.println("Tipo de intervenção inválido, por favor insira um tipo de intervenção válido [VACINACAO, CONSULTA, CIRURGIA]");
                        tipoIntervencao = scanner.nextLine().toUpperCase();
                    }
                    System.out.println("Qual é o ID do veterinário?");
                    int idVeterinario = transformarNumero(scanner.nextLine());
                    Veterinario vet = Veterinario.getVeterinarioById(idVeterinario);
                    if (vet == null) {
                        System.out.println("Veterinário não encontrado!");
                        return;
                    }
                    System.out.println("Qual é a data da procura? [dd/MM/yyyy]");
                    LocalDate dataMarcada = LocalDate.parse(transformarData(scanner.nextLine()), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Operacao.listarIntervencoes(Intervencao.InterventionType.valueOf(tipoIntervencao), idVeterinario, dataMarcada);
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                } finally {
                    menuOperacao();
                }
                break;
            case 7: //Listar, por tipo, todas as interven¸c˜oes passadas de um animal;
                try {
                    Intervencao.InterventionType[] tiposIntervencao = Intervencao.InterventionType.values();
                    System.out.println("Qual seria o tipo de intervenção? [VACINACAO, CONSULTA, CIRURGIA]");
                    String tipoIntervencao = scanner.nextLine().toUpperCase();
                    while (!tipoIntervencao.equals(tiposIntervencao[0].toString()) && !tipoIntervencao.equals(tiposIntervencao[1].toString()) && !tipoIntervencao.equals(tiposIntervencao[2].toString())) {
                        System.out.println("Tipo de intervenção inválido, por favor insira um tipo de intervenção válido [VACINACAO, CONSULTA, CIRURGIA]");
                        tipoIntervencao = scanner.nextLine().toUpperCase();
                    }
                    System.out.println("Qual é o ID do animal?");
                    int idAnimal = transformarNumero(scanner.nextLine());
                    Animal animal = Animal.getAnimalById(idAnimal);
                    if (animal == null) {
                        System.out.println("Animal não encontrado!");
                        return;
                    }
                    Operacao.listarIntervencoes(Intervencao.InterventionType.valueOf(tipoIntervencao), idAnimal);
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                } finally {
                    menuOperacao();
                }
                break;
            case 8: // Listar, por tipo, todas as interven¸c˜oes de hoje de um animal;
                try {
                    Intervencao.InterventionType[] tiposIntervencao = Intervencao.InterventionType.values();
                    System.out.println("Qual seria o tipo de intervenção? [VACINACAO, CONSULTA, CIRURGIA]");
                    String tipoIntervencao = scanner.nextLine().toUpperCase();
                    while (!tipoIntervencao.equals(tiposIntervencao[0].toString()) && !tipoIntervencao.equals(tiposIntervencao[1].toString()) && !tipoIntervencao.equals(tiposIntervencao[2].toString())) {
                        System.out.println("Tipo de intervenção inválido, por favor insira um tipo de intervenção válido [VACINACAO, CONSULTA, CIRURGIA]");
                        tipoIntervencao = scanner.nextLine().toUpperCase();
                    }
                    System.out.println("Qual é o ID do animal?");
                    int idAnimal = transformarNumero(scanner.nextLine());
                    Animal animal = Animal.getAnimalById(idAnimal);
                    if (animal == null) {
                        System.out.println("Animal não encontrado!");
                        return;
                    }
                    Operacao.listarIntervencoesHoje(Intervencao.InterventionType.valueOf(tipoIntervencao), idAnimal);
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                } finally {
                    menuOperacao();
                }
                break;
            case 9: // Listar, por tipo, todas as interven¸c˜oes agendadas de um animal
                try {
                    Intervencao.InterventionType[] tiposIntervencao = Intervencao.InterventionType.values();
                    System.out.println("Qual seria o tipo de intervenção? [VACINACAO, CONSULTA, CIRURGIA]");
                    String tipoIntervencao = scanner.nextLine().toUpperCase();
                    while (!tipoIntervencao.equals(tiposIntervencao[0].toString()) && !tipoIntervencao.equals(tiposIntervencao[1].toString()) && !tipoIntervencao.equals(tiposIntervencao[2].toString())) {
                        System.out.println("Tipo de intervenção inválido, por favor insira um tipo de intervenção válido [VACINACAO, CONSULTA, CIRURGIA]");
                        tipoIntervencao = scanner.nextLine().toUpperCase();
                    }
                    System.out.println("Qual é o ID do animal?");
                    int idAnimal = transformarNumero(scanner.nextLine());
                    Animal animal = Animal.getAnimalById(idAnimal);
                    if (animal == null) {
                        System.out.println("Animal não encontrado!");
                        return;
                    }
                    Operacao.listarIntervencoesFuturas(Intervencao.InterventionType.valueOf(tipoIntervencao), idAnimal);
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                } finally {
                    menuOperacao();
                }
                break;
            case 10: // Listar, por tipo de interven¸c˜ao, por animal e por cliente, a fatura¸c˜ao efetuada (passada (dias antes de X) e presente (dia X)) e mostrar a soma total
                try {
                    Intervencao.InterventionType[] tiposIntervencao = Intervencao.InterventionType.values();
                    System.out.println("Qual seria o tipo de intervenção? [VACINACAO, CONSULTA, CIRURGIA]");
                    String tipoIntervencao = scanner.nextLine().toUpperCase();
                    while (!tipoIntervencao.equals(tiposIntervencao[0].toString()) && !tipoIntervencao.equals(tiposIntervencao[1].toString()) && !tipoIntervencao.equals(tiposIntervencao[2].toString())) {
                        System.out.println("Tipo de intervenção inválido, por favor insira um tipo de intervenção válido [VACINACAO, CONSULTA, CIRURGIA]");
                        tipoIntervencao = scanner.nextLine().toUpperCase();
                    }
                    System.out.println("Qual é o ID do animal?");
                    int idAnimal = transformarNumero(scanner.nextLine());
                    Animal animal = Animal.getAnimalById(idAnimal);
                    if (animal == null) {
                        System.out.println("Animal não encontrado!");
                        return;
                    }
                    System.out.println("Qual é o ID do cliente?");
                    int idCliente = transformarNumero(scanner.nextLine());
                    Cliente cliente = Cliente.getClienteByID(idCliente);
                    if (cliente == null) {
                        System.out.println("Cliente não encontrado!");
                        return;
                    }
                    System.out.println("Qual é o número de dias?");
                    int dias = transformarNumero(scanner.nextLine());
                    Operacao.listarFaturacao(Intervencao.InterventionType.valueOf(tipoIntervencao), idAnimal, idCliente, dias);
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                } finally {
                    menuOperacao();
                }
                break;
            case 11: // Listar, por tipo de interven¸c˜ao, por animal e por cliente, a fatura¸c˜ao agendada(dias agendados depois do dia X) e mostrar a soma total;
                try {
                    Intervencao.InterventionType[] tiposIntervencao = Intervencao.InterventionType.values();
                    System.out.println("Qual seria o tipo de intervenção? [VACINACAO, CONSULTA, CIRURGIA]");
                    String tipoIntervencao = scanner.nextLine().toUpperCase();
                    while (!tipoIntervencao.equals(tiposIntervencao[0].toString()) && !tipoIntervencao.equals(tiposIntervencao[1].toString()) && !tipoIntervencao.equals(tiposIntervencao[2].toString())) {
                        System.out.println("Tipo de intervenção inválido, por favor insira um tipo de intervenção válido [VACINACAO, CONSULTA, CIRURGIA]");
                        tipoIntervencao = scanner.nextLine().toUpperCase();
                    }
                    System.out.println("Qual é o ID do animal?");
                    int idAnimal = transformarNumero(scanner.nextLine());
                    Animal animal = Animal.getAnimalById(idAnimal);
                    if (animal == null) {
                        System.out.println("Animal não encontrado!");
                        return;
                    }
                    System.out.println("Qual é o ID do cliente?");
                    int idCliente = transformarNumero(scanner.nextLine());
                    Cliente cliente = Cliente.getClienteByID(idCliente);
                    if (cliente == null) {
                        System.out.println("Cliente não encontrado!");
                        return;
                    }
                    System.out.println("Qual é o número de dias?");
                    int dias = transformarNumero(scanner.nextLine());
                    Operacao.listarFaturacaoAgendada(Intervencao.InterventionType.valueOf(tipoIntervencao), idAnimal, idCliente, dias);
                } catch (Exception e){
                    System.out.println("ERRO: "+e);
                } finally {
                    menuOperacao();
                }
                break;
            case 0: // Voltar ao menu principal
                menuPrincipal();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                menuOperacao();
        }
    }

    public static void saveAll(){
        Ficheiro.escreverFicheiro(Veterinario.getVeterinarios(), "data/Veterinarios.txt");
        Ficheiro.escreverFicheiro(Cliente.getClientes(), "data/Clientes.txt");
        Ficheiro.escreverFicheiro(Animal.getAnimais(), "data/Animais.txt");
        Ficheiro.escreverFicheiro(Operacao.getOperacoes(), "data/Operacoes.txt");
        Ficheiro.escreverFicheiro(Veterinario.getAllVeterinarioAnimais(), "data/VeterinarioAnimais.txt");
        Ficheiro.escreverFicheiro(Veterinario.getAllVeterinarioClientes(), "data/VeterinarioClientes.txt");
        Ficheiro.escreverFicheiro(Cliente.getAllClienteAnimais(), "data/ClienteAnimais.txt");
    }
}
