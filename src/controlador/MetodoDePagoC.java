/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.MetodoDePagoV;

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
                metodo = metodoDePago.lista.getSelectedItem().toString();
                // 'metodo' va en el controlador de pago
                System.out.print(metodo);
            }
        }

        if (e.getSource() == metodoDePago.cancelar) {
            //inicio
        }
    }
}
