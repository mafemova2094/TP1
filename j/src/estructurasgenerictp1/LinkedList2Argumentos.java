/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estructurasgenerictp1;

/**
 * Se implementa una lista simple
 * @author Mau
 */
public class LinkedList2Argumentos <A,B>{ // LinkedList es genérico de tipo A
    
    public class Node <E,B> { // Clase nodo de  tipo E
        //atributos
        private E artists; // Elemento de tipo E
        private B banda;
        private Node<E,B> next; // Nodo de tipo E
        
        public Node (){
            this.artists=null; //nodo especial
            this.banda=null;
            this.next=null;
        }
        
        public Node (E element,B banda){ // nodo que recibe un elemento de tipo E
            this.artists=element;
            this.banda=banda;
            this.next=null;
        }
        
        public Node (E element,B banda, Node<E,B> next){ // nodo que recibe un elemento de tipo E, y dos punteros
            this.artists=element;
            this.banda=banda;
            this.next=next;
        }
        
        //métodos 
        public B getBanda(){
            return this.banda;
        }
        
        public void setBanda (B element){ //Actualiza un elemento. Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.banda=element; 
            
        }
        
        public E getArtist(){ // consultar un elemento
            return this.artists;
        }
        
        public void setArtist (E element){ //Actualiza un elemento. Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.artists=element; 
            
        }
         public Node<E,B> getNext(){ // Obtiene el siguiente elemento
            return this.next;
        }
        
        public void setNext (Node<E,B> next){ //Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.next=next; 
            
        }
      
    }
    private Node <A,B> head; // indica la cabeza del nodo
    private Node<A,B> current; // puntero actual del nodo
    private Node <A,B>tail; // indica la cola del nodo
    private int size; // indica el tamaño 
    private int pos; // indica la posición
    
    //constructores
    
    public LinkedList2Argumentos (){ // nodo especial en el cual el current es igual al tail y a la cabeza
        this.head=new Node<>();
        this.current=head;
        this.tail=head;
        this.pos=-1;
        this.size=0;
    }
    
    //métodos
    
    /**
     * Inserta un elemento. Crea un nuevo nodo para poderlo insertar en el current
     * @param element debe ser de tipo A
     */
    
    public void insert (A element,B banda){
        Node<A,B> temp=new Node<A,B>(element,banda);
        temp.setNext(current.getNext()); 
        this.current.setNext(temp);
        if (this.current==this.tail){
           this.tail=this.current.getNext();
        }
        size++;
    }
    
    /**
     * Concatena un elemento en la lista doblemente enlazada. Se concatena al final.
     * @param element debe ser de tipo A
     */
    
    public void append (A element,B banda){
        if (size==0){
            Node temp=new Node<>(element,banda);
            this.head.setNext(temp);
            this.current=this.head;
            this.tail=this.tail.getNext();
            size++;
           }
        else{
            Node temp=new Node<>(element,banda);
            this.tail.setNext(temp);
            this.tail=this.tail.getNext();
            size++;
        }
        
    }
    
    /**
     * Obtiene el elemento
     * @return el elemento que está en el current
     */
    
    public B getBanda(){
        try{
            return (B)this.current.getBanda(); // Hay que convertirlo ya que son de diferente tipo uno es E y el otro A
        }
        catch(NullPointerException ex){ // Si es un puntero al final y está vacío, nos tira error si solicitamos el elemento 
            return null;
        }
    }
    
    
    
    public A getArtist(){
        try{
            return (A)this.current.getArtist(); // Hay que convertirlo ya que son de diferente tipo uno es E y el otro A
        }
        catch(NullPointerException ex){ // Si es un puntero al final y está vacío, nos tira error si solicitamos el elemento 
            return null;
        }
    }
    
    
    /**
     * elimina un elemento
     */
    
    public void remove(){
       if (size==0){
           System.out.println("Lista vacía");
           return;
       }
       Node temp=head;
       while(temp.getNext()!=current){
           temp=temp.getNext();
       }
       temp.setNext(this.current.getNext());
       if (current==tail){
          this.current=this.tail=temp;
          this.pos--;
       }
       else{
           this.current=temp;
           this.pos--;
       }
       size--;
    }
    
    /**
     * Modifica el elemento
     * @param element de tipo A
     */
    
    public void updateArtist(A element){
        this.current.setArtist(element);    
    }
    
    
    public void updateBanda(B banda){
        this.current.setBanda(banda);    
    }
    
    /**
     * Vacía la lista
     */
    
    public void clear(){
        this.head.setNext(null);
        this.current=head;
        this.tail=head;
        this.pos=-1;
        this.size=0;
    }
    
    /**
     *
     * ir al elemento siguiente
     */
    
    public void next(){
           this.current=this.current.getNext(); 
           this.pos++;         
    }
    
    /**
     *
     * ir al elemento anterior
     */
    
    public void previous(){
        Node temp=head;
        while(temp.getNext()!=current){
           temp=temp.getNext();
       }
        this.current=temp;
        this.pos--;
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
     * @return la posición
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
    
    /**
     * 
     * @return booleano, para saber si la lista está vacía o no 
     */
    
    public boolean isEmpty(){
        if(this.size==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void main(String [] args){
        System.out.println("*LinkedList**");
        System.out.println("*AgregandoALinkedList**");
        LinkedList2Argumentos lista=new LinkedList2Argumentos<>();
        lista.append(764,5);
        lista.append(1,9);
        lista.append(3,809);
        System.out.println(lista.getArtist());
        System.out.println(lista.getBanda());
        //System.out.println(lista.getSize());
        lista.next();
        System.out.println(lista.getArtist());
        System.out.println(lista.getBanda());
        lista.next();
        System.out.println(lista.getArtist());
        System.out.println(lista.getBanda());
        lista.next();
        System.out.println(lista.getArtist());
        System.out.println(lista.getBanda());
        lista.next();
        System.out.println(lista.getArtist());
        System.out.println(lista.getBanda());
        lista.previous();
        lista.remove();
        System.out.println(lista.getArtist());
        System.out.println(lista.getBanda());
        System.out.println(lista.getPos());
        System.out.println(lista.isEmpty());
        lista.previous();
        lista.insert(5,11);
        lista.next();
        System.out.println(lista.getArtist());
        System.out.println(lista.getBanda());
        System.out.println(lista.getSize());
        lista.goToStart();
        System.out.println(lista.getPos());
        lista.goToEnd();
        System.out.println(lista.getPos());
    }
            
}
