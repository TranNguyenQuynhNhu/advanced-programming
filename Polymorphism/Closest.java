package Polymorphism;

import java.util.*;

interface Point {
    double distTo(Point other);
    long getX();
    long getY();
}

class Point2D implements Point {
    private long x, y;

    public Point2D(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    @Override
    public double distTo(Point other) {
        long dx = x - other.getX();
        long dy = y - other.getY();
        return Math.sqrt((double)dx * dx + (double)dy * dy);
    }
}

public class Closest {
    static Point2D[] temp;

    public static double solve(Point2D[] pts) {
        Arrays.sort(pts, Comparator.comparingLong(Point2D::getX).thenComparingLong(Point2D::getY));
        temp = new Point2D[pts.length];
        return closest(pts, 0, pts.length - 1);
    }

    static double closest(Point2D[] pts, int left, int right) {
        if (right - left <= 3) {
            double ans = Double.MAX_VALUE;
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    ans = Math.min(ans, pts[i].distTo(pts[j]));
                }
            }
            Arrays.sort(pts, left, right + 1, Comparator.comparingLong(Point2D::getY));
            return ans;
        }
        int mid = (left + right) / 2;
        long midX = pts[mid].getX();
        double d1 = closest(pts, left, mid);
        double d2 = closest(pts, mid + 1, right);
        double d = Math.min(d1, d2);
        mergeByY(pts, left, mid, right);
        ArrayList<Point2D> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(pts[i].getX() - midX) < d) {
                strip.add(pts[i]);
            }
        }
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).getY() - strip.get(i).getY()) < d; j++) {
                d = Math.min(d, strip.get(i).distTo(strip.get(j)));
            }
        }
        return d;
    }

    static void mergeByY(Point2D[] pts, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (pts[i].getY() <= pts[j].getY()) temp[k++] = pts[i++];
            else temp[k++] = pts[j++];
        }
        while (i <= mid) temp[k++] = pts[i++];
        while (j <= right) temp[k++] = pts[j++];
        for (i = left; i <= right; i++) pts[i] = temp[i];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point2D[] pts = new Point2D[n];
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            pts[i] = new Point2D(x, y);
        }
        double ans = solve(pts);
        System.out.printf("%.6f\n", ans);
    }
}
