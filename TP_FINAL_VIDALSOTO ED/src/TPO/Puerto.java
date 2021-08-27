/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPO;

import ColaPrioridad.ColaPrioridad;

/**
 *
 * @author Felipe
 */
public class Puerto {

    private String nombre;
    private String pais;
    private Barco[] Darsenas;
    private int cantDarsenasLibres;
    private ColaPrioridad colaBarcos;

    public Puerto(String nombre, String pais, int cantD) {
        this.nombre = nombre;
        this.pais = pais;
        this.cantDarsenasLibres = cantD;
        this.Darsenas = new Barco[cantD];
        this.colaBarcos = new ColaPrioridad();
    }

    public Puerto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Barco[] getDarsenas() {
        return Darsenas;
    }

    public int getCantDarsenasLibres() {
        return cantDarsenasLibres;
    }

    public boolean barcosEnEspera() {
        return !this.colaBarcos.esVacia();
    }

    //Damos ingreso a una darsena un barco
    public void darAltaBarco(Barco unBarco, int prioridad) {
//        this.colaIngresoBarco.ingresarEnCola(unBarco, prioridad);
        this.colaBarcos.insertar(unBarco, prioridad);
    }

    public boolean darBajaBarco(String codigo) {
        boolean exito = false;
        int limite = this.Darsenas.length;
        if (this.cantDarsenasLibres < limite) {
            int i = 0;
            while (i < limite && !exito) {
                if (this.Darsenas[i].getCodigo().equalsIgnoreCase(codigo)) {
                    this.Darsenas[i] = null;
                    exito = true;
                    this.cantDarsenasLibres++;
                }
                i++;
            }
        }
        return exito;
    }

    //09.  ACTUALIZO DARSENAS, SI HAY ALGUNA LIBRE DEJO PASAR UN BARCO
    public boolean actualizarDarsenas() {
        boolean estado = false;
        if (!this.colaBarcos.esVacia() && this.cantDarsenasLibres != 0) {
            int cont = 0;
            int limite = this.Darsenas.length;
            while (cont < limite && this.cantDarsenasLibres > 0) {
                if (this.Darsenas[cont] == null && !this.colaBarcos.esVacia()) {
                    this.Darsenas[cont] = (Barco) this.colaBarcos.recuperarFrente();
                    this.colaBarcos.eliminarFrente();
                    this.cantDarsenasLibres--;
                }
                cont++;
            }
            estado = true;
        }
        return estado;
    }

    public boolean existeBarcoEnDarsena(String codigo) {
        boolean existe = false;
        if (this.cantDarsenasLibres < this.Darsenas.length) {
            int i = 0;
            int limite = this.Darsenas.length;
            while (i < limite && !existe) {
                if (this.Darsenas[i].getCodigo().equalsIgnoreCase(codigo)) {
                    existe = true;
                }
                i++;
            }
        }
        return existe;
    }

    public String mostrarListaDeEspera() {
        return this.colaBarcos.toString();
    }

    public String toString() {
        return this.nombre;
    }

    public boolean equals(Object buscado) {
        String b = (String) buscado.toString();
        return (this.nombre.equals(b));
    }

    public String getDatosPuerto() {
        String p = "";
        p += "Puerto: " + this.nombre + "\n" + " Darsenas: ";
        int i = 0;
        while (i < Darsenas.length && this.Darsenas[i] != null) {
            p += "\n  N°" + (i + 1) + " => Barco '" + this.Darsenas[i].getCodigo() + "' (" + this.Darsenas[i].getTipo() + ")";
            i++;
        }
        return p;
    }
}
