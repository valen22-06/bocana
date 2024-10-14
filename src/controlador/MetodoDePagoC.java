/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.AlojamientosV;
import vista.MetodoDePagoV;
import vista.TarjetaV;

/**
 *
 * @author estud
 */
public class MetodoDePagoC implements ActionListener {

    MetodoDePagoV metodoDePago = new MetodoDePagoV();
    String metodo;

    public MetodoDePagoC(MetodoDePagoV mePa) {
        this.metodoDePago = mePa;
        this.metodoDePago.cancelar.addActionListener(this);
        this.metodoDePago.continuar.addActionListener(this);
        this.metodoDePago.setExtendedState(6);
        this.metodoDePago.setVisible(true);
        this.metodoDePago.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (metodoDePago.lista.getSelectedItem().toString() != "") {
            if (e.getSource() == metodoDePago.continuar) {
                
                    if(metodoDePago.lista.getSelectedItem().toString().equals("Tarjeta")){
                        TarjetaV tarjetaV = new TarjetaV();
                        TarjetaC tarjetaC = new TarjetaC(tarjetaV);
                    } else {
                        metodo = metodoDePago.lista.getSelectedItem().toString();
                    }
            } 
             
        }

        if (e.getSource() == metodoDePago.cancelar) {
            
                        AlojamientosV aloja = new AlojamientosV();
                        AlojamientosC al = new AlojamientosC(aloja);
                        
        }
    }
}
