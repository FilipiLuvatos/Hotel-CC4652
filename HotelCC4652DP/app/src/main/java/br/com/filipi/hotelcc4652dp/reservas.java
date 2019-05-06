package br.com.filipi.hotelcc4652dp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class reservas extends AppCompatActivity {

    Pilha p = new Pilha (100);
    EditText T10,T8,T9,T7,T20;
    Button B5,B9,B12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservas);


        T10 = (EditText)findViewById(R.id.editText10);
        T8 = (EditText)findViewById(R.id.editText8);
        T9 = (EditText)findViewById(R.id.editText9);
        B5 = (Button)findViewById(R.id.button5);
        T7 = (EditText)findViewById(R.id.editText7);
        B9 = (Button)findViewById(R.id.button9);
        T20 = (EditText)findViewById(R.id.editText20);
        B12 = (Button)findViewById(R.id.button12);

        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux4,aux5,aux6;
                aux4 = T10.getText().toString();
                aux5 = T8.getText().toString();
                aux6 = T9.getText().toString();
                p.insereNome(aux4);
                p.insereNome(aux5);
                p.insereNome(aux6);


            }
        });

        B9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.removeNome();
            }
        });
        B12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String aux1,aux4;
                aux1 = T7.getText().toString();
                p.pesquisaPilha(aux1);
                aux4 = T7.getText().toString();
                T20.setText(aux4.toString());
            }
        });




    }
    public class Pilha {

        private String[] alunos;
        private int topoPilha;

        public Pilha (int tamPilha){
            this.alunos = new String[tamPilha];
            this.topoPilha = -1;
        }

        public void insereNome(String nome){

            if(topoPilha == alunos.length -1){
                System.out.println("A Pilha está cehia");

            }else{
                topoPilha++;
                alunos[topoPilha] = nome;

            }


        }

        public void removeNome(){

            if(topoPilha < 0 ){
                System.out.println("A Pihla está vazia");
            }else{
                alunos[topoPilha] = null;
                --topoPilha;

            }
        }

        public void imprimePilha(){
            for(int x=0;x< alunos.length; x++){
                System.out.println("Item [" + (x+1) + "] = " + alunos[x]);
            }
            System.out.println("\nTamanho maxímo da Pilha: " + alunos.length + "\nTopo da pilha = " + (topoPilha + 1));

        }
        public void pesquisaPilha(String nome){
            for(int x=0; x< alunos.length - 1; x++){
                if(alunos[x].equals(nome)){
                    System.out.println("Encontrado Item[" + (x+1) + "] = " + alunos[x]);
                }
            }
        }
    }


}
