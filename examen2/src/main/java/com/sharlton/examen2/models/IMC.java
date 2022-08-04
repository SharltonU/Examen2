package com.sharlton.examen2.models;

import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity
public class IMC {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Futbolista futbolista;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NonNull
    private Date fecha;

    private double valor;
    private Double estatura;
    private Double peso;

    public IMC() {
        this.fecha = new Date();
    }

    public IMC(Futbolista futbolista) {
        this.fecha = new Date();
        this.futbolista = futbolista;
        this.peso = futbolista.getPeso();
        this.estatura = futbolista.getEstatura();
        setValor();
    }

    private void setValor() {
        this.valor = this.peso / (this.estatura * this.estatura);
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Futbolista getFutbolista() {
        return futbolista;
    }
    public void setFutbolista(Futbolista futbolista) {
        this.futbolista = futbolista;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public double getValor() {
        return valor;
    }
    public Double getEstatura() {
        return estatura;
    }
    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }  
}
