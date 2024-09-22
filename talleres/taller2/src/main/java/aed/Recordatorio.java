package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = horario;
    }

    public Horario horario() {
        return horario;
    }

    public Fecha fecha() {
        return new Fecha(fecha);
    }

    public String mensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return String.format("%s @ %s %s", mensaje, fecha, horario);
    }

    @Override
    public boolean equals(Object otro) {
        if (otro == null || otro.getClass() != this.getClass()) {
            return false;
        }

        Recordatorio otroRecordatorio = (Recordatorio) otro;

        return (mensaje == otroRecordatorio.mensaje &&
                fecha.equals(otroRecordatorio.fecha) &&
                horario.equals(otroRecordatorio.horario));
    }

}
