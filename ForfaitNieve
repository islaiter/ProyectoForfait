package forfaitNieve;

import java.time.LocalDate;

public class ForfaitNieve {

      public boolean comprobarFechaValida(LocalDate fechaEntrada, LocalDate fechaSalida){

        LocalDate fechaMinima = LocalDate.parse("2020-11-28");
        LocalDate fechaMaxima = LocalDate.parse("2021-05-02");

        /* Dada una fecha escogida por el usuario para entrar y salir con su forfait nieva, comprobamos
        si esa fecha esta permitida, es decir que este dentro de cuando la estacion esta abierta, que va
        desde el 28/11/2020 hasta el 5/2/2020 ambos inclusive
        */
        return (fechaEntrada.isAfter(fechaMinima)||fechaEntrada.equals(fechaMinima)) &&
                (fechaSalida.isBefore(fechaMaxima)||fechaSalida.equals(fechaMaxima));
    }

}
