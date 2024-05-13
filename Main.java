package exercicios.exercicio_animais;

public class Main {
    public static void main(String[] args) {
       // fix me
    }

    void menuVeterinario(){
        System.out.println("- - - - - -Menu de Veterinários- - - - - -");
        System.out.println("1- Adicionar um Veterinário.");
        System.out.println("2- Mostrar todos os veterinários.");
        System.out.println("3- Mostrar o Veterinário de um Animal.");
        System.out.println("4-Mostrar o Veterinário e o Cliente de um Animal. ");
        System.out.println("5- Mostrar todas as invervenções de um Veterinário de uma determinada data.");
        System.out.println("0-Sair.");
    }

    void menuCliente(){
        System.out.println("- - - - - -Menu de Clientes- - - - - -");
        System.out.println("1- Adicionar um Cliente.");
        System.out.println("2- Mostrar todos os Clientes.");
        System.out.println("3- Mostrar o Cliente de um Animal.");
        System.out.println("4- Emitir um recibo de pagamento.");
        System.out.println("0- Sair.");
    }


    void menuAnimal(){
        System.out.println("- - - - - -Menu de Animais- - - - - -");
        System.out.println("1- Adicionar um Animal.");
        System.out.println("2- Mostrar todos os Animais.");
        System.out.println("3- Mostrar o Animal de um Cliente.");
        System.out.println("4- Mostrar o Animal e o Veterinário de um Cliente.");
        System.out.println("0-Sair.");
    }

    void menuIntervencao(){
        System.out.println("- - - - - -Menu de Intervenções- - - - - -");
        System.out.println("1- Adicionar uma Intervenção.");
        System.out.println("2- Mostrar todas as Intervenções.");
        System.out.println("3- Mostrar a Intervenção de um Animal.");
        System.out.println("4- Mostrar a Intervenção e o Veterinário de um Animal.");
        System.out.println("5- Agendar uma intervenção e apresentar o seu custo.");
        System.out.println("6- Mostrar todas as invervenções de um Animal de uma determinada data.");
    }

    // Utils
    public Integer transformarNumero(String value){
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
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
}
