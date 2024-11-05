import java.util.ArrayList;
public class Kmeans{
    Point[] points;
    Point[] centroids;

    public Kmeans(Point[] points, Point[] centroids){
        this.points = points;
        this.centroids = centroids;
        runKmeans();
    }

    public void runKmeans(){
        Point[] oldCentroids = new Point[centroids.length];
        boolean centroidsChanged;
        do {
            // Sauvegarder les centroïdes actuels
            for (int i = 0; i < centroids.length; i++) {
                oldCentroids[i] = new Point(centroids[i].getX(), centroids[i].getY(), centroids[i].getName());
            }

            ArrayList<ArrayList<Point>> listePoints = new ArrayList<>();
            for (int i = 0; i < centroids.length; i++) {
                listePoints.add(new ArrayList<>());
            }

            for (Point point : points) {
                if (!point.isCentroid(centroids)) {
                    int closestCentroidIndex = -1;
                    double minDistance = Double.MAX_VALUE;
                    for (int i = 0; i < centroids.length; i++) {
                        double distance = point.distance(centroids[i]);
                        if (distance < minDistance) {
                            minDistance = distance;
                            closestCentroidIndex = i;
                        }
                    }
                    if (closestCentroidIndex != -1) {
                        listePoints.get(closestCentroidIndex).add(point);
                    }
                }
            }

            for (int i = 0; i < listePoints.size(); i++) {
                System.out.println(listePoints.get(i));
            }
            System.out.println("----------------------------------");

            centroidsChanged = false; // Réinitialiser le drapeau de changement
            for (int i = 0; i < centroids.length; i++) {
                Point newCentroid = moyenneCentroids(listePoints.get(i));
                if (!newCentroid.equals(centroids[i])) {
                    centroidsChanged = true; // Les centroïdes ont changé
                }
                centroids[i] = newCentroid;
                //System.out.println(centroids[i]);
            }

        } while (centroidsChanged); // Continuer tant que les centroïdes changent
    }

    public Point moyenneCentroids(ArrayList<Point> listePoints){
        if (listePoints.isEmpty()) {
            // Si la liste est vide, retourner un centroïde par défaut ou conserver l'ancien centroïde
            return new Point(0, 0, ""); // Ou vous pouvez retourner un centroïde existant
        }

        int moyenneX = 0;
        int moyenneY = 0;
        for(int j = 0; j < listePoints.size(); j++){
            moyenneX += listePoints.get(j).getX();
            moyenneY += listePoints.get(j).getY();
        }
        moyenneX /= listePoints.size();
        moyenneY /= listePoints.size();
        return new Point(moyenneX, moyenneY, "");
    }
}