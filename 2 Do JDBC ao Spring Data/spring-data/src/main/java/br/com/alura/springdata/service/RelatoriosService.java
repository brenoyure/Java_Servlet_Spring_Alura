package br.com.alura.springdata.service;

import static java.time.LocalDate.parse;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.orm.FuncionarioProjecao;
import br.com.alura.springdata.repository.FuncionarioRepository;

@Service
public class RelatoriosService {

    private boolean system = true;

    private final FuncionarioRepository funcionarioRepository;
    
    private final DateTimeFormatter formatter = ofPattern("dd/MM/yyyy");

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("\n========== Relatórios ============\n");
            System.out.println("Qual acao deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca Funcionário por Nome");
            System.out.println("2 - Busca Funcionário por Nome | Salário Maior que | Data de Contratação");
            System.out.println("3 - Busca Funcionários por Data de Contratação maior que");
            System.out.println("4 - Busca Funcionários Com Maior Salário");
            System.out.println("\n==================================\n");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    buscaFuncionarioNome(scanner);
                    break;
                    
                case 2:
                    buscaFuncionarioPorNomeSalarioMaiorQueDataContratacao(scanner);
                    break;

                case 3:
                    buscaFuncionarioDataContratacaoMaiorQue(scanner);
                    break;

                case 4:
                    buscaFuncionariosMaiorSalario();
                    break;
                    
                default:
                    system = false;
                    break;
            }
        }

    }

    private void buscaFuncionarioNome(Scanner scanner) {
        System.out.println("Qual nome deseja buscar? ");
        String nome = scanner.next();
        List<Funcionario> list = funcionarioRepository.findByDadosPessoaisNomeLike("%" + nome + "%");
        list.forEach(System.out::println);

    }
    
    private void buscaFuncionarioPorNomeSalarioMaiorQueDataContratacao(Scanner scanner) {
        System.out.print("Informe o Nome: ");
        String nome = scanner.next();
        
        System.out.print("\nAgora o salário: R$");
        BigDecimal salario = BigDecimal.valueOf(scanner.nextDouble());
        
        System.out.print("\nPor fim a data de contratação, favor utilizar o padrão 23/10/2022: ");
        String dataStr = scanner.next();
        LocalDate data = parse(dataStr, formatter);
        
        List<Funcionario> lista = funcionarioRepository.findNomeSalarioMaiorQueDataContratacao("%"+nome+"%", salario, data);
        lista.forEach(f -> System.out.printf("%s, R$%s, %s", 
                f.getDadosPessoais()
                    .getNome().replaceAll("_", " "), 
                    
                f.getDadosPessoais()
                    .getSalario(),
                    
                f.getDadosPessoais()
                    .getDataDeContratacao()
                        .format(formatter)
                ));
        
    }
    
    private void buscaFuncionarioDataContratacaoMaiorQue(Scanner scanner) {
        
        System.out.println("Digite a data, favor utilizar o formato 23/10/2022");
        String dataStr = scanner.next();
        LocalDate data = parse(dataStr, formatter);
        List<Funcionario> lista = funcionarioRepository.findDataContratacaoMaiorQue(data);
        
        lista.forEach(f -> System.out.printf("%s, R$%s, %s", 
                f.getDadosPessoais()
                    .getNome().replaceAll("_", " "), 
                    
                f.getDadosPessoais()
                    .getSalario(),
                    
                f.getDadosPessoais()
                    .getDataDeContratacao()
                        .format(formatter)
                ));
        
    }
    
    private void buscaFuncionariosMaiorSalario() {
        List<FuncionarioProjecao> lista = funcionarioRepository.findFuncionarioSalario();
        lista.forEach(f -> System.out.printf("Funcionário: id:%d | nome: %s | Salário: R$%s \n", f.getId(), f.getNome().replaceAll("_", " "), f.getSalario()));
    }

}






















