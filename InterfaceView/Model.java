package InterfaceView;
import java.io.BufferedReader;             //LIBRERIAS UTILIZADAS
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