/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Habitacion {
    public int idHabitacion;
    public String estado;
    public double tarifa;
    public String descripcionBreve;
    public String descripcionDetallada;
    public TipoHabitacion tipoHabitacion;
    public int idHotel;
    public String nombreHotel;
    public List<byte[]> imagenes;

    public Habitacion(int idHabitacion, String estado, double tarifa, String descripcionBreve, String descripcionDetallada, TipoHabitacion tipoHabitacion, int idHotel, String nombreHotel) {
        this.idHabitacion = idHabitacion;
        this.estado = estado;
        this.tarifa = tarifa;
        this.descripcionBreve = descripcionBreve;
        this.descripcionDetallada = descripcionDetallada;
        this.tipoHabitacion = tipoHabitacion;
        this.idHotel = idHotel;
        this.nombreHotel = nombreHotel;
    }
    
    public Habitacion(){
        
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public void setDescripcionBreve(String descripcionBreve) {
        this.descripcionBreve = descripcionBreve;
    }

    public String getDescripcionDetallada() {
        return descripcionDetallada;
    }

    public void setDescripcionDetallada(String descripcionDetallada) {
        this.descripcionDetallada = descripcionDetallada;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public List<byte[]> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<byte[]> imagenes) {
        this.imagenes = imagenes;
    }
        
    
    
}
