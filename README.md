# TOPICOS-AVANZADOS-DE-PROGRAMACION/PROGRAMA DE CIFRADO Y DECIFRADO DE UNA CADENA DE TEXTO POR ASCII
Tareas/Actividades/DIAZ CERVERA BRIAN NOE / ITL / TAP / 2020 / PROFESOR LEVY
----------------------------------------------------------------------------------------------------------------------------------------------
                                                        PLANTAMIENTO DEL PROBLEMA A RESOLVER
                                                        ------------------------------------

Desarrollar un programa que implemente una aplicación con GUI para el cifrado de archivos de texto con el algoritmo de cifrado Vigenère.

Se va a crear un programa de cifrado simple. El proceso es muy sencillo. Se divide en dos partes.
En primer lugar, cada letra mayúscula o minúscula debe desplazarse tres posiciones
hacia la derecha, de acuerdo con la tabla ASCII: la letra ’a’ debe convertirse en la letra
’d’, la letra ’y’ debe convertirse en el carácter ’—’, etc. En segundo lugar, cada línea debe
invertirse. Después de invertir, todos los caracteres de la mitad en adelante (truncado) deben
moverse una posición a la izquierda en ASCII. En este caso, ’b’ se convierte en ’a’ y ’a’ se
convierte en ’‘’.
Por ejemplo, si como entrada tenemos la cadena abcABC1 si la palabra resultante de la
primera parte es ”defDEF1”, las letras ”DEF1”deben moverse una posición a la izquierda.
Sin embargo, si la palabra resultante de la primera parte es ”tesA”, las letras ”sA”serán
desplazadas. El resultado cifrado de la cadena es 1FECedc.
-----------------------------------------------------------------------------------------------------------------------------------------------------
LIBRERIAS
Import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.JFrame; 
import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.BufferedWriter; 
import java.io.File; 
import java.io.FileWriter; 
import java.awt.BorderLayout; 
import java.awt.Color; 
import java.awt.FlowLayout; 
import java.awt.GridLayout; 
import javax.swing.JFrame; 
import javax.swing.JTextField; 
import javax.swing.JTextArea; 
import javax.swing.JButton; 
import javax.swing.JLabel; 
import javax.swing.JScrollPane; 
import javax.swing.JPanel; 
import static InterfaceView.InterfazView.OPEN;
import static InterfaceView.InterfazView.DECRYPT;
import static InterfaceView.InterfazView.ENCRYPT;
import static InterfaceView.InterfazView.SAVE;
------------------------------------------------------------------------------------------------------------------------------------------------------
//la clase InterfazView se encargar únicamente de la creación de la interfaz gráfica del programa ya que aquí definimos una interfaz con las principales //operaciones que el controlador previamente ocupa para hacer la manipulación de las vistas que nosotros creemos
// PANEL es un contenedor y así mismo una ventana ya que su propósito es organizar los componentes de la ventana
// Marco es una ventana en pleno funcionamiento con su título como sus iconos igualmente
// Dialogo se puede considerar también como una ventana emergente cuando se necesita mostrar un mensaje
--------------------------------------------------------------------------------------------------------------------------------------------------------
package InterfaceView;
public interface InterfazView {
    void setControlador(Controller c);
    public String getFileName();
    public String getText();
    public void setText(String s);
    static final String OPEN = "Open file";
    static final String SAVE = "Save text";
    static final String ENCRYPT = "Encrypt";
    static final String DECRYPT = "Decrypt";
------------------------------------------------------------------------------------------------------------------------------------------------------
Lo primero que se hace es crear un marco donde todos los componentes que formaran nuestro programa ya que se crea nuestra clase View que es una 
subclase de los Jframe ya que utilizaremos una instancia de la clase View para así poder mostrar una venta ya aue aqui nosotros podemos colocar el 
tamaño y el acomodo de nuestra interfaz para hacerla más interactiva con al usuario ya aquí mismo es donde contiene todos los componentes ya que los
componentes que vamos a utilizar creados previamente ocupan forzosamente un JtextArea para el nombre del archivo con el cual tendremos que trabajar y
igualmente junto a una etiqueta Jlabel para así poder mostrar al usuario su propósito también aquí creamos los botones como tal con Jbutton para poder conectarlos con la clase MODEL Y CONTROLLER ya que se crearan 4 botones OPEN FILE,ENCRYPT,DECRYPT Y SAVE FILE ya finalmente se crea un JTextArea  donde nosotros podemos visualizar la el correcto funcionamiento de del programa.
------------------------------------------------------------------------------------------------------------------------------------------------------
package InterfaceView;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import static InterfaceView.InterfazView.OPEN;
import static InterfaceView.InterfazView.DECRYPT;
import static InterfaceView.InterfazView.ENCRYPT;
import static InterfaceView.InterfazView.SAVE;
public class View extends JFrame {
    private final JTextArea text; 
    private final JButton encryptJButton;
    private final JButton decryptJButton;
    private final JButton saveJButton;
    private final JButton openJButton;
    private final JTextField fileName;

    public View() {
        super("DIAZ CERVERA BRIAN NOE/ITL/TOPICOS/2020");
        JPanel fileJPanel;
        JLabel lblFile;
        JPanel buttonJPanel;
        BorderLayout layout;
        layout = new BorderLayout(30, 25);
        setLayout(layout);
        fileJPanel = new JPanel();
        fileJPanel.setLayout(new FlowLayout());
        lblFile = new JLabel("Name of file to open:");
        fileJPanel.add(lblFile);
        fileName = new JTextField(25);
        fileJPanel.add(fileName);
        add(fileJPanel, BorderLayout.NORTH);
        text = new JTextArea(30, 30);
        add(new JScrollPane(text), BorderLayout.CENTER);
        buttonJPanel = new JPanel();
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new GridLayout(5, 2));
        openJButton = new JButton(OPEN);
        buttonJPanel.add(openJButton);
        encryptJButton = new JButton(ENCRYPT);
        buttonJPanel.add(encryptJButton);
        decryptJButton = new JButton(DECRYPT);
        buttonJPanel.add(decryptJButton);
        saveJButton = new JButton(SAVE);
        buttonJPanel.add(saveJButton);
        add(buttonJPanel, BorderLayout.EAST);
    }

    public String getFileName() {
        return fileName.getText();
    }

    public String getText() {
        return text.getText();
    }

    public void setText(String s) {
        text.setText(s);
    }

    public void setController(Controller cont) {
        openJButton.addActionListener(cont);
        saveJButton.addActionListener(cont);
        encryptJButton.addActionListener(cont);
        decryptJButton.addActionListener(cont);
    }
}

---------------------------------------------------------------------------------------------------------------------------------------------
En esta clase se almacenan todos los métodos que hacen referencia al ejecutarse lo botones ya que aquí contiene el método de encrypt, decrypt,savefile y openfile ya que aquí tiene que contener todos los métodos necesario para la ejecución del programa.
El método de encriptar mediante ASIIC es igual al de incrypt solo que de manera inversa.
OpenFile: El es el encargado de ir a la ruta de donde se creó el archivo.
Savefile: Es el método el cual nos permite dar y guardar el archivo con nuestra cadena de string convertida.
----------------------------------------------------------------------------------------------------------------------------------------------
package InterfaceView;
import java.io.BufferedReader;           
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
class Model {
    private String content;
    private String fileName;
    final char shiftup = (char) 3;
    final char shiftdown = (char) 1;
    public void setContenido(String text) {
        content = text;
    }

    public String getContenido() {
        return content;
    }

    public void setFileName(String nombre) {
        fileName = fileName;
    }

    public String Encrypt() {
        String ctext = "";
        for (String line : content.split("\n")) {
            StringBuilder chain1 = new StringBuilder();
            for (char c : line.toCharArray()) {
                if (Character.isLetter(c)) {
                    c += shiftup;
                }
                chain1.append(c);
            }

            StringBuilder shift_cadena = new StringBuilder();
            String shifttext = chain1.reverse().toString();

            int h = shifttext.length() / 2;
            for (char c : shifttext.substring(h,
                    shifttext.length()).toCharArray()) {
                if (Character.isLetter(c)) {
                    c -= shiftdown;
                }
                shift_cadena.append(c);
            }
            ctext = ctext + shifttext.substring(0, h) + shift_cadena.toString() + '\n';
        }
        content = ctext;
        return ctext;
    }

    public String Decrypt() {
        String text = "";
        for (String text1 : content.split("\n")) {
            int h = text1.length() / 2;
            StringBuilder shift_chain = new StringBuilder(text1.substring(0, h));

            for (char c : text1.substring(h, text1.length()).toCharArray()) {
                if (Character.isLetter(c)) {
                    c += shiftdown;
                }
                shift_chain.append(c);
            }

            String shifttext = shift_chain.reverse().toString();
            StringBuilder cadena = new StringBuilder();

            for (char c : shifttext.toCharArray()) {
                if (Character.isLetter(c - 3)) {
                    c -= shiftup;
                }
                cadena.append(c);
            }
            text = text + cadena.toString() + '\n';
        }
        content= text;
        return text;
    }

public void SaveFile (String archivo2){
        try {
            FileWriter writer = new FileWriter("File.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String textToPrint = archivo2; 
            bufferedWriter.write(textToPrint);
            bufferedWriter.close();
            System.out.println("Save");
        } catch (IOException e) {
            e.printStackTrace();
        }
}
    public String read(String textSearched) {
        String chain;
        String content = "";
        File file = new File("C:\\Users\\LENOVO THINKPAD L560\\Documents\\NetBeansProjects\\InterfaceView\\"+textSearched);
        try {
            if (file.exists()) {
                BufferedReader b = new BufferedReader(new FileReader(file));
                while ((chain = b.readLine()) != null) {
                    content = content + chain + '\n';
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println(" Error .");
        } catch (IOException ioException) {
            System.err.println(" Error .");
        }
        content = content;
        return content;
    }

}
------------------------------------------------------------------------------------------------------------------------------------------------------

// Esta clase llamada controller es aquella de la comunicación entre la interfaz y el modelo donde están creados todos los métodos
// que se utilizan para accionar los botones ya que cuando el usuario interactúe con la vista se ejecuten los eventos creados de manera
// correcta que se recogerá con el controlador y lanzados por el modelo ya que cuando el modelo devuelva la información su actualiza de interfaz 
// por esta simple razón la clase controller tendrá un objeto de clase View
// En este controlador agregamos 4 acciones o eventos a los que  van a responder nuestros botones en la interfaz ya que la  primera asignada para el //cuatro text file que al momento de poner el nombre del archivo y se haga clic en el botón de OPEN FILE este muestre el texto creado después para el 
//botón de encrypt se tomará la cadena string para hacer la conversión en base al modelo ASIIC y de igual manera con el botón de DESSENCRYPT y finalmente
// el botón de SAVE FILE el cual se encargar de guardar la cadena String en un archivo.
---------------------------------------------------------------------------------------------------------------------------------------------------------
package InterfaceView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
public class Controller implements ActionListener {
    private Model model;
    private View view;
    public Controller(Model m, View v) {
        model = m;
        view = v;
        view.setController(this);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case InterfazView.OPEN:
                model.setFileName(view.getFileName());
                view.setText(model.read(view.getFileName()));
                break;
            case InterfazView.ENCRYPT:
                model.setContenido(view.getText());
                view.setText(model.Encrypt());
                break;
            case InterfazView.DECRYPT:
                model.setContenido(view.getText());
                view.setText(model.Decrypt());
                break;
            case InterfazView.SAVE:
                model.setFileName(view.getFileName());
                model.setContenido(view.getText());
                model.SaveFile(view.getText());
                break;
            default:
                System.err.println("Error");
                break;
        }
    }
    public void run() {
         view.setLocationRelativeTo(null); 
         view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         view.setSize(500, 200);
         view.setVisible(true);
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------
En esta clase basicamente es la encargada de correr el programa
---------------------------------------------------------------------------------------------------------------------------------------------
package InterfaceView;
public class Main {  
    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        Controller run = new Controller(m, v);
        run.run(); 
    }
   
}
-----------------------------------------------------------------------------------------------------------------------------------------------
















