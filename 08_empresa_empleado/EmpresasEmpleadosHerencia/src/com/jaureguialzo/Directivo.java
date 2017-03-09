package com.jaureguialzo;

/**
 * Created by widemos on 9/3/17.
 */
public class Directivo extends Empleado {

    private double salarioAnual;
    private double bonusPersonal;

    public Directivo(String nombre, String apellidos, String fechaNacimiento, String fechaContrato, double salarioAnual, double bonusPersonal) {
        super(nombre, apellidos, fechaNacimiento, fechaContrato);
        this.salarioAnual = salarioAnual;
        this.bonusPersonal = bonusPersonal;
    }

    public double getSalarioAnual() {
        return salarioAnual;
    }

    public void setSalarioAnual(double salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    public double getBonusPersonal() {
        return bonusPersonal;
    }

    public void setBonusPersonal(double bonusPersonal) {
        this.bonusPersonal = bonusPersonal;
    }

    @Override
    public String toString() {
        return "Directivo{" +
                "nombre='" + this.getNombre() + '\'' +
                ", apellidos='" + this.getApellidos() + '\'' +
                ", fechaNacimiento='" + this.getFechaNacimiento() + '\'' +
                ", fechaContrato='" + this.getFechaContrato() + '\'' +
                ", salarioAnual=" + salarioAnual +
                ", bonusPersonal=" + bonusPersonal +
                '}';
    }
}
