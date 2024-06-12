package Interface;

    public interface Produto {
        public String getTipo();
        public String getNome();
        public double getPreco();
        public int getQuantidade();
        public void setNome(String nome);
        public void setPreco(double preco);
        public void setQuantidade(int quantidade);
        public String exibirDetalhes();
    }