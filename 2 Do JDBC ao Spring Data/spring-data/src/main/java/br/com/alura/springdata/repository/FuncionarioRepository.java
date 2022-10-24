package br.com.alura.springdata.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.orm.FuncionarioProjecao;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>, JpaSpecificationExecutor<Funcionario> {

    List<Funcionario> findByDadosPessoaisNomeLike(String nome);

    List<Funcionario> findByDadosPessoaisNomeLike(String nome, Pageable pageable);

    @Query("SELECT f FROM Funcionario f WHERE f.dadosPessoais.nome LIKE :nome AND f.dadosPessoais.salario >= :salario AND f.dadosPessoais.dataDeContratacao >= :data")
    List<Funcionario> findNomeSalarioMaiorQueDataContratacao(String nome, BigDecimal salario, LocalDate data);

    @Query(nativeQuery = true, value = "SELECT * FROM funcionarios f WHERE f.data_de_contratacao >= :data")
    List<Funcionario> findDataContratacaoMaiorQue(LocalDate data);

    @Query(nativeQuery = true, value = "SELECT f.id, f.nome, f.salario FROM funcionarios f")
    List<FuncionarioProjecao> findFuncionarioSalario();

}
