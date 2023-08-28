/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversidad;

/**
 *
 * @author Vera Murillo
 */
public class Profesor {
    protected String nombre;
    protected String ident;
    protected DepartamentoEnum dpto;
    protected int nDesp;
    
    public Profesor(String nombre, String ident, DepartamentoEnum dpto, int nDesp){
        this.nombre = nombre;
        this.ident = ident;
        this.dpto = dpto;
        this.nDesp = nDesp;
    }

    public String getNombreCompleto() {
        return nombre;
    }

    public String getIdentificador() {
        return ident;
    }

    public DepartamentoEnum getDpto() {
        return dpto;
    }

    public int getNumeroDespacho() {
        return nDesp;
    }
    
    public int getHorasDocencia(){
        return switch (dpto) {
            case DEP_ECONOMIA -> 30;
            case DEP_ESTADISTICA_INFORMATICA_MATEMATICAS -> 10;
            case DEP_AGRONOMIA_BIOTECNOLOGIA_ALIMENTACION -> 30;
            default -> 10;
        };
    }
    public int obtieneDespachoDeIdentificador(){
        String[] separado = ident.split("\\.");
        return Integer.parseInt(separado[2]);
    }
}
