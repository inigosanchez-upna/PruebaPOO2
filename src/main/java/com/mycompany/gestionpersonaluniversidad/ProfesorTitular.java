/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversidad;

/**
 *
 * @author Vera Murillo
 */
public class ProfesorTitular extends Profesor{
    protected int anos;
    protected String area;
    protected int horas;
    
    public ProfesorTitular(String nombre, String ident, DepartamentoEnum dpto, int nDesp, int anos, String area, int horas){
        super(nombre,ident,dpto,nDesp);
        this.anos = anos;
        this.area = area;
        this.horas = horas;
    }
    
    @Override
    public int getHorasDocencia(){
        return switch (dpto) {
            case DEP_ECONOMIA -> 20;
            case DEP_ESTADISTICA_INFORMATICA_MATEMATICAS -> 15;
            case DEP_AGRONOMIA_BIOTECNOLOGIA_ALIMENTACION -> 15;
            default -> 15;
        };
    }
    
}
