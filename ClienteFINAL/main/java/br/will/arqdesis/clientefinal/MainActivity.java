package br.usjt.arqdesis.clientefinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;

//Activity é uma subclasse de contexto
//Tudo que for pedido se fala com um contexto

public class MainActivity extends AppCompatActivity {

    public static final String LISTA = "br.usjt.arqdesis.clientefinal.lista";
    EditText texto;
    ArrayList<Cliente> lista;
    ClienteRequester requester;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //retornado o id criado no activity id. (se cria id com o comando id+
        texto = (EditText) findViewById(R.id.busca_cliente);
    }

    public void buscarClientes(View view) {
        requester = new ClienteRequester();
        intent = new Intent(this, ListarClienteActivity.class);
        //Criando Multi Threads
        new Thread(new Runnable() {
            @Override
            //WorkerThread
            public void run() {
                try {
                    lista = requester.getClientes("http://10.0.2.2:8080/arqdesis_poeta/cliente");
                    //Sincroniza as Threads
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            intent.putExtra(LISTA, lista);
                            startActivity(intent);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
