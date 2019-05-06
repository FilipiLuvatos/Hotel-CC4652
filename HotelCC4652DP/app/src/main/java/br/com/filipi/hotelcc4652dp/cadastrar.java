package br.com.filipi.hotelcc4652dp;

import android.os.Bundle;
import android.support.design.bottomappbar.BottomAppBarTopEdgeTreatment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class cadastrar extends AppCompatActivity {

    EditText cam1, cam2,cam3,cam5;
    Button B1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrar);

        cam1 = (EditText) findViewById(R.id.editText2);
        cam2 = (EditText) findViewById(R.id.editText3);
        cam3 = (EditText) findViewById(R.id.editText4);

        cam5 = (EditText) findViewById(R.id.editText11);
        B1 = (Button) findViewById(R.id.button);

        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String aux;
                String data1, data2;

                aux = cam1.getText().toString();
                data1 = cam2.getText().toString();
                data2 = cam3.getText().toString();

                EstruturaLDDE ELDDE = new EstruturaLDDE();


                  ELDDE.adiciona(aux);
                ELDDE.adiciona(data1);
                ELDDE.adiciona(data2);


                cam5.setText(aux.toString());
            }
        });







    }



    class No {
        String dado;
        No prev;
        No proximo;

        public No(String dado, No prev, No nest) {

            this.dado = dado;
            this.prev = prev;
            this.proximo = proximo;

        }

        public String getDado() {
            return dado;
        }

        public void setDado(String dado) {
            this.dado = dado;
        }

        public No getPrev() {

            return prev;
        }

        public void setPrev(No prev) {
            this.prev = prev;
        }

        public No getProximo() {
            return proximo;
        }

        public void setProximo(No proximo) {
            this.proximo = proximo;
        }


    }

    class EstruturaLDDE {

        No primeiro = null;
        No ultimo = null;

        public void adiciona(String dado) {
            No newNo = new No(dado, null, null);

            if (this.primeiro == null) {
                this.primeiro = newNo;
                this.ultimo = newNo;
            } else {
                newNo.setPrev(this.ultimo);
                newNo.setProximo(null);
                this.primeiro.setProximo(newNo);
                this.ultimo = newNo;
            }
        }

        public void remove(String dado) {
            No noAtual = this.primeiro;

            while (noAtual != null) {
                if (noAtual.getDado().equals(dado)) {
                    if (noAtual.getPrev() == null) {
                        this.primeiro = noAtual.getProximo();
                        noAtual.getProximo().setPrev(null);
                    } else {
                        noAtual.getPrev().setProximo(noAtual);
                        noAtual.getProximo().setPrev(noAtual.getPrev());
                    }
                }
                noAtual = noAtual.getProximo();
            }
        }

        public void Imprime() {

            System.out.println(" LDDE ");

            No noAtual = this.primeiro;

            while (noAtual != null) {
                if (noAtual.getPrev() == null) {
                    System.out.println("Nenhum");
                } else {
                    System.out.println("<----> | " + noAtual.getDado() + " | ");
                }
                noAtual = noAtual.getProximo();

            }

        }

        public void Busca(String dado) {

            System.out.println(" LDDE ");

            No noAtual = this.primeiro;

            while (noAtual.equals(dado)) {
                if (noAtual.getPrev().equals(dado)) {
                    System.out.println("Nenhum");
                } else {
                    System.out.println("<----> | " + noAtual.getDado() + " | ");
                }
                noAtual = noAtual.getProximo();

            }

        }


    }




}
