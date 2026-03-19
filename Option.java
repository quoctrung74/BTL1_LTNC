public class Option extends Derivative {
    private final double strikePrice;
    private final boolean isCall;
    private final int expiryDays;

    public Option(String symbol, String name, double currentPrice, double strikePrice, boolean isCall, int expiryDays) {
        super(symbol, name, currentPrice);
        // TODO
        this.strikePrice = strikePrice;
        this.isCall = isCall;
        this.expiryDays = expiryDays;
    }

    @Override
    public double riskScore() {
        // TODO
        return 8.5;
    }
    
    public boolean isInTheMoney(double spotPrice) {
        // TODO
        if (isCall){
            return spotPrice > strikePrice;
        } else {
            retrun spotPrice < strikePrice;
        }
    }

    public double getStrikePrice() {
        // TODO
        return strikePrice;
    }

    public boolean isCall() {
        // TODO
        return isCall;
    }

    public int getExpiryDays() {
        // TODO
        return expiryDays;
    }
}
