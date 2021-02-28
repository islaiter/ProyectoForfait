package forfaitNieve;


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

    public void mensajeNumeroDiasTemporadaAlta (){
        Integer numeroDiasTemporadaAlta = super.calcularNumeroDiasTemporadaAlta(this.fechaEntrada, this.fechaSalida);
        Double precioDiasTemporadaAlta = numeroDiasTemporadaAlta*50*1.02;
        String respuesta = "";
        if (numeroDiasTemporadaAlta==0){
        } else {
            if (numeroDiasTemporadaAlta>=0 && numeroDiasTemporadaAlta<2){
                respuesta = "\t"+numeroDiasTemporadaAlta+" dia en Temporada alta: "+precioDiasTemporadaAlta+"€"+" 51€/dia";
                System.out.println(respuesta);
            } else {
                respuesta = "\t"+numeroDiasTemporadaAlta+" dias en Temporada alta: "+precioDiasTemporadaAlta+"€"+" 51€/dia";
                System.out.println(respuesta);
            }
        }


    }

    // Por alguna razon el metodo de abajo no hay que sobreescribirlo ??????

    /*public void temporadaAlta (LocalDate fechaEntrada, LocalDate fechaSalida){
        mensajeNumeroDiasTemporadaAlta();

    }*/




}
