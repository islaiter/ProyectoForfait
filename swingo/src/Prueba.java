import javax.swing.*;

public class Prueba {
    private JPanel panel1;
    private JButton confirmarFechasButton;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private JSpinner spinner6;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JButton button2;
    private JButton button1;
    private JButton button3;
    private JTextArea hasSeleccionadoUnPeríodoTextArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel Principal");
        frame.setContentPane(new Prueba().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setSize(1200,500);
        frame.setVisible(true);

    }
    private void prepareGUI(){
        spinner1 = new JSpinner();
        spinner1.setSize(10,2);
    }


}