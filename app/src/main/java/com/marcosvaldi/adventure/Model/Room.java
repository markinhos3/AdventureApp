package com.marcosvaldi.adventure.Model;


import java.util.LinkedList;

public class Room {

    //toda room va a tener una DESCRIPCIÓN
    //VBLE DE INSTANCIA
    private String description;

    // LISTA de ITEMS
    private LinkedList<Item> items;
    // en un OBJETO PUEDO TENER REFERENCIAS A OBJETOS DE SU MISMA CLASE
    // cada ROOM va a tener la posibilidad de moverse a otras 4 rooms según las direcciones N,S,E,W

    // VBLES DE INSTANCIA
    private Room roomNorth;
    private Room roomSouth;
    private Room roomEast;
    private Room roomWest;

    //MÉTODO PARA COGER LA LISTA E IMPRIMIRLA EN UN STRING
    public String getRoomItems(){

        if (this.items == null){
            return "";
        }

        String result = "";
        for(Item item: this.items){ // recorre y va sacando un item distinto de tipo Item (es un LinkedList<Item> )
            result = result + item.getName() + "\n";
        }
        return result;
    }

    //como son PRIVATE necesitamos los Métodos GETTERS y SETTERS
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // LAZY GETTER: llamo a la lista de items y si no está construido lo hace en ese momento
    public LinkedList<Item> getItems() {

        if (items == null){
            items = new LinkedList<>();
        }

        return items;
    }

    public void setItems(LinkedList<Item> items) {
        this.items = items;
    }

    public Room getRoomNorth() {
        return roomNorth;
    }

    public void setRoomNorth(Room roomNorth) {
        this.roomNorth = roomNorth;
    }

    public Room getRoomSouth() {
        return roomSouth;
    }

    public void setRoomSouth(Room roomSouth) {
        this.roomSouth = roomSouth;
    }

    public Room getRoomEast() {
        return roomEast;
    }

    public void setRoomEast(Room roomEast) {
        this.roomEast = roomEast;
    }

    public Room getRoomWest() {
        return roomWest;
    }

    public void setRoomWest(Room roomWest) {
        this.roomWest = roomWest;
    }



}
