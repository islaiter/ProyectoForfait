package forfaitNieve;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Locale;
import java.util.Scanner;

public class TestForfaitNieve {
    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        DateTimeFormatter formateadorFechaEstricto = DateTimeFormatter.ofPattern("dd-MM-uuuu", Locale.ITALIAN).withResolverStyle(ResolverStyle.STRICT);
        ValidadorFecha validator = new ValidadorFechaLocalDate(formateadorFechaEstricto);

        DateTimeFormatter formateadorFecha = DateTimeFormatter.BASIC_ISO_DATE;
        ValidadorFecha validator2 = new ValidadorFechaLocalDate(formateadorFecha);



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
        LocalDate fEntrada = LocalDate.parse(fechaEntrada);
        LocalDate fSalida = LocalDate.parse(fechaSalida);

        ForfaitNieve f1 = new ForfaitNieve(fEntrada,fSalida);


        f1.calcularDiasTemporadaEspecial();
        f1.calcularDiasTemporadaAlta();
        f1.calcularDiasTemporadaBaja();
        //f1.numeroDiasTemporadaBaja(fEntrada, fSalida);
        f1.temporadaBaja(fEntrada,fSalida);
        f1.temporadaAlta(fEntrada, fSalida);
        f1.temporadaEspecial(fEntrada, fSalida);

    }
}
