package entities;

public abstract class Pessoa {
    private String nome, sexoExpandido;
    private int idade;
    private char sexo;

    public Pessoa(String nome, int idade, char sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.sexoExpandido = sexo == 'M' ? "Masculino" : "Feminino";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
        setSexoExpandido();
    }

    public String getSexoExpandido() {
        return sexoExpandido;
    }

    private void setSexoExpandido() {
        this.sexoExpandido = sexo == 'M' ? "Masculino" : "Feminino";
    }

    @Override
    public String toString() {
        return "Nome = " + getNome() +
                ", Sexo = " + getSexoExpandido() +
                ", Idade = " + getIdade() + " anos";
    }
}
