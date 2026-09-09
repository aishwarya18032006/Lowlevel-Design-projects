// Strategy pattern: interchangeable fee calculation algorithms
public interface FeeStrategy {
    double calculateFee(long durationInHours);
}
