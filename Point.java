public class Point{
    private int x, y;
    private String name;
    
    Point(){
        this.x = 0;
        this.y = 0;
        this.name = "";
    }

    Point(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public void copyPoint(Point p){
        this.x = p.getX();
        this.y = p.getY();
        this.name = p.getName();
    }

    public int getX(){
        return x;
    }   

    public int getY(){
        return y;
    }

    public double distance(Point p2){
        return Math.sqrt(Math.pow(p2.getX() - this.x, 2) + Math.pow(p2.getY() - this.y, 2));
    }

    public Point distanceProche(Point[] points){
        double distanceMin = Double.MAX_VALUE;
        Point pointProche = new Point();
        for (Point point : points) {
            double distance = distance(point);
            if(distance < distanceMin){
                distanceMin = distance;
                pointProche.copyPoint(point);
            }
        }
        return pointProche;
    }

    public String getName(){
        return name;
    }

    public boolean isCentroid(Point[] centroids){
        for (Point centroid : centroids){
            if(this.equals(centroid)){
                return true;
            }
        }
        return false;
    }


    public boolean equals(Point p){
        return this.x == p.getX() && this.y == p.getY() && this.name.equals(p.getName());
    }

    @Override
    public String toString(){
        if(name.equals("")){
            return name;
        }
        return name+"(" + x + ", " + y + ")";
    }
}