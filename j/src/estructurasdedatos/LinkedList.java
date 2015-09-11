/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estructurasdedatos;

/**
 *
 * @author Mau
 */
public class LinkedList <T>{
    
    public class Node <E> { // Clase nodo de  tipo E
        //atributos
        private E element; // Elemento de tipo E
        private Node<E> next; // Nodo de tipo E
        
        public Node (){
            this.element=null; //nodo especial
            this.next=null;
        }
        
        public Node (E element){
            this.element=element;
            this.next=null;
        }
        
        public Node (E element, Node<E> next){
            this.element=element;
            this.next=next;
        }
        
        //métodos 
        public E getElement(){
            return this.element;
        }
        
        public void setElement (E element){ //Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.element=element; 
            
        }
         public Node<E> getNext(){
            return this.next;
        }
        
        public void setNext (Node<E> next){ //Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.next=next; 
            
        }
      
    }
    private Node head;
    private Node current;
    private Node tail;
    private int size;
    private int pos;
    
    //constructores
    
    public LinkedList (){
        this.head=new Node<>();
        this.current=head;
        this.tail=head;
        this.pos=-1;
        this.size=0;
    }
    
    //métodos
    public void insert (T element){
        Node temp=new Node<>(element);
        temp.setNext(current.getNext()); 
        this.current.setNext(temp);
        if (this.current==this.tail){
           this.tail=this.current.getNext();
        }
        size++;
    }
    
    public void append (T element){
        if (size==0){
            Node temp=new Node<>(element);
            this.head.setNext(temp);
            this.current=this.head;
            this.tail=this.tail.getNext();
            size++;
           }
        else{
            Node temp=new Node<>(element);
            this.tail.setNext(temp);
            this.tail=this.tail.getNext();
            size++;
        }
        
    }
    
    public T getElement(){
        try{
            return (T)this.current.getElement(); // Hay que convertirlo ya que son de diferente tipo uno es E y el otro T
        }
        catch(NullPointerException ex){ // Si es un puntero al final y está vacío, nos tira error si solicitamos el elemento 
            return null;
        }
    }
    
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
    
    public void updateElement(T element){
        this.current.setElement(element);
        
    }
    
    public void clear(){
        this.head.setNext(null);
        this.current=head;
        this.tail=head;
        this.pos=-1;
        this.size=0;
    }
    
    public void next(){
           this.current=this.current.getNext(); 
           this.pos++;         
    }
    
    public void previous(){
        Node temp=head;
        while(temp.getNext()!=current){
           temp=temp.getNext();
       }
        this.current=temp;
        this.pos--;
    }
    
    public int getSize(){
       return this.size;
    }
    
    public int getPos(){
        return this.pos;
    }
    
    public void goToStart(){
        this.current=this.head;
        this.pos=-1;
    }
    
    public void goToEnd(){
        this.current=this.tail;
        this.pos=size-1;
    }
    
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
        LinkedList lista=new LinkedList<>();
        lista.append(4);
        lista.append(1);
        lista.append(3);
        System.out.println(lista.getElement());
        System.out.println(lista.getSize());
        lista.next();
        System.out.println(lista.getElement());
        lista.next();
        System.out.println(lista.getElement());
        lista.next();
        System.out.println(lista.getElement());
        lista.next();
        System.out.println(lista.getElement());
        lista.previous();
        lista.remove();
        System.out.println(lista.getElement());
        System.out.println(lista.getPos());
        System.out.println(lista.isEmpty());
        lista.previous();
        lista.insert(5);
        lista.next();
        System.out.println(lista.getElement());
        System.out.println(lista.getSize());
        lista.goToStart();
        System.out.println(lista.getPos());
        lista.goToEnd();
        System.out.println(lista.getPos());
    }
            
}
