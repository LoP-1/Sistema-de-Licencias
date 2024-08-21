/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Stack;
import javax.swing.table.DefaultTableModel;

public class ArbolBinario {

    public Nodo raiz;

    // Constructor vacío
    public ArbolBinario() {
        raiz = null;
    }

    // Método para insertar un nuevo nodo en el árbol (por ID y datos adicionales)
    public void insertar(int ID, String ruc, String giroActividad, String areaEstablecimiento, String tipoLicencia) {
        raiz = insertarRec(raiz, ID, ruc, giroActividad, areaEstablecimiento, tipoLicencia);
    }

    // Función recursiva para insertar un nodo
    public Nodo insertarRec(Nodo raiz, int ID, String ruc, String giroActividad, String areaEstablecimiento, String tipoLicencia) {
        // Si el árbol está vacío, se crea un nuevo nodo
        if (raiz == null) {
            raiz = new Nodo(ID, ruc, giroActividad, areaEstablecimiento, tipoLicencia);
            return raiz;
        }

        // De lo contrario, se recorre el árbol para encontrar la posición adecuada
        if (ID < raiz.ID) {
            raiz.izquierdo = insertarRec(raiz.izquierdo, ID, ruc, giroActividad, areaEstablecimiento, tipoLicencia);
        } else if (ID > raiz.ID) {
            raiz.derecho = insertarRec(raiz.derecho, ID, ruc, giroActividad, areaEstablecimiento, tipoLicencia);
        }

        // Se retorna el nodo raíz modificado
        return raiz;
    }

    // Método para recorrer el árbol en orden (in-order traversal)
    public void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.println("ID: " + nodo.ID
                    + ", RUC: " + nodo.ruc
                    + ", Giro de Actividad: " + nodo.giroActividad
                    + ", Área de Establecimiento: " + nodo.areaEstablecimiento
                    + ", Tipo de Licencia: " + nodo.tipoLicencia);
            inOrden(nodo.derecho);
        }
    }

    // Método para buscar nodos que coincidan con los valores dados
    public Nodo[] buscar(int ID, String ruc, String giroActividad, String areaEstablecimiento, String tipoLicencia) {
    DynamicArray resultados = new DynamicArray();
    buscarIterativo(ID, ruc, giroActividad, areaEstablecimiento, tipoLicencia, resultados);
    return resultados.getArray();
}

    // Función recursiva para buscar nodos que coincidan con los valores dados (parcialmente)
    public void buscarRec(Nodo nodo, int ID, String ruc, String giroActividad, String areaEstablecimiento, String tipoLicencia, DynamicArray resultados) {
        if (nodo != null) {
            if ((ID == -1 || nodo.ID == ID)
                    && (ruc == null || nodo.ruc.contains(ruc))
                    && (giroActividad == null || nodo.giroActividad.contains(giroActividad))
                    && (areaEstablecimiento == null || nodo.areaEstablecimiento.contains(areaEstablecimiento))
                    && (tipoLicencia == null || nodo.tipoLicencia.contains(tipoLicencia))) {
                resultados.add(nodo);
            }
            buscarRec(nodo.izquierdo, ID, ruc, giroActividad, areaEstablecimiento, tipoLicencia, resultados);
            buscarRec(nodo.derecho, ID, ruc, giroActividad, areaEstablecimiento, tipoLicencia, resultados);
        }
    }

    public void eliminar(int ID) {
        raiz = eliminarRec(raiz, ID);
    }

    // Función recursiva para eliminar un nodo
    Nodo eliminarRec(Nodo raiz, int ID) {
        // Si el árbol está vacío
        if (raiz == null) {
            return raiz;
        }

        // Recorrer el árbol
        if (ID < raiz.ID) {
            raiz.izquierdo = eliminarRec(raiz.izquierdo, ID);
        } else if (ID > raiz.ID) {
            raiz.derecho = eliminarRec(raiz.derecho, ID);
        } else {
            // Nodo encontrado
            // Nodo con solo un hijo o sin hijos
            if (raiz.izquierdo == null) {
                return raiz.derecho;
            } else if (raiz.derecho == null) {
                return raiz.izquierdo;
            }

            raiz.ID = minValor(raiz.derecho);

            // Eliminar el sucesor in-order
            raiz.derecho = eliminarRec(raiz.derecho, raiz.ID);
        }

        return raiz;
    }

    // Función para encontrar el valor mínimo en un árbol
    int minValor(Nodo raiz) {
        int minv = raiz.ID;
        while (raiz.izquierdo != null) {
            minv = raiz.izquierdo.ID;
            raiz = raiz.izquierdo;
        }
        return minv;
    }

    // Método para llenar la tabla de manera iterativa
    public void llenarTabla(DefaultTableModel dataModel) {
        if (raiz == null) {
            return;
        }

        Stack<Nodo> stack = new Stack<>();
        Nodo current = raiz;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.izquierdo;
            }

            current = stack.pop();
            dataModel.addRow(new Object[]{current.ID, current.ruc, current.giroActividad, current.areaEstablecimiento, current.tipoLicencia});
            current = current.derecho;
        }
    }
    
    public void buscarIterativo(int ID, String ruc, String giroActividad, String areaEstablecimiento, String tipoLicencia, DynamicArray resultados) {
    if (raiz == null) {
        return;
    }

    Stack<Nodo> stack = new Stack<>();
    stack.push(raiz);

    while (!stack.isEmpty()) {
        Nodo nodo = stack.pop();

        if ((ID == -1 || nodo.ID == ID)
                && (ruc == null || nodo.ruc.contains(ruc))
                && (giroActividad == null || nodo.giroActividad.contains(giroActividad))
                && (areaEstablecimiento == null || nodo.areaEstablecimiento.contains(areaEstablecimiento))
                && (tipoLicencia == null || nodo.tipoLicencia.contains(tipoLicencia))) {
            resultados.add(nodo);
        }

        if (nodo.derecho != null) {
            stack.push(nodo.derecho);
        }

        if (nodo.izquierdo != null) {
            stack.push(nodo.izquierdo);
        }
    }
}
    
    
}
