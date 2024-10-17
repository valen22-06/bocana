/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import com.toedter.calendar.JDateChooser;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author estud
 */
public class ReservaV extends JFrame {

    public JDateChooser fechaInicio, fechaFin;
    public Container contenedor;
    public JLabel politicas;
    public JLabel titulo, lusuario, usuario, lnombre_habitacion, nombre_habitacion,lmonto, monto, lmetodoPago, metodoPago, lfechaInicio, lfechaFin;
    public JPanel panelNorte, panelCentro, panelSur;
    public JButton cancelar, continuar;
    public GridLayout migrid;
    public FlowLayout miflow;
    public GridBagLayout gridbag;
    public GridBagConstraints gbc;

    public ReservaV() {
        super("Reserva");
        ImageIcon fondo = new ImageIcon("fondo.jpg");
        setContentPane(new JLabel(fondo));
        contenedor = getContentPane();
        miflow = new FlowLayout();
        contenedor.setLayout(miflow);

        panelNorte = new JPanel();
        miflow = new FlowLayout();
        panelNorte.setLayout(miflow);
        
        panelCentro = new JPanel();
        migrid = new GridLayout(4,2,5,5);
        panelCentro.setLayout(migrid); 
        
        panelSur = new JPanel();
        migrid = new GridLayout(1,2,5,5);
        panelSur.setLayout(migrid);
        
        titulo = new JLabel("Reserva");
        lusuario = new JLabel("Nombre del titular:");
        lnombre_habitacion = new JLabel("Nombre de habitacion:");
        lmonto  = new JLabel("Monto:");
        lmetodoPago  = new JLabel("Metodo de pago:");
        lfechaInicio  = new JLabel("Fecha de inicio:");
        lfechaFin  = new JLabel("Fecha de fin");
        politicas  = new JLabel("Política de Cancelación del Hotel [Nombre del Hotel]\n" +
"\n" +
"Cancelación Gratuita: Los huéspedes pueden cancelar su reserva sin cargo hasta 48 horas antes de la fecha de llegada.\n" +
"\n" +
"Cancelación Tardía: Si la cancelación se realiza menos de 48 horas antes de la llegada, se aplicará un cargo equivalente a la primera noche de estancia.\n" +
"\n" +
"No Show: En caso de no presentarse sin haber realizado una cancelación previa, se cobrará el total de la reserva.\n" +
"\n" +
"Modificaciones: Las solicitudes de cambio de fecha o tipo de habitación se aceptarán sin costo, siempre que se realicen con al menos 48 horas de anticipación y estén sujetas a disponibilidad.\n" +
"\n" +
"Reservas No Reembolsables: Las tarifas promocionales y las reservas no reembolsables no permiten cancelaciones ni cambios. El pago total se cargará al momento de la reserva.\n" +
"\n" +
"Reembolsos: En caso de cancelación dentro del plazo permitido, el reembolso se procesará dentro de 7 a 10 días hábiles.");
        
        
      usuario = new JLabel();
      
        

    }
}
