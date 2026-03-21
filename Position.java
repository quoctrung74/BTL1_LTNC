public class Position {
    private final Instrument instrument;
    private int quantity;
    private double averageCostBasis;

    public Position(Instrument instrument, int quantity, double averageCostBasis) {
        // TODO
        this.instrument = instrument;
        this.quantity = quantity;
        this.averageCostBasis = averageCostBasis;
    }

    public double marketValue() {
        // TODO
        return this.quantity * instrument.getCurrentPriceValue();
    }

    public double unrealizedPnL() {
        // TODO
        return marketValue() - this.quantity * this.averageCostBasis;
    }

    public void addQuantity(int qty, double costBasis) {
        // TODO
        this.quantity += qty;
        double totalCost = (this.quantity * this.averageCostBasis) + (qty * costBasis);
        this.averageCostBasis = totalCost/this.quantity;
    }

    public Instrument getInstrument() {
        // TODO
        return instrument;
    }

    public int getQuantity() {
        // TODO
        return quantity;
    }

    public double getAverageCostBasis() {
        // TODO
        return averageCostBasis;
    }

    @Override
    public String toString() {
        // TODO
        return "Position: [" + instrument.getSymbol() + ", quantity=" + quantity + ", averageCostBasis=" + averageCostBasis +"]"; 
    }
}
