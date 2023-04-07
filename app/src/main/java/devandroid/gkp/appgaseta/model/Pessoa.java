package devandroid.gkp.appgaseta.model;

public class Pessoa {

    //Construtor
    //Atributos - Objetos - Molde - Modelo - Template - letraMinuscula
    //Métodos de Acesso - Getters n Setters -
    //

    private String primeiroNome;
    private String sobreNome;
    private String CursoDesejado;
    private String telefoneContato;

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCursoDesejado() {
        return CursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        CursoDesejado = cursoDesejado;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }




    // @tostring
    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", CursoDesejado='" + CursoDesejado + '\'' +
                ", telefoneContato='" + telefoneContato + '\'' +
                '}';
    }
}
