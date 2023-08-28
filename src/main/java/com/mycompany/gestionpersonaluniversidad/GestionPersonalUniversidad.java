/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.gestionpersonaluniversidad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Iñigo
 */
public class GestionPersonalUniversidad {

    public static ArrayList<Profesor> listadoProfesores = new ArrayList<>();
    public static ArrayList<Conserje> listadoRestoPersonal = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("---------------------------------------- REGISTRANDO PERSONAL --------------------------------------------");

        Profesor profesorA = new Profesor("amanda Tolosa Viñas", "Amanda.tol.24", DepartamentoEnum.DEP_ECONOMIA, 24);
        Profesor profesorB = new ProfesorAsociado("Susanita Alemán Coll", "Susanita.ale.52", DepartamentoEnum.DEP_ECONOMIA, 52, "Macroeconomia II", 6);
        Conserje conserjeA = new Conserje("Luis", "Sanz Garcia", 5, "Departamento Economia");

        Profesor profesorC = new Profesor("Otilia Aller Rovira", "Otilia.all.94", DepartamentoEnum.DEP_ESTADISTICA_INFORMATICA_MATEMATICAS, 94);
        Profesor profesorD = new ProfesorTitular("África Solsona Marquez", "Africa.sol.98", DepartamentoEnum.DEP_ESTADISTICA_INFORMATICA_MATEMATICAS, 98, 2010, "Algoritmos Genéticos", 30);
        Conserje conserjeB = new Conserje("Alicia", "Perez Ruiz", 2, "Departamento EIM");

        Profesor profesorE = new Profesor("Florinda Pujadas Checa", "Florinda.puj.154", DepartamentoEnum.DEP_AGRONOMIA_BIOTECNOLOGIA_ALIMENTACION, 154);
        Profesor profesorF = new Profesor("Joaquina Lago Gonzalez", "Joaquina.lag.178", DepartamentoEnum.DEP_AGRONOMIA_BIOTECNOLOGIA_ALIMENTACION, 178);
        Profesor profesorG = new ProfesorAsociado("Salomón Uribe Comas", "Salomon.uri.2", DepartamentoEnum.DEP_AGRONOMIA_BIOTECNOLOGIA_ALIMENTACION, 2, "Programación Orientada a Objetos", 3);
        Conserje conserjeC = new Conserje("Lola", "Sánchez Ochoa", 12, "Departamento ABA");

        Profesor profesorH = new ProfesorTitular("Inmaculada Montaña Huguet", "Inmaculada.mon.97", DepartamentoEnum.DEP_INGENIERIA, 97, 2007, "Ingenieria de Materiales", 40);
        Profesor profesorI = new ProfesorTitular("Antonio Jara Iñiguez", "Antonio.jar.99", DepartamentoEnum.DEP_INGENIERIA, 99, 2016, "Ingenieria de Materiales", 20);
        Profesor profesorJ = new Profesor("Claudia Delgado Cantero", "Claudia.del.450", DepartamentoEnum.DEP_INGENIERIA, 45);

        Conserje conserjeD = new Conserje("Pedro", "Martinez Ronda", 4, "Biblioteca");

        listadoProfesores.add(profesorA);
        listadoProfesores.add(profesorB);
        listadoProfesores.add(profesorC);
        listadoProfesores.add(profesorD);
        listadoProfesores.add(profesorE);
        listadoProfesores.add(profesorF);
        listadoProfesores.add(profesorG);
        listadoProfesores.add(profesorH);
        listadoProfesores.add(profesorI);
        listadoProfesores.add(profesorJ);
        System.out.println("\nEl número total de Profesores es de " + listadoProfesores.size() + ".");
        for (Profesor profesor : listadoProfesores) {
            System.out.println(profesor);
        }
        System.out.println();
        listadoRestoPersonal.add(conserjeA);
        listadoRestoPersonal.add(conserjeB);
        listadoRestoPersonal.add(conserjeC);
        listadoRestoPersonal.add(conserjeD);
        System.out.println("El número total de Conserjes es de " + listadoRestoPersonal.size() + ".");
        for (Conserje conserje : listadoRestoPersonal) {
            System.out.println(conserje);
        }
        System.out.println();
        System.out.println("-------------------------------------- REGISTRO DE NUEVOS PROFESORES TITULARES DESDE FICHERO -------------------------------------------");
        System.out.println();
        String registroNuevosProfesoresTitulares = "listadoNuevosProfesoresTitulares2023.txt";
        registraProfesoresTitularesDesdeFichero(registroNuevosProfesoresTitulares);
        System.out.println("\nDespués de registrar los nuevos ProfesorTitular, el número total de Profesores es de " + listadoProfesores.size());
        System.out.println();
        System.out.println("---------------------------------------- VALIDANDO IDENTIFICADORES DE PROFESORES --------------------------------------------");
        System.out.println();
        ValidacionIdentificador validadorDeIdentificadores = new ValidacionIdentificador();
        for (Profesor profesor : listadoProfesores) {
            System.out.println("[" + validadorDeIdentificadores.validate(profesor.getIdentificador()) + "]¿El profesor " + profesor.getNombreCompleto() + " con identificador " + profesor.getIdentificador() + " cuenta con un identificador válido?");
        }
        System.out.println();
        System.out.println("---------------------------------------- VALIDANDO DESPACHOS ASIGNADOS --------------------------------------------");
        System.out.println();
        for (Profesor profesor : listadoProfesores) {
            if (profesor.getNumeroDespacho() != profesor.obtieneDespachoDeIdentificador()) {
                System.out.println("[NO] El profesor/a " + profesor.getNombreCompleto() + " NO tiene correctamente asignado el despacho " + profesor.getNumeroDespacho() + ".");
            } else {
                System.out.println("[SI] El profesor/a " + profesor.getNombreCompleto() + " tiene correctamente asignado el despacho " + profesor.getNumeroDespacho() + ".");
            }
        }
        System.out.println();
        System.out.println("-------------------------------------- CALCULO DEL NUMERO DE HORAS DE DOCENCIA -------------------------------------------");
        System.out.println();
        muestraNumeroHorasDocencia();
        System.out.println();
    }

    /**
     * Este método lee la información del archivo nombreArchivo y para cada linea
     * que tiene el archivo, registra un nuevo ProfesorTitular en el listadoProfesores.
     * 
     * Recuerde que, para cada linea que lea del archivo, puede usar el método split() 
     * para obtener la información separada en partes. Cada linea tiene la siguiente forma:
     * 
     *      Iñigo Sanchez-Inigo.san.23-DEP_ECONOMIA-23-2023-Microeconomia-15
     * 
     * Este método informa por consola del nombre completo del nuevo ProfesorTitular 
     * cuando este ha sido registrado.
     * 
     */
    private static void registraProfesoresTitularesDesdeFichero(String nombreArchivo) {
        File file=new File(nombreArchivo);
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String linea=br.readLine();
            while (linea!=null){
                String[] lineaSep = linea.split("-");
                DepartamentoEnum aux;
                if (lineaSep[2].equals(String.valueOf(DepartamentoEnum.DEP_AGRONOMIA_BIOTECNOLOGIA_ALIMENTACION))){
                    aux = DepartamentoEnum.DEP_AGRONOMIA_BIOTECNOLOGIA_ALIMENTACION;
                }
                else if (lineaSep[2].equals(String.valueOf(DepartamentoEnum.DEP_ECONOMIA))){
                    aux = DepartamentoEnum.DEP_ECONOMIA;
                }
                else if (lineaSep[2].equals(String.valueOf(DepartamentoEnum.DEP_ESTADISTICA_INFORMATICA_MATEMATICAS))){
                    aux = DepartamentoEnum.DEP_ESTADISTICA_INFORMATICA_MATEMATICAS;
                }
                else{
                    aux = DepartamentoEnum.DEP_INGENIERIA;
                }
                ProfesorTitular profe = new ProfesorTitular(lineaSep[0],lineaSep[1],
                        aux,Integer.parseInt(lineaSep[3]),Integer.parseInt(lineaSep[4]),
                        lineaSep[5],Integer.parseInt(lineaSep[6]));
                System.out.println("Se registra desde archivo el ProfesorTitular: "+lineaSep[0]);
                listadoProfesores.add(profe);
                linea=br.readLine();
            }
        }
        catch (IOException e){
            System.out.println("No se ha podido leer del fichero");
        }
    }

    /**
     * Este método itera por todo el listadoProfesores y para cada profesor
     * muestra por pantalla, por ejemplo, lo siguiente:
     *
     * - Profesor/a: Amanda Tolosa Viñas - Departamento: Departamento de
     * Economía - Horas docencia: 30 horas.
     *
     * El detalle del ejemplo dado es el siguiente: [Amanda Tolosa Viñas] es el
     * nombre completo del profesor/a. [Departamento de Economía] es el nombre
     * del departamento al que pertenece. [30] es el resultado de ejecutar el
     * método getHorasDocencia().
     *
     */
    private static void muestraNumeroHorasDocencia() {
        for (Profesor prof:listadoProfesores){
            System.out.println("- Profesor/a: "+prof.getNombreCompleto()+" - Departamento: "
            +prof.getDpto().getNombreDepartamento()+" - Horas docencia: "
            +prof.getHorasDocencia()+" horas.");
        }
    }
}
