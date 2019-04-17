package com.adamhosman;

public class Point {

    private int x;

    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0,0);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        return distance(0, 0);
    }

    public double distance(int x, int y) {
        Point another = new Point(x, y);
        return distance(another);
    }

    public double distance(Point another) {
        return Math.sqrt(
                Math.pow(another.getX() - this.x, 2) +
                Math.pow(another.getY() - this.y, 2)
        );
    }

}
