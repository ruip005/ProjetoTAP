package exercicios.exercicio_animais.src;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;

import exercicios.exercicio_animais.src.Intervencao.*; // Importar todas as classes do pacote Intervencao

public class Operacao {
    private static HashMap <Integer, Operacao> operacoes = new HashMap<Integer, Operacao>();
    private static Integer nextId = 1;
    private static Integer idOp;
    private LocalDate dataOp;
    private LocalTime hora;
    private Intervencao.InterventionType intervencao;
    private double custo;
    private double duracao;
    private int idVeterinario;
    private int idAnimal;
    private int idCliente;

    public Operacao(LocalDate data, LocalTime hora, Intervencao.InterventionType intervencao, int idVeterinario, int idAnimal, int idCliente, double custo, double duracao) {
        this.dataOp = data;
        this.hora = hora;
        this.intervencao = intervencao;
        this.custo = custo;
        this.duracao = duracao;
        this.idVeterinario = idVeterinario;
        this.idAnimal = idAnimal;
        this.idCliente = idCliente;
        this.idOp = nextId++;
        this.custo = custo;
        this.duracao = duracao;
    }

    public LocalDate getDataOp() {
        return dataOp;
    }
    public void setData(LocalDate data_inicio) {
        this.dataOp = data_inicio;
    }
    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public Intervencao.InterventionType getIntervencao() {
        return intervencao;
    }
    public void setIntervencao(Intervencao.InterventionType intervencao) {
        this.intervencao = intervencao;
    }
    public double getCusto() {
        return custo;
    }
    public void setCusto(double custo) {
        this.custo = custo;
    }
    public double getDuracao() {
        return duracao;
    }
    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }
    public void setIdOp(Integer idOp) {
        this.idOp = idOp;
    }
    public static Integer getIdOp() {
        return idOp;
    }
    public static Operacao getOperacaoById(Integer idOp){
        return operacoes.get(idOp);
    }
    public int getIdVeterinario() {
        return idVeterinario;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public static void adicionarOperacao(Operacao operacao){
        Veterinario vet = Veterinario.getVeterinarioById(operacao.getIdVeterinario());
        Cliente cli = Cliente.getClienteByID(operacao.getIdCliente());
        Animal ani = Animal.getAnimalById(operacao.getIdAnimal());
        if (vet == null || cli == null || ani == null){
            System.out.println("Veterinário, Cliente ou Animal não encontrado");
            return;
        }
        // se hora for antes das 9 ou depois das 17:30
        if (operacao.hora == null || operacao.hora.isBefore(LocalTime.of(9, 0)) || operacao.hora.isAfter(LocalTime.of(17, 30))){
            System.out.println("Hora inválida");
            return;
            // Se a operacao for cirurgia então a hora tem que ser entre as 9 e as 16:00
        } else if (operacao.intervencao == Intervencao.InterventionType.CIRURGIA && (operacao.hora.isBefore(LocalTime.of(9, 0)) || operacao.hora.isAfter(LocalTime.of(16, 0)))){
            System.out.println("Hora inválida");
            return;
        }
        operacoes.put(operacao.idOp, operacao);
    }

    public HashMap<Integer, Operacao> getOperacoes() {
        return operacoes;
    }

    public static void listarIntervencoes(Intervencao.InterventionType intervencao, int idVeterinario){
        Intervencao.InterventionType tiposIntervencao[] = Intervencao.InterventionType.values();
        if (intervencao != tiposIntervencao[0] && intervencao != tiposIntervencao[1] && intervencao != tiposIntervencao[2]){
            System.out.println("Intervenção inválida!");
            return;
        }
        Veterinario vet = Veterinario.getVeterinarioById(idVeterinario);
        if (vet == null){
            System.out.println("Veterinário não encontrado!");
            return;
        }
        for (Operacao op : operacoes.values()){
            if (op.getIntervencao().equals(intervencao) && op.getIdVeterinario() == idVeterinario){
                System.out.printf("ID: %d | Data: %s | Hora: %s | Intervenção: %s | Veterinário: [%d] %s | Animal: [%d] %s | Cliente: [%d] %s | Custo: %.2f | Duração: %.2f\n", op.getIdOp(), op.getDataOp(), op.getHora(), op.getIntervencao(), op.getIdVeterinario(), Veterinario.getVeterinarioById(op.getIdVeterinario()).getNome(), op.getIdAnimal(), Animal.getAnimalById(op.getIdAnimal()).getNome(), op.getIdCliente(), Cliente.getClienteByID(op.getIdCliente()).getNome(), op.getCusto()+"€", op.getDuracao()+"h");
            }
        }
    }

    public static void listarIntervencoes(Intervencao.InterventionType intervencao, Integer idVeterinario, LocalDate date){
        Intervencao.InterventionType tiposIntervencao[] = Intervencao.InterventionType.values();
        if (intervencao != tiposIntervencao[0] && intervencao != tiposIntervencao[1] && intervencao != tiposIntervencao[2]){
            System.out.println("Intervenção inválida!");
            return;
        }
        Veterinario vet = Veterinario.getVeterinarioById(idVeterinario);
        if (vet == null){
            System.out.println("Veterinário não encontrado!");
            return;
        }
        for (Operacao op : operacoes.values()){
            if (op.getIntervencao().equals(intervencao) && op.getIdVeterinario() == idVeterinario && op.getDataOp().equals(date)){
                System.out.printf("ID: %d | Data: %s | Hora: %s | Intervenção: %s | Veterinário: [%d] %s | Animal: [%d] %s | Cliente: [%d] %s | Custo: %.2f | Duração: %.2f\n", op.getIdOp(), op.getDataOp(), op.getHora(), op.getIntervencao(), op.getIdVeterinario(), Veterinario.getVeterinarioById(op.getIdVeterinario()).getNome(), op.getIdAnimal(), Animal.getAnimalById(op.getIdAnimal()).getNome(), op.getIdCliente(), Cliente.getClienteByID(op.getIdCliente()).getNome(), op.getCusto()+"€", op.getDuracao()+"h");
            }
        }
    }

    public static void listarIntervencoes(Intervencao.InterventionType type, LocalDate date){
        Intervencao.InterventionType tiposIntervencao[] = Intervencao.InterventionType.values();
        if (type != tiposIntervencao[0] && type != tiposIntervencao[1] && type != tiposIntervencao[2]){
            System.out.println("Intervenção inválida!");
            return;
        }
        for (Operacao op : operacoes.values()){
            if (op.getDataOp().equals(date) && op.getIntervencao().equals(type)){
                System.out.printf("ID: %d | Data: %s | Hora: %s | Intervenção: %s | Veterinário: [%d] %s | Animal: [%d] %s | Cliente: [%d] %s | Custo: %.2f | Duração: %.2f\n", op.getIdOp(), op.getDataOp(), op.getHora(), op.getIntervencao(), op.getIdVeterinario(), Veterinario.getVeterinarioById(op.getIdVeterinario()).getNome(), op.getIdAnimal(), Animal.getAnimalById(op.getIdAnimal()).getNome(), op.getIdCliente(), Cliente.getClienteByID(op.getIdCliente()).getNome(), op.getCusto()+"€", op.getDuracao()+"h");
            }
        }
        System.out.println("-------------------");
    }

    public static void listarIntervencoes(Intervencao.InterventionType intervencao, Integer idAnimal){
        if (intervencao != Intervencao.InterventionType.VACINACAO && intervencao != Intervencao.InterventionType.CONSULTA && intervencao != Intervencao.InterventionType.CIRURGIA){
            System.out.println("Intervenção inválida!");
            return;
        }
        Animal animal = Animal.getAnimalById(idAnimal);
        if (animal == null){
            System.out.println("Animal não encontrado!");
            return;
        }
        for (Operacao op : operacoes.values()){
            if (op.getIntervencao().equals(intervencao) && op.getIdAnimal() == idAnimal){
                System.out.printf("ID: %d | Data: %s | Hora: %s | Intervenção: %s | Veterinário: [%d] %s | Animal: [%d] %s | Cliente: [%d] %s | Custo: %.2f | Duração: %.2f\n", op.getIdOp(), op.getDataOp(), op.getHora(), op.getIntervencao(), op.getIdVeterinario(), Veterinario.getVeterinarioById(op.getIdVeterinario()).getNome(), op.getIdAnimal(), Animal.getAnimalById(op.getIdAnimal()).getNome(), op.getIdCliente(), Cliente.getClienteByID(op.getIdCliente()).getNome(), op.getCusto()+"€", op.getDuracao()+"h");
            }
        }
    }

    public static void listarIntervencoesHoje(Intervencao.InterventionType intervencao, Integer idAnimal){
        if (intervencao != Intervencao.InterventionType.VACINACAO && intervencao != Intervencao.InterventionType.CONSULTA && intervencao != Intervencao.InterventionType.CIRURGIA){
            System.out.println("Intervenção inválida!");
            return;
        }
        Animal animal = Animal.getAnimalById(idAnimal);
        if (animal == null){
            System.out.println("Animal não encontrado!");
            return;
        }
        for (Operacao op : operacoes.values()){
            if (op.getIntervencao().equals(intervencao) && op.getIdAnimal() == idAnimal && op.getDataOp().equals(LocalDate.now())){
                System.out.printf("ID: %d | Data: %s | Hora: %s | Intervenção: %s | Veterinário: [%d] %s | Animal: [%d] %s | Cliente: [%d] %s | Custo: %.2f | Duração: %.2f\n", op.getIdOp(), op.getDataOp(), op.getHora(), op.getIntervencao(), op.getIdVeterinario(), Veterinario.getVeterinarioById(op.getIdVeterinario()).getNome(), op.getIdAnimal(), Animal.getAnimalById(op.getIdAnimal()).getNome(), op.getIdCliente(), Cliente.getClienteByID(op.getIdCliente()).getNome(), op.getCusto()+"€", op.getDuracao()+"h");
            }
        }
    }

    public static void listarIntervencoesFuturas(Intervencao.InterventionType intervencao, Integer idAnimal) {
        Intervencao.InterventionType tiposIntervencao[] = Intervencao.InterventionType.values();
        if (intervencao != tiposIntervencao[0] && intervencao != tiposIntervencao[1] && intervencao != tiposIntervencao[2]) {
            System.out.println("Intervenção inválida!");
            return;
        }
        Animal ani = Animal.getAnimalById(idAnimal);
        if (ani == null) {
            System.out.println("Animal não encontrado");
            return;
        }
        for (Operacao op : operacoes.values()) {
            if (op.getIntervencao().equals(intervencao) && op.getIdAnimal() == idAnimal && op.getDataOp().isAfter(LocalDate.now())) {
                System.out.printf("ID: %d | Data: %s | Hora: %s | Intervenção: %s | Veterinário: [%d] %s | Animal: [%d] %s | Cliente: [%d] %s | Custo: %.2f | Duração: %.2f\n", op.getIdOp(), op.getDataOp(), op.getHora(), op.getIntervencao(), op.getIdVeterinario(), Veterinario.getVeterinarioById(op.getIdVeterinario()).getNome(), op.getIdAnimal(), Animal.getAnimalById(op.getIdAnimal()).getNome(), op.getIdCliente(), Cliente.getClienteByID(op.getIdCliente()).getNome(), op.getCusto() + "€", op.getDuracao() + "h");
            }
        }
    }

    public static void listarFaturacao(Intervencao.InterventionType intervencao, Integer idAnimal, Integer idCliente, Integer dias){
        if (intervencao != Intervencao.InterventionType.VACINACAO && intervencao != Intervencao.InterventionType.CONSULTA && intervencao != Intervencao.InterventionType.CIRURGIA){
            System.out.println("Intervenção inválida!");
            return;
        }
        Animal animal = Animal.getAnimalById(idAnimal);
        Cliente cliente = Cliente.getClienteByID(idCliente);
        if (animal == null || cliente == null){
            System.out.println("Animal ou Cliente não encontrado!");
            return;
        }
        double total = 0;
        for (Operacao op : operacoes.values()){
            // Listar, por tipo de interven¸c˜ao, por animal e por cliente, a fatura¸c˜ao efetuada
            //(passada (dias antes de X) e presente (dia X)) e mostrar a soma total
            if (op.getIntervencao().equals(intervencao) && op.getIdAnimal() == idAnimal && op.getIdCliente() == idCliente && op.getDataOp().isAfter(LocalDate.now().minusDays(dias))){
                System.out.printf("ID: %d | Data: %s | Hora: %s | Intervenção: %s | Veterinário: [%d] %s | Animal: [%d] %s | Cliente: [%d] %s | Custo: %.2f | Duração: %.2f\n", op.getIdOp(), op.getDataOp(), op.getHora(), op.getIntervencao(), op.getIdVeterinario(), Veterinario.getVeterinarioById(op.getIdVeterinario()).getNome(), op.getIdAnimal(), Animal.getAnimalById(op.getIdAnimal()).getNome(), op.getIdCliente(), Cliente.getClienteByID(op.getIdCliente()).getNome(), op.getCusto()+"€", op.getDuracao()+"h");
                total += op.getCusto();
            }
        }
        System.out.println("Total: "+total+"€");
    }

}

