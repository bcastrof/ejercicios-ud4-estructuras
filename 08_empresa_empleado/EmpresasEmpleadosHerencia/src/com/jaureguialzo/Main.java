package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static List<Empresa> empresas = new ArrayList<>();
    private static List<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int opcion = 0;
        do {
            System.out.println("Empresa\n" +
                    "1. Crear nueva empresa\n" +
                    "2. Borrar una empresa\n" +
                    "Añadir empleados (a una empresa)\n" +
                    "3. Añadir operario\n" +
                    "4. Añadir directivo\n" +
                    "5. Listar empleados (de la empresa)\n" +
                    "Listados\n" +
                    "6. Todas las empresas\n" +
                    "7. Todos los empleados\n" +
                    "8. Listado por empresa y empleado\n" +
                    "9. Salir\n");

            System.out.print("Opción: ");
            try {
                opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1: {
                        // Crear nueva empresa

                        System.out.print("Nombre: ");
                        String nombre = br.readLine();

                        System.out.print("Año de fundación: ");
                        String anyo = br.readLine();

                        empresas.add(new Empresa(nombre, anyo));
                    }
                    break;
                    case 2: {
                        // Borrar una empresa

                        if (empresas.size() > 0) {

                            // Seleccionar empresa
                            int seleccion = seleccionarEmpresa();

                            if (seleccion >= 0) {
                                empresas.get(seleccion).despedirATodoElMundo();
                                empresas.remove(seleccion);
                                System.out.println("INFO: Empresa borrada");
                            } else {
                                System.out.println("ERROR: La empresa seleccionada no existe...");
                            }
                        } else {
                            System.out.println("ERROR: No hay empresas...");
                        }
                    }
                    break;
                    case 3: {
                        // Añadir operario
                        if (empresas.size() > 0) {

                            // Seleccionar empresa
                            int seleccion = seleccionarEmpresa();

                            if (seleccion >= 0) {

                                System.out.print("Nombre: ");
                                String nombre = br.readLine();
                                System.out.print("Apellidos: ");
                                String apellidos = br.readLine();
                                System.out.print("Fecha de nacimiento: ");
                                String fechaNac = br.readLine();
                                System.out.print("Fecha de contrato: ");
                                String fechaCont = br.readLine();

                                System.out.print("Salario/hora: ");
                                double salarioHora = Double.parseDouble(br.readLine());
                                System.out.print("Horas de contrato: ");
                                int horas = Integer.parseInt(br.readLine());

                                empresas.get(seleccion).añadirEmpleado(new Operario(nombre, apellidos, fechaNac, fechaCont, salarioHora, horas));

                            } else {
                                System.out.println("ERROR: La empresa seleccionada no existe...");
                            }
                        } else {
                            System.out.println("ERROR: No hay empresas...");
                        }
                    }
                    break;
                    case 4: {
                        // Añadir directivo
                        if (empresas.size() > 0) {

                            // Seleccionar empresa
                            int seleccion = seleccionarEmpresa();

                            if (seleccion >= 0) {

                                System.out.print("Nombre: ");
                                String nombre = br.readLine();
                                System.out.print("Apellidos: ");
                                String apellidos = br.readLine();
                                System.out.print("Fecha de nacimiento: ");
                                String fechaNac = br.readLine();
                                System.out.print("Fecha de contrato: ");
                                String fechaCont = br.readLine();

                                System.out.print("Salario anual: ");
                                double salarioAnual = Double.parseDouble(br.readLine());
                                System.out.print("Bonus personal: ");
                                double bonus = Double.parseDouble(br.readLine());

                                empresas.get(seleccion).añadirEmpleado(new Directivo(nombre, apellidos, fechaNac, fechaCont, salarioAnual, bonus));

                            } else {
                                System.out.println("ERROR: La empresa seleccionada no existe...");
                            }
                        } else {
                            System.out.println("ERROR: No hay empresas...");
                        }
                    }
                    break;
                    case 5: {
                        // Listar empleados (de la empresa)
                        if (empresas.size() > 0) {

                            // Seleccionar empresa
                            int seleccion = seleccionarEmpresa();

                            if (seleccion >= 0) {

                                empresas.get(seleccion).listarEmpleados();

                            } else {
                                System.out.println("ERROR: La empresa seleccionada no existe...");
                            }
                        } else {
                            System.out.println("ERROR: No hay empresas...");
                        }
                    }
                    break;
                    case 6: {
                        // Todas las empresas
                        for (Empresa e : empresas) {
                            System.out.println(e);
                        }
                    }
                    break;
                    case 7: {
                        // Todos los empleados
                    }
                    break;
                    case 8: {
                        // Listado por empresa y empleado
                        for (Empresa e : empresas) {
                            System.out.println(e);
                            e.listarEmpleados();
                        }
                    }
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("ERROR: Escribe un número...");
            }

        } while (opcion != 9);

    }

    public static int seleccionarEmpresa() {

        int seleccion = -1;

        for (int i = 0; i < empresas.size(); i++) {
            System.out.println((i + 1) + ": " + empresas.get(i));
        }

        System.out.println("Elige empresa: ");
        try {
            seleccion = Integer.parseInt(br.readLine()) - 1;
        } catch (NumberFormatException e) {
        } catch (IOException e) {
        }

        return seleccion;
    }
}
