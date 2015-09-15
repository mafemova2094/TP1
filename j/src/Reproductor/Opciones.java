package Reproductor;

import javazoom.jlgui.basicplayer.BasicPlayer;
import java.io.File;

   /**
    * Clase Reproductor
    */ 
public class Opciones {

    /**
     *Varible player, el cual es de la clase BasicPlayer
     */
    public BasicPlayer player;
    
    /**
    * Constructor de la clase reproductor
    */
   public Opciones(){
       player = new BasicPlayer();
   }
   
   /**
    * Metodo que reproduce la canción
    * @throws Exception 
    */
   public void Play() throws Exception {
        player.play();
   }
   
   /**
    * Metodo que abre el archivo
    * @param ruta
    * @throws Exception 
    */
   public void Open(String ruta) throws Exception {
       if (ruta != null ){
           player.open(new File(ruta));
       }
   }
   
   /**
    * Pone pausa a la cancion que se reproduce actualmente
    * @throws Exception 
    */
   public void Pause() throws Exception {
        player.pause();
   }
   
   /**
    * Metodo que reauna la cancion en el mismo punto en donde se pauso
    * @throws Exception 
    */
   public void Continue() throws Exception {
        player.resume();
   }
   
   /**
    * Metodo que para por completo la canción, y reproducira desde cera la proxima vez que se haga Play
    * @throws Exception 
    */
   public void Stop() throws Exception {
        player.stop();
   }
   
    /**
     * Main de la clase reproductor
     * @param args 
     */
   public static void main(String args[]) throws Exception{
       
       Opciones can=new Opciones();
       can.Open("C:\\Users\\Ricardo Araya\\Documents\\Reproductor\\desnuda.mp3");
       can.Play();
   
   
   
   }
    }