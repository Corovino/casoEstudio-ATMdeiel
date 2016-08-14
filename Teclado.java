/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocajero;

import java .util.Scanner;

/**
 *
 * @author hebertromero
 */
public class Teclado {
    private Scanner entrada;
    
    
    public Teclado(){
        
        entrada =  new Scanner(System.in);
    }
    
    public int obtenerEntrada(){
         return entrada.nextInt();
    }
}
