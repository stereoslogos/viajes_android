package com.example.viajes_ocho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton jrbCartagena,jrbAmazonas,jrbMiami;
    TextView jtvCiudad,jtvTransporte,jtvGuia,jtvTotal;
    EditText jetCantidad;
    CheckBox jcbTransporte,jcbGuia;
    Button jbtCalc,jbtLimp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        jrbCartagena = findViewById(R.id.rbCartagena);
        jrbAmazonas = findViewById(R.id.rbAmazonas);
        jrbMiami = findViewById(R.id.rbMiami);
        jtvCiudad = findViewById(R.id.tvCiudad);
        jtvTransporte = findViewById(R.id.tvTransporte);
        jtvGuia = findViewById(R.id.tvGuia);
        jtvTotal = findViewById(R.id.tvTotal);
        jetCantidad = findViewById(R.id.etCantidad);
        jcbTransporte = findViewById(R.id.cbTransporte);
        jcbGuia = findViewById(R.id.cbGuia);
        jbtCalc = findViewById(R.id.btCalc);
        jbtLimp = findViewById(R.id.btLimp);
    }

    public void calc_tot(){
        String cantidad;
        cantidad = jetCantidad.getText().toString();

        if(cantidad.isEmpty()){
            Toast.makeText(this, "La cantidad de personas es requerida", Toast.LENGTH_SHORT).show();
            jetCantidad.requestFocus();
        }else{
            int valor_ciudad,valor_transporte,valor_guia,valor_total,valor_cantidad;

            valor_cantidad = Integer.parseInt(cantidad);
            valor_ciudad = Integer.parseInt(jtvCiudad.getText().toString());
            valor_transporte = Integer.parseInt(jtvTransporte.getText().toString());
            valor_guia = Integer.parseInt(jtvGuia.getText().toString());
            valor_total = (valor_ciudad + valor_transporte) * valor_cantidad + valor_guia;
            jtvTotal.setText(String.valueOf(valor_total));
        }
    }

    public void calc(View view){
        calc_tot();
    }

    public void Cartagena(View view){
        jtvCiudad.setText("1500000");
        calc_tot();
    }

    public void Amazonas(View view){
        jtvCiudad.setText("2100000");
        calc_tot();
    }

    public void Miami(View view){
        jtvCiudad.setText("3200000");
        calc_tot();
    }

    public void Transporte(View view){
        if(jcbTransporte.isChecked()){
            jtvTransporte.setText("150000");
        }else{
            jtvTransporte.setText("0");
        }
        calc_tot();
    }

    public void Guia(View view){
        if(jcbGuia.isChecked()){
            jtvGuia.setText("300000");
        }else{
            jtvGuia.setText("0");
        }
        calc_tot();
    }

    public void limpiar(View view){
        jetCantidad.setText("");
        jtvGuia.setText("0");
        jtvTransporte.setText("0");
        jtvCiudad.setText("1500000");
        jtvTotal.setText("0");
        jrbCartagena.setChecked(true);
        jcbTransporte.setChecked(false);
        jcbGuia.setChecked(false);
        jetCantidad.requestFocus();
    }
}