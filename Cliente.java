import java.util.Scanner;

public class Cliente implements UsuarioBase {
    private String numeroTarjeta;
    private int cantidadCuotas;
    private String claseVuelo;
    private int numeroAsiento;
    private int cantidadMaletas;
    private String username;
    private String contrasenia;
    private String tipoPlan;
    private String nombre;
    private String apellido;
    private String dpi;
    private String correo;
    private double precioVuelo;

    // Nuevas variables
    private String fechaReserva;
    private String tipoViajeReserva;
    private int cantidadBoletosReserva;
    private String aerolineaReserva;

    private String numeroTarjetaConfirmacion;
    private int cuotasConfirmacion;
    private String claseVueloConfirmacion;

    // Constructor
    public Cliente(String username, String contrasenia, String tipoPlan, String nombre, String apellido, String dpi, String correo,
                String numeroTarjeta, int cantidadCuotas, String claseVuelo,
                int numeroAsiento, int cantidadMaletas) {
        this.numeroTarjeta = numeroTarjeta;
        this.cantidadCuotas = cantidadCuotas;
        this.claseVuelo = claseVuelo;
        this.numeroAsiento = numeroAsiento;
        this.cantidadMaletas = cantidadMaletas;
        this.username = username;
        this.contrasenia = contrasenia;
        this.tipoPlan = "base";
        this.nombre = nombre;
        this.apellido = apellido;
        this.dpi = dpi;
        this.correo = correo; 
        
        // Inicializar las nuevas variables
        this.fechaReserva = "";
        this.tipoViajeReserva = "";
        this.cantidadBoletosReserva = 0;
        this.aerolineaReserva = "";
        this.numeroTarjetaConfirmacion = "";
        this.cuotasConfirmacion = 0;
        this.claseVueloConfirmacion = "";
    }

    // Getters y setters de usuario
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    // Getters y setters de cliente
    public double getPrecioVuelo() {
        return precioVuelo;
    }
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public String getClaseVuelo() {
        return claseVuelo;
    }

    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public int getCantidadMaletas() {
        return cantidadMaletas;
    }

    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }

    // Métodos de la interfaz
    @Override
    public void cambiarTipoCliente(String nuevoTipo) {
        if ("premium".equalsIgnoreCase(nuevoTipo)) {
            this.tipoPlan = "premium";
            System.out.println("Cambiado a tipo de cliente: Premium");
        } else {
            System.out.println("Tipo de cliente no reconocido: " + nuevoTipo);
        }
    }
    
    @Override
    public void aplicarDescuento(double porcentajeDescuento) {
        // Verificar que el porcentaje de descuento sea válido (por ejemplo, entre 0 y 100)
        if (porcentajeDescuento >= 0 && porcentajeDescuento <= 100) {
            // Calcular el nuevo precio aplicando el descuento
            double factorDescuento = porcentajeDescuento / 100.0;
            double nuevoPrecio = precioVuelo - (precioVuelo * factorDescuento);

            // Asignar el nuevo precio
            this.precioVuelo = nuevoPrecio;

            System.out.println("Descuento aplicado. Nuevo precio del vuelo: " + nuevoPrecio);
        } else {
            System.out.println("Porcentaje de descuento no válido.");
        }
    }

    @Override
    public void cambiarContraseña() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la nueva contraseña: ");
        String nuevaContrasenia = scanner.nextLine();
        this.setContrasenia(nuevaContrasenia);
        System.out.println("Contraseña cambiada exitosamente.");

    }

    @Override
    public void hacerReserva(String fecha, String tipoViaje, int cantidadBoletos, String aerolinea) {
        this.fechaReserva = fecha;
        this.tipoViajeReserva = tipoViaje;
        this.cantidadBoletosReserva = cantidadBoletos;
        this.aerolineaReserva = aerolinea;
        System.out.println("Reserva realizada exitosamente.");
    }
    
    @Override
    public void hacerConfirmacion(String numeroTarjeta, int cuotas, String claseVuelo) {
        this.numeroTarjetaConfirmacion = numeroTarjeta;
        this.cuotasConfirmacion = cuotas;
        this.claseVueloConfirmacion = claseVuelo;
        System.out.println("Confirmación realizada exitosamente.");
    }
    
    @Override
    public void imprimirItinerario() {
        System.out.println("----- Itinerario -----");
        System.out.println("Fecha de Reserva: " + fechaReserva);
        System.out.println("Tipo de Viaje: " + tipoViajeReserva);
        System.out.println("Cantidad de Boletos: " + cantidadBoletosReserva);
        System.out.println("Aerolínea: " + aerolineaReserva);
        System.out.println("Número de Tarjeta para Confirmación: " + numeroTarjetaConfirmacion);
        System.out.println("Cuotas para Confirmación: " + cuotasConfirmacion);
        System.out.println("Clase de Vuelo para Confirmación: " + claseVueloConfirmacion);
        System.out.println("-----------------------");
}
}
