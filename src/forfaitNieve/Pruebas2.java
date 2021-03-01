package forfaitNieve;

import java.time.LocalDate;
import java.util.Scanner;

public class Pruebas2 {
    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

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

        PreciosForfaitNieve pf1 = new PreciosForfaitNieve(fEntrada,fSalida);
        ForfaitNieve f1 = new ForfaitNieve(fEntrada,fSalida);

        Double descuentoParticulares = pf1.calculaPrecioParticularidades();
        Double descuentoColectivo = pf1.calculaPrecioColectivo();
        System.out.println("Descuento particulares: "+descuentoParticulares);
        System.out.println("Descuento colectivo: "+descuentoColectivo);
        Double descuentoTotal = descuentoParticulares+descuentoColectivo;
        //System.out.println("Total descuento: "+descuentoTotal);

        System.out.println();
        pf1.temporadaBaja(fEntrada,fSalida);
        pf1.temporadaAlta(fEntrada,fSalida);
        pf1.temporadaEspecial(fEntrada,fSalida);
        System.out.println();
        //Integer precioBaja = pf1.calcularPrecioDiasTemporadaBaja();
        //System.out.println("Precio dias temporada baja: "+precioBaja);
        //System.out.println();
        Integer diasTemporadaBaja = pf1.calcularNumeroDiasTemporadaBaja(fEntrada,fSalida);
        System.out.println();
        Double precioTotal = diasTemporadaBaja*50.0;
        /*System.out.println("Temporada baja pruebas"+diasTemporadaBaja);
        System.out.println("Precio total: "+precioTotal);
        System.out.println();
        pf1.temporadaBaja(fEntrada,fSalida);*/
        //f1.temporadaAlta(fEntrada,fSalida);
        System.out.println("Numero dias temporada especial: "+pf1.getNumeroDiasTemporadaEspecial());
        System.out.println();
        System.out.println("Precio dias temporada baja: "+pf1.getPrecioDiasTemporadaBaja());
        System.out.println("Precio dias temporada alta: "+pf1.getPrecioDiasTemporadaAlta());
        System.out.println("Precio dias temporada especial: "+pf1.getPrecioDiasTemporadaEspecial());
        Double precioTotalEstancia = pf1.getPrecioTotalEstancia();
        System.out.println("El precio total de su estancia es: "+precioTotalEstancia+"€");
        System.out.println("El descuento total es: "+descuentoTotal);
        System.out.println();
        System.out.println("Precio con descuento: "+precioTotalEstancia*(1-descuentoTotal));
        pf1.precioForfait(pf1.getColectivo(),precioTotalEstancia,descuentoParticulares, descuentoColectivo, fEntrada,fSalida);


    }
}
