package br.com.alura.springdata.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.orm.DadosPessoais;
import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.orm.UnidadeTrabalho;
import br.com.alura.springdata.repository.CargoRepository;
import br.com.alura.springdata.repository.FuncionarioRepository;
import br.com.alura.springdata.repository.UnidadeRepository;

@Service
public class CrudFuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final CargoRepository cargoRepository;
    private final UnidadeRepository unidadeRepository;

    private boolean system = true;

    public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository,
            UnidadeRepository unidadeRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.cargoRepository = cargoRepository;
        this.unidadeRepository = unidadeRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("\n========== Funcionários ============\n");
            System.out.println("Qual acao deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");
            System.out.println("\n====================================\n");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;

                case 3:
                    visualizar(scanner);
                    break;

                case 4:
                    deletar(scanner);
                    break;

                default:
                    system = false;
                    break;
            }

        }

    }

    private void salvar(Scanner scanner) {
        DadosPessoais dadosPessoais = fetchDadosPessoais(scanner);
        Cargo cargo = getCargo(scanner);
        UnidadeTrabalho unidade = getUnidadeTrabalho(scanner);
        Funcionario funcionario = new Funcionario(dadosPessoais, cargo, unidade);
        funcionarioRepository.save(funcionario);
        System.out.println("Funcionário " + funcionario.getDadosPessoais().getNome() + " cadastrado.");

    }

    private void visualizar(Scanner scanner) {
        System.out.println("Qual página deseja visualizar?");
        Integer page = scanner.nextInt();
        
        Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.ASC, "dadosPessoais.nome"));
        
        Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
        
        System.out.println(funcionarios);
        System.out.println("Página atual " + funcionarios.getNumber());
        
        System.out.println("Total de elementos: " + funcionarios.getTotalElements());
                
        funcionarios.forEach(f -> System.out.printf("ID: %d %s, %s, %s \n", f.getId(), f.getDadosPessoais().getNome(),
                f.getCargo().getDescricao(), f.getUnidadeTrabalho().getDescricao()));
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Insira o ID ");
        int id = scanner.nextInt();
        Funcionario funcionario = funcionarioRepository.findById(id).get();

        if (funcionario != null) {
            System.out.println("\n========== Editando Funcionário ============\n");
            funcionario.setDadosPessoais(fetchDadosPessoais(scanner));
            funcionario.setCargo(getCargo(scanner));
            funcionario.setUnidadeTrabalho(getUnidadeTrabalho(scanner));
            funcionarioRepository.save(funcionario);
            System.out.println("Dados Atualizados.");
        } else
            System.err.println("Id não encontrado.");

    }

    private void deletar(Scanner scanner) {
        System.out.println("Id para deletar: ");
        int id = scanner.nextInt();
        funcionarioRepository.deleteById(id);
        System.out.println("Deletado.");
    }

    private DadosPessoais fetchDadosPessoais(Scanner scanner) {
        System.out.println("Digite seu Nome: ");
        String nome = scanner.next();

        System.out.println("Digite seu CPF: ");
        String cpf = scanner.next();

        System.out.println("Digite seu Salário: ");
        BigDecimal salario = scanner.nextBigDecimal();

        System.out.println("Digite a Data de Contratação no formato 2022-10-21");
        String dataDeContratacao = scanner.next();

        return new DadosPessoais(nome, cpf, salario, LocalDate.parse(dataDeContratacao));

    }

    private Cargo getCargo(Scanner scanner) {
        System.out.println("Digite o Id do Cargo: ");
        int id = scanner.nextInt();
        Cargo cargo = cargoRepository.findById(id).get();
        System.out.println("Cargo " + cargo.getDescricao());
        return cargo;

    }

    private UnidadeTrabalho getUnidadeTrabalho(Scanner scanner) {
        System.out.println("Digite o Id da Unidade: ");
        int id = scanner.nextInt();
        UnidadeTrabalho unidade = unidadeRepository.findById(id).get();
        System.out.println("Unidade de: " + unidade.getDescricao());
        return unidade;

    }

}
