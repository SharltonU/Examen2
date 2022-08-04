package com.sharlton.examen2.models;

import java.util.Date;
import java.util.Set;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Futbolista {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "futbolista"
    )
    private Set<IMC> imc;

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String posicion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    
    private Double estatura;
    private Double peso;
    private String rama;

    private String direccion;
    private String email;
    private String telefono;
    private String provincia;
    private String canton;
    private String distrito;

    public Futbolista() {

    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Set<IMC> getImc() {
        return imc;
    }
    public void setImc(Set<IMC> imc) {
        this.imc = imc;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
    public String getRama() {
        return rama;
    }
    public void setRama(String rama) {
        this.rama = rama;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getCanton() {
        return canton;
    }
    public void setCanton(String canton) {
        this.canton = canton;
    }
    public String getDistrito() {
        return distrito;
    }
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
}
