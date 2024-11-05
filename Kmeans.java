import java.util.ArrayList;

public class Kmeans {
    Point[] points;
    Point[] centroids;

    public Kmeans(Point[] points, Point[] centroids) {
        this.points = points;
        this.centroids = centroids;
        runKmeans();
    }

    public void runKmeans() {
        boolean centroidChanged;
        do {
            centroidChanged = false;
            ArrayList<ArrayList<Point>> listePoints = new ArrayList<>();
    
            // Initialiser les listes pour chaque centroid
            for (int i = 0; i < centroids.length; i++) {
                listePoints.add(new ArrayList<>());
            }
    
            // Assigner les points au centroid le plus proche
            for (Point point : points) {
                int closestCentroidIndex = -1;
                double minDistance = Double.MAX_VALUE;
                for (int i = 0; i < centroids.length; i++) {
                    double distance = point.distance(centroids[i]);
                    if (distance < minDistance) {
                        minDistance = distance;
                        closestCentroidIndex = i;
                    }
                }
                listePoints.get(closestCentroidIndex).add(point);
            }
    
            // Sauvegarder les anciens centroids
            Point[] oldCentroids = new Point[centroids.length];
            for (int i = 0; i < centroids.length; i++) {
                oldCentroids[i] = new Point(centroids[i].getX(), centroids[i].getY(), centroids[i].getName());
            }
    
            // Recalculer les nouveaux centroids
            for (int i = 0; i < centroids.length; i++) {
                centroids[i] = moyenneCentroids(listePoints.get(i));
                if (!oldCentroids[i].equals(centroids[i])) {
                    centroidChanged = true;
                }
            }
    
            // Afficher les clusters uniquement après le recalcul
            if(centroidChanged){
                for (int i = 0; i < listePoints.size(); i++) {
                    System.out.println("Cluster " + (i + 1) + ": " + listePoints.get(i));
                }
                System.out.println("----------------------------------");
            }
    
        } while (centroidChanged);
    }
    

    public Point moyenneCentroids(ArrayList<Point> listePoints) {
        int sommeX = 0;
        int sommeY = 0;
        for (Point point : listePoints) {
            sommeX += point.getX();
            sommeY += point.getY();
        }
        int moyenneX = sommeX / listePoints.size();
        int moyenneY = sommeY / listePoints.size();
        return new Point(moyenneX, moyenneY, "");
    }
}
