package br.com.filipi.hotelcc4652dp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void BuscarCadastro(View v){
        startActivity(new Intent(this, br.com.filipi.hotelcc4652dp.geral_do_hotel.class));

    }
    public void cadastrar(View v){
        startActivity(new Intent(this, br.com.filipi.hotelcc4652dp.cadastrar.class));

    }
    public void cafedamanha(View v){
        startActivity(new Intent(this, br.com.filipi.hotelcc4652dp.cafe_da_manha.class));

    }
    public void Reserva(View v){
        startActivity(new Intent(this, br.com.filipi.hotelcc4652dp.reservas.class));

    }
    public void Deletarcadastro(View v){
        startActivity(new Intent(this, br.com.filipi.hotelcc4652dp.delete_cliente.class));

    }



}
