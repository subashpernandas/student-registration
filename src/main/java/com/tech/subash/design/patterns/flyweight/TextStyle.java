package com.tech.subash.design.patterns.flyweight;

public class TextStyle {
    private String font;
    private int size;
    private  boolean bold;

    public TextStyle(String font, int size, boolean bold) {
        this.font = font;
        this.size = size;
        this.bold = bold;
    }

    public  void applyStyle(char c, int position){
        System.out.println("character : "+ c +" at position "+ position
        + " with style "+ font +" size ");
    }
}
