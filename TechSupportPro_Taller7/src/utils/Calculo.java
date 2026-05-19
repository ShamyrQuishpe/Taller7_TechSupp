package utils;

public class Calculo {

    //SANTUARIO
    public static double calcularAporte(double recompensa) {
        return recompensa * 0.10;
    }

    //REINO
    public static double calcularImpuesto(double recompensa) {

        if (recompensa <= 100000) {
            return 0;
        }

        else if (recompensa <= 200000) {
            return (recompensa - 100000) * 0.12;
        }

        else if (recompensa <= 400000) {
            return (recompensa - 200000) * 0.25;
        }

        else {
            return (recompensa - 400000) * 0.35;
        }
    }

    public static double recompensaNeta(double recompensa) {

        double aporte = calcularAporte(recompensa);
        double impuesto = calcularImpuesto(recompensa);

        return recompensa - aporte - impuesto;
    }

}
