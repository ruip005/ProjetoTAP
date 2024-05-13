    package exercicios.exercicio_animais.src;

    public class Pessoa {
        private Integer nif;
        private String nome;
        private String endereco;
        private Integer telefone;
        private String email;

        public Pessoa(String nome, Integer telefone, String email, Integer nif) {
            this.nome = nome;
            this.telefone = telefone;
            this.email = email;
            this.nif = nif;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            if (nome.length() > 0) {
                this.nome = nome;
            } else {
                System.out.println("Nome inválido");
            }
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            if (endereco.length() > 0) {
                this.endereco = endereco;
            } else {
                System.out.println("Endereço inválido");
            }
        }

        public Integer getTelefone() {
            return telefone;
        }

        public void setTelefone(Integer telefone) {
            if (telefone > 0) {
                this.telefone = telefone;
            } else {
                System.out.println("Telefone inválido");
            }
        }

        public String getEmail() {
            return email;
        }

        public Integer getNif() {
            return nif;
        }

        public void setNif(Integer nif) {
            this.nif = nif;
        }

        public void setEmail(String email) {
            if (email.length() > 0) {
                this.email = email;
            } else {
                System.out.println("Email inválido");
            }
        }
    }
