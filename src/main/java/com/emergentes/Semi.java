/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author RUBEN
 */
public class Semi {
    private int id;
    private Date fecha=new Date();
    private String nombre;
    private String apellidos;
    private String turno;
    private String Seminarios;
    
    

    public Semi() {
        this.id = 0;
        this.fecha = new Date();
        this.nombre = "";
        this.apellidos = "";
        this.turno = "";
        this.Seminarios = "";
        
    }

  
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSeminarios() {
        return Seminarios;
    }

    public void setSeminarios(String Seminarios) {
        this.Seminarios = Seminarios;
    }

    public Date getFecha() {
         //SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
        //f1.format(fecha);
        return fecha;
    }

    public void setFecha(Date fecha) {
        
        //SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
        //f1.format(fecha);
        this.fecha=fecha;
    }

   

   
    
    
    
}
