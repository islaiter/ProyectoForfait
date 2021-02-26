package forfaitNieve;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TarifasDescuentos extends TestForfaitNieve{
    List <LocalDate>listaConFinde = new ArrayList<LocalDate>();
    List <LocalDate>listaSinFinde= new ArrayList<LocalDate>();
public void listaDias(List<LocalDate>lista){
    for (int i=0;i<lista.size();i++){
        lista.get(i).getDayOfWeek();
        if ((lista.get(i).getDayOfWeek() == DayOfWeek.SATURDAY ||
                lista.get(i).getDayOfWeek() == DayOfWeek.SUNDAY )){
            listaConFinde.add(lista.get(i));
        }
        else{
            listaSinFinde.add(lista.get(i));
        }

    }
}
 public void switchCase() {
        String[] forfaitNombreConFestivos = new String[]{"Forfait Temporada", "Forfait 20 días", "Forfait Temporada L-V", "Forfait 15 días", "Forfait 10 días"};
     String[] forfaitNombreSinFestivos = new String[]{"Forfait Temporada", "Forfait 20 días", "Forfait 15 días", "Forfait 10 días"};
        double[][] PreciosSinFestivos = new double[][]{
                {710,510.00, 495.00, 390.00, 265.00}, //benjamin
                {764.00, 551.5, 534.8, 420.00, 284.5}, //infantil
                {1175.50, 848.50, 822.85, 646.50, 437.50},//adulto
                {940.00, 679.00, 658.00, 517.00, 350.00}, //senior
                {893.00, 645.00, 635.00, 481.25, 337.50}}; //seniorplus

        double [][] PreciosConFestivos = new double[][]{
                {710,510.00, 390.00, 265.00}, //benjamin
                {764.00, 551.5, 420.00, 284.5}, //infantil
                {1175.50, 848.50, 646.50, 437.50},//adulto
                {940.00, 679.00, 517.00, 350.00}, //senior
                {893.00, 645.00, 481.25, 337.50}
        };

        //se hara aqui una copia de este arraydoble para el array sin sabados y domingos (asi controlar que el forfait de lunes a viernes no salte con sabado
        //con un if de la lista !diasFinDeSemana.isEmpty()
        Scanner sc = new Scanner(System.in);
        //precioMuestra es la muestra de la suma de los días
        double precioMuestra = 1500;
        System.out.println("Introduce colectivo");
        int colectivo = sc.nextInt();
        switch (colectivo) {
            case 1:
                precioMuestra = precioMuestra - (precioMuestra * 0.4);
                //Benjamin
                bucle(0, precioMuestra, PreciosConFestivos,PreciosSinFestivos, forfaitNombreSinFestivos, forfaitNombreConFestivos);
                break;

            case 2:
                precioMuestra = precioMuestra - (precioMuestra * 0.35);
                precioMuestra = desc(precioMuestra);
                //Infantil
                bucle(1, precioMuestra, PreciosConFestivos,PreciosSinFestivos, forfaitNombreSinFestivos, forfaitNombreConFestivos);
                break;
            case 3:
                precioMuestra = desc(precioMuestra);
                //Adulto
                bucle(2, precioMuestra, PreciosConFestivos,PreciosSinFestivos, forfaitNombreSinFestivos, forfaitNombreConFestivos);
                break;
            case 4:
                precioMuestra = precioMuestra - (precioMuestra * 0.2);
                precioMuestra = desc(precioMuestra);
                //senior
                bucle(3, precioMuestra, PreciosConFestivos,PreciosSinFestivos, forfaitNombreSinFestivos, forfaitNombreConFestivos);
                break;

            case 5:
                precioMuestra = precioMuestra - (precioMuestra * 0.30);
                precioMuestra = desc(precioMuestra);
                //seniorPlus
                bucle(4, precioMuestra, PreciosConFestivos,PreciosSinFestivos, forfaitNombreSinFestivos, forfaitNombreConFestivos);


            default:
                //Java code
                ;
        }
    }

    public double desc(double descuentos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Discapacitado Si/No");
        String Discapacitado = sc.nextLine();
        if (Discapacitado.equalsIgnoreCase("si") || Discapacitado.equalsIgnoreCase("sí")) {
            descuentos = descuentos - (descuentos * 0.05);
            System.out.println(descuentos + "Descuento por discapacitado");

        }
        System.out.println("¿Familia numerosa?");
        String FamiliaNumerosa = sc.nextLine();
        if (FamiliaNumerosa.equalsIgnoreCase("si") || FamiliaNumerosa.equalsIgnoreCase("sí")) {
            descuentos = descuentos - (descuentos * 0.05);
            System.out.println(descuentos + " Descuento por familia numerosa");
        }
        return descuentos;
    }

    public void bucle(int bucleCase, double precioMuestra, double[][] arrayConFestivos, double [][]arraySinFestivos, String[]forfaitNombreSinFestivos, String[] forfaitNombreConFestivos ) {
        System.out.println(precioMuestra);
        precioMuestra = desc(precioMuestra);
        double restomayor = 0;
        String forfaitValido = "";
        int num = bucleCase;
        for (int j = 0; j < 5; j++) {
            if (precioMuestra > arraySinFestivos[num][j] && listaConFinde.isEmpty()) {
                //double resto= arraySinFestivos[num][j]-precioMuestra;
                double resto = precioMuestra - arraySinFestivos[num][j];
                resto = (float) Math.round(resto * 100.0) / 100.0;
                forfaitValido = forfaitNombreConFestivos[j];
                restomayor = resto;
                System.out.println("EntraEnListaSinFinde");
            }
        }
            for (int j = 0; j < 4; j++) {
                if(precioMuestra>arrayConFestivos[num][j] && !listaConFinde.isEmpty()){
                    double resto = precioMuestra-arrayConFestivos[num][j];
                    resto = (float) Math.round(resto * 100.0) / 100.0;
                    forfaitValido= forfaitNombreSinFestivos[j];
                    restomayor=resto;
                    System.out.println("EntraEnListaConFinde");

                }
            }
        System.out.println("El precio a paga*r suelto es mayor asi que entra aqui" + precioMuestra + " " + forfaitValido + " así se ahorra" +
                restomayor + "€");
        }


    }
