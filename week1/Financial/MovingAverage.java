import java.util.*;

public class MovingAverage {
    public static List<Double> calculate(int[] data, int k) {
        List<Double> result = new ArrayList<>();
        double sum = 0;

        for (int i = 0; i < data.length; i++) {
            sum += data[i];
            if (i >= k) {
                sum -= data[i - k];
            }
            if (i >= k - 1) {
                result.add(Math.round((sum / k) * 100.0) / 100.0); 
            }
        }
        return result;
    }
}

class LinearTrendPredictor {
    public static double predictNext(int[] revenue) {
        int n = revenue.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += i;
            sumY += revenue[i];
            sumXY += i * revenue[i];
            sumX2 += i * i;
        }

        double slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double intercept = (sumY - slope * sumX) / n;

        return Math.round((slope * n + intercept) * 100.0) / 100.0;
    }
}
