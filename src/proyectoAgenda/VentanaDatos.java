/*
 * En esta clase tendremos los metodos de ventana sin ser la de login, tendremos los metodos necesarios
 * para crear, modificar o borrar un contacto, mostrar nuestra agenda y salir.
 */

package proyectoAgenda;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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
    JPanel pCrearContacto = new JPanel();
    JPanel pModificarContacto = new JPanel();
    JPanel pAgenda = new JPanel();
    
    int modBo;
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
    
    
    
    /*
    * Constructor que recibe un objeto de tipo VentanaLogin y un boolean el cual nos dira si esta clase es hija o no de
    * VentanaLogin. Tambien recibira un integer que nos dira si vamos a crear un usuario o a iniciar nuestra agenda.
    */
    public VentanaDatos(VentanaLogin ventanaInicial, Boolean modal, int opcion,String id)
    {
        
        super(ventanaInicial, modal);
        
        switch(opcion)
        {
            case 1:
                vcrearUsuario();
                break;
            case 2:
                agenda(id);
                break;
        }

    }
    
    /*
    * Metodo en el cual pedira los datos necesarios para crear un nuevo usuario y añadirlo a nuestra BD
    */
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
        
        /*
        * Definimos el tamaño de la ventana, no se podra redimensionar, saldra centrada en el centro y sera visible.
        */
        setSize(460, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    
    /*
    *   Metodo en el cual pedira los datos necesarios para crear un nuevo contacto y añadirlo a la agenda del usuario
    */
    public void vCrearContacto()
    {
        pCrearContacto.setLayout(null);
        
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
    
        pCrearContacto.add(bAceptar);
        pCrearContacto.add(bCancelar);
        pCrearContacto.add(lMensaje);
        pCrearContacto.add(lNombre);
        pCrearContacto.add(tFNombre);
        pCrearContacto.add(lApellidos);
        pCrearContacto.add(tFApellidos);
        pCrearContacto.add(lDireccion);
        pCrearContacto.add(tFDireccion);
        pCrearContacto.add(lPoblacion);
        pCrearContacto.add(tFPoblacion);
        pCrearContacto.add(lProvincia);
        pCrearContacto.add(tFProvincia);
        pCrearContacto.add(lNacionalidad);
        pCrearContacto.add(tFNacionalidad);
        pCrearContacto.add(lTelefono);
        pCrearContacto.add(tFTelefono);
        pCrearContacto.add(tFEMail);
        pCrearContacto.add(lEMail);
        pCrearContacto.setVisible(true);
        
        add(pCrearContacto);
        
        /*
        * Definimos el tamaño de la ventana, no se podra redimensionar, saldra centrada en el centro y sera visible.
        */
        setSize(460, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    
    }
    /*
    * Metodo que nos pedira un nombre de un contacto, cuando busquemos mostrara la ventana agenda
    * y colocara en la tabla los contactos que tengan el nombre buscado.
    */
    public void vModBorrarContacto()
    {
        pModificarContacto.setLayout(null);
        
        JLabel lMensaje = new JLabel();
        lMensaje.setText("Seleccione un contacto");
        lMensaje.setBounds(130, 30, 300, 20);
        
        lNombre = new JLabel("Nombre");
        lNombre.setBounds(90, 80, 50, 20);
        tFNombre = new JTextField();
        tFNombre.setBounds(140, 80, 100, 20);
        
        bAceptar = new JButton("Buscar");
        bAceptar.setBounds(250, 80, 80, 20);
        bAceptar.addActionListener(this);
        
        pModificarContacto.add(bAceptar);
        pModificarContacto.add(lMensaje);
        pModificarContacto.add(lNombre);
        pModificarContacto.add(tFNombre);
        
        pModificarContacto.setVisible(true);
        add(pModificarContacto);
        setSize(460, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    /*
    * Metodo que usaremos para modificar o borrar contactos que recibiremos de la tabla agenda.
    * Este metodo recibira dichos datos en un objeto de tipo ResultSet.
    */
    public void vModBoContacto(ResultSet rs)
    {
        try {
            pCrearContacto.setLayout(null);
            
            JLabel lMensaje = new JLabel();
            lMensaje.setText("El nombre y el telefono son obligatorios");
            lMensaje.setBounds(110, 20, 300, 20);
            lNombre = new JLabel("Nombre");
            lNombre.setBounds(30, 60, 50, 20);
            tFNombre = new JTextField(rs.getString("nombre"));
            tFNombre.setBounds(80, 60, 100, 20);
            lApellidos = new JLabel("Apellidos");
            lApellidos.setBounds(200, 60, 80, 20);
            tFApellidos = new JTextField(rs.getString("apellidos"));
            tFApellidos.setBounds(255, 60, 150, 20);
            
            lDireccion = new JLabel("Direccion");
            lDireccion.setBounds(30, 90, 80, 20);
            tFDireccion = new JTextField(rs.getString("direccion"));
            tFDireccion.setBounds(90, 90, 150, 20);
            
            lPoblacion = new JLabel("Poblacion");
            lPoblacion.setBounds(260, 90, 100, 20);
            tFPoblacion = new JTextField(rs.getString("poblacion"));
            tFPoblacion.setBounds(320, 90, 100, 20);
            
            lProvincia = new JLabel("Provincia");
            lProvincia.setBounds(30, 120, 100, 20);
            tFProvincia = new JTextField(rs.getString("nombre"));
            tFProvincia.setBounds(90, 120, 150, 20);
            
            lNacionalidad = new JLabel("Nacionalidad");
            lNacionalidad.setBounds(260, 120, 100, 20);
            tFNacionalidad = new JTextField(rs.getString("nacionalidad"));
            tFNacionalidad.setBounds(335, 120, 100, 20);
            
            lEMail = new JLabel("E-mail");
            lEMail.setBounds(30, 150, 80, 20);
            tFEMail = new JTextField(rs.getString("email"));
            tFEMail.setBounds(75, 150, 150, 20);
            
            lTelefono = new JLabel("Telefono");
            lTelefono.setBounds(260, 150, 100, 20);
            tFTelefono = new JTextField(rs.getString("telefono"));
            tFTelefono.setBounds(315, 150, 100, 20);
            
            bAceptar = new JButton("Aceptar");
            bAceptar.setBounds(50, 200, 100, 20);
            bAceptar.addActionListener(this);
            
            bCancelar = new JButton("Cancelar");
            bCancelar.setBounds(300, 200, 100, 20);
            bCancelar.addActionListener(this);
            
            pCrearContacto.add(bAceptar);
            pCrearContacto.add(bCancelar);
            pCrearContacto.add(lMensaje);
            pCrearContacto.add(lNombre);
            pCrearContacto.add(tFNombre);
            pCrearContacto.add(lApellidos);
            pCrearContacto.add(tFApellidos);
            pCrearContacto.add(lDireccion);
            pCrearContacto.add(tFDireccion);
            pCrearContacto.add(lPoblacion);
            pCrearContacto.add(tFPoblacion);
            pCrearContacto.add(lProvincia);
            pCrearContacto.add(tFProvincia);
            pCrearContacto.add(lNacionalidad);
            pCrearContacto.add(tFNacionalidad);
            pCrearContacto.add(lTelefono);
            pCrearContacto.add(tFTelefono);
            pCrearContacto.add(tFEMail);
            pCrearContacto.add(lEMail);
            pCrearContacto.setVisible(true);
            
            add(pCrearContacto);
            
            /*
            * Definimos el tamaño de la ventana, no se podra redimensionar, saldra centrada en el centro y sera visible.
            */
            setSize(460, 300);
            setResizable(false);
            setLocationRelativeTo(null);
            setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(VentanaDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    /*
    * Ventana que se mostrara cuando en ventana login insertemos un usuario y contraseña correcta,
    * en ella veremos una tabla con los contactos del usuario y nos dara opcion a modificar,crear o borrar dichos contactos.
    */
    public void agenda(String id)
    {
        String idUsuario=id;
        
        pAgenda.setLayout(null);
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
        
        pAgenda.add(scroll);
        pAgenda.setVisible(true);
        add(pAgenda);
        
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
                pAgenda.setVisible(false);
                pModificarContacto.setVisible(false);
                vCrearContacto();                    
                break;
                
            case "Modificar Contacto":
                pAgenda.setVisible(false);
                pCrearContacto.setVisible(false);
                modBo = 1;
                vModBorrarContacto();
                break;
            case "Borrar Contacto":
                pAgenda.setVisible(false);
                pModificarContacto.setVisible(false);
                pCrearContacto.setVisible(false);
                modBo = 2;
                vModBorrarContacto();
                break;
            case "Buscar": 
                pModificarContacto.setVisible(false);
                pCrearContacto.setVisible(false);
                agenda(null);
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
