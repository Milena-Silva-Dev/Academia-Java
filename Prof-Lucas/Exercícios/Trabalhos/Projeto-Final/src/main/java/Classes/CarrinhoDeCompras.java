package Classes;
import Interface.Produto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Produto> itens;

    public CarrinhoDeCompras() {
        itens = new ArrayList<Produto>();
    }

    public void adicionarProduto(Produto produto) {
        itens.add(produto);
    }

    public void removerProduto(String nome, int quantidade) {
        Produto produtoARemover = null;
        for (Produto produto : itens) {
            if (produto.getNome().equalsIgnoreCase(nome) && produto.getQuantidade() == quantidade) {
                produtoARemover = produto;
                break;
            }
        }
        if (produtoARemover != null) {
            itens.remove(produtoARemover);
            System.out.println("Produto removido com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void listarItens() {
        for (Produto item : itens) {
            System.out.println(item.exibirDetalhes());
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void gerarArquivoTexto(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("Item: Qtd: Nome: Preço: SubTotal:\n");
            int index = 1;
            for (Produto item : itens) {
                writer.write(index + " " +
                        item.getQuantidade() + " " +
                        item.getNome() + " " +
                        item.getPreco() + " " +
                        (item.getPreco() * item.getQuantidade()) + "\n");
                index++;
            }
            writer.write("Total: " + calcularTotal());
        } catch (IOException e) {
            System.err.println("Erro ao gerar arquivo: " + e.getMessage());
        }
    }
}
