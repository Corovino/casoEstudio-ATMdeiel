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
public class Cuenta {
    private int numeroCuenta;
    private int nip;
    private double saldoDisponible;
    private double saldoTotal;
    
    public Cuenta( int elNumeroDeCuenta, int elNIP,double elSaldoDisponible, double elSaldoTotal ){
         numeroCuenta = elNumeroDeCuenta;
         nip = elNIP;
         saldoDisponible = elSaldoDisponible;
         saldoTotal = elSaldoTotal;
         
    
    }
    
    // determina si un NIP especificado por el usuario coincide con el NIP en la Cuenta
    public boolean validarNIP( int nipUsuario )
    {
         if ( nipUsuario == nip )
         {
             return true;
         }else{
             return false;
         }
    }// fin del método validarNIP
    
    // devuelve el saldo disponible
    public double obtenerSaldoDisponible()
    {
         return saldoDisponible;
    }// fin de obtenerSaldoDisponible
   
    public double obtenerSaldoTotal()
    {
        return saldoTotal;
    }        
    
    // abona un monto a la cuenta
    public void abonar( double monto )
    {
       saldoTotal += monto; // lo suma al saldo total
    }        
    
    // carga un monto a la cuenta
    public void cargar( double monto )
    {
           saldoDisponible -= monto; // lo resta del saldo disponible
           saldoTotal -= monto; // lo resta del saldo total
    }        
    // devuelve el número de cuenta
    public int obtenerNumeroCuenta()
    {
        return numeroCuenta;
    }        
}
