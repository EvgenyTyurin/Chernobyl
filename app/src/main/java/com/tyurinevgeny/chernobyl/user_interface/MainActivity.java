package com.tyurinevgeny.chernobyl.user_interface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.tyurinevgeny.chernobyl.R;
import com.tyurinevgeny.chernobyl.game_world.GameWorld;
import com.tyurinevgeny.chernobyl.game_world.WorldComm;

import java.util.ArrayList;

/**
 * Main activity
 */

public class MainActivity extends AppCompatActivity {

    WorldComm worldComm;
    // UI elements
    ListView messagesView;
    Button pers1Button;
    ArrayList<String> messageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Start game
        worldComm = WorldComm.getInstance(GameWorld.getInstance());
        // Set UI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messagesView = findViewById(R.id.messages_view);
        pers1Button = findViewById(R.id.person1_button);
        pers1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persButtonClicked(pers1Button);
            }
        });
    }

    void persButtonClicked(Button button) {
        messageList = worldComm.getPersonMessages(button.getText().toString());
        final ListAdapter arrayAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                messageList);
        messagesView.setAdapter(arrayAdapter);
    }

}
