class Ball {
    private double radius;
    private double x;
    private double y;
    private double deltaX;
    private double deltaY;

    public Ball(double radius, double x, double y, double deltaX, double deltaY) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public void move() {
        x += deltaX;
        y += deltaY;
    }

    public void reflectHorizontal() {
        deltaX = -deltaX;
    }

    public void reflectVertical() {
        deltaY = -deltaY;
    }

    public void checkBounce(int width, int height) {
        if (x - radius < 0 || x + radius > width) {
            reflectHorizontal();
        }
        if (y - radius < 0 || y + radius > height) {
            reflectVertical();
        }
    }

    public void print() {
        System.out.println("Ball at (" + x + ", " + y + ")");
    }
}

public class BallClassMain {
    public static void main(String[] args) {
        int width = 100;
        int height = 50;
        Ball ball = new Ball(5, 20, 10, 7, 4);
        for (int i = 1; i <= 15; i++) {
            ball.move();
            ball.checkBounce(width, height);
            System.out.print("Step " + i + ": ");
            ball.print();
        }
    }
}
