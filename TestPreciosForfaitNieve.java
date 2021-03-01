package forfaitNieve;

import java.time.LocalDate;
import java.util.Scanner;

public class TestPreciosForfaitNieve {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);


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

        PreciosForfaitNieve pf1 = new PreciosForfaitNieve(fEntrada,fSalida);
        ForfaitNieve f1 = new ForfaitNieve(fEntrada,fSalida);

        System.out.println();
        Double descuentoColectivo = pf1.calculaPrecioColectivo();
        System.out.println();
        Double descuentoParticulares = pf1.calculaPrecioParticularidades();

        Double descuentoTotal = descuentoParticulares+descuentoColectivo;

        System.out.println();
        pf1.temporadaBaja(fEntrada,fSalida);
        pf1.temporadaAlta(fEntrada,fSalida);
        pf1.temporadaEspecial(fEntrada,fSalida);
        Integer diasTemporadaBaja = pf1.calcularNumeroDiasTemporadaBaja(fEntrada,fSalida);
        System.out.println();
        Double precioTotal = diasTemporadaBaja*50.0;
        Double precioTotalEstancia = pf1.getPrecioTotalEstancia();

        pf1.precioForfait(pf1.getColectivo(),precioTotalEstancia,descuentoParticulares, descuentoColectivo, fEntrada,fSalida);
    }
}
