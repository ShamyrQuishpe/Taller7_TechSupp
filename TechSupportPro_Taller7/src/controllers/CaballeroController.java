package controllers;

import models.Caballero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        // ordenar lista por ID
        Collections.sort(listaCaballeros,
                Comparator.comparingInt(Caballero::getId));

        int izquierda = 0;
        int derecha = listaCaballeros.size() - 1;

        while (izquierda <= derecha) {

            int medio = (izquierda + derecha) / 2;

            Caballero caballero = listaCaballeros.get(medio);
            System.out.println("Buscando: " + id);
            System.out.println("Comparando con: " + caballero.getId());
            if (caballero.getId() == id) {

                return caballero;
            }

            if (caballero.getId() < id) {

                izquierda = medio + 1;

            } else {

                derecha = medio - 1;
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