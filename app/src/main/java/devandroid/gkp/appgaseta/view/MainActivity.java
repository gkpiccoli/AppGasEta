package devandroid.gkp.appgaseta.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.gkp.appgaseta.R;
import devandroid.gkp.appgaseta.controller.CursoController;
import devandroid.gkp.appgaseta.controller.PessoaController;
import devandroid.gkp.appgaseta.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor listaInscricao;
    public static final String NOME_PREFERENCES = "pref_lista";

    PessoaController controller;
    CursoController cursoController;
    Pessoa pessoa;
    List<String> nomesDosCursos;
    EditText editNome;
    EditText editSobrenome;
    EditText editTelefone;
    EditText editCursoDesejado;


    Button btnSalvar;
    Button btnFinalizar;
    Button btnLimpar;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaInscricao = preferences.edit();


        controller = new PessoaController(MainActivity.this);
        controller.toString();


        pessoa = new Pessoa();
        controller.buscar(pessoa);


        editNome = findViewById(R.id.editNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editTelefone = findViewById(R.id.editTelefone);
        editCursoDesejado = findViewById(R.id.editCursoDesejado);
        spinner = findViewById(R.id.spinner);

        editNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editTelefone.setText(pessoa.getTelefoneContato());
        editCursoDesejado.setText(pessoa.getCursoDesejado());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        cursoController = new CursoController();
        nomesDosCursos = cursoController.dadosParaSpinner();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursoController.dadosParaSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        btnLimpar.setOnClickListener(v -> {
            editNome.setText("");
            editSobrenome.setText("");
            editTelefone.setText("");
            editCursoDesejado.setText("");

            controller.limpar();
        });

        btnFinalizar.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
            finish();
        });

        btnSalvar.setOnClickListener(v -> {
            pessoa.setPrimeiroNome(editNome.getText().toString());
            pessoa.setSobreNome(editSobrenome.getText().toString());
            pessoa.setTelefoneContato(editTelefone.getText().toString());
            pessoa.setCursoDesejado(editCursoDesejado.getText().toString());
            Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_LONG).show();

            controller.salvar(pessoa);
        });


        Log.i("POOAndroid", "Objeto pessoa: " + pessoa.toString());
        Log.i("POOAndroid", "Objeto Teste" + pessoa.getClass());
    }
}