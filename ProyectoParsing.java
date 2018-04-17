package proyectoparsing;

/**
 *
 * @author Xavier Navarro
 */

import java.io.*;
import java.util.Scanner;

public class ProyectoParsing {

    
    
    private static StreamTokenizer tokens;
    private static int token;

    public static void main(String argv[]) {
        try {
            InputStreamReader reader;
            if (argv.length > 0) {
                reader = new InputStreamReader(new FileInputStream(argv[0]));
            } else {
                reader = new InputStreamReader(System.in);
            }

            Tokens expresion_in = new Tokens(reader);
            expresion_in.Posmoved();

            ParsingBNF parsingBNF = new ParsingBNF(expresion_in);

            int resultado_expresion = parsingBNF.valor_expresion();

            if (expresion_in.getPosicion() == (int) ';') {
                System.out.println(resultado_expresion);
            
            } else {
                
           
            }
        } catch (Exception e) {
            System.out.println("There was an error: " + e.getMessage());
        }

    }
    
            
}
