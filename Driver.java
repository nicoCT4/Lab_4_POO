/**
 * Autor: Nicolás Concuá
 * Fecha: 11/11/2023
 * Carnet: 23197
 * Universidad del Valle de Guatemala
 * Lab4-Polimorfismo
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *  * La clase `Driver` es la clase principal que inicia la aplicación del torneo de volleyball.
 */
public class Driver{
    /**
     * Método principal para ejecutar la aplicación.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en este programa).
     */
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean go = true;
        int opcion = 0;
        listaClientes = MCSV.cargarRegistrosClientes("InfoUsuario.csv");
        
        while(go){
            PrintMenuInicio();
            opcion = sc.nextInt();
            switch(opcion){
                case 1: // Opción para iniciar sesión
                System.out.println("Ingrese su nombre de usuario:");
                String username = sc.next();
                System.out.println("Ingrese su contraseña:");
                String contrasenia = sc.next();
            
                // Buscar al cliente en la lista
                Cliente clienteIniciado = iniciarSesion(username, contrasenia);
            
                if (clienteIniciado != null) {
                    System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + clienteIniciado.getNombre() + "!");
                    menuCliente(clienteIniciado);
            
                } else {
                    System.out.println("Nombre de usuario o contraseña incorrectos. Inténtelo de nuevo.");
                }
                break;
                        
                case 2:
                    registrarCliente(sc);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    public static void menuCliente(Cliente cliente) {
        Scanner sc = new Scanner(System.in);
        boolean loggedIn = true;

        while (loggedIn) {
            PrintMenuCliente();

            int opcionCliente = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer de entrada

            switch (opcionCliente) {
                case 1:
                    // Hacer una reserva
                    System.out.println("Ingrese la fecha de la reserva (en formato YYYY-MM-DD):");
                    String fechaReserva = sc.nextLine();
            
                    System.out.println("Ingrese el tipo de viaje (ida y vuelta o solo ida):");
                    String tipoViaje = sc.nextLine();
            
                    System.out.println("Ingrese la cantidad de boletos:");
                    int cantidadBoletos = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer de entrada
            
                    System.out.println("Ingrese la aerolínea:");
                    String aerolinea = sc.nextLine();
                    
            
                    cliente.hacerReserva(fechaReserva, tipoViaje, cantidadBoletos, aerolinea);
                    MCSV.guardarClientes("infoviajes.csv", listaClientes);
                    break;
            
                case 2:
                    // Hacer una confirmación
                    System.out.println("Ingrese el número de tarjeta para confirmación:");
                    String numeroTarjetaConfirmacion = sc.nextLine();
                    String numeroTarjetaConfirmacionHash = generarHashMD5(numeroTarjetaConfirmacion);
            
                    System.out.println("Ingrese la cantidad de cuotas para confirmación:");
                    int cuotasConfirmacion = sc.nextInt();
                    sc.nextLine(); // Limpiar el buffer de entrada
            
                    System.out.println("Ingrese la clase de vuelo para confirmación(Coach o Primera Clase:");
                    String claseVueloConfirmacion = sc.nextLine();
            
                    cliente.hacerConfirmacion(numeroTarjetaConfirmacionHash, cuotasConfirmacion, claseVueloConfirmacion);
                    MCSV.guardarClientes("infoviajes.csv", listaClientes);
                    break;
            
                case 3:
                    // Aplicar descuento
                    System.out.println("Ingrese el porcentaje de descuento:");
                    double porcentajeDescuento = sc.nextDouble();
                    sc.nextLine(); // Limpiar el buffer de entrada
            
                    cliente.aplicarDescuento(porcentajeDescuento);
                    
                    break;
            
                case 4:
                    // Imprimir itinerario
                    cliente.imprimirItinerario();
                    break;
            
                case 5:
                    // Cambiar contraseña
                    cliente.cambiarContraseña();
                    MCSV.guardarRegistrosClientes("InfoUsuario.csv", listaClientes);
                    break;
            
                case 6:
                    // Cambiar a tipo de cliente premium
                    cliente.cambiarTipoCliente("premium");
                    MCSV.guardarClientes("infoviajes.csv", listaClientes);
                    break;
            
                case 7:
                    // Salir
                    loggedIn = false;
                    System.out.println("Saliendo al menú principal.");
                    break;
            
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
                    break;
            }
            
        }
    }
    public static void PrintMenuInicio(){
        System.out.println("------------------------------------");
        System.out.println("Bienvenido a Agenia de Viajes");
        System.out.println("------------------------------------");
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Registrarse");
    }
    public static void PrintMenuCliente(){
        System.out.println("------------------------------------");
        System.out.println("Bienvenido a Agenia de Viajes");
        System.out.println("Su menu es tipo Base");
        System.out.println("------------------------------------");
        System.out.println("1. Hacer una reserva");
        System.out.println("2. Hacer una confirmación");
        System.out.println("3. Aplicar descuento");
        System.out.println("4. Imprimir itinerario");
        System.out.println("5. Cambiar contraseña");
        System.out.println("6. Cambiar a tipo de cliente premium");
        System.out.println("7. Salir");
    }
    public static String generarHashMD5(String texto) {
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(texto.getBytes());
        byte[] hash = md.digest();

        // Convertir el hash de bytes a representación hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
        return null;
    }
    }
    
    private static void registrarCliente(Scanner sc) {
        System.out.println("Ingrese su nombre de usuario:");
        String username = sc.next();
    
        System.out.println("Ingrese su contraseña:");
        String contrasenia = sc.next();
        // Utilizar el método de hash para almacenar la contraseña
        String hashedContrasenia = generarHashMD5(contrasenia);
    
        // Otros datos del cliente
        System.out.println("Ingrese su nombre:");
        String nombre = sc.next();
    
        System.out.println("Ingrese su apellido:");
        String apellido = sc.next();
    
        System.out.println("Ingrese su correo:");
        String correo = sc.next();
    
        System.out.println("Ingrese su número de DPI:");
        String dpi = sc.next();
    
        // Crear instancia de Cliente y agregar a la lista
        Cliente nuevoCliente = new Cliente(username, hashedContrasenia, "normal", nombre, apellido, dpi, correo, "", 0, "", 0, 0);
        listaClientes.add(nuevoCliente);
    
        // Guardar la información en el archivo CSV de clientes registrados
        MCSV.guardarRegistrosClientes("InfoUsuario.csv", listaClientes);
    
        System.out.println("Registro exitoso. ¡Bienvenido!");
    }

    private static Cliente iniciarSesion(String username, String contrasenia) {
        String hashedContrasenia = generarHashMD5(contrasenia);
    
        // Buscar al cliente en la lista
        for (Cliente cliente : listaClientes) {
            if (cliente.getUsername().equals(username) && cliente.getContrasenia().equals(hashedContrasenia)) {
                return cliente; // Devuelve el cliente que ha iniciado sesión
            }
        }
    
        return null; // Retorna null si no se encuentra el usuario
    }
    
    
}
