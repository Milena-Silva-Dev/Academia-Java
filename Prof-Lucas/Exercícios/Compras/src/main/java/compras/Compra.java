package compras;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private List<Carrinho> itens;

    public Compra() {
        this.itens = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        itens.add(new Carrinho(quantidade, produto));
    }

    public void listarProdutos(){
        for (Carrinho carrinho : itens) {
            System.out.println(itens);
        }
    }

    public double CalcularValorTotal(){
        double total = 0;
        for (Carrinho carrinho : itens) {
            total += carrinho.getSubtotal();
        }
        return total;
    }
}
