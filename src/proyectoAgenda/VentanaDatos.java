/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoAgenda;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author findag
 */
public class VentanaDatos extends  JDialog implements ActionListener
{
    /*
    * Declaramos los objetos que usaremos de forma comun en esta clase
    */
    Container contenedor = getContentPane();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    
    DefaultTableModel modelo;
    JTable tabla;
    String[] cabecera = {"idusuario", "nombre", "apellidos", "direccion", "poblacion", "provincia", "nacionalidad", "telefono", "email"};
    Object[][] datos;//= obtieneDatos();
    JButton bAceptar;
    JButton bCancelar;
    
    JLabel lNombre;
    JTextField tFNombre;
    
    JLabel lApellidos;
    JTextField tFApellidos;
    
    JLabel lUsuario;
    JTextField tFUsuario;
    
    JLabel lContraseña;
    JTextField tFContraseña;
    
    JLabel lDireccion;
    JTextField tFDireccion;
    
    JLabel lPoblacion;
    JTextField tFPoblacion;
    
    JLabel lProvincia;
    JTextField tFProvincia;
    
    JLabel lNacionalidad;
    JTextField tFNacionalidad;
    
    JLabel lTelefono;
    JTextField tFTelefono;
    
    JLabel lEMail;
    JTextField tFEMail;
    
    
    
    
    public VentanaDatos(VentanaLogin ventanaInicial, Boolean modal, int opcion)
    {
        
        super(ventanaInicial, modal);
        
        switch(opcion)
        {
            case 1:
                vcrearUsuario();
                break;
            case 2:
                agenda();
                break;
        }

    }
    
    public void vcrearUsuario()
    {
        contenedor.setLayout(null);
        setTitle("Creacion de Usuario");
        
        lNombre = new JLabel("Nombre");
        lNombre.setBounds(30, 30, 50, 20);
        tFNombre = new JTextField();
        tFNombre.setBounds(80, 30, 100, 20);
        
        lApellidos = new JLabel("Apellidos");
        lApellidos.setBounds(200, 30, 80, 20);
        tFApellidos = new JTextField();
        tFApellidos.setBounds(255, 30, 150, 20);
        
        lUsuario = new JLabel("Usuario");
        lUsuario.setBounds(30, 60, 50, 20);
        tFUsuario = new JTextField();
        tFUsuario.setBounds(80, 60, 100, 20);
        
        lContraseña = new JLabel("Contraseña");
        lContraseña.setBounds(200, 60, 100, 20);
        tFContraseña = new JTextField();
        tFContraseña.setBounds(270, 60, 150, 20);
        
        lDireccion = new JLabel("Direccion");
        lDireccion.setBounds(30, 90, 80, 20);
        tFDireccion = new JTextField();
        tFDireccion.setBounds(90, 90, 150, 20);
        
        lPoblacion = new JLabel("Poblacion");
        lPoblacion.setBounds(260, 90, 100, 20);
        tFPoblacion = new JTextField();
        tFPoblacion.setBounds(320, 90, 100, 20);
        
        lProvincia = new JLabel("Provincia");
        lProvincia.setBounds(30, 120, 100, 20);
        tFProvincia = new JTextField();
        tFProvincia.setBounds(90, 120, 150, 20);
        
        lNacionalidad = new JLabel("Nacionalidad");
        lNacionalidad.setBounds(260, 120, 100, 20);
        tFNacionalidad = new JTextField();
        tFNacionalidad.setBounds(335, 120, 100, 20);
        
        lEMail = new JLabel("E-mail");
        lEMail.setBounds(30, 150, 100, 20);
        tFEMail = new JTextField();
        tFEMail.setBounds(75, 150, 180, 20);
        
        lTelefono = new JLabel("Telefono");
        lTelefono.setBounds(260, 150, 100, 20);
        tFTelefono = new JTextField();
        tFTelefono.setBounds(315, 150, 100, 20);
    
        bAceptar = new JButton("Aceptar");
        bAceptar.setBounds(50, 200, 100, 20);
        bAceptar.addActionListener(this);
    
        bCancelar = new JButton("Cancelar");
        bCancelar.setBounds(300, 200, 100, 20);
        bCancelar.addActionListener(this);
    
        contenedor.add(bAceptar);
        contenedor.add(bCancelar);
        contenedor.add(lNombre);
        contenedor.add(tFNombre);
        contenedor.add(lApellidos);
        contenedor.add(tFApellidos);
        contenedor.add(lUsuario);
        contenedor.add(tFUsuario);
        contenedor.add(lContraseña);
        contenedor.add(tFContraseña);
        contenedor.add(lDireccion);
        contenedor.add(tFDireccion);
        contenedor.add(lPoblacion);
        contenedor.add(tFPoblacion);
        contenedor.add(lProvincia);
        contenedor.add(tFProvincia);
        contenedor.add(lNacionalidad);
        contenedor.add(tFNacionalidad);
        contenedor.add(lTelefono);
        contenedor.add(tFTelefono);
        contenedor.add(tFEMail);
        contenedor.add(lEMail);

        //array donde se recogen los datos
        
        setSize(460, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    
    public void vCrearContacto()
    {
        panel1.setLayout(null);
        
        JLabel lMensaje = new JLabel();
        lMensaje.setText("El nombre y el telefono son obligatorios");
        lMensaje.setBounds(110, 20, 300, 20);
        lNombre = new JLabel("Nombre");
        lNombre.setBounds(30, 60, 50, 20);
        tFNombre = new JTextField();
        tFNombre.setBounds(80, 60, 100, 20);
        lApellidos = new JLabel("Apellidos");
        lApellidos.setBounds(200, 60, 80, 20);
        tFApellidos = new JTextField();
        tFApellidos.setBounds(255, 60, 150, 20);

        lDireccion = new JLabel("Direccion");
        lDireccion.setBounds(30, 90, 80, 20);
        tFDireccion = new JTextField();
        tFDireccion.setBounds(90, 90, 150, 20);
        
        lPoblacion = new JLabel("Poblacion");
        lPoblacion.setBounds(260, 90, 100, 20);
        tFPoblacion = new JTextField();
        tFPoblacion.setBounds(320, 90, 100, 20);
        
        lProvincia = new JLabel("Provincia");
        lProvincia.setBounds(30, 120, 100, 20);
        tFProvincia = new JTextField();
        tFProvincia.setBounds(90, 120, 150, 20);
        
        lNacionalidad = new JLabel("Nacionalidad");
        lNacionalidad.setBounds(260, 120, 100, 20);
        tFNacionalidad = new JTextField();
        tFNacionalidad.setBounds(335, 120, 100, 20);
        
        lEMail = new JLabel("E-mail");
        lEMail.setBounds(30, 150, 80, 20);
        tFEMail = new JTextField();
        tFEMail.setBounds(75, 150, 150, 20);
        
        lTelefono = new JLabel("Telefono");
        lTelefono.setBounds(260, 150, 100, 20);
        tFTelefono = new JTextField();
        tFTelefono.setBounds(315, 150, 100, 20);
    
        bAceptar = new JButton("Aceptar");
        bAceptar.setBounds(50, 200, 100, 20);
    
        bCancelar = new JButton("Cancelar");
        bCancelar.setBounds(300, 200, 100, 20);
        bCancelar.addActionListener(this);
    
        panel1.add(bAceptar);
        panel1.add(bCancelar);
        panel1.add(lMensaje);
        panel1.add(lNombre);
        panel1.add(tFNombre);
        panel1.add(lApellidos);
        panel1.add(tFApellidos);
        panel1.add(lDireccion);
        panel1.add(tFDireccion);
        panel1.add(lPoblacion);
        panel1.add(tFPoblacion);
        panel1.add(lProvincia);
        panel1.add(tFProvincia);
        panel1.add(lNacionalidad);
        panel1.add(tFNacionalidad);
        panel1.add(lTelefono);
        panel1.add(tFTelefono);
        panel1.add(tFEMail);
        panel1.add(lEMail);
        panel1.setVisible(true);
        
        add(panel1);
        setSize(460, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    
    }
    
    public void vModificarContacto()
    {
        panel2.setLayout(null);
        
        JLabel lMensaje = new JLabel();
        lMensaje.setText("Que contacto quieres modificar?");
        lMensaje.setBounds(130, 30, 300, 20);
        
        lNombre = new JLabel("Nombre");
        lNombre.setBounds(90, 80, 50, 20);
        tFNombre = new JTextField();
        tFNombre.setBounds(140, 80, 100, 20);
        
        bAceptar = new JButton("Buscar");
        bAceptar.setBounds(250, 80, 80, 20);
        bAceptar.addActionListener(this);
        
        panel2.add(bAceptar);
        panel2.add(lMensaje);
        panel2.add(lNombre);
        panel2.add(tFNombre);
        
        panel2.setVisible(true);
        add(panel2);
        setSize(460, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    public void borrar()
    {
        panel4.setLayout(null);
        JLabel lMensaje = new JLabel();
        lMensaje.setText("Que contacto quieres borrar?");
        lMensaje.setBounds(130, 30, 300, 20);
        
        lNombre = new JLabel("Nombre");
        lNombre.setBounds(90, 80, 50, 20);
        tFNombre = new JTextField();
        tFNombre.setBounds(140, 80, 100, 20);
        
        bAceptar = new JButton("Buscar");
        bAceptar.setBounds(250, 80, 80, 20);
        bAceptar.addActionListener(this);
        
        panel4.add(lMensaje);
        panel4.add(lNombre);
        panel4.add(tFNombre);
        panel4.add(bAceptar);
        add(panel4);
        panel4.setVisible(true);
        add(panel4);
        setSize(460, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    public void agenda()
    {
        panel3.setLayout(null);
        setTitle("Agenda");
        JMenuBar mBarra = new JMenuBar();
        
        JMenu mMenu = new JMenu("Opciones");
        
        JMenuItem mIOpcion1 = new JMenuItem("Crear Contacto");
        mIOpcion1.addActionListener(this);
        JMenuItem mIOpcion2 = new JMenuItem("Modificar Contacto");
        mIOpcion2.addActionListener(this);
        JMenuItem mIOpcion3 = new JMenuItem("Borrar Contacto");
        mIOpcion3.addActionListener(this);
        
        setJMenuBar(mBarra);
        mBarra.add(mMenu);
        mMenu.add(mIOpcion1);
        mMenu.add(mIOpcion2);
        mMenu.add(mIOpcion3);
        
        modelo = new DefaultTableModel(datos, cabecera);
        tabla = new JTable(modelo);
        
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(50, 80, 700, 300);
        
        panel3.add(scroll);
        panel3.setVisible(true);
        add(panel3);
        
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ev)
    {
        String auxOpcion = ev.getActionCommand();
        Agenda agenda = new Agenda();
        
        switch(auxOpcion)
        {
            case "Cancelar":
                this.dispose();
                break;
                
            case "Crear Contacto":
                panel4.setVisible(false);
                panel3.setVisible(false);
                panel2.setVisible(false);
                vCrearContacto();                    
                break;
                
            case "Modificar Contacto":
                panel4.setVisible(false);
                panel3.setVisible(false);
                panel1.setVisible(false);
                vModificarContacto();
                break;
            case "Borrar Contacto":
                panel3.setVisible(false);
                panel2.setVisible(false);
                panel1.setVisible(false);
                borrar();
                break;
            case "Buscar": 
                panel4.setVisible(false);
                panel2.setVisible(false);
                panel1.setVisible(false);
                agenda();
                break;
            case "Aceptar":
                
                Personas contacto= new Usuarios
                    (   tFUsuario.getText(),
                        tFContraseña.getText(),
                        tFNombre.getText(),
                        tFApellidos.getText(),
                        tFDireccion.getText(),
                        tFPoblacion.getText(),
                        tFProvincia.getText(),
                        tFNacionalidad.getText(),
                        tFEMail.getText(),
                        Integer.parseInt(tFTelefono.getText())
                    );
                
                agenda.crearUsuario((Usuarios)contacto);
                
                break;
        }
    }
}