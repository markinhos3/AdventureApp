package com.marcosvaldi.adventure.Model;

// AQUÍ GENERAREMOS EL MAPA CON TODAS LAS HABITACIONES

import java.util.LinkedList;

public class MapGenerator {

    // para que me detecte que estoy en la habitación inicial -> al final establezco al final del código de la clase MapGenerator cuál va a ser mi room inicial
    public static Room initialRoom;

    // Método
    public static void generate(){
        // Me creo la 1ª room
        Room room1 = new Room();
        // Descripción - con la función de la librería set
        room1.setDescription("\n\t\t ☣ ROOM 1 ☣\t Te encuentras en un edificio con aspecto de abandono duradero y sensación de que alguna catástrofe ha sucedido . . .");

        Room room2 = new Room();
        room2.setDescription("\n\t\t ☣ ROOM 2 ☣\t En ese momento escuchas varios cuervos merodeando los alrededores y decides adentrárte sin mirar atrás");

        Room room3 = new Room();
        room3.setDescription("\n\t\t ☣ ROOM 3 ☣\t De repente encuentras lo que menos podías imaginar dentro de un edificio cultural, un bar incrustado entre aulas con cortinas polvorientas y un camarero de otra época");

        Room room4 = new Room();
        room4.setDescription("\n\t\t ☣ ROOM 4 ☣\t Suena el móvil y en la pantalla sólo aparece número desconocido . . .");

        // ENLAZO LAS ROOMS (link)
        room1.setRoomSouth(room2);
        room2.setRoomNorth(room1);

        room2.setRoomEast(room3);
        room3.setRoomWest(room2);

        room1.setRoomEast(room4);
        room4.setRoomWest(room1);

        room3.setRoomNorth(room4);
        room4.setRoomSouth(room3);


        // me creo una LISTA DE ITEMS para la ROOM 3
        LinkedList<Item> itemsRoom3 = new LinkedList<>();
        // AÑADO items
        itemsRoom3.add(new Item("Botella","Botella de Moskovskaya")); // paso A LA LISTA itemsRoom3 un NUEVO OBJETO DE TIPO ITEM: sería como poner -> Item item = new Item("","",..); itemsRoom3.add(item); pero sin pasarle el objeto item pq ya lo hace directamente
        itemsRoom3.add(new Item("Cuchillo","Cuchillo Jamonero"));
        itemsRoom3.add(new Item("Billete 500 Eur","Inicorio hecho papel moneda"));

        // tengo que pasarle los ITEMS con la función de JAVA setItems
        room3.setItems(itemsRoom3);

        // ESTABLEZCO cuál es mi room inicial
        initialRoom = room1;
    }
}
