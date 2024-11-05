public class Point {
    private int x, y;
    private String name;

    public Point() {
        this.x = 0;
        this.y = 0;
        this.name = "";
    }

    public Point(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance(Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - this.x, 2) + Math.pow(p2.getY() - this.y, 2));
    }

    public Point distanceProche(Point[] points) {
        double distanceMin = Double.MAX_VALUE;
        Point pointProche = new Point();
        for (Point point : points) {
            double distance = distance(point);
            if (distance < distanceMin) {
                distanceMin = distance;
                pointProche.copyPoint(point);
            }
        }
        return pointProche;
    }

    public void copyPoint(Point p) {
        this.x = p.getX();
        this.y = p.getY();
        this.name = p.getName();
    }

    public String getName() {
        return name;
    }

    public boolean isCentroid(Point[] centroids) {
        for (Point centroid : centroids) {
            if (this.equals(centroid)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public String toString() {
        if (name.equals("")) {
            return "(" + x + ", " + y + ")";
        }
        return name + "(" + x + ", " + y + ")";
    }
}
