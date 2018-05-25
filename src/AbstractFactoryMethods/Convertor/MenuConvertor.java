/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactoryMethods.Convertor;

import AbstractFactoryMethods.AbstractFactory;
import AbstractFactoryMethods.Aritmetica.Aritmetica;
import static AbstractFactoryMethods.Convertor.convertir.DEC_BIN;

/**
 *
 * @author Karicha Valesska Romero Lobato <00002517@uca.edu.sv>
 */
public class MenuConvertor implements AbstractFactory {
    
     @Override
    public Convertor  convercionDecimalBinario(convertir opcion) {
        switch(opcion){
            case DEC_BIN:
                return new DecimalBinario();
                
            default:
                return null;
        }
        
    }

    @Override
    public Aritmetica getOperar(double a, double b) {
        return null;
    }
    
    
}
