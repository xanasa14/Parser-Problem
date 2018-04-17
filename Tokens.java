package proyectoparsing;

import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 *
 * @author Xavier Navarro
 */
public class Tokens {

    private StreamTokenizer tokens;
    private int Pos;

    public Tokens(InputStreamReader reader) {
        tokens = new StreamTokenizer(reader);
        tokens.ordinaryChar('.');
        tokens.ordinaryChar('-');
        tokens.ordinaryChar('/');
    }  

    public void Posmoved() {
        try {
            Pos = tokens.nextToken();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public StreamTokenizer getTokens() {
        return tokens;
    }

    public void setTokens(StreamTokenizer tokens) {
        this.tokens = tokens;
    }

    public int getPosicion() {
        return Pos;
    }

    public void setPosicion(int Pos) {
        this.Pos = Pos;
    }

}
