public class Main {
    public static void main(String[] args) {
        ShapeCreator circleCreator = new CircleCreator();
        ShapeCreator triangleCreator = new TriangleCreator();
        ShapeCreator squareCreator = new SquareCreator();

        Shape s1 = circleCreator.createShape();
        Shape s2 = triangleCreator.createShape();
        Shape s3 = squareCreator.createShape();

        s1.draw();
        s2.draw();
        s3.draw();
    }
}
