package br.com.filipi.hotelcc4652dp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class cafe_da_manha extends AppCompatActivity {

    EditText ed12,ed19,ed18;
    Button B4,B7,B8;
    Fila f = new Fila(100);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_da_manha);

        ed12 = (EditText)findViewById(R.id.editText12);
        ed18 = (EditText)findViewById(R.id.editText18);
        ed19 = (EditText)findViewById(R.id.editText19);
        B4 = (Button)findViewById(R.id.button4);
        B7 = (Button)findViewById(R.id.button7);
        B8 = (Button)findViewById(R.id.button8);

        B4.setOnClickListener(new View.OnClickListener() {//Insere
            @Override
            public void onClick(View v) {
                String aux,aux3;

                aux = ed12.getText().toString();

                f.insereNome(aux);

                f.imprimeFila();
               // ed19.setText(f.imprimeFila());



            }

        });

        B7.setOnClickListener(new View.OnClickListener() {//Remove
            @Override
            public void onClick(View v) {
                f.removeNome();
            }
        });

        B8.setOnClickListener(new View.OnClickListener() {//Busca
            @Override
            public void onClick(View v) {
                String aux;
                aux = ed19.getText().toString();
                f.pesquisaFila(aux);

                ed18.setText(aux.toString());
            }
        });

    }

    public class Fila {
        private String[]alunos;
        private int fimFila;

        public Fila(int tamFila){
            this.alunos = new String[tamFila];
            fimFila = -1;
        }
        public void insereNome(String nome) {
            if (fimFila == alunos.length - 1){
                System.out.println("Não Inserido Fila esta cheia");

            }else{
                fimFila++;
                alunos[fimFila] = nome;

            }
        }
        public void removeNome(){
            if(fimFila < 0 ){
                System.out.println("Não Removido Fila esta vazia");
            }else{
                alunos[0] = null;
                for( int x = 0 ; x < fimFila;x++){
                    alunos[x] = alunos[x+1];
                }
                alunos[fimFila] = null;
                --fimFila;
            }
        }

        public void imprimeFila(){
            System.out.println("\nTamanho maxima da Fila: " + alunos.length + "\nFim da Fila: " + (fimFila + 1));
            for(int x = 0; x < alunos.length; x++){
                System.out.println("Item [" + ( x + 1 ) + "] = " + alunos[x]);
            }
        }

        public void pesquisaFila(String nome){
            boolean n = true;
            for( int x=0; x <alunos.length; x++){
                if(alunos[x] != nome){
                    n = true;
                }

                else{
                    System.out.println("Encontrado item: [" + (x+1) + "] = " + alunos[x] );
                    break;
                }
            }
            if(n == false){
                System.out.println("Este intem não está na Fila");
            }
        }

    }

}
