package interfaceview;
import java.awt.event.*;
import javax.swing.*;
import java.io.*; 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
class Controlador implements ActionListener {
    private Modelo modelo;
    private Vista vista;
    private Encriptado encriptado = new Encriptado();
    public Controlador(Modelo m, Vista v) {
        modelo = m;
        vista = v;
        vista.setController(this);
    }
    
    void BuscarArchivo() throws FileNotFoundException, IOException{
        String text = "";
        File file = new File("C:\\Users\\LENOVO THINKPAD L560\\Documents\\NetBeansProjects\\InterfaceView\\Archivo.txt"); 
        BufferedReader b = new BufferedReader(new FileReader(file)); 
        String s; 
        while ((s = b.readLine()) != null){
            text += s+ "\n";
        }     
      vista.setText(text);
    }
     void GuardarArchivo(){
        try {
            FileWriter writer = new FileWriter("Archivo.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
 
            //no imprime por ser text area (PENDIENTE)
            //String fakeTextToPrint = vista.getText();
            String textToPrint = vista.getFileName(); 
            bufferedWriter.write(textToPrint);
            bufferedWriter.close();
            System.out.println("Save...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        switch (event.getActionCommand()) {
            case VistaInterface.ABRIR:
           {
            try {
                BuscarArchivo();
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
                break;
            case VistaInterface.ENCRYPT:
                modelo.encript();
                break;
            case VistaInterface.DECRYPT:
                modelo.decript();
                break;
            case VistaInterface.GUARDAR:
                GuardarArchivo();
                break; 
            default:
                System.err.println("INGRESE OPCION VALIDA");
                break;
        }
    }
    public void run() {
        vista.setLocationRelativeTo(null);
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setSize(500, 230);
        vista.setVisible(true);
    }
}