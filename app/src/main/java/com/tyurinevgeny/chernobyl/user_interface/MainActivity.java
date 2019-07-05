package com.tyurinevgeny.chernobyl.user_interface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.tyurinevgeny.chernobyl.R;
import com.tyurinevgeny.chernobyl.ResourcesLoader;
import com.tyurinevgeny.chernobyl.game_world.GamePerson;
import com.tyurinevgeny.chernobyl.game_world.GameWorld;
import com.tyurinevgeny.chernobyl.game_world.WorldComm;
import com.tyurinevgeny.chernobyl.game_world.WorldDirection;

import java.util.ArrayList;

/**
 * Main activity
 */

public class MainActivity extends AppCompatActivity {

    private final int PERSON_BUTTONS_NUMBER = 2;
    private WorldComm worldComm;
    // UI elements
    private ListView messagesView;
    private Button[] personButtons = new Button[PERSON_BUTTONS_NUMBER];
    private String selectedPerson = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Init resources loader
        ResourcesLoader.getInstance(this);
        // Create game world and get connection to it
        worldComm = WorldComm.getInstance(GameWorld.getInstance());
        // Set UI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Chatter window init
        messagesView = findViewById(R.id.messages_view);
        // Person buttons init
        ArrayList<GamePerson> activePersons = worldComm.getActivePersons();
        for(int buttonIdx = 0; buttonIdx < PERSON_BUTTONS_NUMBER; buttonIdx++) {
            switch (buttonIdx) {
                case 0:
                    personButtons[buttonIdx] = findViewById(R.id.person1_button);
                    break;
                case 1:
                    personButtons[buttonIdx] = findViewById(R.id.person2_button);
                    break;
            }
            final int finalButtonIdx = buttonIdx;
            personButtons[buttonIdx].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    personButtonClicked(personButtons[finalButtonIdx]);
                }
            });
            if (buttonIdx < activePersons.size()) {
                personButtons[buttonIdx].setText(activePersons.get(buttonIdx).getName());
            }
        }
        // Control buttons
        final Button northButton = findViewById(R.id.north_button);
        northButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveButtonClicked(WorldDirection.NORTH);
            }
        });
        final Button southButton = findViewById(R.id.south_button);
        southButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveButtonClicked(WorldDirection.SOUTH);
            }
        });
        final Button eastButton = findViewById(R.id.east_button);
        eastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveButtonClicked(WorldDirection.EAST);
            }
        });
        final Button westButton = findViewById(R.id.west_button);
        westButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveButtonClicked(WorldDirection.WEST);
            }
        });
    }

    /** Player choose active person */
    private void personButtonClicked(Button button) {
        selectedPerson = button.getText().toString();
        updateMessages(selectedPerson);
    }

    /** Player presses move button */
    private void moveButtonClicked(WorldDirection direction) {
        if (!selectedPerson.equals("")) {
            worldComm.movePerson(selectedPerson, direction);
            updateMessages(selectedPerson);
        }
    }

    /** Update person messages in view */
    private void updateMessages(String personName) {
        ArrayList<String> messageList = worldComm.getPersonMessages(personName);
        final ListAdapter arrayAdapter = new ArrayAdapter<>(this,
                R.layout.list_item,
                messageList);
        messagesView.setAdapter(arrayAdapter);
        messagesView.setSelection(messageList.size() - 1);
    }

}
