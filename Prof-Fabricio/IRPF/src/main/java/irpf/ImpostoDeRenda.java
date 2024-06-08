package irpf;

public class ImpostoDeRenda {
    private Pessoa pessoa;

    public ImpostoDeRenda(Pessoa pessoa){
        this.pessoa = pessoa;
    }

   public double calcular(){
        double salario = pessoa.getSalario();
        double imposto = 0;

       if (salario > 4664.68) {
           imposto += (salario - 4664.68) * 0.275;
           salario = 4664.68;
       }
       if (salario > 3751.06) {
           imposto += (salario - 3751.06) * 0.225;
           salario = 3751.06;
       }
       if (salario > 2826.66) {
           imposto += (salario - 2826.66) * 0.15;
           salario = 2826.66;
       }
       if (salario > 2112.00) {
           imposto += (salario - 2112.00) * 0.075;
       }

       return imposto;
   }

   public void imprimir(){
        double imposto = calcular();
        int faixa = FaixaImpostoDeRenda.faixa(pessoa.getSalario());

       System.out.println(pessoa.getNome() + " seu salário é R$ " + String.format("%.2f", pessoa.getSalario()) +
               " sua faixa de imposto é " + faixa + " e o valor do imposto de renda a ser pago é: R$ " +
               String.format("%.2f", imposto));
   }
}
