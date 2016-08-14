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
public class BaseDatosBanco {
    
    
     private Cuenta cuentas[]; // arreglo de objetos Cuenta
     
     // el constructor sin argumentos de BaseDatosBanco inicializa a cuentas
     public BaseDatosBanco()
     {
          cuentas = new Cuenta[ 2 ]; // sólo 2 cuentas para probar
          cuentas[ 0 ] = new Cuenta( 12345, 5678, 1000.0, 1200.0 );
          cuentas[ 1 ] = new Cuenta( 98765, 56789, 200.0, 200.0 );
     }// fin del constructor sin argumentos de BaseDatosBanco
     
     // obtiene el objeto Cuenta que contiene el número de cuenta especificado
     private Cuenta obtenerCuenta( int numeroCuenta )
     {
         // itera a través de cuentas, buscando el número de cuenta que coincida
         for ( Cuenta cuentaActual : cuentas )
         {
             // devuelve la cuenta actual si encuentra una coincidencia
             if ( cuentaActual.obtenerNumeroCuenta() == numeroCuenta )
                 return cuentaActual;
         } // fin de for
         return null; // si no se encontró una cuenta que coincida, devuelve null
     } // fin del método obtenerCuenta
     // determina si el número de cuenta y el NIP especificados por el usuario coinciden
     // con los de una cuenta en la base de datos
     public boolean autenticarUsuario( int numeroCuentaUsuario, int nipUsuario )
     {
           // trata de obtener la cuenta con el número de cuenta
           Cuenta cuentaUsuario = obtenerCuenta( numeroCuentaUsuario );
           // si la cuenta existe, devuelve el resultado del método validarNIP de Cuenta
           if ( cuentaUsuario != null )
               return cuentaUsuario.validarNIP( nipUsuario );
           else
               return false; // no se encontró el número de cuenta, por lo que devuelve false
     }// fin del método  autenticarUsuario
     
     // devuelve el saldo disponible de la Cuenta con el número de cuenta especificado
     
     public double obtenerSaldoDisponible( int numeroCuentaUsuario )
     {
         return obtenerCuenta( numeroCuentaUsuario ).obtenerSaldoDisponible();
     } // fin del método obtenerSaldoDisponible
     
     // devuelve el saldo total de la Cuenta con el número de cuenta especificado
     public double obtenerSaldoTotal( int numeroCuentaUsuario )
     {
          return obtenerCuenta( numeroCuentaUsuario ).obtenerSaldoTotal();
     }// fin del método obtenerSaldoTotal
     
     // abona un monto a la Cuenta a través del número de cuenta especificado
     public void abonar( int numeroCuentaUsuario, double monto )
     {
         obtenerCuenta( numeroCuentaUsuario ).abonar( monto );
     }//fin del método abonar
     
     // carga un monto a la Cuenta con el número de cuenta especificado
     public void cargar( int numeroCuentaUsuario, double monto )
     {
         obtenerCuenta( numeroCuentaUsuario ).cargar( monto );
     }//fin del método cargar;        
     
    
}
