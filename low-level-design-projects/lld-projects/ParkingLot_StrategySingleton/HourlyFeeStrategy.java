public class HourlyFeeStrategy implements FeeStrategy {
    private static final double RATE_PER_HOUR = 20.0;

    @Override
    public double calculateFee(long durationInHours) {
        return durationInHours * RATE_PER_HOUR;
    }
}
