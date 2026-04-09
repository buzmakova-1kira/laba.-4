package model;

import java.util.ArrayList;
import java.util.List;

/** Ломаная линия: массив точек */
public class Polyline {
    private List<Point> points;

    /** Конструктор: пустая ломаная */
    public Polyline() {
        this.points = new ArrayList<>();
    }

    /** Конструктор: ломаная из списка точек */
    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    /** Возвращает копию списка точек */
    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    /** Возвращает первую точку */
    public Point getFirstPoint() {
        return points.isEmpty() ? null : points.get(0);
    }

    /** Возвращает последнюю точку */
    public Point getLastPoint() {
        return points.isEmpty() ? null : points.get(points.size() - 1);
    }

    /** Добавляет точку */
    public void addPoint(Point point) {
        points.add(point);
    }

    /** Добавляет точку по координатам */
    public void addPoint(double x, double y) {
        points.add(new Point(x, y));
    }

    /** Сдвигает все точки */
    public void move(double dx, double dy) {
        for (Point point : points) {
            point.move(dx, dy);
        }
    }

    /** Возвращает строку: "Линия [Т1,Т2,...]" */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.size(); i++) {
            sb.append(points.get(i));
            if (i < points.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}