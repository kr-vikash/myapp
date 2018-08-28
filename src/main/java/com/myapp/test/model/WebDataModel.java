package com.myapp.test.model;

public class WebDataModel {
    private Grid grid;
    private char startPoint;
    private char endPoint;

    public char getStartPoint() {
        return startPoint;
    }

    public char getEndPoint() {
        return endPoint;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setStartPoint(char startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(char endPoint) {
        this.endPoint = endPoint;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
