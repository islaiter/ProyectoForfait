package forfaitNieve;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List<LocalDate> calcularDiasTemporadaEspecial2 (){
          List<LocalDate> listaFechas = new ArrayList<LocalDate>();
          List<LocalDate> listaFechas2 = new ArrayList<LocalDate>();
          List<LocalDate> diasTemporadaEspecial = new ArrayList<LocalDate>();


          obtenerFechasEntreDos(LocalDate.parse("2020-12-26"),LocalDate.parse("2020-12-31"));
          obtenerFechasEntreDos(LocalDate.parse("2021-01-02"),LocalDate.parse("2021-01-06"));
          obtenerFechasEntreDos(LocalDate.parse("2021-02-27"),LocalDate.parse("2021-03-02"));

          listaFechas = Stream.concat(obtenerFechasEntreDos(LocalDate.parse("2020-12-26"),LocalDate.
                  parse("2020-12-31")).stream(),obtenerFechasEntreDos(LocalDate.parse("2021-01-02"),
                  LocalDate.parse("2021-01-06")).stream()).collect(Collectors.toList());

          listaFechas2 = Stream.concat(obtenerFechasEntreDos(LocalDate.parse("2021-01-02"),LocalDate.
                parse("2021-01-06")).stream(),obtenerFechasEntreDos(LocalDate.parse("2021-02-27"),
                LocalDate.parse("2021-03-02")).stream()).collect(Collectors.toList());

          diasTemporadaEspecial = Stream.concat(listaFechas.stream(),listaFechas2.stream()).collect(Collectors.toList());
          diasTemporadaEspecial = diasTemporadaEspecial.stream().distinct().collect(Collectors.toList());
          ArrayList<LocalDate> listaComoArrayList = new ArrayList<LocalDate>(diasTemporadaEspecial);

          return listaComoArrayList;

    }

    public List<LocalDate> calcularDiasTemporadaAlta (){

          /* Definimos todas las listas que nos van a hacer falta
          periodoFechas1-4 tiene los periodos fuera de fin de semana que son dias temporada alta
          diasTotales tiene todos los dias que van entre el 1 de Diciembre al 3 de Abril, con esta lista
          luego calculamos que dias son de fin de semana y se añade a la lista diasFinDeSemana
          listaDiasEspeciales llama al metodo calcularDiasTemporadaEspecial para traernos que dias son especiales
          Por ultimo, metemos periodoFechas1-4 en listaTotal, junto con los dias de fin de semana, y al conjunto
          luego le quitamos los dias que son dias especiales, quitamos los duplicados y ordenamos la lista
          */

          List<LocalDate> periodoFechas1 = new ArrayList<LocalDate>();
          List<LocalDate> periodoFechas2 = new ArrayList<LocalDate>();
          List<LocalDate> periodoFechas3 = new ArrayList<LocalDate>();
          List<LocalDate> periodoFechas4 = new ArrayList<LocalDate>();
          List<LocalDate> diasTotales = new ArrayList<LocalDate>();
          List<LocalDate> diasFinDeSemana = new ArrayList<LocalDate>();
          List<LocalDate> listaTotal = new ArrayList<LocalDate>();
          List<LocalDate> listaDiasEspeciales = new ArrayList<LocalDate>();

          //

          periodoFechas1 = obtenerFechasEntreDos(LocalDate.parse("2020-12-05"),LocalDate.parse("2020-12-09"));
          periodoFechas2 = obtenerFechasEntreDos(LocalDate.parse("2020-12-31"),LocalDate.parse("2021-01-02"));
          periodoFechas3 = obtenerFechasEntreDos(LocalDate.parse("2021-02-06"),LocalDate.parse("2021-02-27"));
          periodoFechas4 = obtenerFechasEntreDos(LocalDate.parse("2021-03-27"),LocalDate.parse("2021-04-05"));
          // Desde el 1 de Diciembre, para que no pille luego como dias de temporada alta el ultimo finde de Noviembre
          diasTotales = obtenerFechasEntreDos(LocalDate.parse("2020-12-01"),LocalDate.parse("2021-04-03"));
          listaDiasEspeciales = calcularDiasTemporadaEspecial2();

          // Recorremos todos los dias entre el 1 de Diciembre y el 3 de Abril para ver que dias son de fin de semana
          // En caso de ser un dia de fin de semana, se añade el elemento a la lista de nombre diasFinDeSemana

          for (int i=0;i<diasTotales.size();i++){
              diasTotales.get(i).getDayOfWeek();
              if ((diasTotales.get(i).getDayOfWeek() == DayOfWeek.SATURDAY ||
                      diasTotales.get(i).getDayOfWeek() == DayOfWeek.SUNDAY )){
                  diasFinDeSemana.add(diasTotales.get(i));
              }
          }

          // Añadimos todos los elementos de las otras listas

          listaTotal = Stream.concat(listaTotal.stream(),periodoFechas1.stream()).collect(Collectors.toList());
          listaTotal = Stream.concat(listaTotal.stream(),periodoFechas2.stream()).collect(Collectors.toList());
          listaTotal = Stream.concat(listaTotal.stream(),periodoFechas3.stream()).collect(Collectors.toList());
          listaTotal = Stream.concat(listaTotal.stream(),periodoFechas4.stream()).collect(Collectors.toList());
          listaTotal = Stream.concat(listaTotal.stream(),diasFinDeSemana.stream()).collect(Collectors.toList());

          // Ahora eliminamos de la lista todos los elementos duplicados
          listaTotal = listaTotal.stream().distinct().collect(Collectors.toList());
          // Ordenamos la lista en caso de que este desordenada
          Collections.sort(listaTotal);
          listaTotal.removeAll(listaDiasEspeciales);
          //System.out.println("La lista FINAL de dias de temporada alta y no especial: "+listaTotal);

          return listaTotal;

    }

    public List<LocalDate> calcularDiasTemporadaBaja(){
          // Los dias de comienzo y fin de la temporada, el dia de fin tiene que ser uno mayor al calendario
          // porque el metodo obtenerFechasEntreDos obvia el ultimo dia
          LocalDate diaInicio = LocalDate.parse("2020-11-28");
          LocalDate diaFin = LocalDate.parse("2021-05-03");

          // Definimos los dias de temporada baja y cargamos todos los dias del calendario
          List<LocalDate> diasTemporadaBaja = new ArrayList<LocalDate>();
          diasTemporadaBaja=obtenerFechasEntreDos(diaInicio,diaFin);

          // Ahora queremos en dos listas distintas, los dias de temporada alta y especial
          List<LocalDate> diasTemporadaAlta = new ArrayList<LocalDate>();
          List<LocalDate> diasTemporadaEspecial = new ArrayList<LocalDate>();
          // Cargamos los dias correspondientes, usando los metodos ya creados

          diasTemporadaAlta = calcularDiasTemporadaAlta();
          diasTemporadaEspecial = calcularDiasTemporadaEspecial2();

          // Ahora a la lista de dias de temporada baja, eliminamos todos los de las otras dos listas
           diasTemporadaBaja.removeAll(diasTemporadaAlta);
           diasTemporadaBaja.removeAll(diasTemporadaEspecial);

           // Solo nos quedaria entonces todos los dias de temporada baja

          return diasTemporadaBaja;

    }

    public Integer numeroDiasTemporadaEspecial(LocalDate fechaEntrada, LocalDate fechaSalida){
          Integer numeroDiasTemporadaEspecial = 0;
          Integer numeroDiasTemporadaEspecial2 = 0;
          List<LocalDate> temporadaEspecial = calcularDiasTemporadaEspecial2();
          // El dia de salida imaginamos que salen a primera hora, no que se quedan ese dia y luego salen, si no
          // a.datesUntil(b) añade todas las fechas de a hasta b sin incluir b, por eso tenemos que sumar 1

        List<LocalDate> diasEstancia = obtenerFechasEntreDos(fechaEntrada,fechaSalida);

          // Esto es una mierda porque el tiempo de ejecucion es N^2 pero sirve de momento

          /* for (int i=0;i<temporadaEspecial.size();i++){
              for (int j=0;j<diasEstancia.size();j++)
                  if (temporadaEspecial.get(i).equals(diasEstancia.get(j))){
                      numeroDiasTemporadaEspecial++;
              }
          } */

          // Este esta mejor, el tiempo de ejecucion ya no es cuadratico
          // Dada la lista de dias que el usuario esta de estancia, si ese dia esta dentro de los idas especiales
          // suma 1 al contador de dias de temporada especial

          for (int i=0;i<diasEstancia.size();i++){
              if (temporadaEspecial.contains(diasEstancia.get(i))){
                  numeroDiasTemporadaEspecial2++;
              }
          }



        if (numeroDiasTemporadaEspecial2==0){
        } else {
            System.out.println("\t"+numeroDiasTemporadaEspecial2+" dias en Temporada especial.");
        }
          return numeroDiasTemporadaEspecial2;
    }

    public Integer numeroDiasTemporadaAlta(LocalDate fechaEntrada, LocalDate fechaSalida){
          // Contador a 0
        Integer numeroDiasTemporadaAlta = 0;
        // lista que contiene todos los dias de temporada alta
        List<LocalDate> diasTemporadaAlta = calcularDiasTemporadaAlta();
        List<LocalDate> diasEstancia = obtenerFechasEntreDos(fechaEntrada,fechaSalida);

        for (int i=0;i<diasEstancia.size();i++){
            if (diasTemporadaAlta.contains(diasEstancia.get(i))){
                numeroDiasTemporadaAlta++;
            }
        }

        if (numeroDiasTemporadaAlta==0){
        } else {
            System.out.println("\t"+numeroDiasTemporadaAlta+" dias en Temporada alta.");
        }

        return numeroDiasTemporadaAlta;

    }

    public Integer numeroDiasTemporadaBaja(LocalDate fechaEntrada, LocalDate fechaSalida){
        // Contador a 0
        Integer numeroDIasTemporadaBaja = 0;
        // lista que contiene todos los dias de temporada alta
        List<LocalDate> diasTemporadaBaja = calcularDiasTemporadaBaja();
        List<LocalDate> diasEstancia = obtenerFechasEntreDos(fechaEntrada,fechaSalida);

        System.out.println("    Son un total de "+diasEstancia.size()+" dias");

        for (int i=0;i<diasEstancia.size();i++){
            if (diasTemporadaBaja.contains(diasEstancia.get(i))){
                numeroDIasTemporadaBaja++;
            }
        }

        if (numeroDIasTemporadaBaja==0){
        } else {
            System.out.println("\t"+numeroDIasTemporadaBaja+" dias en Temporada baja.");
        }



        return numeroDIasTemporadaBaja;

    }

    public List<LocalDate> obtenerFechasEntreDos (LocalDate comienzo, LocalDate fin){
          List<LocalDate> listaDias = comienzo.datesUntil(fin).collect(Collectors.toList());
          return listaDias;
    }

    public LocalDate getLocalDate(){
          return localDate;
    }


    public int compareTo(ForfaitNieve o) {
        return getLocalDate().compareTo(o.getLocalDate());
    }
}
