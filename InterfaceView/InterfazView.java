
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

}
