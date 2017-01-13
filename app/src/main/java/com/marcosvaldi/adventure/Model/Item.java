package com.marcosvaldi.adventure.Model;


public class Item {

    // VBLES DE INSTANCIA
    private String name;
    private String description;

    // para QUE SEAN ACCESIBLES/PÚBLICOS se hacen uso de los Métodos GET y SET
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Añandimos CONSTRUCTORES

    // DEFAULT CONSTRUCTOR (pq hago otro y java ya no me lo haría)
    public Item(){

    }

    // CONSTRUCTOR PROPIO
    public Item(String name,String description){
        // para PASARLE el NAME a la vble de instancia NAME y lo mismo con description
        this.name = name;
        this.description = description;

    }

    // Item extiende del Object propio de Java -> queremos que nuestro toString sea el q ejecute lo que queramos
    // SOBREESCRIBIR
    @Override
    public String toString() {
        return "☛" + getName() + " " + getDescription() + "☚\n";
    }
}
