public class FlatRateFeeStrategy implements FeeStrategy {
    private static final double FLAT_RATE = 100.0;

    @Override
    public double calculateFee(long durationInHours) {
        return FLAT_RATE;
    }
}
