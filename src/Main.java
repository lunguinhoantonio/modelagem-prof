import entities.Professor;
import utils.Formatacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Professor> professores = new ArrayList<>();
        int opc, index, idade;
        char simOuNao = 0;
        String nomeFormatado, nomeCompleto, disciplina, especialidade;
        do {
            System.out.println("0. Fechar programa");
            System.out.println("1. Cadastrar professor");
            System.out.println("2. Listar professores");
            System.out.println("3. Editar professor");
            System.out.println("4. Remover professores");
            System.out.println("5. Mostrar informações dos professores");
            System.out.print("Resposta: ");
            opc = scanner.nextInt();
            Formatacoes.div();
            switch (opc) {
                case 0:
                    if (!professores.isEmpty()) {
                        professores.clear();
                    }
                case 1:
                    char sexo;
                    do {
                        System.out.print("Digite o sexo do(a) professor(a) [M/F]: ");
                        sexo = scanner.next().toUpperCase().charAt(0);
                    } while (sexo != 'M' && sexo != 'F');
                    scanner.nextLine();
                    do {
                        System.out.print(sexo == 'M' ?
                                "Digite o nome completo do professor: " :
                                "Digite o nome completo da professora: ");
                        nomeCompleto = scanner.nextLine();
                        nomeFormatado = Formatacoes.formatarNome(nomeCompleto);
                        System.out.println("Esse nome está correto?");
                        System.out.println(nomeFormatado);
                        System.out.print("Resposta [S/N]: ");
                        simOuNao = scanner.nextLine().toUpperCase().charAt(0);
                    } while (simOuNao == 'N');
                    do {
                        System.out.print("Digite a idade de " + nomeFormatado + ": ");
                        idade = scanner.nextInt();
                        if (idade < 18 || idade > 75) {
                            System.out.println("Idade muito extrema! Tente novamente!");
                        }
                    } while (idade < 18 || idade > 75);
                    scanner.nextLine();
                    String primeiroNome = Formatacoes.obterPrimeiroNome(nomeFormatado);
                    System.out.print("Digite o nome da disciplina que " + primeiroNome + " lecionará: ");
                    disciplina = scanner.nextLine();
                    System.out.print("Digite uma área que " + primeiroNome + " tem mais especialidade: ");
                    especialidade = scanner.nextLine();
                    Formatacoes.div();

                    professores.add(new Professor(nomeFormatado, idade, sexo, disciplina, especialidade));
                    System.out.println(professores.getLast().getNome() +
                            (professores.getLast().getSexo() == 'M' ?
                                    " foi adicionado com sucesso!" :
                                    " foi adicionada com sucesso!"));
                    Formatacoes.div();
                    break;
                case 2:
                    if (professores.isEmpty()) {
                        System.out.println("Lista vazia!");
                        Formatacoes.div();
                        continue;
                    }
                    listarProfessores(professores);
                    break;
                case 3:
                    if (professores.isEmpty()) {
                        System.out.println("Lista vazia!");
                        Formatacoes.div();
                        continue;
                    }
                    listarProfessores(professores);
                    System.out.print("Resposta: ");
                    index = scanner.nextInt() - 1;
                    do {
                        System.out.println("Atributo a ser alterado de " + professores.get(index).getNome());
                        System.out.println("1. Nome");
                        System.out.println("2. Idade");
                        System.out.println("3. Sexo");
                        System.out.println("4. Disciplina");
                        System.out.println("5. Especialidade");
                        System.out.print("Resposta: ");
                        opc = scanner.nextInt();
                        scanner.nextLine();
                        Formatacoes.div();
                        switch (opc) {
                            case 1:
                                String nomeAntigo = professores.get(index).getNome();
                                do {
                                    System.out.print("Novo nome para " + nomeAntigo + ": ");
                                    nomeCompleto = scanner.nextLine();
                                    nomeFormatado = Formatacoes.formatarNome(nomeCompleto);
                                    System.out.println("Esse nome está correto?");
                                    System.out.println(nomeFormatado);
                                    System.out.print("Resposta [S/N]: ");
                                    simOuNao = scanner.nextLine().toUpperCase().charAt(0);
                                } while (simOuNao == 'N');
                                professores.get(index).setNome(nomeFormatado);
                                System.out.println("Novo nome alterado de " +
                                        nomeAntigo + " para " +
                                        professores.get(index).getNome());
                                Formatacoes.div();
                                break;
                            case 2:
                                int idadeAntiga = professores.get(index).getIdade();
                                do {
                                    System.out.print("Nova idade para " + professores.get(index).getNome() + ": ");
                                    idade = scanner.nextInt();
                                    scanner.nextLine();
                                    if (idadeAntiga == idade) {
                                        System.out.println("Não teve mudança de idade");
                                        continue;
                                    }
                                    if (idade < 18 || idade > 75) {
                                        System.out.println("Idade muito extrema! Tente novamente!");
                                        continue;
                                    }
                                    System.out.println("Essa idade está correto?");
                                    System.out.println(idade);
                                    System.out.print("Resposta [S/N]: ");
                                    simOuNao = scanner.nextLine().toUpperCase().charAt(0);
                                } while (simOuNao == 'N');
                                professores.get(index).setIdade(idade);
                                System.out.println("Nova idade de " +
                                        professores.get(index).getNome() +
                                        ": de " + idadeAntiga + " anos para " +
                                        professores.get(index).getIdade() + " anos");
                                Formatacoes.div();
                                break;
                            case 3:
                                System.out.println("Alterar o sexo de " +
                                        (professores.get(index).getSexo() == 'M' ? "Masculino" : "Feminino") + " para " +
                                        (professores.get(index).getSexo() == 'M' ? "Feminino" : "Masculino") + "?");
                                System.out.print("Resposta [S/N]: ");
                                simOuNao = scanner.nextLine().toUpperCase().charAt(0);
                                if (simOuNao == 'S') {
                                    professores.get(index).setSexo(professores.get(index).getSexo() == 'M' ? 'F' : 'M');
                                    System.out.println("Sexo alterado com sucesso!");
                                }
                                Formatacoes.div();
                                break;
                            case 4:
                                String disciplinaAntiga = professores.get(index).getDisciplina();
                                do {
                                    System.out.println("Antiga disciplina: " + disciplinaAntiga);
                                    System.out.print("Digite a nova disciplina: ");
                                    disciplina = scanner.nextLine();
                                    System.out.println("Essa disciplina está correta?");
                                    System.out.println(disciplina);
                                    System.out.print("Resposta [S/N]: ");
                                    simOuNao = scanner.nextLine().toUpperCase().charAt(0);
                                } while (simOuNao == 'N');
                                professores.get(index).setDisciplina(disciplina);
                                System.out.println("Disciplina alterada de " +
                                        disciplinaAntiga + " para " + professores.get(index).getDisciplina());
                                Formatacoes.div();
                                break;
                            case 5:
                                String especialidadeAntiga = professores.get(index).getEspecialidade();
                                do {
                                    System.out.println("Especialidade antiga: " + especialidadeAntiga);
                                    System.out.print("Digite a nova especialidade de " +
                                            professores.get(index).getNome() + ": ");
                                    especialidade = scanner.nextLine();
                                    System.out.println("Essa especialidade está correta?");
                                    System.out.println(especialidade);
                                    System.out.print("Resposta [S/N]: ");
                                    simOuNao = scanner.nextLine().toUpperCase().charAt(0);
                                } while (simOuNao == 'N');
                                professores.get(index).setEspecialidade(especialidade);
                                System.out.println("Especialidade alterada de " + especialidadeAntiga + " para " +
                                        professores.get(index).getEspecialidade());
                                Formatacoes.div();
                                break;
                        }
                    } while (opc < 1 || opc > 5);
                    break;
                case 4:
                    if (professores.isEmpty()) {
                        System.out.println("Lista vazia!");
                        Formatacoes.div();
                        continue;
                    }
                    listarProfessores(professores);
                    System.out.print("Resposta: ");
                    index = scanner.nextInt() - 1;
                    do {
                        System.out.println("Tem certeza que deseja remover " + professores.get(index).getNome() + "?");
                        System.out.print("Resposta [S/N]: ");
                        simOuNao = scanner.nextLine().toUpperCase().charAt(0);
                    } while (simOuNao == 'N');
                    break;
                case 5:
                    if (professores.isEmpty()) {
                        System.out.println("Lista vazia!");
                        Formatacoes.div();
                        continue;
                    }

                    for (int i = 0; i < professores.size(); i++) {
                        System.out.println((i + 1) + ". " + professores.get(i));
                        Formatacoes.div();
                    }
            }
        } while (opc != 0);

        scanner.close();
    }
    public static void listarProfessores(List<Professor> professores) {
        for (int i = 0; i < professores.size(); i++) {
            System.out.println((i + 1) + ". " + professores.get(i).getNome());
        }
        Formatacoes.div();
    }
}