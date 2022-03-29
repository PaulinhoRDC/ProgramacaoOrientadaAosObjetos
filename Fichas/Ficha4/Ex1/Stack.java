package Fichas.Ficha4.Ex1;

/*

1. Uma Stack (ou pilha) é uma estrutura linear do tipo LIFO ("last in first
out”), ou seja, o último elemento a ser inserido é o primeiro a ser removido.
Uma stack possui assim apenas um extremo para inserção e para remoção.
Implemente uma Stack de Strings, com as usuais operações sobre stacks:
(a) String top(): que determina o elemento no topo da stack;
(b) void push(String s): insere no topo;
(c) void pop(): remove o elemento do topo da stack, se esta não estiver
vazia;
(d) boolean empty(): determina se a stack está vazia;
(e) int length(): determina o comprimento da stack;

 */

import Fichas.Ficha4.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stack {

    ArrayList<String> stack;

    // CONSTRUTORES //
    public Stack(){
        this.stack = new ArrayList<>();
    }

    public Stack(ArrayList<String> stack) {
        this.stack = stack;
    }

    public Stack(Stack s) {
        setStack((ArrayList<String>) s.getStack());             // VERIFICAR //
    }

    // GETTER & SETTER 'S //
    public List<String> getStack() {
        return new ArrayList<>(this.stack);
    }

    public void setStack(ArrayList<String> stack) {
        this.stack = new ArrayList<>(stack);
    }

    // MÉTODOS //

    //(a) String top(): que determina o elemento no topo da stack;
    public String top() {
        if (!this.stack.isEmpty())
            return this.stack.get(this.stack.size() - 1);
        else
            return null; //Temos que futuramente validar se a stack está vazia. Caso esteja vazia não
        //faz sentido executar este método.
    }

    //(b) void push(String s): insere no topo;
    public void push(String s){
        this.stack.add(s);
    }

    //(c) void pop(): remove o elemento do topo da stack, se esta não estiver vazia;

    public void pop(){
        if(!this.stack.isEmpty()){
            this.stack.remove(this.stack.size()-1);
        }
    }

    //(d) boolean empty(): determina se a stack está vazia;

    public boolean empty(){
        return this.stack.isEmpty();
    }

    //(e) int length(): determina o comprimento da stack;

    public int length(){
        return this.stack.size();
    }

    // OUTROS MÉTODOS QUE TODAS AS CLASSES DEVEM TER //

    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + stack +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stack stack1 = (Stack) o;
        return Objects.equals(stack, stack1.stack);
    }

    public Stack clone(){
        return new Stack(this);
    }


}

