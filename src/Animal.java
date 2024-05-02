package exercicios.exercicio_animais.src;
public abstract class Animal {
    private String NomeAnimal;
    private String Especie;
    private int Idade;
    private String cor;
    private String sexo;
    private String raca;

    public Animal (){
    }
    public Animal(String nome, String especie, int idade, String cor, String sexo, String raca) {
        this.NomeAnimal = nome;
        this.Especie = especie;
        this.Idade = idade;
        this.cor = cor;
        this.sexo = sexo;
        this.raca = raca;
    }

    public void setNome(String nome) {
        this.NomeAnimal = nome;
    }

    public void setEspecie(String especie) {
        this.Especie = especie;
    }

    public void setIdade(int idade) {
        this.Idade = idade;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return NomeAnimal;
    }

    public String getEspecie() {
        return Especie;
    }

    public int getIdade() {
        return Idade;
    }

    public String getCor() {
        return cor;
    }

    public String getRaca() {
        return raca;
    }

    public String getSexo() {
        return sexo;
    }

    public abstract String locomocao();


    public class Mamifero extends Animal {
        private String TipoPelo;

        public Mamifero(String nome, String especie, int idade, String cor, String sexo, String raca, String tipoPelo) {
            super(nome, especie, idade, cor, sexo, raca);
            this.TipoPelo = tipoPelo;
        }

        public void setTipoPelo(String tipoPelo) {
            this.TipoPelo = tipoPelo;
        }

        public String getTipoPelo() {
            return TipoPelo;
        }

        public String toString() {
            return super.toString() + " Tipo de Pelo: " + TipoPelo;
        }

        public  String locomocao(){
            return "Caminha sobre 4 patas";
        };
    }

    public class Reptil extends Animal {
        private boolean Venenoso;

        public Reptil(String nome, String especie, int idade, String cor, String sexo, String raca, boolean venenoso) {
            super(nome, especie, idade, cor, sexo, raca);
            this.Venenoso = venenoso;
        }

        public void setVenenoso(boolean venenoso) {
            this.Venenoso = venenoso;
        }

        public boolean getVenenoso() {
            return Venenoso;
        }

        public String toString() {
            return super.toString() + " Venenoso: " + Venenoso;
        }

        public  String locomocao(){
            return "Rasteja pelo chão";
        };
    }
    
  
  
 
}
