package br.com.alura.springdata.orm;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UnidadeTrabalho {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String descricao;
    
    @Embedded
    private Endereco endereco;

    public UnidadeTrabalho(String descricao, Endereco endereco) {
        this.descricao = descricao;
        this.endereco = endereco;
    }

    public UnidadeTrabalho() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "[Unidade " + id + ", " + descricao + ", " + endereco + "]";
    }
    
}
