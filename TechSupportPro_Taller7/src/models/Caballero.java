package models;

public class Caballero {

    private int id;
    private String nombreCab;
    private String rangoCab;
    private String constelacionCab;
    private int nivelPoderCab;

    private String mision;
    private int dificultad;
    private double recompensa;

    public Caballero(int id, String nombreCab, String rangoCab, String constelacionCab, int nivelPoderCab, String mision, int dificultad, double recompensa) {
        this.id = id;
        this.nombreCab = nombreCab;
        this.rangoCab = rangoCab;
        this.constelacionCab = constelacionCab;
        this.nivelPoderCab = nivelPoderCab;
        this.mision = mision;
        this.dificultad = dificultad;
        this.recompensa = recompensa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCab() {
        return nombreCab;
    }

    public void setNombreCab(String nombreCab) {
        this.nombreCab = nombreCab;
    }

    public String getRangoCab() {
        return rangoCab;
    }

    public void setRangoCab(String rangoCab) {
        this.rangoCab = rangoCab;
    }

    public String getConstelacionCab() {
        return constelacionCab;
    }

    public void setConstelacionCab(String constelacionCab) {
        this.constelacionCab = constelacionCab;
    }

    public int getNivelPoderCab() {
        return nivelPoderCab;
    }

    public void setNivelPoderCab(int nivelPoderCab) {
        this.nivelPoderCab = nivelPoderCab;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(double recompensa) {
        this.recompensa = recompensa;
    }

    @Override
    public String toString() {
        return "Caballero: " +
                id + " | " +
                nombreCab + " | " +
                rangoCab + " | " +
                constelacionCab + " | " +
                nivelPoderCab + " | " +
                mision + " | " +
                dificultad + " | $" +
                recompensa;
    }
}
