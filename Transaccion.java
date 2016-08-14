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
public abstract class Transaccion
        {
     private int  numeroCuenta;
     private Pantalla pantalla;
     private BaseDatosBanco baseDatosBanco; // base de datos de información de cuentas
     
     // el constructor de Transaccion es invocado por las subclases mediante super()
     public Transaccion( int numeroCuentaUsuario, Pantalla pantallaATM, BaseDatosBanco baseDatosBancoATM )
     {
          numeroCuenta = numeroCuentaUsuario;
          pantalla = pantallaATM;
          baseDatosBanco = baseDatosBancoATM;
     }        
     // devuelve el número de cuenta
     public int obtenerNumeroCuneta(){
          return numeroCuenta;
     }
     
     public Pantalla obtenerPantalla()
     {
              return pantalla;
      }
     
     // devuelve una referencia a la base de datos del banco
      public BaseDatosBanco obtenerBaseDatosBanco()
     {
              return baseDatosBanco;
      } // fin del método obtenerBaseDatosBanco
      
      // realiza la transacción (cada subclase sobrescribe este método)
       abstract public void ejecutar();
}
