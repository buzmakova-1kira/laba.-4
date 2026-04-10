package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Ломаная линия с вычислением длины */
public class PolylineWithLength {
    private List<Point> points;

    /** Конструктор: пустая ломаная */
    public PolylineWithLength() {
        this.points = new ArrayList<>();
    }

    /** Конструктор: ломаная из списка точек */
    public PolylineWithLength(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    /** Возвращает копию списка точек */
    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    /** Добавляет точку */
    public void addPoint(Point point) {
        points.add(point);
    }

    /** Добавляет точку по координатам */
    public void addPoint(double x, double y) {
        points.add(new Point(x, y));
    }

    /** Добавляет несколько точек  */
    public void addPoints(Point... newPoints) {
        points.addAll(Arrays.asList(newPoints));
    }

    /** Возвращает общую длину ломаной */
    public double getLength() {
        if (points.size() < 2) {
            return 0.0;
        }

        double length = 0.0;
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            double dx = p2.getX() - p1.getX();
            double dy = p2.getY() - p1.getY();
            length += Math.sqrt(dx * dx + dy * dy);
        }
        return length;
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