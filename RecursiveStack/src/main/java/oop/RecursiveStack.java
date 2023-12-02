package oop;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * A Recursive Stack is a stack (LIFO)
 * that is immutable.
 * @param <E>
 */
public class RecursiveStack<E>  implements Iterable<E> {

    final E e;
    final RecursiveStack<E> next;

    /**
     * Creates an empty stack
     */
    public RecursiveStack() {
        e = null;
        next = null;
    }

    /**
     * Create a stack with e on top and next as the next stack.
     * The next is unchanged.
     *
     * @param e the element to put on top
     * @param next the following stack
     */
    private RecursiveStack(E e, RecursiveStack<E> next) {
        this.e = e;
        this.next = next;
    }

    /**
     * Creates and return a new stack with e on top and the
     * current stack at the bottom.
     * The current stack is unchanged.
     *
     * @param e the element to place on top
     * @return the new stack
     */
    public RecursiveStack<E> add(E e) {
		 return new RecursiveStack<>(e, this);
    }

    /**
     * Returns the element on top of the stack
     *
     * @throws EmptyStackException if the stack is empty
     * @return the element on top of the stack
     */
    public E top() {
        // TODO
        if(this.size() == 0){
            throw new EmptyStackException();
        }
         return this.e;
    }

    /**
     * Return the stack with element on top removed.
     * The current stack is unchanged.
     *
     * @return the stack with the top element removed
     */
    public RecursiveStack<E> removeTop() {
        // TODO
        if (this.size() == 0){
            throw new EmptyStackException();
        }
         return this.next;
    }

    /**
     * Computes the number of elements in the stack
     *
     * @return the number of element in the stack
     */
    public int size() {
        // TODO
        if(this.next == null){
            return 0;
        }
        else return 1+this.next.size();
    }

    /**
     * Reverse the stack.
     * The current stack is unchanged.
     *
     * @return a reversed version of the current stack (the top element becomes the bottom one)
     */
    public RecursiveStack<E> reverse() {
        // TODO
         if (this.next == null){
             return this;
         }
         RecursiveStack<E> a = new RecursiveStack<>();
         for(E e : this){
             a = a.add(e);
         }
         return a;
    }

    /**
     * Creates a top-down iterator on the stack
     * The delete is not implemented
     *
     * @return the top-down iterator.
     */
    @Override
    public Iterator<E> iterator() {
        // TODO: think about implementing an inner class
         return new StackIterator();
    }
    public class StackIterator implements Iterator<E>{
        RecursiveStack<E> a = RecursiveStack.this;

        @Override
        public boolean hasNext(){
            return a.next != null;
        }
        @Override
        public E next(){
            E e = a.e;
            a = a.next;
            return e;
        }
    }
}
