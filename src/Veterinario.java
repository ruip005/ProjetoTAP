package exercicios.exercicio_animais.src;

public class Veterinario {
    private Integer id;
    private String nome;
    private String crmv;
    private String especialidade;
    private String telefone;
    private String email;
    private String endereco;

    public Veterinario() {
    }

    public Veterinario(Integer id, String nome, String crmv, String especialidade, String telefone, String email, String endereco) {
        this.id = id;
        this.nome = nome;
        this.crmv = crmv;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCrmv() {
        return crmv;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }
}
