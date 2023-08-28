/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionpersonaluniversidad;

import java.util.regex.Pattern;

/**
 *
 * @author Vera Murillo
 */
public class ValidacionIdentificador {
    private static final String pat="^[A-Z]{1}[a-z]{0,14}.[a-z]{3}.(\\d){1,3}$";
    private final Pattern pattern;
    public ValidacionIdentificador(){
        pattern=Pattern.compile(pat);
    }
    public boolean validate(String codigo){
        return pattern.matcher(codigo).matches();
        }
}
