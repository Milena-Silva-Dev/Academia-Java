package irpf;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da primeira pessoa: ");
        String nome1 = scanner.nextLine();
        System.out.print("Digite o salário da primeira pessoa: ");
        double salario1 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite o nome da segunda pessoa: ");
        String nome2 = scanner.nextLine();
        System.out.print("Digite o salário da segunda pessoa: ");
        double salario2 = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite o nome da terceira pessoa: ");
        String nome3 = scanner.nextLine();
        System.out.print("Digite o salário da terceira pessoa: ");
        double salario3 = scanner.nextDouble();

        scanner.close();

        Pessoa pessoa1 = new Pessoa(nome1, salario1);
        Pessoa pessoa2 = new Pessoa(nome2, salario2);
        Pessoa pessoa3 = new Pessoa(nome3, salario3);

        ImpostoDeRenda ir1 = new ImpostoDeRenda(pessoa1);
        ImpostoDeRenda ir2 = new ImpostoDeRenda(pessoa2);
        ImpostoDeRenda ir3 = new ImpostoDeRenda(pessoa3);

        ir1.imprimir();
        ir2.imprimir();
        ir3.imprimir();
    }
}

