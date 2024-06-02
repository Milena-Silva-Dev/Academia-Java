package compras;

public class Principal {
    public static void main(String[] args) {
        Produto produto1 = new Produto("Lápis", 2.50);
        Produto produto2 = new Produto("Borracha", 4.00);
        Produto produto3 = new Produto("Caneta", 7.50);
        Produto produto4 = new Produto("Caderno", 30.50);
        Produto produto5 = new Produto("Marca Texto", 5.00);

        Compra carrinho = new Compra();
        carrinho.adicionarProduto(produto1, 2);
        carrinho.adicionarProduto(produto2, 1);
        carrinho.adicionarProduto(produto3, 5);
        carrinho.adicionarProduto(produto4, 1);
        carrinho.adicionarProduto(produto5, 3);

        System.out.println("Produtos no carrinho");
        carrinho.listarProdutos();

        double total = carrinho.CalcularValorTotal();
        System.out.println("Total: R$ " + String.format("%.2f", total));

    }
}
