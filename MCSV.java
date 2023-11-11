import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MCSV {

    public static ArrayList<Cliente> cargarClientes(String nombreArchivo) {
        ArrayList<Cliente> clientes = new ArrayList<>();
    
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(";");
                // Verificar si hay suficientes campos para representar un cliente
                if (partes.length >= 13) {
                    // Obtener los valores de cada campo
                    String username = partes[0];
                    String contrasenia = partes[1];
                    String tipoPlan = partes[2];
                    String nombre = partes[3];
                    String apellido = partes[4];
                    String dpi = partes[5];
                    String correo = partes[6];
                    String numeroTarjeta = partes[7];
                    int cantidadCuotas = Integer.parseInt(partes[8]);
                    String claseVuelo = partes[9];
                    int numeroAsiento = Integer.parseInt(partes[10]);
                    int cantidadMaletas = Integer.parseInt(partes[11]);
    
                    // Crear instancia de Cliente y agregar a la lista
                    Cliente cliente = new Cliente(username, contrasenia, tipoPlan, nombre, apellido, dpi, correo,
                            numeroTarjeta, cantidadCuotas, claseVuelo, numeroAsiento, cantidadMaletas);
                    clientes.add(cliente);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo de clientes");
            System.out.println(e);
        }
    
        return clientes;
    }

    public static void guardarClientes(String nombreArchivo, ArrayList<Cliente> clientes) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribe la línea de encabezados
            escritor.write("username;contrasenia;tipoPlan;nombre;apellido;dpi;correo;numeroTarjeta;cantidadCuotas;claseVuelo;numeroAsiento;cantidadMaletas");
            escritor.newLine();

            // Escribe los datos de los clientes
            for (Cliente cliente : clientes) {
                String linea = String.format("%s;%s;%s;%s;%s;%s;%s;%s;%d;%s;%d;%d",
                        cliente.getUsername(), cliente.getContrasenia(), cliente.getTipoPlan(),
                        cliente.getNombre(), cliente.getApellido(), cliente.getDpi(), cliente.getCorreo(),
                        cliente.getNumeroTarjeta(), cliente.getCantidadCuotas(), cliente.getClaseVuelo(),
                        cliente.getNumeroAsiento(), cliente.getCantidadMaletas());

                escritor.write(linea);
                escritor.newLine();
            }
            System.out.println("Datos de clientes guardados en " + nombreArchivo);
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo CSV");
            System.out.println(e);
        }
    }

    public static ArrayList<Cliente> cargarRegistrosClientes(String nombreArchivo) {
    ArrayList<Cliente> registrosClientes = new ArrayList<>();

    try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
        String linea;
        while ((linea = lector.readLine()) != null) {
            String[] partes = linea.split(";");
            // Verificar si hay suficientes campos para representar un registro de cliente
            if (partes.length >= 6) {
                // Obtener los valores de cada campo
                String username = partes[0];
                String contrasenia = partes[1];
                String nombre = partes[2];
                String apellido = partes[3];
                String correo = partes[4];
                String dpi = partes[5];

                // Crear instancia de Cliente y agregar a la lista
                Cliente registroCliente = new Cliente(username, contrasenia, "", nombre, apellido, dpi, correo, "", 0, "", 0, 0);
                registrosClientes.add(registroCliente);
                
            }
        }
    } catch (Exception e) {
        System.out.println("Error al leer el archivo de registros de clientes");
        System.out.println(e);
    }

    return registrosClientes;
}

    public static void guardarRegistrosClientes(String nombreArchivo, ArrayList<Cliente> registrosClientes) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribe la línea de encabezados
            escritor.write("username;contrasenia;nombre;apellido;correo;dpi");
            escritor.newLine();

            // Escribe los datos de los registros de clientes
            for (Cliente registroCliente : registrosClientes) {
                String linea = String.format("%s;%s;%s;%s;%s;%s",
                        registroCliente.getUsername(), registroCliente.getContrasenia(),
                        registroCliente.getNombre(), registroCliente.getApellido(),
                        registroCliente.getCorreo(), registroCliente.getDpi());

                escritor.write(linea);
                escritor.newLine();
            }
            System.out.println("Registros de clientes guardados en " + nombreArchivo);
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo de registros de clientes");
            System.out.println(e);
        }
    }
    
}
