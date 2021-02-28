package forfaitNieve;

// TODO implementar todos los metodos en esta clase o forfait, NUNCA EN CLASE TEST

import java.time.LocalDate;
import java.util.Scanner;

public class PreciosForfaitNieve extends ForfaitNieve{
    private Double descuentoPrecioParticulares = 0.0;
    private Double descuentoPrecioColectivo = 0.0;
    private final Scanner sc = new Scanner(System.in);
    private final Scanner sc2 = new Scanner(System.in);
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    public PreciosForfaitNieve(){

    }

    public PreciosForfaitNieve(LocalDate fechaEntrada, LocalDate fechaSalida){
        this.fechaSalida = fechaSalida;
        this.fechaEntrada = fechaEntrada;
    }
    //private int colectivo = 0;

    // Metodo que pide por pantalla si una persona es discapacitada o de familia numerosa
    // Si ambas son si, el descuento es de 10%, si una es si es de 5%, si ambas son no de 0%



    public Double calculaPrecioParticularidades(){
        System.out.println("Discapacitado (Si/No): ");
        String discapacitado  = sc.nextLine().toLowerCase();
        System.out.println("Familia numerosa (Si/No): ");
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
        System.out.println("Colectivo (Benj-1/Inf-2/Adul-3/Sen-4/SenP-5): ");
        int colectivo = sc2.nextInt();
        switch (colectivo){
            case 1:
                descuentoPrecioColectivo = 0.0;
            case 2:
                descuentoPrecioColectivo = 0.4;
            case 3:
                descuentoPrecioColectivo = 0.35;
            case 4:
                descuentoPrecioColectivo = 0.2;
            case 5:
                descuentoPrecioColectivo = 0.3;
        }
        return descuentoPrecioColectivo;
    }

    public void mensajeNumeroDiasTemporadaBaja(){
        Integer numeroDiasTemporadaBaja = super.calcularNumeroDiasTemporadaBaja(this.fechaEntrada,this.fechaSalida);
        Integer precioDiasTemporadaBaja = numeroDiasTemporadaBaja*50;
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
        Integer numeroDiasTemporadaAlta = super.calcularNumeroDiasTemporadaAlta(this.fechaEntrada, this.fechaSalida);
        Double precioDiasTemporadaAlta = numeroDiasTemporadaAlta*50*1.02;
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
        Integer numeroDiasTemporadaEspecial = super.calcularNumeroDiasTemporadaEspecial(this.fechaEntrada,this.fechaSalida);
        Double precioDiasTemporadaEspecial = numeroDiasTemporadaEspecial*50*1.03;
        if (numeroDiasTemporadaEspecial==0){
        }else{
            if (numeroDiasTemporadaEspecial>0 && numeroDiasTemporadaEspecial<=1){
                System.out.println("\t"+numeroDiasTemporadaEspecial+" dia en Temporada alta: "+precioDiasTemporadaEspecial+"€"+" (51.50€/dia)");
            } else {
                System.out.println("\t"+numeroDiasTemporadaEspecial+" dias en Temporada alta: "+precioDiasTemporadaEspecial+"€"+" (51.50€/dia)");
            }
        }

    }
    
    

    // Por alguna razon el metodo de abajo no hay que sobreescribirlo ??????

    /*public void temporadaAlta (LocalDate fechaEntrada, LocalDate fechaSalida){
        mensajeNumeroDiasTemporadaAlta();

    }*/




}
