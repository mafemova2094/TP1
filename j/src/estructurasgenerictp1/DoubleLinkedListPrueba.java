/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estructurasgenerictp1;

/**
 *
 * @author Mau
 * @param <T>
 */
public class DoubleLinkedListPrueba <N,R,A,Al,G,D> {
    
    private class Node <N,R,A,Al,G,D> { // Clase nodo de  tipo E
        //atributos
        private N nombre; // Elemento de tipo N
        private R ruta; // Elemento de tipo R
        private A artista; // Elemento de tipo A
        private Al album; // Elemento de tipo Al
        private G genero; // Elemento de tipo G
        private D duracion; // Elemento de tipo D
        
        private Node<N,R,A,Al,G,D> next; // Nodo de tipo E
        private Node<N,R,A,Al,G,D> previous; // Nodo de tipo E
        
        public Node (){
            this.nombre=null; //nodo especial
            this.ruta=null;
            this.artista=null;
            this.album=null;
            this.genero=null;
            this.duracion=null;
            
            this.next=null;
            this.previous=null;
        }
        
        
        public Node (N nombre,R ruta, A artista, Al album, G genero, D duracion, Node<N,R,A,Al,G,D> previous, Node<N,R,A,Al,G,D> next){ // nodo que recibe un elemento de tipo E, y dos punteros
            this.nombre=nombre;
            this.ruta=ruta;
            this.artista=artista;
            this.album=album;
            this.genero=genero;
            this.duracion=duracion;
            
            this.next=next; 
            this.previous=previous;
        }
        
        //métodos 
        public N getNombre(){ // consultar un elemento
            return this.nombre;
        }
        
        public void setNombre(N nombre){ // Actualiza un elemento. Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.nombre=nombre; 
            
        }
        
        public R getRuta(){ // consultar un elemento
            return this.ruta;
        }
        
        public void setRuta(R ruta){ // Actualiza un elemento. Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.ruta=ruta; 
        }
        
        public A getArtista(){ // consultar un elemento
            return this.artista;
        }
        
        public void setArtista(A artista){ // Actualiza un elemento. Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.artista=artista; 
        }
        
        public Al getAlbum(){ // consultar un elemento
            return this.album;
        }
        
        public void setAlbum(Al album){ // Actualiza un elemento. Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.album=album;
            
        }
        
        public G getGenero(){ // consultar un elemento
            return this.genero;
        }
        
        public void setGenero(G genero){ // Actualiza un elemento. Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.genero=genero; 
        }
        
        public D getDuracion(){ // consultar un elemento
            return this.duracion;
        }
        
        public void setDuracion(D duracion){ // Actualiza un elemento. Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.duracion=duracion; 
            
        }
        
        
         public Node<N,R,A,Al,G,D> getNext(){ // Obtener el siguiente elemento
            return this.next;
        }
        
        public void setNext (Node<N,R,A,Al,G,D> next){ // Actualizar el siguiente elemento. Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.next=next; 
        }
        
        public Node<N,R,A,Al,G,D> getPrevious(){ // Obtener el previo elemento
            return this.previous;
        }
        
        public void setPrevious (Node<N,R,A,Al,G,D> previous){ // Actualizar el anterior elemento
            this.previous=previous;
        }
      
    }
    
    // atrtibutos
    
    private Node<N,R,A,Al,G,D> head; // indica la cabeza del nodo
    private Node<N,R,A,Al,G,D> current; // puntero actual del nodo
    private Node<N,R,A,Al,G,D> tail; // indica la cola del nodo
    private int size; // indica el tamaño 
    private int pos; // indica la posición
    
    // constructores
    
    public DoubleLinkedListPrueba() { // nodo especial en el cual el current es igual al tail y a la cabeza
        this.head=new Node<N,R,A,Al,G,D>();
        this.current=this.tail=this.head;
        this.pos=-1;
        this.size=0;
    }
    
    // métodos
    
    /**
     * Inserta un elemento. Crea un nuevo nodo para poderlo insertar en el current
     * @param element debe ser de tipo T
     */
        
    public void insert(N nombre,R ruta, A artista, Al album, G genero, D duracion){
        if(this.size==0){
          Node <N,R,A,Al,G,D> temp=new Node <>(nombre,ruta,artista,album,genero,duracion,this.current,this.current.getNext());
          this.current.setNext(temp);
          this.tail=temp;
          size++;
        }
        else{
          Node <N,R,A,Al,G,D> temp=new Node <>(nombre,ruta,artista,album,genero,duracion,this.current,this.current.getNext());
          this.current.setNext(temp);
          Node <N,R,A,Al,G,D> temp1=temp.getNext();
          temp1.setPrevious(temp);
          if(this.current==this.tail){
              this.tail=temp;
          }
          size++;
        }
    }
    
    /**
     * Concatena un elemento en la lista doblemente enlazada. Se concatena al final.
     * @param element debe ser de tipo T
     */
    public void append(N nombre,R ruta, A artista, Al album, G genero, D duracion){
        Node<N,R,A,Al,G,D> temp=new Node <>(nombre,ruta,artista,album,genero,duracion,this.tail,this.tail.getNext());
        this.tail.setNext(temp);
        this.tail=temp;
        size++;
    }
    
    /**
     * Obtiene el elemento
     * @return el elemento que está en el current
     */
    public N getNombre(){
        return this.current.getNombre();
    }
    
    public R getRuta(){
        return this.current.getRuta();
    }
    public A getArtista(){
        return this.current.getArtista();
    }
    public Al getAlbum(){
        return this.current.getAlbum();
    }
    public G getGenero(){
        return this.current.getGenero();
    }
    public D getDuracion(){
        return this.current.getDuracion();
    }
    
    
    
    
    
    /**
     * elimina un elemento
     */
    public void remove(){
        if(this.current==this.head){
            System.out.println("No es posible eliminar");
            return;
        }
        Node <N,R,A,Al,G,D> temp=this.current.getPrevious();
        Node <N,R,A,Al,G,D> temp1=this.current.getNext();
        temp.setNext(temp1);
        if(this.current==this.tail){
            this.current=this.tail=temp;
            size--;
        }
        else{
            temp1.setPrevious(temp);
            this.current=temp;
            size--;
        }
    }
    
    /**
     * Modifica el elemento
     * @param nombre de tipo T
     */
    public void updateNombre(N nombre){
        this.current.setNombre(nombre);
    }  
    public void updateRuta(R ruta){
        this.current.setRuta(ruta);
    }  
    public void updateArtista(A artista){
        this.current.setArtista(artista);
    }  
    public void updateAlbum(Al album){
        this.current.setAlbum(album);
    }  
    public void updateGenero(G genero){
        this.current.setGenero(genero);
    }  
    public void updatDuracion(D duracion){
        this.current.setDuracion(duracion);
    }  
    
    
    public void getElement(){
        System.out.println(this.current.getNombre()+"-"+this.current.getRuta()+"-"+
                this.current.getArtista()+"-"+this.current.getAlbum()+"-"+this.current.getGenero()+
                "-"+this.current.getDuracion());
        return;
    }
    
    
    
    
    
    /**
     * Vacía la lista
     */
    public void clear(){
        this.head=new Node<N,R,A,Al,G,D>();
        this.current=this.tail=this.head;
        this.pos=-1;
        this.size=0;
    }
    
    /**
     *
     * @return ir al elemento siguiente
     */
    public Node <N,R,A,Al,G,D> next(){
        this.current=this.current.getNext();
        pos++;
        return this.current;
    }
    
    /**
     *
     * @return ir al elemento anterior
     */
    public Node<N,R,A,Al,G,D> previous(){
        this.current=this.current.getPrevious();
        pos--;
        return this.current;
    } 
    
    /**
     *
     * @return el tamaño
     */
    public int getSize(){
        return this.size;
    }
    
    /**
     *
     * @return la posición actual
     */
    public int getPos(){
        return this.pos;
    }
    
    /**
     * mover al principio de la lista
     */
    public void goToStart(){
        this.current=this.head;
        this.pos=-1;
    }
    
    /**
     * mover al final de la lista
     */
    public void goToEnd(){
        this.current=this.tail;
        this.pos=size-1;
    }
    
    
    public DoubleLinkedListPrueba <N,R,A,Al,G,D> buscarArtista(A artista){
        DoubleLinkedListPrueba <N,R,A,Al,G,D> temp=new DoubleLinkedListPrueba <>();
        Node <N,R,A,Al,G,D> nodo=head.getNext();
        while(nodo!=null){
            if(nodo.getArtista()==artista){
                temp.append(nodo.getNombre(),nodo.getRuta(),nodo.getArtista(),nodo.getAlbum(),nodo.getGenero(),nodo.getDuracion());
                nodo=nodo.getNext();
            }
            else{
                nodo=nodo.getNext();
            }
        }
        return temp;
    }
    
    
    public DoubleLinkedListPrueba<N,R,A,Al,G,D> buscarAlbum(Al album){
        DoubleLinkedListPrueba <N,R,A,Al,G,D> temp=new DoubleLinkedListPrueba <>();
        Node <N,R,A,Al,G,D> nodo=head.getNext();
        while(nodo!=null){
            if(nodo.getAlbum()==album){
                temp.append(nodo.getNombre(),nodo.getRuta(),nodo.getArtista(),nodo.getAlbum(),nodo.getGenero(),nodo.getDuracion());
                nodo=nodo.getNext();
            }
            else{
                nodo=nodo.getNext();
            }
        }
        return temp;
    }
    
    public DoubleLinkedListPrueba<N,R,A,Al,G,D> buscarGenero(G genero){
        DoubleLinkedListPrueba <N,R,A,Al,G,D> temp=new DoubleLinkedListPrueba <>();
        Node <N,R,A,Al,G,D> nodo=head.getNext();
        while(nodo!=null){
            if(nodo.getGenero()==genero){
                temp.append(nodo.getNombre(),nodo.getRuta(),nodo.getArtista(),nodo.getAlbum(),nodo.getGenero(),nodo.getDuracion());
                nodo=nodo.getNext();
            }
            else{
                nodo=nodo.getNext();
            }
        }
        return temp;
    }
    
    /**
     *
     * @param nombre
     * @return
     */
    public DoubleLinkedListPrueba<N,R,A,Al,G,D> buscarNombre(N nombre){
        DoubleLinkedListPrueba <N,R,A,Al,G,D> temp=new DoubleLinkedListPrueba <N,R,A,Al,G,D>();
        Node <N,R,A,Al,G,D> nodo=this.head.getNext();
        for(int i=0;i<=size-1;i++){
            if(nodo.getNombre().equals(nombre)){
                System.out.println(nodo.getNombre());
                System.out.println(nodo.getArtista());
                temp.append(nodo.getNombre(),nodo.getRuta(),nodo.getArtista(),nodo.getAlbum(),nodo.getGenero(),nodo.getDuracion());
                nodo=nodo.getNext();
            }
            else{
                nodo=nodo.getNext();
            }
        }
        temp.goToStart();
        return temp;
    }

    /**
     *
     * @param args
     */
    public static void main(String [] args){
        DoubleLinkedListPrueba dll=new DoubleLinkedListPrueba<>();
        dll.append(1, 2, 3, 4, 5, 6);
        dll.append(11, 22, 33, 44, 55, 66);
        dll.append(111, 222, 333, 444, 555, 666);
        dll.append(1111, 2222, 3333,4444, 5555, 6666);
        dll.next();
        
      
        
        DoubleLinkedListPrueba y = dll.buscarNombre(1);
        y.next();
        System.out.println(y.getGenero());
        System.out.println(y.getArtista());
        System.out.println(y.getNombre());
        System.out.println(y.getSize());
        
        
        /**
        dll.getElement();
        dll.goToEnd();
        dll.remove();
        dll.previous();
        dll.getElement();
        System.out.println(dll.getPos());
        dll.goToStart();
        dll.next();
        dll.getElement();
        dll.next();
        dll.getElement();
        **/
    }
}

