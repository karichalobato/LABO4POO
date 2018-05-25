/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactoryMethods.Convertor;

/**
 *
 * @author Karicha Valesska Romero Lobato <00002517@uca.edu.sv>
 */
public class DecimalBinario implements Convertor {
    @Override
    public String convertir(Integer e) {
        String binario="";
        while (e>=1){
            binario+=e%2;
            e=e/2;
        }
        binario+=e;
        binario = new StringBuilder(binario).reverse().toString();
        return binario;
    }
    
}
