package forfaitNieve;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Locale;
import java.util.Scanner;

public class PruebaForfaitNieve {
    public static void main(String[] args) {
        DateTimeFormatter formateadorFecha = DateTimeFormatter.BASIC_ISO_DATE;
        ValidadorFecha validator = new ValidadorFechaLocalDate(formateadorFecha);
        Scanner teclado = new Scanner(System.in);

        /*

        DateTimeFormatter hace un parse de una fecha en dos fases:
        1-) Parsea el texto en varios objetos de tipo Fecha, dependiendo de la configuracion
        2-) Resuelve lo anterior a un objeto tipo Date. ResolverStyle es un Enum con 3 tipos:
        LENIENT: resuelve una fecha de forma laxa.
        INTELLIGENT: hace lo anterior pero de forma inteligente, teniendo cuidado con los meses de 30/31 dias
        STRICT: Lo anterior pero encima ve si febrero tiene 28 dias o 29 dependiendo de si es bisiesto el año o no

         */

        DateTimeFormatter formateadorFechaEstricto = DateTimeFormatter.ofPattern("dd-MM-uuuu", Locale.ITALIAN).withResolverStyle(ResolverStyle.STRICT);
        ValidadorFecha validator2 = new ValidadorFechaLocalDate(formateadorFechaEstricto);

        System.out.println("Es valida la fecha 28/2/2019? "+validator.esValido("20190228"));
        System.out.println("Es valida la fecha 29/2/2019? "+validator.esValido("20190230"));
        System.out.println();
        System.out.println("Es valida la fecha 28/2/2019? "+validator2.esValido("28-02-2019"));
        System.out.println("Es valida la fecha 30/2/2019? "+validator2.esValido("30-02-2019"));
        System.out.println();
        ForfaitNieve f1 = new ForfaitNieve();

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String fechaEntrada = LocalDate.parse("2020-11-28").format(formateador);
        String fechaSalida = LocalDate.parse("2021-05-02").format(formateador);

        LocalDate fechaEntrada1 = LocalDate.parse("2020-11-27");
        LocalDate fechaSalida1 = LocalDate.parse("2021-05-02");


        // f1.comprobarFechaEntradaYSalida(fechaEntrada,fechaSalida);

        LocalDate fechaPrueba1 = LocalDate.parse("2020-11-28");
        System.out.println("Fecha prueba 1: "+fechaPrueba1);
       // f1.comprobarFechaValida(fechaPrueba1);

        //f1.comprobarFechaValida(fechaEntrada1,fechaSalida1);

        System.out.println("Esta dentro del rango? "+f1.comprobarFechaValida(fechaEntrada1,fechaSalida1));

        LocalDate ff = LocalDate.parse("2020-11-28");

      //  System.out.println("Comprobar: "+ff.equals(fechaPrueba1));

    }
}
