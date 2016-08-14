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
public class SolicitudSaldo  extends Transaccion
{
// constructor de SolicitudSaldo
public SolicitudSaldo( int numeroCuentaUsuario, Pantalla pantallaATM, BaseDatosBanco baseDatosBanco )
{
       super( numeroCuentaUsuario, pantallaATM, baseDatosBanco );
}

// realiza la transacción
@Override
public void ejecutar()
{
      // obtiene referencias a la base de datos del banco y la pantalla
      BaseDatosBanco baseDatosBanco = obtenerBaseDatosBanco();
      Pantalla pantalla = obtenerPantalla();
      
      // obtiene el saldo disponible para la cuenta implicada
      double saldoDisponible = baseDatosBanco.obtenerSaldoDisponible(  obtenerNumeroCuneta() );
      // obtiene el saldo total para la cuenta implicada
      double saldoTotal =baseDatosBanco.obtenerSaldoTotal(  obtenerNumeroCuneta() );
      // muestra la información del saldo en la pantalla
      pantalla.mostrarLineaMensaje( "\nInformacion de saldo:" );
      pantalla.mostrarMensaje( " - Saldo disponible: " );
      pantalla.mostrarMontoDolares( saldoDisponible );
      pantalla.mostrarMensaje( "\n - Saldo total: ");
      pantalla.mostrarMontoDolares( saldoTotal );
      pantalla.mostrarLineaMensaje( "");
      
      
              
}// fin del método ejecutar        
    
    
    
}
