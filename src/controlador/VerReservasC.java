/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.Hotel;
import modelo.HotelDao;
import modelo.Reserva;
import modelo.ReservaDao;
import modelo.Usuario;
import vista.UsuarioV;
import vista.VerReservasV;

/**
 *
 * @author Usuario
 */
public class VerReservasC implements ActionListener{
    VerReservasV verReservasV = new VerReservasV();
    Usuario usuario = new Usuario();
    Hotel hotel = new Hotel();
    HotelDao hotelDao = new HotelDao();
    ReservaDao reservaDao = new ReservaDao();
    Reserva reserva;
    
    
    public VerReservasC(VerReservasV verReservasV, Usuario usuario){
        this.verReservasV=verReservasV;
        this.usuario=usuario;
        this.reserva=new Reserva();
        List<Reserva> reservas = new ArrayList<>();
        if(usuario.getIdRol()==4){
            System.out.println("hola");
            List<Hotel> hoteles = hotelDao.listar();
            for(int i=0;i<hoteles.size();i++){
                if(hoteles.get(i).getUsuario().getIdUsuario()==usuario.getIdUsuario()){
                    reservas = reservaDao.listarPorHotel(hoteles.get(i).getIdHotel());
                    break;
                }
            }
            
        }else{
            reservas = reservaDao.listarPorUsuario(usuario.getIdUsuario());
        }
        
        
        JPanel panel = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        panel.setLayout(gridbag);
        
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(2, 10, 2, 20);
        gbc.anchor = GridBagConstraints.WEST;
        
        JPanel panelPosicion = new JPanel();
        FlowLayout flow = new FlowLayout(FlowLayout.LEFT);
        panelPosicion.setLayout(flow);
        panelPosicion.setPreferredSize(new Dimension(200,100));
        
        JLabel lposicion = new JLabel();
        lposicion.setText("Posicion");
        lposicion.setFont(new Font("Times New Roman", 1, 30));
        
        panelPosicion.add(lposicion);
        gbc.gridx = 0;
        panel.add(panelPosicion,gbc);

        JPanel panelfechaInicio = new JPanel();
        flow = new FlowLayout(FlowLayout.LEFT);
        panelfechaInicio.setLayout(flow);
        panelfechaInicio.setPreferredSize(new Dimension(200,100));
        
        JLabel lfechaInicio = new JLabel();
        lfechaInicio.setText("Fecha inicio");
        lfechaInicio.setFont(new Font("Times New Roman", 1, 30));
        
        panelfechaInicio.add(lfechaInicio);
        gbc.gridx = 1;
        panel.add(panelfechaInicio,gbc);
        
        JPanel panelfechaFin = new JPanel();
        flow = new FlowLayout(FlowLayout.LEFT);
        panelfechaFin.setLayout(flow);
        panelfechaFin.setPreferredSize(new Dimension(200,100));

        JLabel lfechaFin = new JLabel();
        lfechaFin.setText("Fecha fin");
        lfechaFin.setFont(new Font("Times New Roman", 1, 30));

        panelfechaFin.add(lfechaFin);
        gbc.gridx = 2;
        panel.add(panelfechaFin,gbc);
        
        JPanel panelestado = new JPanel();
        flow = new FlowLayout(FlowLayout.LEFT);
        panelestado.setLayout(flow);
        panelestado.setPreferredSize(new Dimension(200,100));
        
        JLabel lestado = new JLabel();
        lestado.setText("Estado");
        lestado.setFont(new Font("Times New Roman", 1, 30));

        panelestado.add(lestado);
        gbc.gridx = 3;
        panel.add(panelestado,gbc);
        
        JPanel panelhabitacion = new JPanel();
        flow = new FlowLayout(FlowLayout.LEFT);
        panelhabitacion.setLayout(flow);
        panelhabitacion.setPreferredSize(new Dimension(200,100));
        
        JLabel lhabitacion = new JLabel();
        lhabitacion.setText("Habitacion");
        lhabitacion.setFont(new Font("Times New Roman", 1, 30));
        
        panelhabitacion.add(lhabitacion);

        gbc.gridx = 4;
        panel.add(panelhabitacion,gbc);
        
        if(usuario.getIdRol()==4){
            JPanel panelUsuario = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelUsuario.setLayout(flow);
            panelUsuario.setPreferredSize(new Dimension(200,100));

            JLabel lusuario = new JLabel();
            lusuario.setText("Usuario");
            lusuario.setFont(new Font("Times New Roman", 1, 30));

            panelUsuario.add(lusuario);
            
            gbc.gridx = 5;
            panel.add(panelUsuario,gbc);
        }else{
            JPanel panelhotel = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelhotel.setLayout(flow);
            panelhotel.setPreferredSize(new Dimension(200,100));

            JLabel lhotel = new JLabel();
            lhotel.setText("Hotel");
            lhotel.setFont(new Font("Times New Roman", 1, 30));

            panelhotel.add(lhotel);

            gbc.gridx = 5;
            panel.add(panelhotel,gbc);
        }
        
        
        
        gbc.gridy = 0;
        gbc.gridx = 0;
        this.verReservasV.panelReservas.add(panel,gbc);
        
        for(int i =0;i<reservas.size();i++){
            panel = new JPanel();
            gridbag = new GridBagLayout();
            panel.setLayout(gridbag);
            
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
            gbc.insets = new Insets(2, 10, 2, 10);
            gbc.anchor = GridBagConstraints.CENTER;
            
            panelPosicion = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelPosicion.setLayout(flow);
            panelPosicion.setPreferredSize(new Dimension(200,100));
            
            lposicion = new JLabel();
            int p = i+1;
            lposicion.setText(Integer.toString(p));
            lposicion.setFont(new Font("Times New Roman", 0, 25));
            
            panelPosicion.add(lposicion);
            
            gbc.gridx = 0;
            gbc.gridy = p;
            panel.add(panelPosicion,gbc);
            
            panelfechaInicio = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelfechaInicio.setLayout(flow);
            panelfechaInicio.setPreferredSize(new Dimension(200,100));
            
            lfechaInicio = new JLabel();
            lfechaInicio.setText(reservas.get(i).getFechaInicio());
            lfechaInicio.setFont(new Font("Times New Roman", 0, 25));
            
            panelfechaInicio.add(lfechaInicio);
            
            gbc.gridx = 1;
            gbc.gridy = p;
            panel.add(panelfechaInicio,gbc);
            
            panelfechaFin  = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelfechaFin.setLayout(flow);
            panelfechaFin.setPreferredSize(new Dimension(200,100));
            
            lfechaFin = new JLabel();
            lfechaFin.setText(reservas.get(i).getFechaFin());
            lfechaFin.setFont(new Font("Times New Roman", 0, 25));
            
            panelfechaFin.add(lfechaFin);
            
            gbc.gridx = 2;
            gbc.gridy = p;
            panel.add(panelfechaFin,gbc);
            
            panelestado  = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelestado.setLayout(flow);
            panelestado.setPreferredSize(new Dimension(200,100));
            
            lestado = new JLabel();
            lestado.setText(reservas.get(i).getEstado());
            lestado.setFont(new Font("Times New Roman", 0, 25));
            
            panelestado.add(lestado);
            
            gbc.gridx = 3;
            gbc.gridy = p;
            panel.add(panelestado,gbc);
            
            panelhabitacion  = new JPanel();
            flow = new FlowLayout(FlowLayout.LEFT);
            panelhabitacion.setLayout(flow);
            panelhabitacion.setPreferredSize(new Dimension(200,100));
            
            lhabitacion = new JLabel();
            lhabitacion.setText(reservas.get(i).getHabitacion().getNombreHabitacion());
            lhabitacion.setFont(new Font("Times New Roman", 0, 25));
            
            panelhabitacion.add(lhabitacion);
            
            gbc.gridx = 4;
            gbc.gridy = p;
            panel.add(panelhabitacion,gbc);
            
            if(usuario.getIdRol()==4){
                JPanel panelUsuario  = new JPanel();
                flow = new FlowLayout(FlowLayout.LEFT);
                panelUsuario.setLayout(flow);
                panelUsuario.setPreferredSize(new Dimension(200,100));

                JLabel lusuario = new JLabel();
                lusuario.setText(reservas.get(i).getUsuario().getNombre1()+" "+reservas.get(i).getUsuario().getApellido1());
                lusuario.setFont(new Font("Times New Roman", 0, 25));

                panelUsuario.add(lusuario);

                gbc.gridx = 5;
                gbc.gridy = p;
                panel.add(panelUsuario,gbc);
            }else{
                JLabel panelhotel  = new JLabel();
                flow = new FlowLayout(FlowLayout.LEFT);
                panelhotel.setLayout(flow);
                panelhotel.setPreferredSize(new Dimension(200,100));

                JLabel lhotel = new JLabel();
                lhotel.setText(reservas.get(i).getHabitacion().getHotel().getNombreHotel());
                lhotel.setFont(new Font("Times New Roman", 0, 25));

                panelhotel.add(lhotel);

                gbc.gridx = 5;
                gbc.gridy = p;
                panel.add(panelhotel,gbc);
            }
            
            gbc.gridx = 0;
            gbc.gridy = p;
            gbc.insets = new Insets(2, 10, 2, 10);
            this.verReservasV.panelReservas.add(panel,gbc);
        }
        
        
        
        this.verReservasV.bvolver.addActionListener(this);
        this.verReservasV.setExtendedState(6);
        this.verReservasV.setVisible(true);
        this.verReservasV.setDefaultCloseOperation(3);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==verReservasV.bvolver){
            UsuarioV usuarioV = new UsuarioV();
            UsuarioC usuarioC = new UsuarioC(usuarioV, usuario);
        }
        
    }
}
