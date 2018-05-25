/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactoryMethods;

import AbstractFactoryMethods.Aritmetica.MenuAritmetica;
import AbstractFactoryMethods.Convertor.MenuConvertor;

/**
 *
 * @author Karicha Valesska Romero Lobato <00002517@uca.edu.sv>
 */
public interface FactoryProducer {
    public static AbstractFactory getFactory(operacion calculo){
        switch (calculo){
            case ARITMETICA:
                return (AbstractFactory) new MenuAritmetica();
        
            case CONVERSION:
                return (AbstractFactory) new MenuConvertor();
                
            default:
                return null;
        }
    }
}
