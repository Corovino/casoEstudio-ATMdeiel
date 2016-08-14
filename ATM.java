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
public class ATM {
    
   private boolean usuarioAutenticado; // indica si el usuario es autenticado
   private int numeroCuentaActual; // número de cuenta actual del usuario
   private Pantalla pantalla; // pantalla del ATM
   private Teclado teclado; // teclado del ATM
   private DispensadorEfectivo dispensadorEfectivo; // dispensador de efectivo del ATM
   private RanuraDeposito ranuraDeposito; // ranura de depósito del ATM
   private BaseDatosBanco baseDatosBanco;
    
   // constantes correspondientes a las opciones del menú principal
  private static final int SOLICITUD_SALDO = 1;
  private static final int RETIRO = 2;
  private static final int DEPOSITO = 3;
  private static final int SALIR = 4;
  
  public ATM()
 {
        usuarioAutenticado = false; // al principio, el usuario no está autenticado
        numeroCuentaActual = 0; // al principio, no hay número de cuenta
        pantalla = new Pantalla(); // crea la pantalla
        
        teclado = new Teclado(); // crea el teclado
        dispensadorEfectivo = new DispensadorEfectivo(); // crea el dispensador deefectivo
        ranuraDeposito = new RanuraDeposito(); // crea la ranura de depósito
        baseDatosBanco = new BaseDatosBanco(); // crea la base de datos de informaciónde cuentas
} // fin del constructor sin argumentos de ATM
 
  public void run(){
            while(true){
                 while( !usuarioAutenticado )
                 {
                         pantalla.mostrarLineaMensaje("\nBienvenido");
                         autenticarUsuario();
                 }//fin del while
                 
                 realizarTransacciones(); //El usuario se autentica
                 usuarioAutenticado=false;  // restablece antes de la siguiente sesiòn  con el ATM
                 
                 numeroCuentaActual=0; // restablece antes de la siguiente sesión con elATM
                 pantalla.mostrarLineaMensaje( "“nGracias! Adios!”");
                 
            }//fin del while
  
  
  }// fin método run
  
  //método para autenticar usuario
  private void autenticarUsuario()
  {
        pantalla.mostrarMensaje("“\\nEscriba su numero de cuenta: ”");
        int numeroCuenta= teclado.obtenerEntrada();  //recibe como entrada el numero de cuenta
        
        pantalla.mostrarMensaje("“\\nEscriba su NIP: ”"); //pide el NIP
        int nip = teclado.obtenerEntrada(); // recibe como entrada el NIP
        
        // establece usuarioAutenticado con el valor booleano devuelto por la base dedatos
       usuarioAutenticado=baseDatosBanco.autenticarUsuario(numeroCuenta, nip);
       
       // verifica si la autenticación tuvo éxito
       if(usuarioAutenticado)
       {
           numeroCuentaActual =numeroCuenta; // guarda el # de cuenta del usuario
       }else{
           pantalla.mostrarMensaje("Numero de cuenta o NIP invalido. Intente de nuevo");
       }  // fin del método autenticarUsuario
       
       
              
       
       
  }
  
  // muestra el menú principal y realiza transacciones
       
       public void realizarTransacciones()
       {
            // variable local para almacenar la transacción que se procesa actualmente
           Transaccion transaccionActual=null;
           boolean usuarioSalio= false ; // el usuario no ha elegido salir
           
           // itera mientras que el usuario no haya elegido la opción para salir delsistema
           
           while(!usuarioSalio)
           {
                 // muestra el menú principal y obtiene la selección del usuario
                  int seleccionMenuPrincipal = mostrarMenuPrincipal();
                  
                  // decide cómo proceder, con base en la opción del menú seleccionada por elusuario
                  
                  switch(seleccionMenuPrincipal)
                  {
                      case SOLICITUD_SALDO:
                      case RETIRO:
                      case DEPOSITO:
                          // inicializa como nuevo objeto del tipo elegido
                          transaccionActual= crearTransaccion(seleccionMenuPrincipal);
                          transaccionActual.ejecutar(); //ejecuta la transacción 
                          break;
                      case SALIR:
                          // el usuario eligió terminar la sesión
                          pantalla.mostrarLineaMensaje( "\nCerrando el sistema..." );
                          usuarioSalio = true; // esta sesión con el ATM debe terminar
                         break;
                      default: // el usuario no introdujo un entero de 1 a 4
                            pantalla.mostrarLineaMensaje("108 \nNo introdujo una seleccion valida. Intente de nuevo." );
                          break;
                          
                  } // fin de switch
                  
           } // fin de while
       } // fin del método realizarTransacciones 
  
       // muestra el menú principal y devuelve una selección de entrada
       
       private int mostrarMenuPrincipal()
       {
             pantalla.mostrarLineaMensaje( "“\\nMenu principal:" );
             pantalla.mostrarLineaMensaje( "1 - Ver mi saldo" );
             pantalla.mostrarLineaMensaje( "2 - Retirar efectivo" );
             pantalla.mostrarLineaMensaje( "3 - Depositar fondos" );
             pantalla.mostrarLineaMensaje( "4 - Salir\\n" );
             pantalla.mostrarMensaje( "Escriba una opcion:" );  // devuelve la opcion seleccionada por elusuario
             return teclado.obtenerEntrada();
       } // fin del método mostrarMenuPrincipal
       
       // devuelve un objeto de la subclase especificada de Transaccion
       private Transaccion crearTransaccion( int tipo )
       {
           Transaccion temp = null; // variable temporal Transaccion
           switch( tipo)
           {
               case SOLICITUD_SALDO: // crea una nueva transacción SolicitudSaldo
                   temp = new SolicitudSaldo(
                             numeroCuentaActual, pantalla, baseDatosBanco );
               case RETIRO: // crea una nueva transacción Retiro139 temp
                   temp = new Retiro( numeroCuentaActual, pantalla,
                           baseDatosBanco, teclado, dispensadorEfectivo );
                   break;
              case DEPOSITO: // crea una nueva transacción Deposito
                  temp = new Deposito( numeroCuentaActual, pantalla, baseDatosBanco, teclado, ranuraDeposito );
                  break;
           } // fin de switch   
           return temp; // devuelve el objeto recién creado
       } // fin del método crearTransaccion       
       
}// fin de la clase ATM
