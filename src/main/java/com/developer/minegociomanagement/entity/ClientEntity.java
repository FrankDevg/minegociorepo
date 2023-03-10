package com.developer.minegociomanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id_cliente;

    @Column(name = "tipo_identificacion")
    private String tipo_identificacion;
    @Column(name = "numero_identificacion",unique = true)
    private String numero_identificacion;
    @Column(name = "nombres")
    private String nombres;

    @Column(name = "correo")
    private String correo;
    @Column(name = "celular")
    private String celular;


    public ClientEntity(){

    }

    public ClientEntity(Long id_cliente, String tipo_identificacion, String numero_identificacion, String nombres, String correo, String celular) {
        this.id_cliente = id_cliente;
        this.tipo_identificacion = tipo_identificacion;
        this.nombres = nombres;
        this.correo = correo;
        this.celular = celular;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }
}
