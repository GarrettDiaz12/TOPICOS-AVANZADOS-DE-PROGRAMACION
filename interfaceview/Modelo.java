package interfaceview;
class Modelo {

    private Vista v;

    public Modelo(Vista v) {
        this.v = v;
    }

    void setFile(String fileName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    String read() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void setContenido(String text) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void encript() {

        v.setText(Encriptado.encriptar(v.getFileName().toCharArray()));
    }

    void decript() {
        v.setText(Encriptado.desencriptar(v.getFileName().toCharArray()));

    }

    void setFileName(String fileName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void write() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
//metodos
  class Encriptado {
    public static String encriptar(char p[]) {
        String s = "";
        for (int i = 0; i < p.length; i++) {
            if ((p[i] >= 65 && p[i] <= 90) || (p[i] >= 97 && p[i] <= 122)) {
                p[i] += 3;
            }
        }
        p = invertir(p);
        int partido = Math.round(p.length / 2);
        for (int i = partido; i < p.length; i++) {
            if ((p[i] >= 65 && p[i] <= 90) || (p[i] >= 97 && p[i] <= 122)) {
                p[i] -= 1;
            }
        }
        for (int i = 0; i < p.length; i++) {
            s = s + "" + p[i];
        }
        return s;
    }

    // metedo para desencripar solo cambia el orden de instrucciones y signos.
    // PARA QUE EL TEXTO SE DESECRIPTE SE TIENE QUE INGRESAR COMO TEXTO EL TEXTO
    // CIFRADO COMO SI
    // SI SE AGREGARA NUEVO STRING PARA QUE FUNCIONE CORRECTAMENTE
    public static String desencriptar(char p2[]) {
        String salida = "";
        int partido = Math.round(p2.length / 2);
        for (int i = partido; i < p2.length; i++) {
            if ((p2[i] >= 65 && p2[i] <= 90) || (p2[i] >= 97 && p2[i] <= 122)) {
                p2[i] += 1;
            }
        }
        p2 = invertir(p2);
        for (int i = 0; i < p2.length; i++) {
            if ((p2[i] >= 65 && p2[i] <= 90) || (p2[i] >= 97 && p2[i] <= 122)) {
                p2[i] -= 3;
            }
        }
        for (int i = 0; i < p2.length; i++) {
            salida = salida + "" + p2[i];
        }
        return salida;
    }

    // INVERTIR PARA EL ULTIMO PASO
    public static char[] invertir(char p3[]) {
        char[] invertido = new char[p3.length];
        for (int i = 0; i < p3.length; i++) {
            invertido[i] = p3[p3.length - 1 - i];
        }
        return invertido;
    }

    char[] chars(String des) {
        char[] temporal = new char[des.length()];
        for (int i = 0; i < des.length(); i++) {
            temporal[i] = des.charAt(i);
        }
        return temporal;
    }
}