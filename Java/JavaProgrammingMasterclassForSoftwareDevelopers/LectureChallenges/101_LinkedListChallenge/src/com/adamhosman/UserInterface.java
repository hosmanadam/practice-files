package com.adamhosman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {

    }

    public void printPlayList(String title, int totalDuration, LinkedList<Single> songs) {
        System.out.println("\n" + title);
        System.out.println(createUnderlineFor(title));
        for (int i=0; i<songs.size(); i++) {
                System.out.println(i+1 + ". " + formatSingle(songs.get(i)));
        }
        System.out.println("TOTAL DURATION: " + formatDuration(totalDuration));
    }

    public void printMenu(ArrayList<String> menu) {
        String MENU_TITLE = "MAIN MENU";
        System.out.println("\n" + MENU_TITLE);
        System.out.println(createUnderlineFor(MENU_TITLE));
        for (int i=0; i<menu.size(); i++) {
            System.out.println(i + " - " + menu.get(i));
        }
    }

    public String formatSingle(Single single) {
        return
                single.getArtist() + "/" +
                single.getAlbumTitle() + " - " +
                single.getTitle() +
                " (" + formatDuration(single.getDuration()) + ")";
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

    // TODO: incorporate ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓

    public void confirm(Boolean success) {
        if (success) {
            System.out.println("DONE ✓");
        } else {
            System.out.println("Something went wrong, please try again.");
        }
    }

    public void printHello() {
        System.out.println("\nHello!");
    }

    public void printGoodbye() {
        System.out.println("\nGoodbye!");
    }

    public int getMenuChoice(ArrayList<String> menu) {
        int choice = getInt("Please enter number of menu item: ");
        while (choice < 0 || choice > menu.size()) {
            choice = getInt("Invalid choice, please try again: ");
        }
        System.out.println("--");
        return choice;
    }

    public String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getInt() {
        return getInt("Please enter number: ");
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

}
