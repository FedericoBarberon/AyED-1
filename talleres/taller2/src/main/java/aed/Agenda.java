package aed;

public class Agenda {
    Fecha fecha;
    ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        fecha = new Fecha(fechaActual);
        recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String str = fecha + "\n=====\n";

        for (int i = 0; i < recordatorios.longitud(); i++) {
            Recordatorio recordatorio = recordatorios.obtener(i);

            if (fecha.equals(recordatorio.fecha())) {
                str += recordatorio + "\n";
            }
        }

        return str;
    }

    public void incrementarDia() {
        fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        return new Fecha(fecha);
    }

}
