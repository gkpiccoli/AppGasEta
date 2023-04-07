package devandroid.gkp.appgaseta.apoio;

public class UtilGasEta {

    public void metodoNaoEstatico(){}

    public static void metodoEstatico(){}

    public static String mensagem(){
        return "Qualquer mensagem";
    }

    public static double valor(){
        return 599.99;
    }

    public static String calcularMelhorOpcao(double gasolina, double etanol){
        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if (etanol <= precoIdeal){
            mensagemDeRetorno = "Abasteça com Etanol";
        }
        else {
            mensagemDeRetorno = "Abasteça com Gasolina";
        }
        return mensagemDeRetorno;
    }
}
