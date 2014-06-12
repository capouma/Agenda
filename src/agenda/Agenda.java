/*
 * Vamos a desarrollar un proyecto para una agenda, la persona tendra primero que darse de alta y despues
 * podra insertar sus contactos.
 */

package agenda;

/**
 *
 * @author findag
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Instanciamos un objeto de tipo ventanaLogin.
        VentanaLogin ventanaInicio = new VentanaLogin();
        ventanaInicio.setVentanaInicial(ventanaInicio);
    }
    
}
