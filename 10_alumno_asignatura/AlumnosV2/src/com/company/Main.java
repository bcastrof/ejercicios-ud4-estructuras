package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Alumno> alumnos = new HashSet<>();
        List<Alumno> alumnosList = new ArrayList<>();

        Set<Asignatura> asignaturas = new HashSet<>();
        List<Asignatura> asignaturaList = new ArrayList<>();

        //variable de control de bucle
        int opcion;

        do {

            System.out.print("1) Alumnos\n" +
                    "Crear nuevo alumno.\n" +
                    "Borrar alumno.\n" +
                    "2) Asignaturas\n" +
                    "Crear nueva asignatura.\n" +
                    "Borrar asignatura.\n" +
                    "3) Matrícula\n" +
                    "Matricular alumno en asignatura.\n" +
                    "Listado de alumnos matriculados en una asignatura.\n" +
                    "Listado de asignaturas en las que está matriculado un alumno.\n" +
                    "Listado de todos los alumnos del centro y total de horas en las que están matriculados.\n" +
                    "4) Salir\n" +
                    "Teclee opcion: ");
            opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1: {

                    System.out.print("1) Crear nuevo alumno.\n" +
                            "2) Borrar alumno.\n" +
                            "Teclee opcion: ");
                    opcion = Integer.parseInt(br.readLine());

                    switch (opcion) {
                        case 1: {

                            System.out.print("Nombre del Alumno: ");
                            String nombre = br.readLine();
                            nombre = nombre.toUpperCase();
                            System.out.print("Apellido del Alumno: ");
                            String apellido = br.readLine();
                            apellido = apellido.toUpperCase();
                            System.out.print("Email del Alumno: ");
                            String email = br.readLine();
                            email = email.toUpperCase();

                            Alumno alumno = new Alumno(nombre, apellido, email);
                            if (alumnos.add(alumno) == true) {
                                alumnosList.add(alumno);
                            }
                        }
                        break;

                        case 2: {
                            for (int i = 0; i < alumnosList.size(); i++) {
                                System.out.println((i + 1) + "" + alumnosList.get(i));
                            }
                            System.out.print("selecciona el alumno: ");
                            int alumnoSeleccionado = Integer.parseInt(br.readLine()) - 1;
                            Alumno a = alumnosList.get(alumnoSeleccionado);
                            a.borrarAs();
                            alumnosList.remove(a);
                            alumnos.remove(a);
                        }
                        break;
                    }
                }
                break;

                case 2: {
                    System.out.print("1) Crear nueva asignatura.\n" +
                            "2) Borrar asignatura.\n" +
                            "Teclee opcion: ");
                    opcion = Integer.parseInt(br.readLine());

                    switch (opcion) {
                        case 1: {

                            System.out.print("Nombre de la Asignatura: ");
                            String nombre = br.readLine();
                            nombre = nombre.toUpperCase();
                            System.out.print("Horas semanales de la Asignatura: ");
                            int horaSemanales = Integer.parseInt(br.readLine());

                            Asignatura asignatura = new Asignatura(nombre, horaSemanales);
                            if (asignaturas.add(asignatura) == true) {
                                asignaturaList.add(asignatura);
                            }
                        }
                        break;

                        case 2: {

                            for (int i = 0; i < asignaturaList.size(); i++) {
                                System.out.println((i + 1) + "" + asignaturaList.get(i));
                            }
                            System.out.print("selecciona la asignatura: ");
                            int asignaturaSeleccionada = Integer.parseInt(br.readLine()) - 1;
                            Asignatura as = asignaturaList.get(asignaturaSeleccionada);
                            as.borrarAlumnoa();
                            asignaturaList.remove(as);
                            asignaturas.remove(as);
                        }
                        break;
                    }
                }
                break;

                case 3: {

                    System.out.print("1) Matricular alumno en asignatura.\n" +
                            "2) Listado de alumnos matriculados en una asignatura.\n" +
                            "3) Listado de asignaturas en las que está matriculado un alumno.\n" +
                            "4) Listado de todos los alumnos del centro y total de horas en las que están matriculados.\n" +
                            "Teclee opcion: ");
                    opcion = Integer.parseInt(br.readLine());

                    switch (opcion) {
                        case 1: {

                            for (int i = 0; i < alumnosList.size(); i++) {
                                System.out.println((i + 1) + "" + alumnosList.get(i));
                            }
                            System.out.print("selecciona el alumno: ");
                            int alumnoSeleccionado = Integer.parseInt(br.readLine()) - 1;

                            for (int i = 0; i < asignaturaList.size(); i++) {
                                System.out.println((i + 1) + " " + asignaturaList.get(i));
                            }
                            System.out.print("Elige asignatura: ");
                            int asignaturaSeleccionada = Integer.parseInt(br.readLine()) - 1;
                            Alumno a = alumnosList.get(alumnoSeleccionado);
                            asignaturaList.get(asignaturaSeleccionada).añdirAlumno(a);

                        }
                        break;

                        case 2: {

                            for (int i = 0; i < asignaturaList.size(); i++) {
                                System.out.println((i + 1) + "" + asignaturaList.get(i));
                            }
                            System.out.print("selecciona la asignatura: ");
                            int asignaturaSeleccionada = Integer.parseInt(br.readLine()) - 1;
                            Asignatura as = asignaturaList.get(asignaturaSeleccionada);
                            as.lista();
                        }
                        break;

                        case 3: {

                            for (int i = 0; i < alumnosList.size(); i++) {
                                System.out.println((i + 1) + " " + alumnosList.get(i));
                            }
                            System.out.print("elige el alumno: ");
                            int alumnoSeleccionado = Integer.parseInt(br.readLine());
                            Alumno al = alumnosList.get(alumnoSeleccionado);
                            al.listaAs();
                        }
                        break;
                        case 4: {

                            for (Alumno a : alumnosList) {
                                System.out.println(a + " " + a.totalHoras());
                            }
                        }
                        break;
                    }
                }
                break;
            }
            System.out.println();
        } while (opcion != 4);
    }
}
