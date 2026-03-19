public class Future extends Derivative {
    private final double contractSize;
    private final int expiryDays;

    public Future(String symbol, String name, double currentPrice, double contractSize, int expiryDays) {
        super(symbol, name, currentPrice);
        // TODO
        this.contractSize = contractSize;
        this.expiryDays = expiryDays;
    }

    @Override
    public double riskScore() {
        // TODO
        return 8.5;
    }

    public double getContractSize() {
        // TODO
        retrun contractSize;
    }

    public int getExpiryDays() {
        // TODO
        return expiryDays;
    }
}
