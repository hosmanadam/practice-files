package com.adamhosman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {

    }

    public void printPlayList(String title, int totalDuration, LinkedList<Single> songs) {
        System.out.println("\n" + title.toUpperCase());
        System.out.println(createUnderlineFor(title));
        for (int i=0; i<songs.size(); i++) {
                System.out.println(i+1 + ". " + formatSingle(songs.get(i), true));
        }
        System.out.println("TOTAL DURATION: " + formatDuration(totalDuration));
    }

    public void printMenu(ArrayList<String> menu) {
        System.out.println("\nYOU CAN:");
        for (int i=0; i<menu.size(); i++) {
            System.out.println(i + " - " + menu.get(i));
        }
    }

    public void printNowPlaying(Single song) {
        System.out.println("\n▶︎ Now playing: " + formatSingle(song, false));
    }

    public void printHello() {
        System.out.println("\nHello!");
    }

    public void printGoodbye() {
        System.out.println("\nGoodbye!");
    }

    public void printError(String message) {
        System.out.println("\nERROR: " + message);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public int getMenuChoice(ArrayList<String> menu) {
        int choice = getInt(">> ");
        while (choice < 0 || choice > menu.size()) {
            choice = getInt(">> ");
        }
        return choice;
    }

    public int getInt(String prompt) {
        System.out.print(prompt);
        boolean hasNextInt = scanner.hasNextInt();
        while (!hasNextInt) {
            System.out.print("Not a number, please try again: ");
            scanner.nextLine();
            hasNextInt = scanner.hasNextInt();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public String formatSingle(Single single, boolean addDuration) {
        return
                single.getArtist() + "/" +
                single.getAlbumTitle() + " - " +
                single.getTitle() +
                (addDuration ? " (" + formatDuration(single.getDuration()) + ")" : "");
    }

    public String formatDuration(int duration) {
        int minutes = duration / 60;
        int seconds = duration % 60;
        String secondsPadding = (seconds < 10 ? "0": "");
        return minutes + ":" + secondsPadding + seconds;
    }

    public String createUnderlineFor(String string) {
        return new String(new char[string.length()]).replace("\0", "-");
    }

}
