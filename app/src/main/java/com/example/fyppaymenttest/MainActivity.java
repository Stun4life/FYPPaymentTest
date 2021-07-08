package com.example.fyppaymenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.craftman.cardform.Card;
import com.craftman.cardform.CardForm;
import com.craftman.cardform.OnPayBtnClickListner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardForm cardForm = findViewById(R.id.cardForm);
        TextView textDescription = findViewById(R.id.payment_amount);
        Button btnPay = findViewById(R.id.btn_pay);

        textDescription.setText("$123");
        btnPay.setText(String.format("Payer %s", textDescription.getText()));

        cardForm.setPayBtnClickListner(new OnPayBtnClickListner() {
            @Override
            public void onClick(Card card) {
                Toast.makeText(MainActivity.this, "Number : " + card.getNumber() + " | CVC : " + card.getCVC(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}