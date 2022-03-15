package ies.lab1.ex1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.NoSuchElementException;

public class TqsStackTest {

    private TqsStack<String> newStack;
    private TqsStack<String> halfStack;

    @BeforeEach
    public void setUp(){
        newStack = new TqsStack<String>();

        halfStack = new TqsStack<String>();

        for(int i =0; i<10 ; i++){
            halfStack.push("Renato");
        }
    }

    @DisplayName("A stack is empty on construction.")
    @Test
    public void isEmpty()
    {
        assertTrue(newStack.isEmpty());
    }

    @DisplayName("A stack has size 0 on construction.")
    @Test
    public void sizeConstruction(){
        assertEquals(0, newStack.size());
    }

    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    @Test
    public void size(){
        assertTrue(!halfStack.isEmpty());
        assertEquals(10, halfStack.size());
    }

    @DisplayName("If one pushes x then pops, the value popped is x.")
    @Test
    public void push_then_pop(){

        halfStack.push("João");

        assertEquals("João", halfStack.pop());
    }

    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
    @Test
    public void push_then_peek(){

        halfStack.push("Pedro");
        int size = halfStack.size();
        assertEquals("Pedro", halfStack.peek());
        assertEquals(size, halfStack.size());
    }

    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
    @Test
    public void empty_after_pops(){

        for(int i =0; i<10 ; i++){
            halfStack.pop();
        }
        assertTrue(halfStack.isEmpty());
        assertEquals(0, halfStack.size());
    }

    @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
    @Test
    public void pop_exception(){

        assertThrows(NoSuchElementException.class,()->{newStack.pop();});
    }

    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    @Test
    public void peek_exception(){

        assertThrows(NoSuchElementException.class,()->{newStack.peek();});
    }
    
}
