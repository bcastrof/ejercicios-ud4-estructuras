package com.company;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bcastrof on 08/03/2017.
 */
public class Alumno {

    private String nombre;
    private String apellido;
    private String email;


    //  private Set<Asignatura> asignaturas = new HashSet<>();
    private ArrayList<Asignatura> asignaturasList = new ArrayList<>();

    public Alumno() {
    }

    public Alumno(String nombre, String apellidos, String email) {
        this.nombre = nombre;
        this.apellido = apellidos;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellido;
    }

    public void setApellidos(String apellidos) {
        this.apellido = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void añadirAsignatura(Asignatura asignatura) {

        asignaturasList.add(asignatura);
        // asignatura.añdirAlumno(this);

    }

    public void borrarAsignatura(Asignatura as) {
        asignaturasList.remove(as);
    }

    public void borrarAs() {

        for (Asignatura as : asignaturasList) {
            as.listaAl(this);
        }
    }

    public int totalHoras() {
        int totalHoras = 0;

        for (Asignatura as : asignaturasList) {
            totalHoras += as.getHoraSemanales();
        }

        return totalHoras;
    }

    public void listaAs() {
        for (Asignatura a : asignaturasList) {
            System.out.println(a);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;

        if (nombre != null ? !nombre.equals(alumno.nombre.equalsIgnoreCase(nombre)) : alumno.nombre != null)
            return false;
        if (apellido != null ? !apellido.equals(alumno.apellido.equalsIgnoreCase(apellido)) : alumno.apellido != null)
            return false;
        return email != null ? email.equals(alumno.email.equalsIgnoreCase(email)) : alumno.email == null;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellido + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
