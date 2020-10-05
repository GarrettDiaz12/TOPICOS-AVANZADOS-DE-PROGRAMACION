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
