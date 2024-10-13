/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import vista.FotosV;
import vista.IniciarSesionV;

/**
 *
 * @author estud
 */
public class FotosC implements ActionListener {

    FotosV vista = new FotosV();
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    
    int num;
    byte[] imagen;
    FileInputStream entrada;
    FileOutputStream salida;
    ArrayList<JLabel> fotos = new ArrayList<>();
    
    

    public FotosC(FotosV vista) {
        this.vista = vista;
        this.vista.seleccionar.addActionListener(this);
        this.vista.guardar.addActionListener(this);
        this.vista.eliminar.addActionListener(this);
        this.vista.setExtendedState(6);
        this.vista.setVisible(true);
        this.vista.setDefaultCloseOperation(3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.seleccionar) {
            if (seleccionar.showDialog(null, null) == JFileChooser.APPROVE_OPTION) {
                archivo = seleccionar.getSelectedFile();
                if (archivo.canRead()) {

                    agregarFoto(archivo);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no compatible");
                }

            }
        }

        if (e.getSource() == vista.guardar) {
            String respuesta = GuardarArchivo(archivo, imagen);
                if (respuesta != null) { 
                    JOptionPane.showMessageDialog(null, respuesta);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no guardado");

                }
        }

        if (e.getSource() == vista.eliminar) {
            try{
                 num=Integer.parseInt(JOptionPane.showInputDialog(vista,"Ingrese el numero de la imagen que desea eliminar"));
                 if(num>0 && num<fotos.size()){
                    eliminar(num);
                } else {
                    JOptionPane.showMessageDialog(vista, "El numero ingresado no coincide con la cantidad de imagenes seleccionadas");
                }
            } catch(NumberFormatException eN){
                JOptionPane.showMessageDialog(vista, "Ingrese un numero"+ eN.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }

    }

    public byte[] AbrirArchivo(File archivo) {
        byte[] imagen = new byte[1024 * 1024];
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(imagen);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo: " + e.getMessage());
        }
        return imagen;
    }

    public String GuardarArchivo(File archivo, byte[] imagen) {
        String mensaje = null;
        try {
            salida = new FileOutputStream(archivo);
            salida.write(imagen);
            mensaje = "Guardado";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo: " + e.getMessage());
        }
        return mensaje;
    }

    private void agregarFoto(File archivo) {
        int x=fotos.size()+1;
        if (archivo.getName().endsWith("jpg")
                || archivo.getName().endsWith("jpeg")
                || archivo.getName().endsWith("png")
                || archivo.getName().endsWith("PNG")) {
        

        imagen = AbrirArchivo(archivo);
        JLabel foto = new JLabel();
        JLabel text = new JLabel("Hola");
        foto.setSize(100, 100);

        ImageIcon ima = new ImageIcon(imagen);
        Image imagenEscalada = ima.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH);
        foto.setText(""+x);
        foto.setIcon(new ImageIcon(imagenEscalada));

        fotos.add(foto);
        vista.panelCentro.add(foto);
        vista.panelCentro.revalidate();
        vista.panelCentro.repaint();

        }
    }
    
    private void  eliminar(int num){
        System.out.println(fotos.size());
        vista.panelCentro.removeAll();
        fotos.remove(num-1);
        for(int i =0;i<fotos.size();i++){
            
            JLabel foto = fotos.get(i);
            foto.setText(""+(i+1));
            vista.panelCentro.add(foto);
        }
        vista.panelCentro.revalidate();
        vista.panelCentro.repaint();

    }

}
