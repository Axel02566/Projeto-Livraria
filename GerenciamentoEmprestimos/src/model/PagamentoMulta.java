package model;

import enums.MetodoPagamento;

import java.time.LocalDate;

public class PagamentoMulta {
    private String id;
    private String matriculaUsuario;
    private double valor;
    private LocalDate dataPagamento;
    private MetodoPagamento metodoPagamento;


    public PagamentoMulta(String id, String matriculaUsuario, double valor, LocalDate dataPagamento) {
        super();
        this.id = id;
        this.matriculaUsuario = matriculaUsuario;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.metodoPagamento = MetodoPagamento.CARTAO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getMatriculaUsuario() {
        return matriculaUsuario;
    }
    public void setMatriculaUsuario(String matriculaUsuario) {
        this.matriculaUsuario = matriculaUsuario;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }
    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
}
