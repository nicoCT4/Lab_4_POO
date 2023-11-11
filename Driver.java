/**
 * Autor: Nicolás Concuá
 * Fecha: 11/11/2023
 * Carnet: 23197
 * Universidad del Valle de Guatemala
 * Lab4-Polimorfismo
 */
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
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean go = true;
        int opcion = 0;
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
        System.out.println("------------------------------------");
        System.out.println("1. Hacer una reserva");
        System.out.println("2. Hacer una confirmación");
        System.out.println("3. Imprimir itinerario");
        System.out.println("4. Cambiar contraseña");
        System.out.println("5. Cerrar sesión");
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
    private static boolean volverAlMenu(Scanner scanner, String eleccion) {
        System.out.println("¿Desea volver" + eleccion + " (1: Sí, 0: No): ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        if (opcion == 0) {
            if (eleccion.equals(" al menú? ")) {
                System.out.println("Saliendo del programa.");

                return false;
            } else {
                System.out.println("Saliendo de la opción.");
                return false;
            }
        } else {
            return true;
        }
    }
}
