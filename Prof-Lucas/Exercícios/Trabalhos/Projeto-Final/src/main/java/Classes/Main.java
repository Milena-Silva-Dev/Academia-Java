package Principal;

import Classes.CarrinhoDeCompras;
import Classes.Eletronico;
import Classes.Roupa;
import Classes.Alimento;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            exibirMenu();
            int opcao = lerInteiro("Opção: ");
            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    removerProduto();
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 4:
                    calcularTotal();
                    break;
                case 5:
                    gerarRelatorio();
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1. Adicionar produto");
        System.out.println("2. Remover produto");
        System.out.println("3. Listar produtos");
        System.out.println("4. Calcular total");
        System.out.println("5. Gerar relatório");
        System.out.println("6. Sair");
    }

    private static int lerInteiro(String mensagem) {
        int valor = -1;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensagem);
                valor = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.nextLine(); // Consumir a nova linha
            }
        }
        return valor;
    }

    private static double lerDouble(String mensagem) {
        double valor = -1;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensagem);
                valor = scanner.nextDouble();
                scanner.nextLine(); // Consumir a nova linha
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número decimal.");
                scanner.nextLine(); // Consumir a nova linha
            }
        }
        return valor;
    }

    private static void adicionarProduto() {
        System.out.println("Escolha o tipo de produto:");
        System.out.println("1. Eletrônico");
        System.out.println("2. Roupa");
        System.out.println("3. Alimento");
        int tipo = lerInteiro("Opção: ");

        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            double preco = lerDouble("Preço: ");
            int quantidade = lerInteiro("Quantidade: ");

            switch (tipo) {
                case 1:
                    int garantiaMeses = lerInteiro("Garantia em meses: ");
                    carrinho.adicionarProduto(new Eletronico(nome, preco, garantiaMeses, quantidade));
                    break;
                case 2:
                    System.out.print("Tamanho: ");
                    String tamanho = scanner.nextLine();
                    System.out.print("Cor: ");
                    String cor = scanner.nextLine();
                    carrinho.adicionarProduto(new Roupa(nome, preco, tamanho, cor, quantidade));
                    break;
                case 3:
                    System.out.print("Data de validade (AAAA-MM-DD): ");
                    String dataValidade = scanner.nextLine();
                    carrinho.adicionarProduto(new Alimento(nome, preco, dataValidade, quantidade));
                    break;
                default:
                    System.out.println("Tipo de produto inválido.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao adicionar produto: " + e.getMessage());
            scanner.nextLine(); // Consumir a nova linha em caso de erro
        }
    }

    private static void removerProduto() {
        System.out.print("Nome do produto a remover: ");
        String nome = scanner.nextLine();
        int quantidade = lerInteiro("Quantidade: ");
        carrinho.removerProduto(nome, quantidade);
    }

    private static void listarProdutos() {
        carrinho.listarItens();
    }

    private static void calcularTotal() {
        System.out.println("Total: " + carrinho.calcularTotal());
    }

    private static void gerarRelatorio() {
        System.out.print("Nome do arquivo para o relatório: ");
        String nomeArquivo = scanner.nextLine();
        carrinho.gerarArquivoTexto(nomeArquivo);
    }
}
