package com.lucas.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){

        ImageView imagem = findViewById(R.id.imageView6);
        TextView txtResultado = findViewById(R.id.textView2);

        int numero = new Random().nextInt(3);
        String [] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "pedra":
                imagem.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagem.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagem.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
            (escolhaApp == "tesoura" && opcaoSelecionada == "papel") ||
            (escolhaApp == "papel" && opcaoSelecionada == "pedra") ||
            (escolhaApp == "pedra" && opcaoSelecionada == "tesoura")
        ){//App Vencedor
            txtResultado.setText("Que pena, o App venceu...");
        }else if(
            (opcaoSelecionada == "tesoura" && escolhaApp == "papel") ||
            (opcaoSelecionada == "papel" && escolhaApp == "pedra") ||
            (opcaoSelecionada == "pedra" && escolhaApp == "tesoura")
        ){//Usuário vencedor
            txtResultado.setText("Parabéns, você venceu!!");
        }else{//Empate
            txtResultado.setText("Empate!!!");
        }

    }

}