/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversidad;

/**
 *
 * @author Iñigo
 */
public enum DepartamentoEnum {
    DEP_ECONOMIA,
    DEP_ESTADISTICA_INFORMATICA_MATEMATICAS,
    DEP_AGRONOMIA_BIOTECNOLOGIA_ALIMENTACION,
    DEP_INGENIERIA;
    
    public String getNombreDepartamento(){
        return switch(this) {
            case DEP_ECONOMIA  -> "Departamento de Economía";
            case DEP_INGENIERIA -> "Departamento de Ingeniería"; 
            case DEP_ESTADISTICA_INFORMATICA_MATEMATICAS -> "Departamento de Estadística, Informática y Matemáticas";
            case DEP_AGRONOMIA_BIOTECNOLOGIA_ALIMENTACION -> "Departamento de Agronomia, Biotecnología y Alimentación"; 
       }; 
    }
    
}


