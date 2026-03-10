public class PilaPizza {
    private Nodo cima;

    public PilaPizza() {
        cima = null;
    }

    public boolean isEmpty() {
        return cima == null;
    }

    // push(): insertar en el tope
    public void push(Pizza pizza) {
        Nodo nuevo = new Nodo(pizza);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    // pop(): retirar del tope
    public Pizza pop() {
        if (isEmpty()) return null;
        Pizza temp = cima.dato;
        cima = cima.siguiente;
        return temp;
    }

    // peek(): ver el tope sin retirar
    public Pizza peek() {
        if (isEmpty()) return null;
        return cima.dato;
    }

    // limpiar pila (útil para invalidar redo)
    public void clear() {
        cima = null;
    }
}