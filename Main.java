public class Main {
    public static void main(String[] args){
        
        
        Point s1 = new Point(10, 10, "S1");
        Point s2 = new Point(12, 10, "S2");
        Point s3 = new Point(11, 11, "S3");
        Point s4 = new Point(3, 3, "S4");
        Point s5 = new Point(4, 3, "S5");
        Point s6 = new Point(3, 4, "S6");
        Point s7 = new Point(20, 20, "S7");
        Point s8 = new Point(21, 20, "S8");
        Point[] points = {s1, s2, s3, s4, s5, s6, s7, s8};
        Point[] centroids = {s1, s4, s7}; // Initial centroids

        Kmeans kmeans = new Kmeans(points,centroids);
        
    }
}
