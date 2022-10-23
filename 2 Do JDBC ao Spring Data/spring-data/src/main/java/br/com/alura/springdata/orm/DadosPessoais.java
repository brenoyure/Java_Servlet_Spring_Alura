package br.com.alura.springdata.orm;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {

    @Column(nullable = false, length = 55)
    private String nome;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(nullable = false)
    private BigDecimal salario;

    @Column(nullable = false)
    private LocalDate dataDeContratacao;

    public DadosPessoais() {

    }

    public DadosPessoais(String nome, String cpf, BigDecimal salario, LocalDate dataDeContratacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dataDeContratacao = dataDeContratacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDataDeContratacao() {
        return dataDeContratacao;
    }

    public void setDataDeContratacao(LocalDate dataDeContratacao) {
        this.dataDeContratacao = dataDeContratacao;
    }

    @Override
    public String toString() {
        return "DadosPessoais [nome=" + nome + ", cpf=" + cpf + ", salario=" + salario + ", dataDeContratacao="
                + dataDeContratacao + "]";
    }

}
