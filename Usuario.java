public abstract class Usuario {
    protected String username;
    protected String contrasenia;
    protected String tipoPlan;
    protected String nombre;
    protected String apellido;
    protected String dpi;
    protected String correo;

    // Constructor
    public Usuario(String username, String contrasenia, String tipoPlan,
                String nombre, String apellido, String dpi, String correo) {
        this.username = username;
        this.contrasenia = contrasenia;
        this.tipoPlan = tipoPlan;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dpi = dpi;
        this.correo = correo;
    }

    // Getters y setters
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
}


