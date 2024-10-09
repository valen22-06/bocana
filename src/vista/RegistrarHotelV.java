/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class RegistrarHotelV extends JFrame{
    public Container contenedor;
    public JLabel lregistrar;
    public JLabel lnit;
    public JLabel lnombreHotel;
    public JLabel ldireccion;
    public JLabel lnumeroHabitaciones;
    public JLabel ltiposervicio;
    public JTextField tnit;
    public JTextField tnombreHotel;
    public JTextField tdireccion;
    public JTextField tnumeroHabitaciones;
    public JButton bregistrar;
    public JButton bcancelar;
    public JButton bwifi, bgym, bpiscina, bac, brestaurante, brecepcion24horas, bplaya, bsauna, bbar;
    public JPanel panelBag;
    public JPanel panel;
    public JPanel panelNorte;
    public JPanel panelCentro;
    public JPanel panelSur;
    public JPanel panelServicios;
    private GridLayout migrid;
    private FlowLayout miflow;
    private GridBagLayout gridbag;
    private GridBagConstraints gbc;
    private GridBagConstraints gbcn;
    
    
    public RegistrarHotelV(){
        
        super("Registrar Hotel");
        
        
        contenedor = getContentPane();
        miflow = new FlowLayout();
        contenedor.setLayout(miflow);
        
        panel = new JPanel();
        gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
        
        //panelNorte
        panelNorte = new JPanel();
        miflow = new FlowLayout();
        panelNorte.setLayout(miflow);
        
        
        lregistrar = new JLabel("Registrar Hotel");
        lregistrar.setFont(new Font("Times New Roman", 1, 80));
        
        
        panelNorte.add(lregistrar);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(20, 100, 50, 100);
        
        panel.add(panelNorte, gbc);
        
        
        //panelCentro
        panelCentro = new JPanel();
        migrid = new GridLayout(4, 2, 80, 8);
        panelCentro.setLayout(migrid);
        
        lnit = new JLabel("NIT");
        lnit.setFont(new Font("Times New Roman", 0, 30));
        lnombreHotel = new JLabel("Nombre del hotel");
        lnombreHotel.setFont(new Font("Times New Roman", 0, 30));
        ldireccion = new JLabel("Direccion");
        ldireccion.setFont(new Font("Times New Roman", 0, 30));
        lnumeroHabitaciones = new JLabel("Numero de habitaciones");
        lnumeroHabitaciones.setFont(new Font("Times New Roman", 0, 30));

        tnit = new JTextField(10);
        tnit.setFont(new Font("Times New Roman", 0, 25));
        tnombreHotel = new JTextField(10);
        tnombreHotel.setFont(new Font("Times New Roman", 0, 25));
        tdireccion = new JTextField(10);
        tdireccion.setFont(new Font("Times New Roman", 0, 25));
        tnumeroHabitaciones = new JTextField(10);
        tnumeroHabitaciones.setFont(new Font("Times New Roman", 0, 25));

        
        panelCentro.add(lnit);
        panelCentro.add(tnit);
        panelCentro.add(lnombreHotel);
        panelCentro.add(tnombreHotel);
        panelCentro.add(ldireccion);
        panelCentro.add(tdireccion);
        panelCentro.add(lnumeroHabitaciones);
        panelCentro.add(tnumeroHabitaciones);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 50, 30, 50);
        
        panel.add(panelCentro, gbc);
        
        //panelServicios
        
        panelServicios = new JPanel();
        migrid = new GridLayout(3,3,5,5);
        panelServicios.setLayout(migrid);
        
        ltiposervicio = new JLabel("Tipos de servicios");
        ltiposervicio.setFont(new Font("Times New Roman", 0, 30));
        
        bwifi = new JButton("Wifi");
        bwifi.setFont(new Font("Times New Roman", 0, 20)); 
        bwifi.setContentAreaFilled(false);
        bwifi.setForeground(Color.BLACK);
       
        bgym = new JButton("GYM");
        bgym.setFont(new Font("Times New Roman", 0, 20));
        bgym.setContentAreaFilled(false);
        bgym.setForeground(Color.BLACK);
        
        bpiscina = new JButton("Piscina");
        bpiscina.setFont(new Font("Times New Roman", 0, 20)); 
        bpiscina.setContentAreaFilled(false);
        bpiscina.setForeground(Color.BLACK);
       
        bac = new JButton("Aire acondicionado");
        bac.setFont(new Font("Times New Roman", 0, 20));
        bac.setContentAreaFilled(false);
        bac.setForeground(Color.BLACK);
        
        brestaurante = new JButton("Restaurante");
        brestaurante.setFont(new Font("Times New Roman", 0, 20)); 
        brestaurante.setContentAreaFilled(false);
        brestaurante.setForeground(Color.BLACK);
       
        brecepcion24horas = new JButton("Recepcion 24 horas");
        brecepcion24horas.setFont(new Font("Times New Roman", 0, 20));
        brecepcion24horas.setContentAreaFilled(false);
        brecepcion24horas.setForeground(Color.BLACK);
        
        bplaya = new JButton("Playa");
        bplaya.setFont(new Font("Times New Roman", 0, 20)); 
        bplaya.setContentAreaFilled(false);
        bplaya.setForeground(Color.BLACK);
       
        bsauna = new JButton("Sauna");
        bsauna.setFont(new Font("Times New Roman", 0, 20));
        bsauna.setContentAreaFilled(false);
        bsauna.setForeground(Color.BLACK);
        
        bbar = new JButton("Bar");
        bbar.setFont(new Font("Times New Roman", 0, 20)); 
        bbar.setContentAreaFilled(false);
        bbar.setForeground(Color.BLACK);

        
        panelServicios.add(bwifi);
        panelServicios.add(bgym);
        panelServicios.add(bpiscina);
        panelServicios.add(bac);
        panelServicios.add(brecepcion24horas);
        panelServicios.add(brestaurante);
        panelServicios.add(bplaya);
        panelServicios.add(bsauna);
        panelServicios.add(bbar);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 50, 15, 50);
        
        panel.add(ltiposervicio, gbc);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 50, 30, 50);
        
        panel.add(panelServicios, gbc);
        
        //panelSur
        panelSur = new JPanel();
        migrid = new GridLayout(1, 2, 8, 8);
        panelSur.setLayout(migrid);
        
        
        bcancelar = new JButton("Cancelar");
        bcancelar.setFont(new Font("Times New Roman", 0, 20));
        
        bcancelar.setContentAreaFilled(false);
        bcancelar.setForeground(Color.BLACK);
        
        bregistrar = new JButton("Registrar");
        bregistrar.setFont(new Font("Times New Roman", 0, 20));
        
        bregistrar.setContentAreaFilled(false);
        bregistrar.setForeground(Color.BLACK);
        
        panelSur.add(bcancelar);
        panelSur.add(bregistrar);
        
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 50, 10, 50);
        
        panel.add(panelSur, gbc);
        
        

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(800, 600)); // Establece un tamaño preferido para el JScrollPane

        
        contenedor.add(scrollPane);
        
    
    }
}
