package InterfaceView;
public class Main {  
    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        Controller run = new Controller(m, v);
        run.run(); 
    }
}
