package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] recordatorios;

    public ArregloRedimensionableDeRecordatorios() {
        recordatorios = new Recordatorio[0];
    }

    public int longitud() {
        return recordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] nuevosRecordatorios = new Recordatorio[recordatorios.length + 1];

        for (int j = 0; j < recordatorios.length; j++) {
            nuevosRecordatorios[j] = recordatorios[j];
        }

        nuevosRecordatorios[recordatorios.length] = i;

        recordatorios = nuevosRecordatorios;
    }

    public Recordatorio obtener(int i) {
        return recordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] nuevosRecordatorios = new Recordatorio[recordatorios.length - 1];

        for (int i = 0; i < nuevosRecordatorios.length; i++) {
            nuevosRecordatorios[i] = recordatorios[i];
        }

        recordatorios = nuevosRecordatorios;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        recordatorios[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        recordatorios = new Recordatorio[vector.longitud()];

        for (int i = 0; i < recordatorios.length; i++) {
            recordatorios[i] = vector.obtener(i);
        }
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        return new ArregloRedimensionableDeRecordatorios(this);
    }
}
