package models;

public class Mision {

    private String nombreMision;
    private int dificultadMision;

    public Mision(String nombreMision, int dificultadMision) {
        this.nombreMision = nombreMision;
        this.dificultadMision = dificultadMision;
    }

    public String getNombreMision() {
        return nombreMision;
    }

    public int getDificultadMision() {
        return dificultadMision;
    }

}
