import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] revenue = {1200, 1300, 1250, 1400, 1500, 1600, 1550, 1650};

        System.out.println("Past Revenue (Last 8 Days):");
        System.out.println(Arrays.toString(revenue));

        System.out.println("\n 3-Day Moving Averages:");
        List<Double> movingAvg = MovingAverage.calculate(revenue, 3);
        for (double avg : movingAvg) {
            System.out.println(" → " + avg);
        }

        double nextPrediction = LinearTrendPredictor.predictNext(revenue);
        System.out.println("\n🔮 Predicted Revenue for Next Day (Using Linear Regression): ₹" + nextPrediction);
    }
}
