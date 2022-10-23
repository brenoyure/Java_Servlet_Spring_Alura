package br.com.alura.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.springdata.service.CrudCargoService;
import br.com.alura.springdata.service.CrudFuncionarioService;
import br.com.alura.springdata.service.CrudUnidadeService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private final CrudCargoService cargoService;
    private final CrudFuncionarioService funcionarioService;
    private final CrudUnidadeService unidadeService;

    private boolean system = true;

    public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService, CrudUnidadeService unidadeService) {
        this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
        this.unidadeService = unidadeService;
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

            else {
                system = false;
            }

        }

    }

}
