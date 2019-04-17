package com.adamhosman;

public class Main {

    public static void main(String[] args) {
    	PracticeRoom myStudio = new PracticeRoom();
    	myStudio.setUp();
    	myStudio.getPiano().play("La Valse d'Amélie", "Yann Tiersen");
    	myStudio.tearDown();
    }
}
