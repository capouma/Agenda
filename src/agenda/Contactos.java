/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoagenda;

/**
 *
 * @author nelson
 */
public class Contactos extends Personas
{
    public Contactos()
    {
        super();
    }
    
    public Contactos(String nombre,String apellidos,String direccion,String poblacion,String provincia,String nacionalidad,String email,Integer telefono)
    {
        super.setNombre(nombre);
        super.setApellidos(apellidos);
        super.setDireccion(direccion);
        super.setPoblacion(poblacion);
        super.setProvincia(provincia);
        super.setNacionalidad(nacionalidad);
        super.setEmail(email);
        super.setTelefono(telefono);
    }
}
