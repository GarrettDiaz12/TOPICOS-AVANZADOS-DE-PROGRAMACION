package interfaceview;
import java.awt.*;
import javax.swing.*;

public class Vista extends JFrame implements VistaInterface {

    private final JTextArea text;
    private final JButton encriptadoJButton;
    private final JButton desencriptadoJButton;
    private final JButton abrirJButton;
    private final JButton guardarJButton;
    private final JTextField fileName;

    public Vista() {

        JPanel fileJPanel;
        JLabel lblFile;
        JPanel buttonJPanel;
        BorderLayout layout;

        layout = new BorderLayout(30, 25);
        setLayout(layout);
        fileJPanel = new JPanel();
        fileJPanel.setLayout(new FlowLayout());
        lblFile = new JLabel("texto/Cifrado:");
        lblFile.setToolTipText("Archivo a abrir");
        fileJPanel.add(lblFile);
        fileName = new JTextField(25);
        fileJPanel.add(fileName);
        add(fileJPanel, BorderLayout.NORTH);
        text = new JTextArea(10, 20);
        add(new JScrollPane(text), BorderLayout.CENTER);
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new GridLayout(4, 2));
        abrirJButton = new JButton("ABRIR");
        buttonJPanel.add(abrirJButton);
        guardarJButton = new JButton("GUARDAR");
        buttonJPanel.add(guardarJButton);
        encriptadoJButton = new JButton("ENCRIPTAR");
        buttonJPanel.add(encriptadoJButton);
        desencriptadoJButton = new JButton("DESENCRIPTAR");
        buttonJPanel.add(desencriptadoJButton);
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

    public void setController(Controlador cont) {
        encriptadoJButton.addActionListener(cont);
        desencriptadoJButton.addActionListener(cont);
        abrirJButton.addActionListener(cont);
        guardarJButton.addActionListener(cont);
    }
    
}
