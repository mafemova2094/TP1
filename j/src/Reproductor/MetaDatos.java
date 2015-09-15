package Reproductor;
//Librerias de uso
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.images.Artwork;



public class MetaDatos
{
    private String Artista,Album,Titulo,year,BPM,genero,ruta,rutaI=null;
    private Artwork portada;
    private int duracion;
    Tag tag;
    public MetaDatos(){
        
    } 
    public void meta(String ruta){
        this.ruta = ruta;

        File cancion = new File(ruta);
        try {
            AudioFile audioFile = AudioFileIO.read(cancion);
            duracion = audioFile.getAudioHeader().getTrackLength();
            tag = audioFile.getTag();

        } catch (Exception e) {
            e.printStackTrace();

        }
         try{
                Artista=tag.getFirst(FieldKey.ARTIST);
                if(Artista.equals("")){
                        Artista="Desconocido";
                    }
                }catch(KeyNotFoundException e){}
                try{
                    Album=tag.getFirst(FieldKey.ALBUM);
                    if(Album.equals("")){
                        Album="Desconocido";
                    }
                }
                catch(KeyNotFoundException e){
                }
                try{Titulo=tag.getFirst(FieldKey.TITLE);
                    if(Titulo.equals("")){
                        Titulo="Desconocido";
                    }
                }
                catch(KeyNotFoundException e){
                }
                try{
                    genero=tag.getFirst(FieldKey.GENRE);
                    //System.out.println(genero);
                    if(genero.equals("")||genero.equals("Género desconocido")){
                        genero="Desconocido";
                    }
                }catch(KeyNotFoundException e){
                }
                try{
                    BPM = tag.getFirst(FieldKey.FBPM);
                 }
                catch(KeyNotFoundException e){
                }
                 try{portada=tag.getFirstArtwork();
                 
        }
        catch(KeyNotFoundException e){
        }
    }

    public void guardarImagen(){
    try{                         
                InputStream RecibirDatos =new ByteArrayInputStream(portada.getBinaryData());
                BufferedImage bImageFromConvert = ImageIO.read(RecibirDatos);
                int w = bImageFromConvert.getWidth();
                int h = bImageFromConvert.getHeight();
                BufferedImage bufim = new BufferedImage(300, 300, bImageFromConvert.getType());
                Graphics2D g = bufim.createGraphics();
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g.drawImage(bImageFromConvert, 0, 0, 300, 300, 0, 0, w, h, null);
                g.dispose();
                rutaI=ruta+".jpg";
                File JPG=new File(rutaI);
                
                ImageIO.write(bufim,"jpg",JPG);
                
                
        
                }catch(Exception e){
                    this.rutaI=null;    
                }
    }
    public String getImagen(){
    return this.rutaI;
    }
    public String getArtista(){
    return this.Artista;
    }
    public String getTitulo(){
    return this.Titulo;
    }
    public String getAlbum(){
    return this.Album;
    }
    public int getduracion(){
    return duracion;
    }
    public double getduracionMin(){
    return duracion/60;
    }
    public String getgenero(){
    return this.genero;
    }
    public void setTitulo(String m){
    this.Titulo=m;
    }
    public void setArtista(String artista){
    this.Artista=artista;
    }
   
    public static void main(String args[]){
        
        MetaDatos h=new MetaDatos();
        
        h.meta("C:\\Users\\Ricardo Araya\\Documents\\celular\\celular09-10-14\\card\\musica\\Ricardo Arjona\\Ricardo Arjona1\\desnuda.mp3");
        System.out.println(h.getArtista());
        System.out.println(h.getAlbum());
        System.out.println(h.getTitulo());
        System.out.println(h.getduracion());
        System.out.println(h.getduracionMin());
        System.out.println(h.getgenero());
        
    }
    
   
}