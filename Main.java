package exercicios.exercicio_animais;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.zip.DataFormatException;

import exercicios.exercicio_animais.src.*;
import exercicios.exercicio_animais.src.Intervencao.Intervencao;

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
            Intervencao.InterventionType[] interventionTypes = Intervencao.InterventionType.values();
            System.out.printf("Qual é o tipo de intervenção que deseja realizar [%s, %s, %s]?\n", interventionTypes[0], interventionTypes[1], interventionTypes[2]);
            String tipoIntervencao = scanner.nextLine().toUpperCase();
            while (!tipoIntervencao.equals(interventionTypes[0].toString()) && !tipoIntervencao.equals(interventionTypes[1].toString()) && !tipoIntervencao.equals(interventionTypes[2].toString())) {
                System.out.println("Tipo de intervenção inválido, por favor insira um tipo de intervenção válido");
                tipoIntervencao = scanner.nextLine();
            }
            System.out.println("Qual é a data de inicio da intervenção [dd/MM/yyyy]?");
            String dataInsert = verifyDate(scanner.nextLine());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = formatter.parse(dataInsert);
            Operacao.listarIntervalo(tipoIntervencao, date);
        } catch (Exception e){
            System.out.println("ERRO: "+e);
        }
    }

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
    }
}
