/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;


/**
 *
 * @author Miguel_Castillo
 */
public class ArbolReportes {

     private Reporte raiz;

    public ArbolReportes() {
        this.raiz = null;
    }
    public void vaciarArbol() {
        raiz = null; // Simplemente establecemos la raíz como nula
    }

    public void insertar(String ruc, String giroActividad, String areaEstablecimiento, String tipoLicencia) {
        Reporte nuevo = new Reporte(ruc, giroActividad, areaEstablecimiento, tipoLicencia);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            insertarRec(raiz, nuevo);
        }
    }

    private void insertarRec(Reporte actual, Reporte nuevo) {
        if (nuevo.ruc.compareTo(actual.ruc) < 0) {
            if (actual.izquierdo == null) {
                actual.izquierdo = nuevo;
            } else {
                insertarRec(actual.izquierdo, nuevo);
            }
        } else {
            if (actual.derecho == null) {
                actual.derecho = nuevo;
            } else {
                insertarRec(actual.derecho, nuevo);
            }
        }
    }

    public void imprimirEnOrden() {
        imprimirEnOrdenRec(raiz);
    }

    private void imprimirEnOrdenRec(Reporte actual) {
        if (actual != null) {
            imprimirEnOrdenRec(actual.izquierdo);
            System.out.println("RUC: " + actual.ruc + ", Giro de Actividad: " + actual.giroActividad +
                    ", Area de Establecimiento: " + actual.areaEstablecimiento +
                    ", Tipo de Licencia: " + actual.tipoLicencia);
            imprimirEnOrdenRec(actual.derecho);
        }
    }

    // Método para contar la cantidad de establecimientos
    public String contarEstablecimientos() {
        int cantidad = contarEstablecimientosRec(raiz);
        return "Cantidad de Establecimientos: " + cantidad;
    }


    private int contarEstablecimientosRec(Reporte actual) {
        if (actual == null) {
            return 0;
        }
        return 1 + contarEstablecimientosRec(actual.izquierdo) + contarEstablecimientosRec(actual.derecho);
    }

    // Método para contar la cantidad de giros de actividad únicos
     public String contarGiroActividad() {
        ArrayDinamico girosActividad = new ArrayDinamico();
        contarGiroActividadRecursion(raiz, girosActividad);
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < girosActividad.getSize(); i++) {
            String giro = girosActividad.getArray()[i];
            int cantidad = contarGiroActividadEspecifico(raiz, giro);
            result.append("Giro de Actividad: ").append(giro).append(", Cantidad: ").append(cantidad).append("\n");
        }
        return result.toString();
    }


    private void contarGiroActividadRecursion(Reporte actual, ArrayDinamico girosActividad) {
        if (actual != null) {
            if (!girosActividad.contains(actual.giroActividad)) {
                girosActividad.add(actual.giroActividad);
            }
            contarGiroActividadRecursion(actual.izquierdo, girosActividad);
            contarGiroActividadRecursion(actual.derecho, girosActividad);
        }
    }

    private int contarGiroActividadEspecifico(Reporte actual, String giroActividad) {
        if (actual == null) {
            return 0;
        }
        int count = giroActividad.equals(actual.giroActividad) ? 1 : 0;
        return count + contarGiroActividadEspecifico(actual.izquierdo, giroActividad) + contarGiroActividadEspecifico(actual.derecho, giroActividad);
    }

    // Método para contar la cantidad de tipo de licencia por parámetro
    public String contarTipoLicencia() {
        ArrayDinamico tiposLicencia = new ArrayDinamico();
        contarTipoLicenciaRecursion(raiz, tiposLicencia);
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tiposLicencia.getSize(); i++) {
            String tipo = tiposLicencia.getArray()[i];
            int cantidad = contarTipoLicenciaEspecifico(raiz, tipo);
            result.append("Tipo de Licencia: ").append(tipo).append(", Cantidad: ").append(cantidad).append("\n");
        }
        return result.toString();
    }

    private void contarTipoLicenciaRecursion(Reporte actual, ArrayDinamico tiposLicencia) {
        if (actual != null) {
            if (!tiposLicencia.contains(actual.tipoLicencia)) {
                tiposLicencia.add(actual.tipoLicencia);
            }
            contarTipoLicenciaRecursion(actual.izquierdo, tiposLicencia);
            contarTipoLicenciaRecursion(actual.derecho, tiposLicencia);
        }
    }

    private int contarTipoLicenciaEspecifico(Reporte actual, String tipoLicencia) {
        if (actual == null) {
            return 0;
        }
        int count = tipoLicencia.equals(actual.tipoLicencia) ? 1 : 0;
        return count + contarTipoLicenciaEspecifico(actual.izquierdo, tipoLicencia) + contarTipoLicenciaEspecifico(actual.derecho, tipoLicencia);
    }

}
