/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversidad;

/**
 *
 * @author Vera Murillo
 */
public class ProfesorAsociado extends Profesor{
    protected String asig;
    protected int nCred;
    public ProfesorAsociado(String nombre, String ident, DepartamentoEnum dpto, int nDesp, String asig, int nCred){
        super(nombre,ident,dpto,nDesp);
        this.asig = asig;
        this.nCred = nCred;
    }
    @Override
    public int getHorasDocencia(){
        return switch (dpto) {
            case DEP_ECONOMIA -> 10;
            case DEP_ESTADISTICA_INFORMATICA_MATEMATICAS -> 10;
            case DEP_AGRONOMIA_BIOTECNOLOGIA_ALIMENTACION -> 10;
            default -> 10;
        };
    }
}
