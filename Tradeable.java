public interface Tradeable {
    String getSymbol();

    double getCurrentPriceValue();

    boolean isAvailableForTrading();

    default String getTradingInfo() {
        // TODO
        String status = isAvailableForTrading()?"Available":"Not Available";
        return "Tradeable: " + getSymbol() + " at $" + getCurrentPriceValue() + " (" + status + ")";
    }
}
