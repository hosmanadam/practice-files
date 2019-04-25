package com.adamhosman;

import java.util.Scanner;

class X {

    private Scanner x = new Scanner(System.in);

    X() {

    }

    int x() {
        int x = -1;
        System.out.print("Enter `x`: ");
        if (this.x.hasNextInt()) {
            x = this.x.nextInt();
        }
        this.x.nextLine();
        return x;
    }

}
