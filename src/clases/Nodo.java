/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class Nodo {
    public int ID;
    public String ruc;
    public String giroActividad;
    public String areaEstablecimiento;
    public String tipoLicencia;
    public Nodo izquierdo;
    public Nodo derecho;

    public Nodo(int ID, String ruc, String giroActividad, String areaEstablecimiento, String tipoLicencia) {
        this.ID = ID;
        this.ruc = ruc;
        this.giroActividad = giroActividad;
        this.areaEstablecimiento = areaEstablecimiento;
        this.tipoLicencia = tipoLicencia;
        izquierdo = derecho = null;
    }
    
    @Override
    public String toString() {
        return "Nodo{" +
                "ID=" + ID +
                ", ruc='" + ruc + '\'' +
                ", giroActividad='" + giroActividad + '\'' +
                ", areaEstablecimiento='" + areaEstablecimiento + '\'' +
                ", tipoLicencia='" + tipoLicencia + '\'' +
                '}';
    }
    
}
