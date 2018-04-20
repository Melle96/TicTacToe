package com.example.melle.tictactoe;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static java.nio.file.Paths.get;

public class MainActivity extends AppCompatActivity  {
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    //    pas deze functie toe als er een tile wordt aangeklikt
    public void TileClicked(View view) {
        // id verkrijgen van de tile
        int id = view.getId();

        //  haal kleinste id van id af
        int cijfer = id - 2131165223;

        // bepaal row en column
        int row = (cijfer / 3);
        int column = ((cijfer) % 3);
        Log.d("herkennen", String.valueOf(row));
        Log.d("herkennen", String.valueOf(column));
        Log.d("herkennen", String.valueOf(view.getId()));

        //  pas functie draw uit game toe
        Tile tile = game.draw(row, column);
        Button button = (Button) view;

        // maak een CROSS of CIRCLE van de button
        switch(tile) {
            case CROSS:
                button.setText("CROSS");
                break;
            case CIRCLE:
                button.setText("CIRCLE");
                break;
            case INVALID:
                break;
        }

        //  checken of de game klaar is
        GameState gamestate = game.check();

        // als er remise of gewonnen is nieuwe game aanmaken
        if (gamestate == GameState.DRAW || gamestate == GameState.PLAYER_ONE || gamestate == GameState.PLAYER_TWO) {
            game = new Game();

            // alle button opnieuw de naam button geven
            for (int i = 0; i < 9; i++) {
                Button Button = (Button) findViewById(2131165223 + i);
                Button.setText("BUTTON");
            }
        }
    }

    // als reset wordt aangeklikt functie toepassen
    public void ResetClicked(View view) {
        // maak een nieuwe game
        game = new Game();

        // alle buttons opnieuw naam button geven
        for (int i = 0; i < 9; i++) {
            Button Button = (Button) findViewById(2131165223 + i);
            Button.setText("BUTTON");
            Log.d("herkennen", String.valueOf(view.getId()));
        }

    }


    // functie aanroepen indien om advies van de computer wordt gevraagd
    public void AdviseClicked(View view) {
        // er wordt een nummer van de button geadviseerd
        int advies = game.advise();

        // nummer advies printen
        Button button = (Button) view;
        button.setText("Zetadvies: " + advies);
        Log.d("herkennen", String.valueOf(view.getId()));
    }



    // opslaan buttonteksten
    public void onSaveInstanceState(Bundle outState) {
        Button Button = (Button) findViewById(R.id.button_1);
        Button Button1 = (Button) findViewById(R.id.button_2);
        Button Button2 = (Button) findViewById(R.id.button_3);
        Button Button3 = (Button) findViewById(R.id.button_4);
        Button Button4 = (Button) findViewById(R.id.button_5);
        Button Button5 = (Button) findViewById(R.id.button_6);
        Button Button6 = (Button) findViewById(R.id.button_7);
        Button Button7 = (Button) findViewById(R.id.button_8);
        Button Button8 = (Button) findViewById(R.id.button_9);
        Button Button9 = (Button) findViewById(R.id.button10);
        Button Button10 = (Button) findViewById(R.id.button);

        super.onSaveInstanceState(outState); // always call super
        outState.putString("buttonnaam", (String) Button.getText());
        outState.putString("buttonnaam1", (String) Button1.getText());
        outState.putString("buttonnaam2", (String) Button2.getText());
        outState.putString("buttonnaam3", (String) Button3.getText());
        outState.putString("buttonnaam4", (String) Button4.getText());
        outState.putString("buttonnaam5", (String) Button5.getText());
        outState.putString("buttonnaam6", (String) Button6.getText());
        outState.putString("buttonnaam7", (String) Button7.getText());
        outState.putString("buttonnaam8", (String) Button8.getText());
        outState.putString("buttonnaam9", (String) Button9.getText());
        outState.putString("buttonnaam10", (String) Button10.getText());

    }

    // zet teksten goed bij rotatie
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Button Button = (Button) findViewById(R.id.button_1);
        Button Button1 = (Button) findViewById(R.id.button_2);
        Button Button2 = (Button) findViewById(R.id.button_3);
        Button Button3 = (Button) findViewById(R.id.button_4);
        Button Button4 = (Button) findViewById(R.id.button_5);
        Button Button5 = (Button) findViewById(R.id.button_6);
        Button Button6 = (Button) findViewById(R.id.button_7);
        Button Button7 = (Button) findViewById(R.id.button_8);
        Button Button8 = (Button) findViewById(R.id.button_9);
        Button Button9 = (Button) findViewById(R.id.button10);
        Button Button10 = (Button) findViewById(R.id.button);


        super.onRestoreInstanceState(savedInstanceState);
        String button = savedInstanceState.getString(("buttonnaam"));
        String button1 = savedInstanceState.getString(("buttonnaam1"));
        String button2 = savedInstanceState.getString(("buttonnaam2"));
        String button3 = savedInstanceState.getString(("buttonnaam3"));
        String button4 = savedInstanceState.getString(("buttonnaam4"));
        String button5 = savedInstanceState.getString(("buttonnaam5"));
        String button6 = savedInstanceState.getString(("buttonnaam6"));
        String button7 = savedInstanceState.getString(("buttonnaam7"));
        String button8 = savedInstanceState.getString(("buttonnaam8"));
        String button9 = savedInstanceState.getString(("buttonnaam9"));
        String button10 = savedInstanceState.getString(("buttonnaam10"));

        Button.setText(button);
        Button1.setText(button1);
        Button2.setText(button2);
        Button3.setText(button3);
        Button4.setText(button4);
        Button5.setText(button5);
        Button6.setText(button6);
        Button7.setText(button7);
        Button8.setText(button8);
        Button9.setText(button9);
        Button10.setText(button10);
    }



}