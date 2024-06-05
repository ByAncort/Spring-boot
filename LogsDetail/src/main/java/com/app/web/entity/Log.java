package com.app.web.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logID")
    private int logID;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_hora")
    private Date fechaHora;

    // Constructor vacío necesario para Spring JDBC
    public Log() {
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logID=" + logID +
                ", descripcion='" + descripcion + '\'' +
                ", fechaHora=" + fechaHora +
                '}';
    }
}
