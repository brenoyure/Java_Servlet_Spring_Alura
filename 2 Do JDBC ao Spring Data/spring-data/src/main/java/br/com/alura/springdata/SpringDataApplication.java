package br.com.alura.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.springdata.service.CrudCargoService;
import br.com.alura.springdata.service.CrudFuncionarioService;
import br.com.alura.springdata.service.CrudUnidadeService;
import br.com.alura.springdata.service.RelatorioFuncionarioDinamico;
import br.com.alura.springdata.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private final CrudCargoService cargoService;
    private final CrudFuncionarioService funcionarioService;
    private final CrudUnidadeService unidadeService;
    private final RelatoriosService relatoriosService;
    private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

    private boolean system = true;

    public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService, CrudUnidadeService unidadeService, RelatoriosService relatoriosService, RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
        this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
        this.unidadeService = unidadeService;
        this.relatoriosService = relatoriosService;
        this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        while (system) {
            System.out.println("\n========== Menu ============\n");
            System.out.println("Qual acao vc quer executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Cargos");
            System.out.println("2 - Funcionários");
            System.out.println("3 - Unidades");
            System.out.println("4 - Relatórios");
            System.out.println("5 - Relatórios Dinâmicos");

            int action = scanner.nextInt();

            if (action == 1) {
                cargoService.inicial(scanner);
            }
            
            else if (action == 2) {
                funcionarioService.inicial(scanner);
            }
            
            else if (action == 3) {
                unidadeService.inicial(scanner);
                
            }
            
            else if (action == 4) {
                relatoriosService.inicial(scanner);
                
            }
            
            else if (action == 5) {
                relatorioFuncionarioDinamico.inicial(scanner);
                
            }

            else {
                system = false;
            }

        }

    }

}
