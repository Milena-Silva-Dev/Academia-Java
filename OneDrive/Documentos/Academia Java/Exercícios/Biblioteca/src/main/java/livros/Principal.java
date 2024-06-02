package livros;

public class Principal {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Laranja Mecânica", "Anthony Burges", 1962);
        Livro livro2 = new Livro("Jogos Vorazes", "Suzanne Collins", 2008);
        Livro livro3 = new Livro("Orgulho e Preconceito", "Jane Austen", 1813);
        Livro livro4 = new Livro("Sway", "Kat Spears", 2014);
        Livro livro5 = new Livro("A seleção", "Kiera Cass", 2012);

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);

        System.out.println("Lista de livros adicionados na biblioteca:");
        biblioteca.listarLivros();
    }
}
