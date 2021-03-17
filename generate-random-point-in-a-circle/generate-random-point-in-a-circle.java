import java.util.Random;
class Solution {
    double r;
    double x;
    double y;

    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }
    
    public double[] randPoint() {
        double xMin = x - r;
        double yMin = y - r;
        while(true) {
            double x2 = xMin + Math.random() * r * 2;
            double y2 = yMin + Math.random() * r * 2;
            if (Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2)) <= r) {
                return new double[]{x2, y2};
            }
        }
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */