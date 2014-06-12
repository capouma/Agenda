/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoAgenda;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoAgenda.BaseDatos;
import proyectoAgenda.Personas;

/**
 *
 * @author nelson
 */
public class Agenda
{
    public Agenda(){}
    
    BaseDatos bd= new BaseDatos();
    
    /**Pasandole un contacto y el id del usuario que lo crea, se inserta
     * en la BD
     * 
     * @param contacto
     * @param idusuario
     * @return 
     */
    public boolean crearContacto(Personas contacto,String idusuario)
    {
        //datos contacto
        String datos[]=
        {
            idusuario,
            contacto.getNombre(),
            contacto.getApellidos(),
            contacto.getDireccion(),
            contacto.getPoblacion(),
            contacto.getProvincia(),
            contacto.getNacionalidad(),
            contacto.getTelefono().toString(),
            contacto.getEmail()
        };
        
        //campos BD
        String campos[]=
        {
            "idusuario",
            "nombre",
            "apellidos",
            "direccion",
            "poblacion",
            "provincia",
            "nacionalidad",
            "telefono",
            "email"     
        };
        
        bd.consulta("insert", "contactos", campos, datos, null, null);
        
        return true;
    }
    
    public boolean borrarContacto(Personas contacto,String id)
    {
        try
        {
            String idContacto;
            
            String datos[]={"idcontacto"};
            
            String c[]=
            {
                contacto.getNombre(),
                contacto.getApellidos(),
                contacto.getDireccion(),
                contacto.getPoblacion(),
                contacto.getProvincia(),
                contacto.getNacionalidad(),
                contacto.getTelefono().toString(),
                contacto.getEmail()
            };
            
            String condicional=" where `idusuario`='"+id+"' and `telefono`="+contacto.getTelefono();
           
            ResultSet rs=bd.consulta("select", "contactos", datos, c, condicional, null);//obtenemos el id del usuario a eliminar
           
            rs.first();//nos ponemos en la primera posicion del resultset
            
           String f[]={"idcontacto"};
           String v[]={rs.getString(1)};//array con el id del contacto
           
            bd.consulta("delete", "contactos", f, v, null, null);//eliminamos el usuario
            
            return true;
            
        } catch (Exception ex)
        {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /**
     * Pasado un contacto y un array con sus valores nuevos, recogidos en
     * un array, este actualiza sus datos en la base de datos
     * 
     * @param contacto
     * @param valores
     * @return 
     */
    public boolean modificarContacto(Personas contacto,String valores[],String id)
    {
        try
        {
            BaseDatos bd = new BaseDatos();
            
            String campos[]=
            {
                "nombre",
                "apellidos",
                "direccion",
                "poblacion",
                "provincia",
                "nacionalidad",
                "telefono",
                "email"
            };
            
            String condicional=" where `idusuario`='"+id+"' and `telefono`="+contacto.getTelefono();
            ResultSet rs=bd.consulta("select", "contactos", campos, valores, condicional, null);//obtenemos el id del usuario a modificar
            
            
            bd.consulta("update", "contactos", campos, valores, null, null);
            
            return true;
        }catch(Exception ex)
        {
            return false;
        }
    }
}
