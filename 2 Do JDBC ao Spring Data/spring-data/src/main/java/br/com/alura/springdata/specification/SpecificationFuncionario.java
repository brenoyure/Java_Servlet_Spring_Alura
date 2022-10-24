package br.com.alura.springdata.specification;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.springdata.orm.Funcionario;

public class SpecificationFuncionario {

    public static Specification<Funcionario> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("dadosPessoais").get("nome"), "%" + nome + "%");
    }
    
    public static Specification<Funcionario> cpf(String cpf) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("dadosPessoais").get("nome"), cpf);
    }
    
    public static Specification<Funcionario> salario(BigDecimal salario) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("dadosPessoais").get("salario"), salario);
    }
    
    public static Specification<Funcionario> dataDeContratacao(LocalDate data) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("dadosPessoais").get("dataDeContratacao"), data);
    }
}
