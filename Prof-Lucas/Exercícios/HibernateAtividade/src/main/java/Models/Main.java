package Models;

import DAO.DepartamentoDAO;
import DAO.FuncionarioDAO;
import Models.Departamento;
import Models.Funcionario;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        Departamento departamento = Departamento.builder()
                .nome("RH")
                .build();
        departamentoDAO.save(departamento);

        Funcionario funcionario = Funcionario.builder()
                .nome("Ana")
                .salario(BigDecimal.valueOf(3000))
                .departamento(departamento)
                .build();
        funcionarioDAO.save(funcionario);

        System.out.println(departamentoDAO.findAll());
        System.out.println(funcionarioDAO.findAll());
    }
}
