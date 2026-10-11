package br.senai.sistema.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordemServico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String equipamento;

    @Column(nullable = false, length = 20)
    private String marca;

    @Column(nullable = false, length = 100)
    private String defeitoRelatado;

    @Column(length = 100)
    private String diagnostico;

    @Column(length = 10)
    private BigDecimal valor;

    @Column(length = 100)
    private String status;

    @Column(nullable = false)
    private LocalDate dataAbertura;

    public OrdemServico() {
    }

    public OrdemServico(String equipamento, String marca, String defeitoRelatado, String diagnostico, BigDecimal valor, String status, LocalDate dataAbertura) {
        this.equipamento = equipamento;
        this.marca = marca;
        this.defeitoRelatado = defeitoRelatado;
        this.diagnostico = diagnostico;
        this.valor = valor;
        this.status = status;
        this.dataAbertura = dataAbertura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDefeitoRelatado() {
        return defeitoRelatado;
    }

    public void setDefeitoRelatado(String defeitoRelatado) {
        this.defeitoRelatado = defeitoRelatado;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

     public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}