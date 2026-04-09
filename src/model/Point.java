package model;

/** Точка на плоскости с координатами x и y */
public class Point {
    private double x;
    private double y;

    /** Конструктор: x и y */
    // FIX_ME: не было пробелов после запятых
    // старый код: public Point(double x,double y)
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /** Возвращает X */
    public double getX() {
        return x;
    }

    /** Устанавливает X */
    public void setX(double x) {
        this.x = x;
    }

    /** Возвращает Y */
    public double getY() {
        return y;
    }

    /** Устанавливает Y */
    public void setY(double y) {
        this.y = y;
    }

    /** Сдвигает точку на dx, dy */
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /** Возвращает строку: "{x;y}" */
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}