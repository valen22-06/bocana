/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;



import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hotel extends JFrame {
    private Container contenedor;
    private GridLayout migrid;
    private FlowLayout miflow;
    private GridBagLayout gridbag;
    private GridBagConstraints gbc;
    private GridBagConstraints gbcn;
    private JLabel info, logo, lregistrar, liniciar;
    private JPanel panelsur, panelnorte, panelcentro, panel;
    private JButton iniciar, registrar, inicio;
    
    public Hotel (){
        
        super("Hoteles Bocana");
        
        contenedor = getContentPane();
        miflow = new FlowLayout(FlowLayout.CENTER);
        contenedor.setLayout(miflow);
        
        
        
        panel = new JPanel();
        miflow = new FlowLayout();
        gridbag = new GridBagLayout();
        panel.setLayout(miflow);
        
        
        info = new JLabel("<html>Alojamientos Bocana <br>Observa sin compromiso</html>");
        info.setFont(new Font("Times New Roman", 1, 20));
        info.setForeground(Color.gray);
        
       
         //panel norte
         
         
         panelnorte = new JPanel();
         miflow = new FlowLayout(FlowLayout.CENTER);
        panelnorte.setLayout(miflow);
        
         ImageIcon logoIcon = new ImageIcon("logoUno.png");
        logo = new JLabel(logoIcon);
        
        panelnorte.add(logo);
        
         gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.insets = new Insets(20, 50, 50, 50);
         
//         panel.add(panelnorte);
        
        
        
        //panel centro
        
         panelcentro = new JPanel();
         miflow = new FlowLayout();
        panelcentro.setLayout(miflow);
        
         ImageIcon inicioIcon = new ImageIcon("inicio.png");
         Image scaledImage1 = inicioIcon.getImage().getScaledInstance(100, 50, Image.SCALE_SMOOTH);
         
         inicio = new JButton(new ImageIcon(scaledImage1));
         
         panelcentro.add(inicio);
         

        gbc.gridy = 1;

         
//         panel.add(panelcentro);

         
         //panel sur
         
         panelsur = new JPanel();
         migrid = new GridLayout(2, 2, 8, 8);
        panelsur.setLayout(migrid);
         
         ImageIcon iniciarIcon = new ImageIcon("iniciarSesion.png");
         Image scaledImage2 = iniciarIcon.getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH);
         
         ImageIcon registroIcon = new ImageIcon("registro.png");
         Image scaledImage3 = registroIcon.getImage().getScaledInstance(50, 30, Image.SCALE_SMOOTH);
         
         liniciar = new JLabel("<html>¿Ya tienes una cuenta? <br>Inicia sesion</html>");
         lregistrar = new JLabel("<html>¿No tienes una cuenta? <br>Registrate</html>");
         
         iniciar = new JButton(new ImageIcon(scaledImage2));
         registrar = new JButton(new ImageIcon(scaledImage3));
         
         
         panelsur.add(liniciar);
         panelsur.add(iniciar);
         panelsur.add(lregistrar);
         panelsur.add(registrar);
         
       
        gbc.gridy = 2;
       
         
//         panel.add(panelsur);
        

        gbc.gridy = 3;

//         panel.add(info);
         
         
         
         contenedor.add(panelnorte);
         contenedor.add(panelcentro);
         contenedor.add(panelsur);

    }
}
