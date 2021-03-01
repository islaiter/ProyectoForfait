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

        System.out.println("\n\t\t\t\t\t\t\t\033[4m\033[1mPROGRAMA FORFAIT NIEVE\033[0m\033[2m\n");

        System.out.println("\033[1mEntrada\033[0m");
        System.out.print("Dia: ");
        String diaEntrada = sn.nextLine();
        System.out.print("Mes: ");
        String mesEntrada = sn.nextLine();
        System.out.print("Año: ");
        String anioEntrada = sn.nextLine();
        String fechaEntrada = "";
        fechaEntrada = diaEntrada+"-"+mesEntrada+"-"+anioEntrada;
        System.out.println("\033[1mSalida\033[0m");
        System.out.print("Dia: ");
        String diaSalida = sn.nextLine();
        System.out.print("Mes: ");
        String mesSalida = sn.nextLine();
        System.out.print("Año: ");
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
