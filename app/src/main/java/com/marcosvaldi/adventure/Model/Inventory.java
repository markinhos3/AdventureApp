package com.marcosvaldi.adventure.Model;


import java.io.Serializable;
import java.util.LinkedList;

public class Inventory implements Serializable { //PARCELABLE: permite coger los datos en memoria y guardarlos en disco, más eficiente que SERIALIZABLE

    // me defino una LISTA "inventory" de TIPO ITEM
    private LinkedList<Item> inventory = new LinkedList<>(); // PRIVATE para que la lista no la vea el usuario

    //DEFAULT CONSTRUCTOR DE INVENTARIO
    public Inventory(){

    }

    // Método para IMPRIMIR EL INVENTARIO
    public String print(){

        String result = "";

        // declaro una VBLE llamada item que es de TIPO Item (el tipo me viene dado cuando he definido la LISTA de TIPO Item)
        for (Item item: inventory) { // para cada item pasar según lo que haya en el inventario

           result = result + item.getName() + "\n"; // ya hago uso de la vble item

        }

        return result;
    }

    // Método para AÑADIR Items
    public void add(Item item){

        this.inventory.add(item); // el this no tengo pq ponerlo
    }


}
