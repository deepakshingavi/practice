import java.util.ArrayList;
import java.util.List;

public class PointOnLine {

    static void lineFromPoints(Point P, Point Q)
    {

    }

    // Driver code
    public static void main(String[] args)
    {
        Point P = new Point(3, 2);
        Point Q = new Point(2, 6);
        lineFromPoints(P, Q);
    }

    public Point[] getPointsOnCrosshair(Point a,Point b) {

        //getting slope of the line
        double m = (b.y - a.y)/( b.x - b.y);
        // slope intercept y = mx + b
        double c = b.y - (m * b.x);

        List<Point> pointsOnLine = new ArrayList<>();


        // stocked here

        return null; //to be completed
    }
}



class Point{
    int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
