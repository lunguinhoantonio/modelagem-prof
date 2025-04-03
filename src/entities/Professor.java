package entities;

public class Professor extends Pessoa {
    private String disciplina, especialidade;

    public Professor(String nome, int idade, char sexo, String disciplina, String especialidade) {
        super(nome, idade, sexo);
        this.disciplina = disciplina;
        this.especialidade = especialidade;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return super.toString() + ", Disciplina = " + getDisciplina() +
                ", Especialidade = " + getEspecialidade();
    }
}
