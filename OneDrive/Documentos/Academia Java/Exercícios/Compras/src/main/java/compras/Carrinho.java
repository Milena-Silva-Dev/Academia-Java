package compras;

public class Carrinho {
    private int quantidade;
    private Produto produto;

    public Carrinho(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return produto.getNome() + "Valor Unitário: - R$ " + String.format("%.2f", produto.getPreco()) + " x Qtd: " + quantidade + " Subtotal = R$ " + String.format("%.2f", getSubtotal());
    }

}
