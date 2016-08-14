/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocajero;

/**
 *
 * @author hebertromero
 */
public class DispensadorEfectivo {
    
    private  final static int  CUENTA_INICIAL=500;
    private int cuenta;
    
    public DispensadorEfectivo(){
          cuenta=CUENTA_INICIAL;
    }
    
    public void dispensarEfectivo(int monto){
        int billetesRequeridos = monto / 20;
        cuenta -= billetesRequeridos;
    
    }
    
    public boolean haySuficienteEfectivoDisponible( int monto ){
        
          int billetesRequeridos = monto / 20;
          if ( cuenta >= billetesRequeridos )
                         return true; // hay suficientes billetes disponibles
           else
           return false;
    }
}
