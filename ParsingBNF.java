package proyectoparsing;

/**
 *
 * @author Xavier Navarro
 */

public class ParsingBNF {

    private Tokens expresion_in;

    public ParsingBNF(Tokens expresion_in) {
        this.expresion_in = expresion_in;
    }

    public int valor_expresion() 
    {
        int sub_valor = term_ini();
        return term_fin(sub_valor);
    }

    private int term_ini() {
        int sub_valor = factor_ini();
        return factor_fin(sub_valor);
    }

    private int term_fin(int sub_valor) {
        switch (expresion_in.getPosicion()) {
            case (int) '+': {
                expresion_in.Posmoved();
                int valor = term_ini();
                return term_fin(sub_valor + valor);
            }
            case (int) '-': {
                expresion_in.Posmoved();
                int valor = term_ini();
                return term_fin(sub_valor - valor);
            }
            default:
                return sub_valor;
        }
    }

    private int factor_ini() {
        switch (expresion_in.getPosicion()) {
            case (int) '(':
                expresion_in.Posmoved();
                int valor = valor_expresion();
                if (expresion_in.getPosicion() == (int) ')') {
                    expresion_in.Posmoved();
                } else {
                    System.out.println("')' Missing");
                }
                return valor;
            case (int) '-':
                expresion_in.Posmoved();
                return -factor_ini();

            case -3: 
                expresion_in.Posmoved();
                // 
                return 0;
            case -2: 
                expresion_in.Posmoved();
                return (int) expresion_in.getTokens().nval;
            default:
                System.out.println("error in Factor");
                return 0;
        }

    }

    private int factor_fin(int sub_valor) {
        switch (expresion_in.getPosicion()) {
            case (int) '*': {
                expresion_in.Posmoved();
                int valor = factor_ini();
                return factor_fin(sub_valor * valor);
            }
            case (int) '/': {
                expresion_in.Posmoved();
                int valor = factor_ini();
                return factor_fin(sub_valor / valor);
            }
            default:
                return sub_valor;
        }
    }

}
