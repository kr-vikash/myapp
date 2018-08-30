package com.myapp.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Edge {
    private char startPoint;
    private List<Character> endPoint;
    private List<Double> l;
    private List<Double> s;
    private Map<Character,Double> weight;

    public char getStartPoint() {
        return startPoint;
    }

    public List<Character> getEndPoint() {
        return endPoint;
    }

    public List<Double> getL() {
        return l;
    }

    public List<Double> getS() {
        return s;
    }

    public void setEndPoint(List<Character> endPoint) {
        this.endPoint = endPoint;
    }

    public void setL(List<Double> l) {
        this.l = l;
    }

    public void setS(List<Double> s) {
        this.s = s;
    }

    public void setStartPoint(char startPoint) {
        this.startPoint = startPoint;
    }

    public void setWeight() {
        Map<Character,Double> weight =new HashMap<>();;
        for (int i=0;i<l.size();i++){
            weight.put(endPoint.get(i),l.get(i)*1.0/s.get(i));
        }
        this.weight=weight;
    }

    public Map<Character,Double> getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return startPoint+"->" +endPoint;
    }
}

