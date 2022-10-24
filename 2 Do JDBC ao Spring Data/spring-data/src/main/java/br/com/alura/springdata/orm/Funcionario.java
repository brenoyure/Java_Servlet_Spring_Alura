package br.com.alura.springdata.orm;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Embedded
    private DadosPessoais dadosPessoais;

    @ManyToOne
    private Cargo cargo;

    @ManyToOne
    private UnidadeTrabalho unidadeTrabalho;

    public Funcionario() {

    }

    public Funcionario(DadosPessoais dadosPessoais, Cargo cargo, UnidadeTrabalho unidadeTrabalho) {
        this.dadosPessoais = dadosPessoais;
        this.cargo = cargo;
        this.unidadeTrabalho = unidadeTrabalho;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DadosPessoais getDadosPessoais() {
        return dadosPessoais;
    }

    public void setDadosPessoais(DadosPessoais dadosPessoais) {
        this.dadosPessoais = dadosPessoais;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public UnidadeTrabalho getUnidadeTrabalho() {
        return unidadeTrabalho;
    }

    public void setUnidadeTrabalho(UnidadeTrabalho unidadeTrabalho) {
        this.unidadeTrabalho = unidadeTrabalho;
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", dadosPessoais=" + dadosPessoais + ", cargo=" + cargo + ", unidadeTrabalho="
                + unidadeTrabalho + "]";
    }

}
