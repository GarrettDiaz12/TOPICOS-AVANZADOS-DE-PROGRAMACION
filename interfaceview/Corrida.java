package interfaceview;
public class Corrida {
    public static void main(String[] args) {
        Vista v = new Vista();
        Modelo m = new Modelo(v);
        Controlador c = new Controlador(m, v);
        c.run();
    }
}
