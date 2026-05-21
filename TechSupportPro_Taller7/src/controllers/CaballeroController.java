package controllers;

import models.Caballero;

import java.util.ArrayList;

public class CaballeroController {

    private ArrayList<Caballero> listaCaballeros;

    public CaballeroController() {
        listaCaballeros = new ArrayList<>();
    }

    // registrar
    public void registrarCaballero(Caballero caballero) {
        listaCaballeros.add(caballero);
    }

    // listar
    public ArrayList<Caballero> listarCaballeros() {
        return listaCaballeros;
    }

    // buscar por id
    public Caballero buscarPorId(int id) {

        for (Caballero c : listaCaballeros) {

            if (c.getId() == id) {
                return c;
            }
        }

        return null;
    }

    // modificar
    public boolean modificarCaballero(int id,
                                      String nombre,
                                      String rango,
                                      String constelacion,
                                      int nivelPoder,
                                      String mision,
                                      int dificultad,
                                      double recompensa) {
        Caballero caballero = buscarPorId(id);
        if (caballero != null) {
            caballero.setNombreCab(nombre);
            caballero.setRangoCab(rango);
            caballero.setConstelacionCab(constelacion);
            caballero.setNivelPoderCab(nivelPoder);
            caballero.setMision(mision);
            caballero.setDificultad(dificultad);
            caballero.setRecompensa(recompensa);

            return true;
        }

        return false;
    }
}