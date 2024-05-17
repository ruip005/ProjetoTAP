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

    public Operacao(){}

    public Operacao(LocalDate data, LocalTime hora, Intervencao.InterventionType intervencao, double custo, double duracao, int idVeterinario, int idAnimal, int idCliente) {
        this.dataOp = data;
        this.hora = hora;
        this.intervencao = intervencao;
        this.custo = custo;
        this.duracao = duracao;
        this.idVeterinario = idVeterinario;
        this.idAnimal = idAnimal;
        this.idCliente = idCliente;
        this.idOp = nextId++;
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
        operacoes.put(operacao.idOp, operacao);
    }

    public HashMap<Integer, Operacao> getOperacoes() {
        return operacoes;
    }

    public static void listarIntervencoes(Intervencao.InterventionType intervencao, int idVeterinario){
        Veterinario vet = Veterinario.getVeterinarioById(idVeterinario);
        if (vet == null){
            System.out.println("Veterinário não encontrado");
            return;
        }
        for (Operacao op : operacoes.values()){
            if (op.getIntervencao().equals(intervencao)){
                System.out.println(op);
            }
        }
    }

    public static void listarIntervencoes(Intervencao.InterventionType intervencao, Integer idAnimal){
        Animal ani = Animal.getAnimalById(idAnimal);
        if (ani == null){
            System.out.println("Animal não encontrado");
            return;
        }
        for (Operacao op : operacoes.values()){
            if (op.getIntervencao().equals(intervencao)){
                System.out.println(op);
            }
        }
    }

    public static void listarIntervencoes(Date date){
        for (Operacao op : operacoes.values()){
            if (op.getDataOp().equals(date)){
                System.out.println(op);
                System.out.println("Ola mae");
            }
        }
    }

    public static void listarIntervencoesHoje(Intervencao.InterventionType Intervencao, Integer idAnimal){
        Animal ani = Animal.getAnimalById(idAnimal);
        if (ani == null){
            System.out.println("Animal não encontrado");
            return;
        }
        for (Operacao op : operacoes.values()){ // fix me
            if (op.getIntervencao().equals(Intervencao) && op.getDataOp().equals(new Date())){
                System.out.println(op);
            }
        }
    }

}

