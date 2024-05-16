package exercicios.exercicio_animais.src;

import java.util.Date;
import java.util.HashMap;

import exercicios.exercicio_animais.src.Intervencao.*; // Importar todas as classes do pacote Intervencao

public class Operacao {
    private static HashMap <Integer, Operacao> operacoes = new HashMap<Integer, Operacao>();
    private Date data_inicio;
    private Date data_fim;
    private String intervencao;
    private double custo;
    private double duracao;
    private int idVeterinario;
    private int idAnimal;
    private int idCliente;

    public Operacao(){}

    public Operacao(Date data_inicio, Date data_fim, String intervencao, double custo, double duracao, int idVeterinario, int idAnimal, int idCliente) {
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.intervencao = intervencao;
        this.custo = custo;
        this.duracao = duracao;
        this.idVeterinario = idVeterinario;
        this.idAnimal = idAnimal;
        this.idCliente = idCliente;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public String getIntervencao() {
        return intervencao;
    }

    public void setIntervencao(String intervencao) {
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

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void adicionarOperacao(Operacao operacao){
        Veterinario vet = Veterinario.getVeterinarioById(operacao.getIdVeterinario());
        Cliente cli = Cliente.getClienteByID(operacao.getIdCliente());
        Animal ani = Animal.getAnimalById(operacao.getIdAnimal());
        if (vet == null || cli == null || ani == null){
            System.out.println("Veterinário, Cliente ou Animal não encontrado");
            return;
        }
        operacoes.put(operacoes.size()+1, operacao);
    }

    public HashMap<Integer, Operacao> getOperacoes() {
        return operacoes;
    }

    public static void listarIntervencoes(String intervencao, Date inicio, Date fim){
        for (Operacao op : operacoes.values()){
            if (op.getIntervencao().equals(intervencao) && op.getData_inicio().after(inicio) && op.getData_fim().before(fim)){ // Verificar se a intervenção é do tipo pretendido e se a data está entre o intervalo
                System.out.println(op);
            }
        }
    }

    public static void listarIntervencoes(String intervencao, int idVeterinario){
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

    public static void listarIntervencoes(String intervencao, int idVeterinario, Date inicio, Date fim){
        Veterinario vet = Veterinario.getVeterinarioById(idVeterinario);
        if (vet == null){
            System.out.println("Veterinário não encontrado");
            return;
        }
        for (Operacao op : operacoes.values()){
            if (op.getIntervencao().equals(intervencao) && op.getData_inicio().after(inicio) && op.getData_fim().before(fim)){ // Verificar se a intervenção é do tipo pretendido e se a data está entre o intervalo
                System.out.println(op);
            }
        }
    }

    public static void listarIntervencoes(String intervencao, Integer idAnimal){
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

    public static void listarIntervencoesAgendadas(String intervencao, Integer idAnimal){
        Animal ani = Animal.getAnimalById(idAnimal);
        if (ani == null){
            System.out.println("Animal não encontrado");
            return;
        }
        for (Operacao op : operacoes.values()){
            if (op.getIntervencao().equals(intervencao) && op.getData_inicio().after(new Date())){
                System.out.println(op);
            }
        }
    }

    public static void listarIntervencoesHoje(String Intervencao, Integer idAnimal){
        Animal ani = Animal.getAnimalById(idAnimal);
        if (ani == null){
            System.out.println("Animal não encontrado");
            return;
        }
        for (Operacao op : operacoes.values()){
            if (op.getIntervencao().equals(Intervencao) && op.getData_inicio().equals(new Date())){
                System.out.println(op);
            }
        }
    }

    public static void listarIntervencoes(String intervencao, Integer idAnimal, Integer idCliente, Date inicio, Date fim){
        Animal ani = Animal.getAnimalById(idAnimal);
        Cliente cli = Cliente.getClienteByID(idCliente);
        if (ani == null || cli == null){
            System.out.println("Animal ou Cliente não encontrado");
            return;
        }
        double total = 0;
        for (Operacao op : operacoes.values()){
            if (op.getIntervencao().equals(intervencao) && op.getData_inicio().after(inicio) && op.getData_fim().before(fim)){
                System.out.println(op);
                total += op.getCusto();
            }
        }
        System.out.println("Total: " + total);
    }

    public static void listarIntervencoes(String intervencao, Integer idAnimal, Integer idCliente){
        Animal ani = Animal.getAnimalById(idAnimal);
        Cliente cli = Cliente.getClienteByID(idCliente);
        if (ani == null || cli == null){
            System.out.println("Animal ou Cliente não encontrado");
            return;
        }
        double total = 0;
        for (Operacao op : operacoes.values()){
            // depois do dia atual
            if (op.getIntervencao().equals(intervencao) && op.getData_inicio().after(new Date())){
                System.out.println(op);
                total += op.getCusto();
            }
        }
        System.out.println("Total: " + total);
    }

    public static void listarIntervalo(String intervencao, Date data){
        for (Operacao op : operacoes.values()){
            if (op.getIntervencao().equals(intervencao) && op.getData_inicio().after(data)){
                System.out.println(op);
            }
        }
    }

}

