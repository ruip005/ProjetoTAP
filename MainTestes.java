package exercicios.exercicio_animais;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import exercicios.exercicio_animais.src.Ficheiro;
import exercicios.exercicio_animais.src.*;

public class MainTestes {
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    private static Scanner scanner = new Scanner(System.in);
    // Classe para testar o codigo
    public static void main(String[] args) {
        Ficheiro.carregarDados("data/Veterinarios.txt");
        //Veterinario vet = new Veterinario("João", 993456789, "ruirr31@gmail.com", 123451111, 123456781);
        //Veterinario.adicionarVeterinario(vet);
        //Veterinario vet2 = new Veterinario("Rui", 123456789, "dwad@gmail.com", 333356789, 323456789);
        //Veterinario.adicionarVeterinario(vet2);
        Cliente cliente1 = new Cliente("Rui", 123456789, "rda@gmail.com", 123456789, "Rua", 1, 1234, "Porto");
        Cliente.adicionarCliente(cliente1);
        Animal animal1 = new Animal("Rex", "Cão", 10, Animal.Genero.MACHO, 1);
        Animal.adicionarAnimal(animal1);
        Veterinario.adicionarAnimalVeterinario(1, 1);
        Ficheiro.criarFicheiros();
        //Ficheiro.escreverFicheiro(Veterinario.getVeterinarios(), "data/Veterinarios.txt");
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
