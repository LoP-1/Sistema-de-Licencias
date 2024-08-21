/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Miguel_Castillo
 */
public class ArrayDinamico {
    private String[] array;
    private int size;

    public ArrayDinamico() {
        array = new String[10]; // tamaño inicial
        size = 0;
    }

    public void add(String value) {
        if (size == array.length) {
            // aumentar el tamaño del array
            String[] newArray = new String[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = value;
    }

    public String[] getArray() {
        String[] result = new String[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }

    public int getSize() {
        return size;
    }

    public boolean contains(String value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }
}
