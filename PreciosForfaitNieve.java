package forfaitNieve;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PreciosForfaitNieve extends ForfaitNieve{
    private Double descuentoPrecioParticulares = 0.0;
    private Double descuentoPrecioColectivo = 0.0;
    private int colectivo;
    private final Scanner sc = new Scanner(System.in);
    private final Scanner sc2 = new Scanner(System.in);
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    private final Integer PRECIO_DIA_TEMPORADA_BAJA=50;
    private final Integer PRECIO_DIA_TEMPORADA_ALTA=51;
    private final Double PRECIO_DIA_TEMPORADA_ESPECIAL=51.50;

    public PreciosForfaitNieve(){

    }

    public PreciosForfaitNieve(LocalDate fechaEntrada, LocalDate fechaSalida){
        this.fechaSalida = fechaSalida;
        this.fechaEntrada = fechaEntrada;
    }
    //private int colectivo = 0;

    // Metodo que pide por pantalla si una persona es discapacitada o de familia numerosa
    // Si ambas son si, el descuento es de 10%, si una es si es de 5%, si ambas son no de 0%

    public int getColectivo(){
        return colectivo;
    }

    public Double calculaPrecioParticularidades(){
        System.out.print("Discapacitado (Si/No): ");
        String discapacitado  = sc.nextLine().toLowerCase();
        System.out.print("Familia numerosa (Si/No): ");
        String familiaNumerosa = sc.nextLine().toLowerCase();


        if (discapacitado.equals("si") && familiaNumerosa.equals("si")){
            descuentoPrecioParticulares=0.1;
        } else {
            if(discapacitado.equals("si") || familiaNumerosa.equals("si")){
                descuentoPrecioParticulares=0.05;
            } else{
                descuentoPrecioParticulares=0.0;
            }
        }
        return descuentoPrecioParticulares;
    }

    public Double calculaPrecioColectivo(){
        System.out.print("Colectivo (Benj-1/Inf-2/Adul-3/Sen-4/SenP-5): ");
        int eleccion = sc2.nextInt();
        // Haciendo colectivo = eleccion podemos obtener lo que el usuario escoge
        colectivo = eleccion;
            switch (colectivo){
                case 1:
                    descuentoPrecioColectivo = 0.40;
                    break;
                case 2:
                    descuentoPrecioColectivo = 0.35;
                    break;
                case 3:
                    descuentoPrecioColectivo = 0.0;
                    break;
                case 4:
                    descuentoPrecioColectivo = 0.2;
                    break;
                case 5:
                    descuentoPrecioColectivo = 0.3;
                    break;
            }
        return descuentoPrecioColectivo;
    }

    public Double getDescuentoTotal(){
        return descuentoPrecioParticulares+descuentoPrecioColectivo;
    }

    public void mensajeNumeroDiasTemporadaBaja(){
        Integer numeroDiasTemporadaBaja = getNumeroDiasTemporadaBaja();
        Integer precioDiasTemporadaBaja = getPrecioDiasTemporadaBaja();
        if (numeroDiasTemporadaBaja==0){

        } else {
            if (numeroDiasTemporadaBaja>0 && numeroDiasTemporadaBaja<=1){
                System.out.println("\t"+numeroDiasTemporadaBaja+" dia en Temporada baja: "+precioDiasTemporadaBaja+"€"+" (50€/dia");
            } else {
                System.out.println("\t"+numeroDiasTemporadaBaja+" dias en Temporada baja: "+precioDiasTemporadaBaja+"€"+" (50€/dia");
            }
        }
    }

    public void mensajeNumeroDiasTemporadaAlta (){
        Integer numeroDiasTemporadaAlta = getNumeroDiasTemporadaAlta();
        Integer precioDiasTemporadaAlta = getPrecioDiasTemporadaAlta();
        if (numeroDiasTemporadaAlta==0){
        } else {
            if (numeroDiasTemporadaAlta>0 && numeroDiasTemporadaAlta<=1){
                System.out.println("\t"+numeroDiasTemporadaAlta+" dia en Temporada alta: "+precioDiasTemporadaAlta+"€"+" (51€/dia)");
            } else {
                System.out.println("\t"+numeroDiasTemporadaAlta+" dias en Temporada alta: "+precioDiasTemporadaAlta+"€"+" (51€/dia)");
            }
        }


    }

    public void mensajeNumeroDiasTemporadaEspecial(){
        Integer numeroDiasTemporadaEspecial = getNumeroDiasTemporadaEspecial();
        Double precioDiasTemporadaEspecial = getPrecioDiasTemporadaEspecial();
        if (numeroDiasTemporadaEspecial==0){
        }else{
            if (numeroDiasTemporadaEspecial>0 && numeroDiasTemporadaEspecial<=1){
                System.out.println("\t"+numeroDiasTemporadaEspecial+" dia en Temporada alta: "+precioDiasTemporadaEspecial+"€"+" (51.50€/dia)");
            } else {
                System.out.println("\t"+numeroDiasTemporadaEspecial+" dias en Temporada alta: "+precioDiasTemporadaEspecial+"€"+" (51.50€/dia)");
            }
        }

    }

    public Integer getNumeroDiasTemporadaBaja(){
        return super.calcularNumeroDiasTemporadaBaja(this.fechaEntrada,this.fechaSalida);
    }

    public Integer getNumeroDiasTemporadaAlta(){
        return super.calcularNumeroDiasTemporadaAlta(this.fechaEntrada, this.fechaSalida);
    }

    public Integer getNumeroDiasTemporadaEspecial(){
        return super.calcularNumeroDiasTemporadaEspecial(this.fechaEntrada,this.fechaSalida);
    }

    public Integer getPrecioDiasTemporadaBaja(){
        return getNumeroDiasTemporadaBaja()*PRECIO_DIA_TEMPORADA_BAJA;
    }

    public Integer getPrecioDiasTemporadaAlta(){
        return getNumeroDiasTemporadaAlta()*PRECIO_DIA_TEMPORADA_ALTA;
    }

    public Double getPrecioDiasTemporadaEspecial(){
        return getNumeroDiasTemporadaEspecial()*PRECIO_DIA_TEMPORADA_ESPECIAL;
    }

    public Double getPrecioTotalEstancia(){
        return getPrecioDiasTemporadaBaja()*1.0+getPrecioDiasTemporadaAlta()*1.0+getPrecioDiasTemporadaEspecial();
    }




    // Por alguna razon el metodo de abajo no hay que sobreescribirlo ??????

    /*public void temporadaAlta (LocalDate fechaEntrada, LocalDate fechaSalida){
        mensajeNumeroDiasTemporadaAlta();

    }*/

    public void getPruebaColectivo (int colectivo){
        System.out.println("Tu colectivo es el: "+colectivo);
    }

    public void precioForfait(int colectivo, Double precio, Double descuentoParticulares,
                              Double descuentoColectivo ,LocalDate fechaEntrada, LocalDate fechaSalida){

        // Esto hace fila * columna, es decir:
        // [0][0] > [0][1] ... [0][4]
        // [1][0] > [1][1] ... [1][4]
        // Hasta el final

        Double [][] matriz = new Double[][]{
                {265.00,284.50, 437.50, 350.00, 337.50}, //forfait10
                {390.00, 420.00, 646.50, 517.00, 481.25}, //forfait15
                {510.00, 551.50, 848.50, 679.00, 645.00},//forfait20
                {495.00,534.80,822.85,658.00,635.00}, //forfait l-v
                {710.00,764.00,1175.50,940.00,893.00}}; //forfait full

        Double descuentoTotal = descuentoParticulares + descuentoColectivo;

        precio = precio*(1-descuentoTotal);
        Double diferencia = 0.0;
        Double totalPrecio = 0.0;

        List<LocalDate> diasEstancia = obtenerFechasEntreDos(fechaEntrada,fechaSalida);
        Integer numeroDiasEstancia = diasEstancia.size();

        String[] nombresForfait = new String[]{"Forfait 10 días", "Forfait 15 días", "Forfait 20 días",
                "Forfait Temporada L-V", "Forfait Temporada"};

            if (numeroDiasEstancia>=1 && numeroDiasEstancia<=8 && colectivo==3){
                totalPrecio = matriz[0][colectivo-1] * (1-descuentoParticulares);
                diferencia = precio-totalPrecio;

                System.out.println("Se le recomienda la adquisicion de un Forfait de "+numeroDiasEstancia+" " +
                        "dias sueltos que le sale por "+precio+"€");
            } else if (numeroDiasEstancia>=1 && numeroDiasEstancia<=9){
                totalPrecio = matriz[0][colectivo-1] * (1-descuentoParticulares);
                diferencia = precio-totalPrecio;
                System.out.println("Se le recomienda la adquisicion de un "+nombresForfait[0]+" que le sale por "
                        +totalPrecio+"€ con lo que se ahorra un total de "+Math.abs(diferencia)+"€");
            }

            if (numeroDiasEstancia>9 && numeroDiasEstancia<=15){
                totalPrecio = matriz[0][colectivo-1] * (1-descuentoParticulares);
                diferencia = precio-totalPrecio;
                System.out.println("Se le recomienda la adquisicion de un "+nombresForfait[0]+" que le sale por "
                        +totalPrecio+"€ con lo que se ahorra un total de "+Math.abs(diferencia)+"€");
            }
            if (numeroDiasEstancia>15 && numeroDiasEstancia<=20){
                totalPrecio = matriz[1][colectivo-1] * (1-descuentoParticulares);
                diferencia = precio-totalPrecio;
                System.out.println("Se le recomienda la adquisicion de un "+nombresForfait[1]+" que le sale por "
                        +totalPrecio+"€ con lo que se ahorra un total de"+Math.abs(diferencia)+"€");
            }
            if (numeroDiasEstancia>20 && numeroDiasEstancia<=25){
                totalPrecio = matriz[2][colectivo-1] * (1-descuentoParticulares);
                diferencia = precio-totalPrecio;
                System.out.println("Se le recomienda la adquisicion de un "+nombresForfait[2]+" que le sale por "
                        +totalPrecio+"€ con lo que se ahorra un total de"+Math.abs(diferencia)+"€");
            }
            if (numeroDiasEstancia>26 && numeroDiasEstancia<=109){
                totalPrecio = matriz[3][colectivo-1] * (1-descuentoParticulares);
                diferencia = precio-totalPrecio;
                System.out.println("Total precio:"+totalPrecio);
                System.out.println("Se le recomienda la adquisicion de un "+nombresForfait[3]+" que le sale por "
                        +totalPrecio+"€ con lo que se ahorra un total de "+diferencia+Math.abs(diferencia)+"€");
            }
            if (numeroDiasEstancia>109 && numeroDiasEstancia<=155){
                totalPrecio = matriz[4][colectivo-1] * (1-descuentoParticulares);
                diferencia = precio-totalPrecio;
                System.out.println("Se le recomienda la adquisicion de un "+nombresForfait[4]+" que le sale por "
                        +totalPrecio+"€ con lo que se ahorra un total de"+Math.abs(diferencia)+"€");
            }


        }

    }
