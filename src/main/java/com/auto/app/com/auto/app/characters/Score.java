package com.auto.app.com.auto.app.characters;

public class Score {
    private int point;

    Score(){
        this.point = 0;
    }

    Score(int point){
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
