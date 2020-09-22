package interfaceview;

public interface VistaInterface {
    void setController(Controlador cont);

    public String getFileName();

    public String getText();

    public void setText(String s);

    static final String ENCRYPT = "ENCRIPTAR";
    static final String DECRYPT = "DESENCRIPTAR";
    static final String ABRIR = "ABRIR";
    static final String GUARDAR = "GUARDAR";

}
