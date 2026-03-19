import java.time.LocalDateTime;

public abstract class Instrument {
    private final String symbol;
    private String name;
    private double currentPrice;
    private LocalDateTime lastUpdated;

    public Instrument(String symbol, String name, double currentPrice) {
        // TODO
        this.symbol = symbol;
        this.name = name;
        this.currentPrice = currentPrice;
        this.lastUpdated = LocalDateTime.now();
    }

    public abstract double riskScore();

    public abstract String assetClass();
    
    public void updatePrice(double newPrice) {
        // TODO
        if (newPrice < 0) throw new IllegalArgumentException();
        this.currentPrice = newPrice;
        this.lastUpdated = LocalDateTime.now();
    }

    public String getSymbol() {
        // TODO
        return symbol;
    }

    public String getName() {
        // TODO
        return name;
    }

    public double getCurrentPriceValue() {
        // TODO
        return currentPrice;
    }

    public LocalDateTime getLastUpdated() {
        // TODO
        return lastUpdated;
    }

    @Override
    public String toString() {
        // TODO
        return this.getClass().getSimpleName() + "[symbol=" + symbol + ", price=" + currentPrice + ", risk=" + riskScore() + "]"; 
    }
}
