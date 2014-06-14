/*
 * Ventana que iniciara nuestro programa, pedira un nombre de usuario y una contraseña,
 * tambien tendremos la opcion de crear un nueco usuario.
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author findag
 */
public class VentanaLogin extends JFrame implements ActionListener
{
        /*
    * Definimos los atributos
    */
    private VentanaLogin ventanaInicial;
    private int opcion;
    static Container contenedor;
    static JLabel lUsuario;
    static JLabel lClave;
    static JTextField tFUsuario;
    static JPasswordField tFClave;
    static JButton bAceptar;
    static JButton bSalir;
    static JButton bCrear;
    BaseDatos bd= new BaseDatos();
    /*
    * Creamos un constructor con unos valores determinados y que llamara al metodo
    * iniciarComponentes.
    */
    public VentanaLogin()
    {
        //LLamamos al metodo iniciarComponentes.
        iniciarComponentes();
        /*
        * Definimos titulo, tamaño de la ventana, indicamos que no se podra aumentar
        * el tamaño de dicha ventana, que la ventana aparecera en el medio, que se cerrara
        * al pulsar en la x de la ventana se cierra y que la ventana es visible.
        */
        setTitle("Bienvenido a NPCP");
        setSize(350,300);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    
    /*
    * Creamos un metodo iniciarComponentes que usaremos para llenar nuestro contenedor
    * con lo que vamos a mostrar en la ventana Login.
    */
    public void iniciarComponentes()
    {
        
        contenedor = getContentPane();
        
        //Ponemos el layout a null para dar nosotros la posicion de los distintos atributos
        contenedor.setLayout(null);
        
        /*
        * Definimos los distintos objetos que usamos, les damos tamaño y posicion y en los botones
        * le agregamos un evento de tipo actionListener
        */
        lUsuario = new JLabel("Usuario");
        lUsuario.setBounds(150, 50, 100, 20);
        
        lClave = new JLabel("Contraseña");
        lClave.setBounds(140, 100, 100, 20);
        
        tFUsuario = new JTextField("");
        tFUsuario.setBounds(100, 70, 150, 20);
        
        tFClave = new JPasswordField("");
        tFClave.setBounds(100, 120, 150, 20);
        
        bAceptar = new JButton("Aceptar");
        bAceptar.setBounds(80, 160, 80, 20);
        bAceptar.addActionListener(this);
        
        bCrear = new JButton("Crear");
        bCrear.setBounds(190, 160, 80, 20);
        bCrear.addActionListener(this);
        
        bSalir = new JButton("Salir");
        bSalir.setBounds(135, 210, 80, 20);
        bSalir.addActionListener(this);
        
        // Añadimos los distintos objetos al contenedor.
        contenedor.add(lUsuario);
        contenedor.add(tFUsuario);
        contenedor.add(lClave);
        contenedor.add(tFClave);
        contenedor.add(bAceptar);
        contenedor.add(bCrear);
        contenedor.add(bSalir);
        
    }

    /*
    * Sobreescribimos el metodo actionPerformed para que dependiendo del boton
    * pulsado nos realice una accion u otra.
    */
    @Override
    public void actionPerformed(ActionEvent ev)
    {
        if (ev.getSource() == bSalir)
        {
            System.exit(0);
        }
        else if(ev.getSource() == bAceptar)
        {
            String nombre=tFUsuario.getText();
            
            // Obtener el password 
                char passArray[] = tFClave.getPassword(); 
            // Revisar que sean letras y numeros 
                for (int i = 0; i < passArray.length; i++) 
                { 
                    char c = passArray[i];
                // Si no es letra o numero entonces no es valido 
                    if (!Character.isLetterOrDigit(c)) 
                    {
                        System.out.println("no es caracter válido");  
                    }
                } 
        
            // Convertir el password a String 
                String pass = new String(passArray);
                
                String campos[]={"id"};
                String condicional="where `nomusuario`='"+nombre+"' and `claveusuario`='"+pass+"'";
                ResultSet rs= bd.consulta("select", "usuarios", campos, null, condicional, null);
            try            
            {
                //control de resultados
                
                rs.first();
                String id=rs.getString("id");//pregunto si el resultset tiene esta columna
                                           //en caso de que no la tenga, salta una excepción
                
                /*
                recogida del valor, ID del usuario para poder usar en la ventana de contactos etc...
                aprobechando que tenemos una consulta hecha, para pasar este valor (id) e ir jugando con
                el por el programa
                */
                
                opcion = 2;
                VentanaDatos ventanados = new VentanaDatos(ventanaInicial, true, opcion, id);
                
            } catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "La clave/usuario introducido/s no es/son correctos.","Fallo autenticación", JOptionPane.WARNING_MESSAGE);
            }
                
            
        }
        else if(ev.getSource() == bCrear)
        {
            opcion = 1;
            VentanaDatos ventanados = new VentanaDatos(ventanaInicial, true, opcion,null);
        }
    }
    /**
     * @return the ventanaInicial
     */
    public VentanaLogin getVentanaInicial() {
        return ventanaInicial;
    }

    /**
     * @param ventanaInicial the ventanaInicial to set
     */
    public void setVentanaInicial(VentanaLogin ventanaInicial) {
        this.ventanaInicial = ventanaInicial;
    }
}
