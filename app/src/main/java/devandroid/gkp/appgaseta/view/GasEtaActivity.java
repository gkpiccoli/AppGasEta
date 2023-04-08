package devandroid.gkp.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.gkp.appgaseta.R;
import devandroid.gkp.appgaseta.apoio.UtilGasEta;
import devandroid.gkp.appgaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {

    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;

    EditText editGasolina;
    EditText editEtanol;

    TextView txtResultado;

    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    double precoGasolina;
    double precoEtanol;
    String recomendacao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        // findview associa os métodos aos campos

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        // setonclick associa os botoes aos cliques

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isDadosOk = true;

                if (TextUtils.isEmpty(editEtanol.getText())) {
                    editGasolina.setError("* Campo Obrigatório");
                    editGasolina.requestFocus();
                    isDadosOk = false;
                }

                if (TextUtils.isEmpty(editGasolina.getText())) {
                    editEtanol.setError("* Campo Obrigatório");
                    editEtanol.requestFocus();
                    isDadosOk = false;
                }

                if (isDadosOk) {

                    precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                    precoEtanol = Double.parseDouble(editEtanol.getText().toString());

                    recomendacao = UtilGasEta.calcularMelhorOpcao(precoGasolina, precoEtanol);

                    txtResultado.setText(recomendacao);

                } else {

                    Toast.makeText(GasEtaActivity.this, "Atenção: digite os campos obrigatórios.",
                            Toast.LENGTH_LONG).show();


                }

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editEtanol.setText("");
                editGasolina.setText("");

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: Desabilitar o botão Salvar

                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                combustivelEtanol.setNomeDoCombustivel("Etanol");
                combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));

                int parada = 0;

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity.this, "Boa Economia!!!", Toast.LENGTH_LONG).show();
                finish();

            }
        });


        Toast.makeText(GasEtaActivity.this, UtilGasEta.calcularMelhorOpcao(5.55, 3.19),
                Toast.LENGTH_LONG).show();
    }
}
