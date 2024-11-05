public class Main {
    public static void main(String[] args){

        Point a1 = new Point(2, 10, "A1");
        Point a2 = new Point(2, 5, "A2");
        Point a3 = new Point(8, 4, "A3");
        Point b1 = new Point(5, 8, "B1");
        Point b2 = new Point(7, 5, "B2");
        Point b3 = new Point(6, 4, "B3");
        Point c1 = new Point(1, 2, "C1");
        Point c2 = new Point(4, 9, "C2");
        Point[] points = {a1, a2, a3, b1, b2, b3, c1, c2};
        Point[] centroids = {a1, b1, c1};

        Kmeans kmeans = new Kmeans(points,centroids);
        
    }
}
