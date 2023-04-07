package devandroid.gkp.appgaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.gkp.appgaseta.model.Pessoa;
import devandroid.gkp.appgaseta.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaInscricao;
    public static final String NOME_PREFERENCES = "pref_lista";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaInscricao = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC_Controller", "Controller iniciada...");
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller", "Salvo " + pessoa.toString());


        listaInscricao.putString("Nome", pessoa.getPrimeiroNome());
        listaInscricao.putString("Sobrenome", pessoa.getSobreNome());
        listaInscricao.putString("Telefone", pessoa.getTelefoneContato());
        listaInscricao.putString("Curso", pessoa.getCursoDesejado());
        listaInscricao.apply();
    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("Nome", "N/A"));
        pessoa.setSobreNome(preferences.getString("Sobrenome", "N/A"));
        pessoa.setTelefoneContato(preferences.getString("Telefone", "N/A"));
        pessoa.setCursoDesejado(preferences.getString("Curso", "N/A"));

        return pessoa;
    }

    public void limpar() {

        listaInscricao.clear();
        listaInscricao.apply();

    }

}
