package com.marcosvaldi.adventure.Model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory implements Serializable { //PARCELABLE: permite coger los datos en memoria y guardarlos en disco, más eficiente que SERIALIZABLE

    // me defino una LISTA "inventory" de TIPO ITEM
    private LinkedList<Item> inventory = new LinkedList<>(); // PRIVATE para que la lista no la vea el usuario

    //DEFAULT CONSTRUCTOR DE INVENTARIO
    public Inventory(){

    }

    // Me creo una LISTA DE STRINGS:
    public List<String> getItemNames (){
        List<String> names = new ArrayList<>();

        //nombres de los elementos que están en mi inventario usando el __for mejorado__ :
        for (Item item: inventory){

            names.add(item.getName());
        }

        return names;
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


    public Item getItem(int itemPosition) {

        return inventory.get(itemPosition);
    }

    public void deleteItem(int itemPosition) {

        inventory.remove(itemPosition);
    }
}
