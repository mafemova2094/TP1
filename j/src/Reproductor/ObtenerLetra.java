/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reproductor;

/**
 * Librerías necesarias para Obtener la letra de las canciones
 * @author Mau
 */
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
 
/**
 *
 * @author Mau Clase Obtener letra
 */
public class ObtenerLetra {
 
   private final static String url = "http://www.songlyrics.com"; // URL de donde se toman las letras
 
    /**
     *
     * @param Artista información requerida
     * @param Nombre información requerida
     * @return letra de la canción 
     * @throws IOException si no se encuentra la canción
     */
    public  String getLetra( String Artista, String Nombre) throws IOException {
     String letra = Nombre+"\n";
     Document pagina = Jsoup.connect(url+ "/"+Artista.replace(" ", "-").toLowerCase()+"/"+Nombre.replace(" ", "-").toLowerCase()+"-lyrics/").get();
     String titulo = pagina.title();
     Element p = pagina.select("p.songLyricsV14").get(0);
      for (Node e: p.childNodes()) {
          if (e instanceof TextNode) {
            letra=letra +((TextNode)e).getWholeText();
          }
      }
 
     return letra;
   }

    /**
     *
     * @param args Main de la clase Obtener letra
     * @throws IOException
     */
    public static void main(String args[]) throws IOException{
       ObtenerLetra h=new ObtenerLetra();
       
       System.out.println(h.getLetra("Ricardo Arjona", "Fuiste tu"));
       
       
       
   }



}