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
public class DoubleLinkedList <T> {
    
    private class Node <E> { // Clase nodo de  tipo E
        //atributos
        private E element; // Elemento de tipo E
        private Node<E> next; // Nodo de tipo E
        private Node<E> previous;
        
        public Node (){
            this.element=null; //nodo especial
            this.next=null;
            this.previous=null;
        }
        
        public Node (E element){
            this.element=element;
            this.next=null;
            this.previous=null;
        }
        
        public Node (E element, Node<E> previous, Node<E> next){
            this.element=element;
            this.next=next; 
            this.previous=previous;
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
        
        public Node<E> getPrevious(){
            return this.previous;
        }
        
        public void setPrevious (Node<E> previous){
            this.previous=previous;
        }
      
    }
    
    // atrtibutos
    
    private Node<T> head;
    private Node<T> current;
    private Node<T> tail;
    private int size;
    private int pos;
    
    // constructores
    
    public DoubleLinkedList() {
        this.head=new Node<T>();
        this.current=this.tail=this.head;
        this.pos=-1;
        this.size=0;
    }
    
    // métodos
    
    public void insert(T element){
        if(this.size==0){
          Node <T> temp=new Node <>(element,this.current,this.current.getNext());
          this.current.setNext(temp);
          this.tail=temp;
          size++;
        }
        else{
          Node <T> temp=new Node <>(element,this.current,this.current.getNext());
          this.current.setNext(temp);
          Node <T> temp1=temp.getNext();
          temp1.setPrevious(temp);
          if(this.current==this.tail){
              this.tail=temp;
          }
          size++;
        }
    }
    
    public void append(T element){
        Node temp=new Node <T>(element,this.tail,this.tail.getNext());
        this.tail.setNext(temp);
        this.tail=temp;
        size++;
    }
    
    public T getElement(){
        return this.current.getElement();
    }
    
    public void remove(){
        if(this.current==this.head){
            System.out.println("No es posible eliminar");
            return;
        }
        Node <T> temp=this.current.getPrevious();
        Node <T> temp1=this.current.getNext();
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
    
    public void updateElement(T element){
        this.current.setElement(element);
    }  
    
    public void clear(){
        this.head=new Node<T>();
        this.current=this.tail=this.head;
        this.pos=-1;
        this.size=0;
    }
    
    public Node <T> next(){
        this.current=this.current.getNext();
        pos++;
        return this.current;
    }
    
    public Node<T> previous(){
        this.current=this.current.getPrevious();
        pos--;
        return this.current;
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
    
    public static void main(String [] args){
        DoubleLinkedList dll=new DoubleLinkedList();
        dll.insert(1);
        dll.insert(2);
        dll.insert(3);
        dll.insert(4);
        dll.append(5);
        dll.next();
        System.out.println(dll.getElement());
        System.out.println(dll.getSize());
        System.out.println(dll.getPos());
        dll.updateElement(7);
        System.out.println(dll.getElement());
        dll.goToEnd();
        dll.remove();
        dll.previous();
        System.out.println(dll.getElement());
        System.out.println(dll.getPos());
        dll.goToStart();
        dll.next();
        System.out.println(dll.getElement());
        dll.next();
        System.out.println(dll.getElement());
    }
}

