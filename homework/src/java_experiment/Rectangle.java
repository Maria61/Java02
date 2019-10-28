package java_experiment;

/**
 * @author Maria
 * @program homework
 * @date 2019/10/28 14:42
 */
public class Rectangle {
    double width;
    double height;
    String color;

    public Rectangle() {
        this.color = "白色";
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return width*height;
    }

    public double getPerimeter(){
        return 2*(width + height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                '}';
    }
}
