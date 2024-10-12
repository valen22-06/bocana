/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import modelo.Habitacion;
import modelo.HabitacionDao;
import modelo.Hotel;
import modelo.HotelDao;
import vista.AlojamientosV;

/**
 *
 * @author Usuario
 */
public class AlojamientosC {
    AlojamientosV alojamientosV = new AlojamientosV();
    HabitacionDao habitacionDao = new HabitacionDao();
    List<Habitacion> datosHabitaciones = habitacionDao.listar();
    
    public AlojamientosC(AlojamientosV alojamientosV) {
        this.alojamientosV = alojamientosV;
        
        
        for(int i =0;i<datosHabitaciones.size();i++){
            this.alojamientosV.panelHotel = new JPanel();
            this.alojamientosV.gridbag = new GridBagLayout();
            this.alojamientosV.panelHotel.setLayout(this.alojamientosV.gridbag);
            this.alojamientosV.panelHotel.setPreferredSize(new Dimension(1300,160));

            this.alojamientosV.gbc = new GridBagConstraints();
            this.alojamientosV.gbc.gridx = 0;
            this.alojamientosV.gbc.gridy = 0;
            this.alojamientosV.gbc.gridwidth = 1;
            this.alojamientosV.gbc.gridheight = 3;
            
            ImageIcon img=new ImageIcon("hotel.jpeg");
            JLabel imgLabel1 = new JLabel(img);

            this.alojamientosV.panelImg = new JPanel();
            this.alojamientosV.miflow = new FlowLayout();
            this.alojamientosV.panelImg.setLayout(this.alojamientosV.miflow); 
            this.alojamientosV.panelImg.setPreferredSize(new Dimension(180,110));
            
            this.alojamientosV.panelImg.add(imgLabel1);


            this.alojamientosV.gbc.insets = new Insets(20, 20, 20, 20);
            this.alojamientosV.panelHotel.add(this.alojamientosV.panelImg,this.alojamientosV.gbc);


            this.alojamientosV.panelNombre = new JPanel();
            this.alojamientosV.miflow = new FlowLayout(FlowLayout.LEFT);
            this.alojamientosV.panelNombre.setLayout(this.alojamientosV.miflow); 
            this.alojamientosV.panelNombre.setPreferredSize(new Dimension(900,30));
            
            this.alojamientosV.ltitulo = new JLabel("Nombre hotel");
            this.alojamientosV.ltitulo.setFont(new Font("Times New Roman", Font.BOLD, 28));
            
            this.alojamientosV.panelNombre.add(this.alojamientosV.ltitulo);

            this.alojamientosV.gbc.gridx = 1;
            this.alojamientosV.gbc.gridwidth = 2;
            this.alojamientosV.gbc.gridheight = 1;
            this.alojamientosV.gbc.insets = new Insets(5, 100, 5, 5);
            this.alojamientosV.panelHotel.add(this.alojamientosV.panelNombre,this.alojamientosV.gbc);


            this.alojamientosV.panelDescripcion = new JPanel();
            this.alojamientosV.miflow = new FlowLayout(FlowLayout.LEFT);
            this.alojamientosV.panelDescripcion.setLayout(this.alojamientosV.miflow); 
            this.alojamientosV.panelDescripcion.setPreferredSize(new Dimension(900,60));
            
            String texto = datosHabitaciones.get(i).getDescripcionBreve();
            String descripcion = insertarSaltosDeLinea(texto, 100);
            
            
            this.alojamientosV.ldescripcion = new JLabel("<html>"+descripcion+"</html>");
            this.alojamientosV.ldescripcion.setFont(new Font("Times New Roman", 0, 19));

            this.alojamientosV.panelDescripcion.add(this.alojamientosV.ldescripcion);
            
            this.alojamientosV.gbc.gridy = 1;
            this.alojamientosV.gbc.insets = new Insets(5, 100, 5, 5);
            this.alojamientosV.panelHotel.add(this.alojamientosV.panelDescripcion,this.alojamientosV.gbc);


            this.alojamientosV.panelPrecio = new JPanel();
            this.alojamientosV.miflow = new FlowLayout();
            this.alojamientosV.panelPrecio.setLayout(this.alojamientosV.miflow); 
            this.alojamientosV.panelPrecio.setPreferredSize(new Dimension(180,30));
            
            this.alojamientosV.lprecio = new JLabel("$"+Double.toString( datosHabitaciones.get(i).getTarifa()));
            this.alojamientosV.lprecio.setFont(new Font("Times New Roman", Font.BOLD, 28));
            
            this.alojamientosV.panelPrecio.add(this.alojamientosV.lprecio);

            this.alojamientosV.gbc.gridy = 2;
            this.alojamientosV.gbc.gridwidth = 1;
            this.alojamientosV.gbc.insets = new Insets(5, 100, 5, 400);
            this.alojamientosV.panelHotel.add(this.alojamientosV.panelPrecio,this.alojamientosV.gbc);


            this.alojamientosV.panelBoton = new JPanel();
            this.alojamientosV.miflow = new FlowLayout();
            this.alojamientosV.panelBoton.setLayout(this.alojamientosV.miflow); 
            this.alojamientosV.panelBoton.setPreferredSize(new Dimension(300,40));
            

            this.alojamientosV.bvermas = new JButton("Ver mas");
            this.alojamientosV.bvermas.setFont(new Font("Times New Roman", 0, 20));
            this.alojamientosV.bvermas.setBackground(Color.white);
            this.alojamientosV.bvermas.setForeground(Color.BLACK);
            this.alojamientosV.bvermas.putClientProperty("valor", datosHabitaciones.get(i).getIdHabitacion());
            
            this.alojamientosV.panelBoton.add(this.alojamientosV.bvermas);

            this.alojamientosV.gbc.gridx = 2;

            this.alojamientosV.gbc.insets = new Insets(1, 20, 5, 5);
            this.alojamientosV.panelHotel.add(this.alojamientosV.panelBoton,this.alojamientosV.gbc);

            Border lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1);  // Borde de línea negra de 3 píxeles
            this.alojamientosV.panelHotel.setBorder(lineBorder);

            this.alojamientosV.gbc = new GridBagConstraints();
            this.alojamientosV.gbc.gridx = 0;
            this.alojamientosV.gbc.gridy = i;
            this.alojamientosV.gbc.gridwidth = 1;
            this.alojamientosV.gbc.gridheight = 1;

            this.alojamientosV.panelDown.add(this.alojamientosV.panelHotel,this.alojamientosV.gbc);
        }

        JScrollPane scrollPane = new JScrollPane(this.alojamientosV.panelDown);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(800, 400));
        
        this.alojamientosV.contenedor.add(scrollPane,BorderLayout.CENTER);
        

        this.alojamientosV.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.alojamientosV.setVisible(true);
        this.alojamientosV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static String insertarSaltosDeLinea(String texto, int maxCaracteres) {
        StringBuilder resultado = new StringBuilder(texto.length());
        int contador = 0;
        
        for (char c : texto.toCharArray()) {
            if (contador >= maxCaracteres && Character.isWhitespace(c)) {
                resultado.append("<br>");  // Insertar salto de línea
                contador = 0;  // Reiniciar contador
            } else {
                resultado.append(c);
                contador++;
            }
        }
        
        return resultado.toString();
    }
}


