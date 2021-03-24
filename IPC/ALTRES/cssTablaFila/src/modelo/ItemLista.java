/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author jsoler
 */
public class ItemLista {
    
    private String descripcion;
    
    private int unidades;
    
    private LocalDate fechaAlta;

    /**
     * Get the value of fechaAlta
     *
     * @return the value of fechaAlta
     */
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Set the value of fechaAlta
     *
     * @param fechaAlta new value of fechaAlta
     */
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


    /**
     * Get the value of unidades
     *
     * @return the value of unidades
     */
    public int getUnidades() {
        return unidades;
    }

    /**
     * Set the value of unidades
     *
     * @param unidades new value of unidades
     */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }


    /**
     * Get the value of descripcion
     *
     * @return the value of descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Set the value of descripcion
     *
     * @param descripcion new value of descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
