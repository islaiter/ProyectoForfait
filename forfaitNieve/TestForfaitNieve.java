package forfaitNieve;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class TestForfaitNieve {
    LocalDate fEntrada;
    LocalDate fSalida;
    List<LocalDate> listaDias;


    public static void main(String[] args) {
        TestForfaitNieve fechas = new TestForfaitNieve();
        Scanner sn = new Scanner(System.in);

        DateTimeFormatter formateadorFechaEstricto = DateTimeFormatter.ofPattern("dd-MM-uuuu", Locale.ITALIAN).withResolverStyle(ResolverStyle.STRICT);
        ValidadorFecha validator = new ValidadorFechaLocalDate(formateadorFechaEstricto);
        TarifasDescuentos descuentos = new TarifasDescuentos();
        DateTimeFormatter formateadorFecha = DateTimeFormatter.BASIC_ISO_DATE;
        ValidadorFecha validator2 = new ValidadorFechaLocalDate(formateadorFecha);

        ForfaitNieve f1 = new ForfaitNieve();
        System.out.println("Entrada");
        System.out.println("Dia");
        String diaEntrada = sn.nextLine();
        System.out.println("Mes");
        String mesEntrada = sn.nextLine();
        System.out.println("Año");
        String anioEntrada = sn.nextLine();
        String fechaEntrada = "";
        fechaEntrada = diaEntrada+"-"+mesEntrada+"-"+anioEntrada;
        System.out.println("Salida");
        System.out.println("Dia");
        String diaSalida = sn.nextLine();
        System.out.println("Mes");
        String mesSalida = sn.nextLine();
        System.out.println("Año");
        String anioSalida = sn.nextLine();
        String fechaSalida = "";
        fechaEntrada = anioEntrada+"-"+mesEntrada+"-"+diaEntrada;
        fechaSalida = anioSalida+"-"+mesSalida+"-"+diaSalida;
        fechas.fEntrada = LocalDate.parse(fechaEntrada);
        fechas.fSalida = LocalDate.parse(fechaSalida);


        f1.calcularDiasTemporadaEspecial2();
        f1.calcularDiasTemporadaAlta();
        f1.calcularDiasTemporadaBaja();
        f1.numeroDiasTemporadaBaja(fechas.fEntrada, fechas.fSalida);
        f1.numeroDiasTemporadaAlta(fechas.fEntrada, fechas.fSalida);
        f1.numeroDiasTemporadaEspecial(fechas.fEntrada, fechas.fSalida);
        fechas.listaDias=f1.obtenerFechasEntreDos(fechas.fEntrada, fechas.fSalida);
        System.out.println(fechas.listaDias);
        descuentos.listaDias(fechas.listaDias);
        descuentos.switchCase();

    }

}
