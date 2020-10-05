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
