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
            Intervencao intervencao = new Vacinacao(vet, animal1, 10);
            Operacao novaOperacao = new Operacao(LocalDate.now(), LocalTime.now(), intervencao.getTipoIntervencao(), intervencao.calcularCusto(), intervencao.calcularDuracao(), vet.getIdVet(), animal1.getIdAnimal(), cliente1.getIdCli());
            Operacao.adicionarOperacao(novaOperacao);
            System.out.println("Operação adicionada com sucesso!");
            System.out.println("Data: "+novaOperacao.getDataOp().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +" | Hora: " + novaOperacao.getHora().format(DateTimeFormatter.ofPattern("HH:mm")));
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
