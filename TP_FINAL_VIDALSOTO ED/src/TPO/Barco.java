/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO;

/**
 *
 * @author Felipe
 */
public class Barco {

    private String codigo;
    private String tipo;
    private String bandera;
    private int prioridad;
    private int numDarsena;

    public Barco(String cod, String tipo, String bandera) {
        this.codigo = cod;
        this.tipo = tipo;
        this.bandera = bandera;
    }

    public void actualizarTipo() {
        if (tipo.equalsIgnoreCase("PESQUERO")) {
            this.prioridad = 0;
        } else if (this.tipo.equalsIgnoreCase("PASAJEROS")) {
            this.prioridad = 1;
        } else {
            this.prioridad = 2;
        }
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
    
    @Override
    public String toString()
    {
        return this.codigo;
    }

    // 010. METODO QUE DEVUELVE LOS DATOS DEL BARCO EN UN STRING
    public String getDatos() {
        String datos = "";
        datos += "'Barco codigo': " + this.codigo + " | 'Tipo': " + this.tipo + " | 'Pais': " + this.bandera;
        return datos;
    }

}
