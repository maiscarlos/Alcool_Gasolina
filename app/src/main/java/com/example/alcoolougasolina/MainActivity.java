package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view) {
        //recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validar os campos digitados
        Boolean camposValidad0s = validarCampos(precoAlcool, precoGasolina);

        if (camposValidad0s) {

            //convertendo string para int
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            if ((valorAlcool / valorGasolina) >= 0.7) {
                textResultado.setText("Melhor utilizar -GASOLINA-.");

            } else {
                textResultado.setText("Melhor utilizar -ÁLCOOL-.");
            }


        } else {
            textResultado.setText("Preencha corretamente os campos!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;
        //String campo = "preenchido";

        if (pAlcool == null || pAlcool.equals("")) {
            camposValidados = false;
            //campo = "alcool";

        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
            //campo = "gasolina";


        }

        return camposValidados;


    }


}
