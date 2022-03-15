package ies.lab1.ex1;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class TqsStack<T> {

    private LinkedList <T> stack = new LinkedList<T>();

    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public int size(){
        return stack.size();
    }
    public void push(T val){
        stack.push(val);
    }
    public T peek() throws NoSuchElementException{
        if (stack.peekFirst()!=null){
            return (T) stack.peekFirst();
        }
        throw new NoSuchElementException();
    }
    public T pop()throws NoSuchElementException{
        return (T) stack.pop();
    }
    
}
