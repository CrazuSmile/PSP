public class Profesional {
    private String nombre;
    private int edad;
    private char genero;
    private int tipo;

    public Profesional() {
    }

    public Profesional(String nombre, int edad, char genero, int tipo) {
        this.nombre = nombre;
        this.edad = edad;
        if (genero == 'm' || genero == 'f') {
            this.genero = genero;
        } else {
            System.out.println("No es un genero valido");
        }
        if (tipo == 1 || tipo == 2 || tipo == 3) {
            this.tipo = tipo;
        } else {
            System.out.println("No existe ese tipo");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public char getGenero() {
        return genero;
    }

    public int getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(char genero) {
        if (genero == 'm' || genero == 'f') {
            this.genero = genero;
        } else {
            System.out.println("No es un genero valido");
        }
    }

    public void setTipo(int tipo) {
        if (tipo == 1 || tipo == 2 || tipo == 3) {
            this.tipo = tipo;
        } else {
            System.out.println("No existe ese tipo");
        }
    }

    @Override
    public String toString() {
        if (genero == 'm') {
            if (tipo == 1) {
                return nombre + " de " + edad + ", del genero masculino y de tipo Jugador.";
            } else if (tipo == 2) {
                return nombre + " de " + edad + ", del genero masculino y de tipo Directivo.";
            } else {
                return nombre + " de " + edad + ", del genero masculino y de tipo Fisio.";
            }
        } else {
            if (tipo == 1) {
                return nombre + " de " + edad + ", del genero femenino y de tipo Jugador.";
            } else if (tipo == 2) {
                return nombre + " de " + edad + ", del genero femenino y de tipo Directivo.";
            } else {
                return nombre + " de " + edad + ", del genero femenino y de tipo Fisio.";
            }
        }
    }
}
