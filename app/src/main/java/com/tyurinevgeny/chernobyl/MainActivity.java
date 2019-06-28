package com.tyurinevgeny.chernobyl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tyurinevgeny.chernobyl.game_world.GameWorld;
import com.tyurinevgeny.chernobyl.game_world.WorldComm;

/**
 * Main activity
 */

public class MainActivity extends AppCompatActivity {

    WorldComm worldComm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        worldComm = WorldComm.getInstance(GameWorld.getInstance());
        System.out.println(worldComm.getPersonReport("Ivan Petrov"));
    }
}
