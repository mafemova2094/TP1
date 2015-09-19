
package WebService; // nombre del paquete

import java.io.BufferedReader; // librería necesaria leer
import java.io.BufferedWriter; // librería necesaria escribir
import java.io.FileWriter; // librería necesaria escritor de archivo
import java.io.IOException; // librería necesaria excepción
import java.io.InputStreamReader; // librería necesaria 
import java.net.MalformedURLException; // librería necesaria excepción de URL 
import java.net.URL; // librería necesaria para el URL
import java.net.URLConnection; // librería necesaria para establecer conexión con URL

/**
 *
 * @author Mau clase EjemploConexion
 */
public class EjemploConexion {

    /**
     *
     * @param args 
     * @throws MalformedURLException excepción 
     * @throws IOException excepción si no sirve
     */
    public static void main(String[] args) throws MalformedURLException, IOException{
        // Para cambiar el tipo de búsqueda, solo cambia en el link lo que dice "artist" por "album" o "title"
        // lo que va después de los dos puntos, por ejemplo aquí metallica, es la busqueda ingresada.
        URL url = new URL("http://musicbrainz.org/ws/2/cdstub/?query=title:metallica"); /// instanciación del URL 
        URLConnection connection = url.openConnection(); // establece la conexión con el servidor
        
        BufferedReader reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        //Una vez realizada la búsqueda, 
        BufferedWriter out = new BufferedWriter(new FileWriter("archivo.xml")); // Archivo xml 
        out.write(reader.readLine()); // lectura / escritura del xml
        out.close();
    }
    
}
