package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bcastrof on 08/03/2017.
 */
public class Asignatura {

    private String nombre;
    private int horaSemanales;

    //private Set<Alumno> alumnos = new HashSet<>();
    private List<Alumno> alumnosList = new ArrayList<>();

    public Asignatura() {
    }

    public Asignatura(String nombre, int horaSemanales) {
        this.nombre = nombre;
        this.horaSemanales = horaSemanales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoraSemanales() {
        return horaSemanales;
    }

    public void setHoraSemanales(int horaSemanales) {
        this.horaSemanales = horaSemanales;
    }

    public void añdirAlumno(Alumno alumno) {

        alumnosList.add(alumno);
        alumno.añadirAsignatura(this);

    }

    public void borrarAlumnoa() {
        for (Alumno a : alumnosList) {
            a.borrarAsignatura(this);
        }
    }

    public void listaAl(Alumno al) {
        alumnosList.remove(al);
    }


    public void lista() {
        for (Alumno a : alumnosList) {
            System.out.println(a);
        }
    }


    @Override
    public String toString() {
        return "Asignatura{" +
                "nombre='" + nombre + '\'' +

                ", horaSemanales=" + horaSemanales +
                '}';
    }
}
