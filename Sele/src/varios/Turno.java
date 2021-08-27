package varios;

public class Turno {

    private int turno = 1;
    private int repeticiones; //cantidad de "vueltas"
    private int cantidad; //cantidad de turnos

    public Turno(int rep, int cant) {
        repeticiones = rep;
        cantidad = cant;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public int getTurno() {
        return turno;
    }

    public synchronized void pasarTurno() {
        turno = turno + 1;
        if (turno > cantidad && repeticiones >= 0) {
            turno = 1;
            repeticiones--;
        }
    }
}
