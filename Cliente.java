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
        this.tipoPlan = tipoPlan;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dpi = dpi;
        this.correo = correo;

        
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
        this.tipoPlan = nuevoTipo;
    }
    @Override
    public void aplicarDescuento(double porcentajeDescuento) {
        // TODO Auto-generated method stub
    }

    @Override
    public void cambiarContraseña() {
        // TODO Auto-generated method stub
    }

    @Override
    public void hacerReserva(String fecha, String tipoViaje, int cantidadBoletos, String aerolinea) {
        // TODO Auto-generated method stub
    }

    @Override
    public void hacerConfirmacion(String numeroTarjeta, int cuotas, String claseVuelo) {
        // TODO Auto-generated method stub
    }

    @Override
    public void imprimirItinerario() {
        // TODO Auto-generated method stub
    }
}
