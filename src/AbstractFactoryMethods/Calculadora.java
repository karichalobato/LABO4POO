/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactoryMethods;


import AbstractFactoryMethods.Aritmetica.resultadoArit;
import AbstractFactoryMethods.Convertor.Convertor;
import AbstractFactoryMethods.Convertor.convertir;
import AbstractFactoryMethods.FactoryProducer;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;


/**
 *
 * @author Karicha Valesska Romero Lobato <00002517@uca.edu.sv>
 */
public class Calculadora extends JPanel {
    private int WIDTH=500, HEIGHT =300;
    private int widthTF=60, heightTF =20;
    private int widthBT=70, heightBT =30;
    private int widthR = 460,heightR = 30;
        
        
        JButton btn_BinarioDecimal, btn_Sumar, btn_Restar,btn_Multiplicar, btn_Dividir;


        JTextField textfield1, textfield2, textfield3,txt_resultado, field;
        private AbstractFactory factory;
        private Double a;
        private Double b;
        private Integer num;
                

    public Calculadora () {
        //Declaracion de botones.
        this.btn_BinarioDecimal = new JButton("Binario/Decimal");
        this.btn_Sumar = new JButton("+");
        this.btn_Restar = new JButton("-");
        this.btn_Multiplicar = new JButton("*");
        this.btn_Dividir = new JButton("/");
        
        //Declaracion de etiquetas.
        this.textfield1 = new JTextField();
        this.textfield2 = new JTextField();
        this.textfield3 = new JTextField();
        this.field = new JTextField();
        this.txt_resultado = new JTextField();
        
        //Posicionar botones.
        btn_BinarioDecimal.setBounds(250, 120, widthBT, heightBT);
        btn_Sumar.setBounds(20, 120, widthBT,heightBT);
        btn_Restar.setBounds(95, 120, widthBT,heightBT);
        btn_Multiplicar.setBounds(20, 155, widthBT,heightBT);
        btn_Dividir.setBounds(95, 155, widthBT,heightBT);
        
        
        //Posicionar etiquetas.
        textfield1.setBounds(20,60,widthTF,heightTF);
        textfield2.setBounds(85,60,widthTF,heightTF);
        textfield3.setBounds(250,65,widthTF,heightTF);
        txt_resultado.setBounds(20,20,widthR,heightR);
        
        field.setBounds(20, 260,280,30);
        
        //Creando eventos de botones.
        btn_BinarioDecimal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_Convertor(convertir.DEC_BIN);
            }
        });
        
        btn_Sumar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_Aritmetica(resultadoArit.SUMA);
            }
        });
        
        btn_Restar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn_Aritmetica(resultadoArit.RESTA);

            }
        });
        
        btn_Multiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn_Aritmetica(resultadoArit.MULTIPLICACION);

            }
        });
        
        btn_Dividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btn_Aritmetica(resultadoArit.DIVISION);

            }
        });
        
        txt_resultado.setEditable(false);
        textfield1.setEditable(true);
        textfield2.setEditable(true);
        textfield3.setEditable(true);
        field.setEditable(false);



        add(txt_resultado);
        add(textfield1);
        add(textfield2);
        add(textfield3);
        add(btn_Sumar);
        add(btn_Restar);
        add(btn_Multiplicar);
        add(btn_Dividir);
        add(btn_BinarioDecimal);
        add(field);

        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    private void getFieldsText(operacion calculo){
        try{
            if (calculo==operacion.ARITMETICA){

                a = Double.parseDouble(textfield1.getText());
                b = Double.parseDouble(textfield2.getText());
            }else if (calculo==operacion.CONVERSION) {
                        num = Integer.parseInt(textfield3.getText());
                }
        }catch(NumberFormatException extp){
            field.setText("Verificar valores ingresados");
        }

    }


    private void btn_Aritmetica(resultadoArit operation){
        getFieldsText(operacion.ARITMETICA);
        factory = FactoryProducer.getFactory(operacion.ARITMETICA);
        try {
            Double total;
            total = factory.getOperar(operation).operation(a,b);
            txt_resultado.setText(total.toString());
            field.setText(null);
            }catch(NullPointerException expt){}
    }


    private void btn_Convertor(Convertor opcion){
        getFieldsText(operacion.CONVERSION);
        factory =FactoryProducer.getFactory(operacion.CONVERSION);
        try {
            String total;
            total = factory.getconvercionDecimalBinario(opcion).convertir(num);
            txt_resultado.setText(total);
            field.setText(null);

        }catch (NullPointerException expt){}

    }


    
}
