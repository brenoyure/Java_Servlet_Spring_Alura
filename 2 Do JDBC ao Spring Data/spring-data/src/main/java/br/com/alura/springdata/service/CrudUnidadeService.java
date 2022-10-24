package br.com.alura.springdata.service;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Endereco;
import br.com.alura.springdata.orm.UnidadeTrabalho;
import br.com.alura.springdata.repository.UnidadeRepository;

@Service
public class CrudUnidadeService {

    private final UnidadeRepository unidadeRepository;

    public CrudUnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    private boolean system = true;

    public void inicial(Scanner scanner) {

        while (system) {
            System.out.println("\n========== Unidades ============\n");
            System.out.println("Qual acao deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Exibir Todos");
            System.out.println("4 - Deletar");
            System.out.println("\n================================\n");

            int action = scanner.nextInt();

            switch (action) {

                case 1:
                    salvar(scanner);
                    break;

                case 2:
                    atualizar(scanner);
                    break;

                case 3:
                    visualizar();
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
        String descricao = getDescricao(scanner);
        Endereco endereco = getEndereco(scanner);
        UnidadeTrabalho novaUnidade = new UnidadeTrabalho(descricao, endereco);
        unidadeRepository.save(novaUnidade);
        System.out.println("Unidade Salva.");
    }

    public void atualizar(Scanner scanner) {
        
        try {
            
            System.out.println("\n#### Unidades ####\n");
            visualizar();
            System.out.println("\n##################\n");
            
            
            System.out.print("Insira o ID: ");
            int id = scanner.nextInt();

            if (id < 1) {
                System.err.println("IDs devem ser valores a partir de 1");
                atualizar(scanner);
            }

            UnidadeTrabalho unidade = unidadeRepository.findById(id).get();

            String descricao = getDescricao(scanner);
            Endereco endereco = getEndereco(scanner);
            unidade.setDescricao(descricao);
            unidade.setEndereco(endereco);
            
            unidadeRepository.save(unidade);
            System.out.println("Dados da Unidade atualizados.");
            
        } catch (InputMismatchException e) {
            scanner.next();
            System.err.println("Apenas números são permitidos.");
            
        } catch (NoSuchElementException e) {
            System.err.println("Unidade não encontrada.");
            
        } finally {
            inicial(scanner);
        }

    }

    private void visualizar() {
        unidadeRepository.findAll().forEach(System.out::println);
    }

    private void deletar(Scanner scanner) {
        System.out.println("Insira o ID para deletar: ");
        int id = scanner.nextInt();
        unidadeRepository.deleteById(id);
    }

    private String getDescricao(Scanner scanner) {
        System.out.println("Digite uma descrição: ");
        String descricao = scanner.next();
        return descricao;

    }

    private Endereco getEndereco(Scanner scanner) {
        System.out.println("Digite o Estado: ");
        String estado = scanner.next();

        System.out.println("Digite a cidade: ");
        String cidade = scanner.next();

        System.out.println("Digite o bairro: ");
        String bairro = scanner.next();

        System.out.println("Digite o cep: ");
        String cep = scanner.next();

        System.out.println("Digite a rua: ");
        String rua = scanner.next();

        System.out.println("Digite o número da casa: ");
        int numero = scanner.nextInt();

        Endereco endereco = new Endereco(estado, cidade, bairro, cep, rua, numero);
        return endereco;

    }

}
