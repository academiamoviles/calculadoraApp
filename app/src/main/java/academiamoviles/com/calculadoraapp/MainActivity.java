package academiamoviles.com.calculadoraapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //1 Declaración de variables
    EditText edt_n1,edt_n2,edt_resultado;
    Button btn_suma,btn_resta,btn_multiplicacion,btn_division;

    float n1,n2,resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. Inicializamos las vistas
        inicializarVistas();

        //3. Programamos la lógica de evento al presionar alguna opción
        iniciarEventos();
    }

    private void obtenerinputs() {

        // Obtenemos los valores y parseamos de tipo string a tipo float

        n1 = Float.parseFloat(edt_n1.getText().toString());
        n2 = Float.parseFloat(edt_n2.getText().toString());

    }

    private void inicializarVistas() {

        // Match entre los ids de la vistas y las varaibles

        edt_n1 = (EditText) findViewById(R.id.edt_n1);
        edt_n2 = (EditText) findViewById(R.id.edt_n2);
        edt_resultado = (EditText) findViewById(R.id.edt_resultado);
        btn_suma = (Button) findViewById(R.id.btn_suma);
        btn_resta =  (Button) findViewById(R.id.btn_resta);
        btn_multiplicacion = (Button) findViewById(R.id.btn_multiplicacion);
        btn_division = (Button) findViewById(R.id.btn_division);

    }

    private void iniciarEventos() {

        // Declaramos los eventos

        btn_suma.setOnClickListener(this);
        btn_resta.setOnClickListener(this);
        btn_division.setOnClickListener(this);
        btn_multiplicacion.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        // Implementamos la operación que corresponda según el botón presionado
        // obtenemos los valores que ingresa el usuario
        obtenerinputs();

        switch (view.getId()){
            case R.id.btn_suma:
                resultado = n1 + n2;
                setearValorOutput(resultado);
                break;

            case R.id.btn_resta:
                resultado = n1 - n2;
                setearValorOutput(resultado);
                break;

            case R.id.btn_multiplicacion:
                resultado = n1 * n2;
                setearValorOutput(resultado);
                break;

            case R.id.btn_division:
                resultado = n1 / n2;
                setearValorOutput(resultado);
                break;
        }
    }

    public void setearValorOutput(float resultado){

        edt_resultado.setText(String.valueOf(resultado));

    }
}