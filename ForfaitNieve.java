package forfaitNieve;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class ForfaitNieve implements Comparable<ForfaitNieve>{

      private LocalDate localDate;

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

    public boolean compruebaFechas(){
          /* Dada las fechas por el usuario (que entrar por scanner en la clase test
          tenemos que ver primero que la fecha es valida, con el metodo esValida, luego que dicha fecha
          esta dentro de la temporada global , con el metodo comprobarFechaValida y por ultimo, ver
          la cantidad de dias de temporada alta,baja y especial que tiene
          */
          return true;
    }

    public void calcularDiasTemporadaEspecial(LocalDate fechaEntrada, LocalDate fechaSalida){
          ArrayList<LocalDate> temporadaEspecial = new ArrayList<LocalDate>();
          Integer numeroDiasTemporadaAlta = 0;

          temporadaEspecial.add(LocalDate.parse("2020-12-26"));
          temporadaEspecial.add(LocalDate.parse("2020-12-27"));
          temporadaEspecial.add(LocalDate.parse("2021-01-02"));
          temporadaEspecial.add(LocalDate.parse("2021-01-03"));
          temporadaEspecial.add(LocalDate.parse("2021-01-04"));
          temporadaEspecial.add(LocalDate.parse("2021-01-05"));
          temporadaEspecial.add(LocalDate.parse("2021-02-27"));
          temporadaEspecial.add(LocalDate.parse("2021-02-28"));
          temporadaEspecial.add(LocalDate.parse("2021-03-01"));
          temporadaEspecial.add(LocalDate.parse("2020-12-28"));
          temporadaEspecial.add(LocalDate.parse("2020-12-29"));
          temporadaEspecial.add(LocalDate.parse("2020-12-30"));
          System.out.println("Lista sin ordernar"+temporadaEspecial);
          Collections.sort(temporadaEspecial);
          System.out.println("Lista ordenada: "+temporadaEspecial);

          if (comprobarFechaValida(fechaEntrada,fechaSalida)){
            for (int i=0;i < temporadaEspecial.size();i++){
                if (temporadaEspecial.get(i).isAfter(fechaEntrada) || temporadaEspecial.get(i).equals(fechaEntrada)){
                    numeroDiasTemporadaAlta++;
                }

            }
          } else {
              System.out.println("Fechas no validas");
          }
        System.out.println("El numero de dias de temporada alta es: "+numeroDiasTemporadaAlta);
    }

    public LocalDate getLocalDate(){
          return localDate;
    }


    public int compareTo(ForfaitNieve o) {
        return getLocalDate().compareTo(o.getLocalDate());
    }
}
