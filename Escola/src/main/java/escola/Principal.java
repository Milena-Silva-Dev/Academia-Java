package escola;

public class Principal {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Milena","MT1",25);
        Aluno aluno2 = new Aluno("Gabriel","MT2",26);
        Aluno aluno3 = new Aluno("Ana","MT3",22);
        Aluno aluno4 = new Aluno("Isabela","MT4",21);
        Aluno aluno5 = new Aluno("Mariana","MT5",25);
        Aluno aluno6 = new Aluno("Juan","MT6",21);
        Aluno aluno7 = new Aluno("Marcos","MT7",52);
        Aluno aluno8 = new Aluno("Paula","MT8",42);
        Aluno aluno9 = new Aluno("Ercilia","MT9",72);
        Aluno aluno10 = new Aluno("Julia","MT10",18);

        Turma turma1 = new Turma("1A", "Turma A");
        Turma turma2 = new Turma("2B", "Turma B");

        turma1.adicionarAluno(aluno1);
        turma1.adicionarAluno(aluno2);
        turma1.adicionarAluno(aluno3);
        turma1.adicionarAluno(aluno4);
        turma1.adicionarAluno(aluno5);

        turma2.adicionarAluno(aluno6);
        turma2.adicionarAluno(aluno7);
        turma2.adicionarAluno(aluno8);
        turma2.adicionarAluno(aluno9);
        turma2.adicionarAluno(aluno10);

        System.out.println("A lista de alunos na " + turma1.getNome() + ":");
        turma1.listarAlunos();

        System.out.println("A lista de alunos na " + turma2.getNome() + ":");
        turma2.listarAlunos();

    }
}
