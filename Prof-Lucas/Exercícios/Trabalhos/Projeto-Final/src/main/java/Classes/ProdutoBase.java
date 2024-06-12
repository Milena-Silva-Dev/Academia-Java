package Classes;
import Interface.Produto;

public abstract class ProdutoBase implements Produto {
    private String Nome;
    private double Preco;    ;
    private int Quantidade;

    public ProdutoBase(String Nome, double Preco, int Quantidade) {
        this.Nome = Nome;
        this.Preco = Preco;
        this.Quantidade = Quantidade;
    }

    public ProdutoBase(){}; //Construtor vazio caso queira criar objetos sem precisar passar parâmetros

    @Override
    public String getNome() {
        return Nome;
    }

    @Override
    public double getPreco() {
        return Preco;
    }

    @Override
    public void setNome(String nome) {
        this.Nome = nome;
    }

    @Override
    public void setPreco(double preco) {
        this.Preco = preco;

    }

    @Override
    public void setQuantidade(int quantidade) {
        this.Quantidade = quantidade;
    }

    @Override
    public int getQuantidade() {
        return Quantidade;
    }

    @Override
    public abstract String exibirDetalhes();
}
