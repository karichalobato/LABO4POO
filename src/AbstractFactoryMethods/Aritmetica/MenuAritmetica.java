/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactoryMethods.Aritmetica;

import AbstractFactoryMethods.AbstractFactory;
import AbstractFactoryMethods.Convertor.Convertor;

/**
 *
 * @author Karicha Valesska Romero Lobato <00002517@uca.edu.sv>
 */
public class MenuAritmetica implements AbstractFactory {
     @Override
    public Convertor convercionDecimalBinario() {
        return null;
    }

    @Override
    public Aritmetica getOperar(resultadoArit operation) {
        
        switch(operation){
            case SUMA:
                return new Sumar();
            case RESTA:
                return new Restar();
                
            case MULTIPLICACION:
                return new Multiplicar();
                
            case DIVISION:
                return new Dividir();
                
            default: 
                return null;
        }
        
    }
    
}
