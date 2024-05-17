package exercicios.exercicio_animais;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.DataFormatException;

import exercicios.exercicio_animais.src.*;
import exercicios.exercicio_animais.src.Intervencao.Cirurgia;
import exercicios.exercicio_animais.src.Intervencao.Consulta;
import exercicios.exercicio_animais.src.Intervencao.Intervencao;
import exercicios.exercicio_animais.src.Intervencao.Vacinacao;

public class Main {
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    private static Scanner scanner = new Scanner(System.in);
    // Classe para testar o codigo
    public static void main(String[] args) {
        Veterinario vet = new Veterinario("João", 123456789, "ruirr31@gmail.com", 123456789, 123456789);
        Veterinario.adicionarVeterinario(vet);
        Cliente cliente1 = new Cliente("Rui", 123456789, "rda@gmail.com", 123456789, "Rua", 1, 1234, "Porto");
        Cliente.adicionarCliente(cliente1);
        Animal animal1 = new Animal("Rex", "Cão", 10, Animal.Genero.MACHO, 1);
        Animal.adicionarAnimal(animal1);
        Veterinario.adicionarAnimalVeterinario(1, 1);
        try {
            // Criar uma intervenção
            Intervencao.InterventionType []tiposIntervencao = Intervencao.InterventionType.values();
            System.out.println("Qual seria o tipo de intervenção? [VACINACAO, CONSULTA, CIRURGIA]");
            String tipoIntervencao = scanner.nextLine().toUpperCase();
            while(!tipoIntervencao.equals(tiposIntervencao[0].toString()) && !tipoIntervencao.equals(tiposIntervencao[1].toString()) && !tipoIntervencao.equals(tiposIntervencao[2].toString())){
                System.out.println("Tipo de intervenção inválido, por favor insira um tipo de intervenção válido [VACINACAO, CONSULTA, CIRURGIA]");
                tipoIntervencao = scanner.nextLine().toUpperCase();
            }
            System.out.println("Qual seria a data da intervenção? [dd/MM/yyyy]");
            LocalDate dataMarcada = LocalDate.parse(verifyDate(scanner.nextLine()), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println("Qual seria a hora da intervenção? [HH:mm]");
            LocalTime horaMarcada = LocalTime.parse(verifyTime(scanner.nextLine()), DateTimeFormatter.ofPattern("HH:mm"));
            System.out.println("Qual seria a distância da intervenção? [km] (Se não houver distância, insira 0)");
            String distancia = scanner.nextLine();
            System.out.println("Qual seria o id do veterinário?");
            int idVeterinario = scanner.nextInt();
            System.out.println("Qual seria o id do animal?");
            int idAnimal = scanner.nextInt();
            Veterinario vetOp = Veterinario.getVetById(idVeterinario);
            Animal animalOp = Animal.getAnimalById(idAnimal);
            if (vetOp == null || animalOp == null){
                System.out.println("Veterinário ou animal não existem");
                return;
            }
            // Se o tipoIntervencao for Cirurgia o codigo abaixe será Invervencao intervencao = new Cirurgia...
            Intervencao intervencao;
            if (tipoIntervencao.equals(tiposIntervencao[0])){
                intervencao = new Vacinacao(vetOp, animalOp, Integer.parseInt(distancia));
            } else if (tipoIntervencao.equals(tiposIntervencao[1])){
                intervencao = new Consulta(vetOp, animalOp, Integer.parseInt(distancia));
            } else {
                intervencao = new Cirurgia(vetOp, animalOp, Integer.parseInt(distancia));
            }
            Operacao operacao = new Operacao(dataMarcada, horaMarcada, intervencao.getTipoIntervencao(), idVeterinario, idAnimal, Cliente.getClientIdByAnimalId(idAnimal), intervencao.calcularCusto(), intervencao.calcularDuracao());
            System.out.println("Operaçao criada com sucesso");
        } catch (Exception a){
            System.out.println("ERRO: "+a);
        } finally {
            System.out.println("Fim do programa");
        }
    }

    public static String verifyDate(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            Date date = format.parse(data); // Verificar se a data é válida
            return format.format(date);
        } catch (ParseException e) {
            System.out.println("Data inválida, por favor insira uma data válida [dd/MM/yyyy]");
            String newDate = verifyDate(scanner.nextLine());
            return newDate;
            }
    }

    public static String verifyTime(String hora) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        format.setLenient(false);
        try {
            Date time = format.parse(hora); // Verificar se a hora é válida
            return format.format(time);
        } catch (ParseException e) {
            System.out.println("Hora inválida, por favor insira uma hora válida [HH:mm]");
            String newTime = verifyTime(scanner.nextLine());
            return newTime;
        }
    }


    /*
    public static String verifyDate(String data){
        String formattedDate = "";
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
        } catch (ParseException e) {
            System.out.println("Data inválida, por favor insira uma data válida [dd/MM/yyyy]");
            String newDate = verifyDate(scanner.nextLine());
            return newDate;
        } catch (Exception e){
            System.out.println("ERRO: "+e);
        }
        // Return DIA/MES/ANO
        return formattedDate;
    }*/
}
