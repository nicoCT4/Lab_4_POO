public interface UsuarioBase {
    void cambiarTipoCliente(String nuevoTipo); // Cambiar de base a premium y viceversa
    void aplicarDescuento(double porcentajeDescuento);
    void cambiarContraseña();

    // Métodos relacionados con la reserva
    void hacerReserva(String fecha, String tipoViaje, int cantidadBoletos, String aerolinea);

    // Métodos relacionados con la confirmación
    void hacerConfirmacion(String numeroTarjeta, int cuotas, String claseVuelo);
    void imprimirItinerario();
}
