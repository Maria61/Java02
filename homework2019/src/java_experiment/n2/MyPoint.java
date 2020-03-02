package java_experiment.n2;

/**
 * @author Maria
 * @program homework
 * @date 2019/10/28 15:38
 */
public class MyPoint {
    double x;
    double y;

    public MyPoint() {
        this.x = 0;
        this.y = 0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(MyPoint p){

        return Math.sqrt(Math.pow(Math.abs(x - p.x),2)+Math.pow(Math.abs(y - p.y),2));

    }
}
