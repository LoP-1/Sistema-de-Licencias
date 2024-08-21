/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Miguel_Castillo
 */
class DynamicArray {
    private Nodo[] array;
    private int size;

    public DynamicArray() {
        array = new Nodo[10]; // tamaño inicial
        size = 0;
    }

    public void add(Nodo nodo) {
        if (size == array.length) {
            // aumentar el tamaño del array
            Nodo[] newArray = new Nodo[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = nodo;
    }

    public Nodo[] getArray() {
        Nodo[] result = new Nodo[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }

    public int getSize() {
        return size;
    }
    
}
