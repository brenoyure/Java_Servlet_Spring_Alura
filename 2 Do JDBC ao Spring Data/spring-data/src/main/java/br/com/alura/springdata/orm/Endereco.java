package br.com.alura.springdata.orm;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

    @Column(nullable = false, length = 55)
    private String estado;

    @Column(nullable = false, length = 55)
    private String cidade;

    @Column(nullable = false, length = 55)
    private String bairro;

    @Column(nullable = false, length = 8)
    private String cep;

    @Column(nullable = false, length = 55)
    private String rua;

    @Column(nullable = false)
    private Integer numero;

    public Endereco() {

    }

    public Endereco(String estado, String cidade, String bairro, String cep, String rua, Integer numero) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco [ " + estado + ", " + cidade + ", Bairro= " + bairro + ", CEP= " + cep + ", Rua= "
                + rua + ", Nº= " + numero + "]";
    }

}
