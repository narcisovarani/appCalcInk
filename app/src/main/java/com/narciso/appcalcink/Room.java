package com.narciso.appcalcink;

import java.util.ArrayList;

public class Room {
    private ArrayList<Wall> walls = new ArrayList<>();

    public void init() {

        for (int i = 0; i <= 4; i++) {
            walls.add(new Wall(0.00, 0.00, 0, 0));
        }
    }

    public Wall getWall (int i){

       return walls.get(i);
    }
}
