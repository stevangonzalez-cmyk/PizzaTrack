public class GestionPedidos {

    private PilaPizza pilaPrincipal = new PilaPizza();   // Undo
    private PilaPizza pilaSecundaria = new PilaPizza();  // Redo

    // Registrar pizza
    public void registrarPizza(Pizza pizza) {
        pilaPrincipal.push(pizza);
        // si registras algo nuevo, se invalida el redo
        pilaSecundaria.clear();
        System.out.println("Pedido registrado: " + pizza);
    }

    // Deshacer
    public void deshacer() {
        if (pilaPrincipal.isEmpty()) {
            System.out.println("No hay pedidos para deshacer.");
            return;
        }
        Pizza p = pilaPrincipal.pop();
        pilaSecundaria.push(p);
        System.out.println("Se deshizo: " + p);
    }

    // Rehacer
    public void rehacer() {
        if (pilaSecundaria.isEmpty()) {
            System.out.println("No hay pedidos para rehacer.");
            return;
        }
        Pizza p = pilaSecundaria.pop();
        pilaPrincipal.push(p);
        System.out.println("Se rehizo: " + p);
    }

    // Mostrar pedido actual
    public void mostrarPedidoActual() {
        Pizza p = pilaPrincipal.peek();
        if (p == null) {
            System.out.println("No hay pedidos activos.");
        } else {
            System.out.println("Pedido actual: " + p);
        }
    }
}
