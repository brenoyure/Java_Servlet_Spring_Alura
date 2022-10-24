package br.com.alura.springdata.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.FuncionarioRepository;
import br.com.alura.springdata.specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamico {

    private final FuncionarioRepository funcionarioRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        System.out.println("Digite um nome: ");
        String nome = scanner.next();

        System.out.println("Digite um cpf: ");
        String cpf = scanner.next();

        System.out.println("Digite o salário : ");
        BigDecimal salario = new BigDecimal(scanner.next());

        System.out.println("Digite a data de contratação: ");
        String dataStr = scanner.next();

        if (nome.equalsIgnoreCase("NULL")) {
            nome = null;
        }
        if (cpf.equalsIgnoreCase("NULL")) {
            cpf = null;
        }
        if (salario == BigDecimal.ZERO) {
            salario = null;
        }

        LocalDate data;
        if (dataStr.equalsIgnoreCase("NULL")) {
            data = null;
        } else {
            data = LocalDate.parse(dataStr, formatter);
        }

        List<Funcionario> funcionarios = funcionarioRepository
                .findAll(Specification.where(
                        SpecificationFuncionario.nome(nome))
                        .or(SpecificationFuncionario.cpf(cpf))
                        .or(SpecificationFuncionario.salario(salario))
                        .or(SpecificationFuncionario.dataDeContratacao(data))

                );

        funcionarios.forEach(System.out::println);

    }

}
