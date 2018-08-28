package com.myapp.test.model;

import java.util.Arrays;
import java.util.List;

public class Edge {
    private char startPoint;
    private List<Character> endPoint;
    private List<Double> len;
    private List<Double> speed;
    private List<Double> weight;

    public char getStartPoint() {
        return startPoint;
    }

    public List<Character> getEndPoint() {
        return endPoint;
    }

    public List<Double> getLen() {
        return len;
    }

    public List<Double> getSpeed() {
        return speed;
    }

    public void setEndPoint(List<Character> endPoint) {
        this.endPoint = endPoint;
    }

    public void setLen(List<Double> len) {
        this.len = len;
    }

    public void setSpeed(List<Double> speed) {
        this.speed = speed;
    }

    public void setStartPoint(char startPoint) {
        this.startPoint = startPoint;
    }

    public void setWeight() {
        List<Double> weight= Arrays.asList();
        for (int i=0;i<len.size();i++){
            weight.add(len.get(i)*speed.get(i));
        }
        this.weight=weight;
    }

    public List<Double> getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return startPoint+"->" +endPoint;
    }
}
