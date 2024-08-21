/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Miguel_Castillo
 */
public class Reporte {

    String ruc;
    String giroActividad;
    String areaEstablecimiento;
    String tipoLicencia;
    Reporte izquierdo;
    Reporte derecho;

    public Reporte(String ruc, String giroActividad, String areaEstablecimiento, String tipoLicencia) {
        this.ruc = ruc;
        this.giroActividad = giroActividad;
        this.areaEstablecimiento = areaEstablecimiento;
        this.tipoLicencia = tipoLicencia;
        this.izquierdo = null;
        this.derecho = null;
    }

}
