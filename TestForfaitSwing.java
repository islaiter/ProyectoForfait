package forfaitNieve;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class TestForfaitSwing {
    public static void main(String[] args) {

        // Creamos un Frame general, de nombre marco, con tel texot de la ventana entre comillas

        JFrame marco = new JFrame("Nevada Sierra S.A.");

        // Decimos que el tipo de layout de marco va a ser FlowLayout

        marco.setLayout(new BorderLayout());

        // Creamos 3 JPanel, el principal va a ser el de nombre contenedor, y dentro de este estan superior
        // e inferior

        JPanel contenedor = new JPanel();
        JPanel panelSuperior = new JPanel();
        JSplitPane panelCentral = new JSplitPane();
        JPanel panelInferior = new JPanel();

        // el panel inferior se tiene que dividir en dos, uno con fechas y otro con boton y caja

        JPanel fechas = new JPanel();
        JPanel botonYCaja = new JPanel();

        // Para el panel central

        JPanel fechaEntrada = new JPanel();
        JPanel fechaSalida = new JPanel();
        JPanel periodoDias = new JPanel();

        // Para el panel inferior

        JPanel colectivo = new JPanel();
        JPanel particularidad = new JPanel();
        JPanel recomendacion = new JPanel();

        // Los dos subelementos de recomendacion

        JPanel recomendacionForfait = new JPanel();
        JPanel recomendacionBotones = new JPanel();

        // Boton confirmar fechas

        JButton confirmarFechas = new JButton("Confirmar Fechas");

        // Elegimos las dimensiones necesaras para panelSuprerior

        panelSuperior.setPreferredSize(new Dimension(800,36));

        // Creamos un label de nombre expendedorForfaits con el texto necesario y cambiamos la fuente a tahoma
        // mientras que el tamaño de la fuente sera de 18

        JLabel expendedorForfaits = new JLabel("EXPENDEDOR DE FORFAITS");
        expendedorForfaits.setFont(new Font("Tahoma",Font.PLAIN,18));

        // Para el panel superior añadimos que el border sea hacia afuera y le añadimos el label y lo añadimos
        // a contenedor, para que lo contenga completo.

        panelSuperior.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        panelCentral.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        panelInferior.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        panelSuperior.add(expendedorForfaits);

        // Creamos los bordes con los textos necesarios para fechaEntrada y salida

        // Top, left, bottom, right son los numeros

        fechaEntrada.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createTitledBorder("Fecha Entrada"), BorderFactory
                .createEmptyBorder(20, 150, 20, 150)));

        fechaSalida.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createTitledBorder("Fecha Salida"), BorderFactory
                .createEmptyBorder(20, 150, 20, 150)));

        // Hacemos lo propio con los elementos del panel inferior


        colectivo.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createTitledBorder("Colectivo"), BorderFactory
                .createEmptyBorder(80, 160, 20, 80)));

        particularidad.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createTitledBorder("Particularidad"), BorderFactory
                .createEmptyBorder(80,160,20,80)));

        recomendacion.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createTitledBorder("Recomendacion"), BorderFactory
                .createEmptyBorder(80, 160, 20, 80)));



        // Creamos 6 elementos JLabel, dia mes y año de ambas fechas

        JLabel diaFechaEntrada = new JLabel("Dia");
        JLabel mesFechaEntrada = new JLabel("Mes");
        JLabel anioFechaEntrada = new JLabel("Año");

        JLabel diaFechaSalida = new JLabel("Dia");
        JLabel mesFechaSalida = new JLabel("Mes");
        JLabel anioFechaSalida = new JLabel("Año");

        // Añadimos los elementos correspondientes a cada una de las dos fechas

        fechaEntrada.add(diaFechaEntrada);
        fechaEntrada.add(mesFechaEntrada);
        fechaEntrada.add(anioFechaEntrada);

        fechaSalida.add(diaFechaSalida);
        fechaSalida.add(mesFechaSalida);
        fechaSalida.add(anioFechaSalida);


        // Hacemos el split de panel central en dos

        panelCentral = new JSplitPane(JSplitPane.VERTICAL_SPLIT,fechas,botonYCaja);

        // Añadimos tambien fechaEntrada y fechaSalida al panel central

        fechas.add(fechaEntrada);
        fechas.add(fechaSalida);
        botonYCaja.add(confirmarFechas);
        botonYCaja.add(periodoDias);

        // Añadimos al pnale inferior los JPanel correspondientes

        panelInferior.add(colectivo);
        panelInferior.add(particularidad);
        panelInferior.add(recomendacion);

        contenedor.add(panelSuperior);

        // Ahora decimos que el borde del contenedor es hacia adentro y lo añadimos a marco

        contenedor.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        marco.add(contenedor, BorderLayout.NORTH);
        marco.add(panelCentral, BorderLayout.CENTER);
        //marco.add(panelSuperior, BorderLayout.NORTH);
        marco.add(panelInferior, BorderLayout.SOUTH);

        // Por defecto la operacion de cerrar cierra la aplicacion y libera los recursos

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacemos con pack que se reajuste al tamaño minimo

        marco.pack();

        marco.setResizable(false);

        // Hacemos el marco visible

        marco.setVisible(true);

        /*SpinnerModel model = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(model);
        JComponent editor = new JSpinner.DateEditor(spinner, "d");
        spinner.setEditor(editor);*/

        /*//fecha entrada fecha salida spinners
            SpinnerModel model = new SpinnerDateModel();
            JSpinner spinner = new JSpinner(model);
            JComponent spinnerdiaSalida = new JSpinner.DateEditor(spinner, "dd");
            JComponent spinnerMesSalida = new JSpinner.DateEditor(spinner, "MM");
            JComponent spinnerAnhoSalida = new JSpinner.DateEditor(spinner, "yyyy");
            JComponent spinnerdiaEntrada = new JSpinner.DateEditor(spinner, "dd");
            JComponent spinnerMesEntrada = new JSpinner.DateEditor(spinner, "MM");
            JComponent spinnerAnhoEntrada = new JSpinner.DateEditor(spinner, "yyyy");

            panelSalida.add(spinnerdiaSalida);
            panelSalida.add(spinnerMesSalida);
            panelSalida.add(spinnerAnhoSalida);
            panelEntrada.add(spinnerdiaEntrada);
            panelEntrada.add(spinnerMesEntrada);
            panelEntrada.add(spinnerAnhoEntrada);*/
    }
}
