import java.util.*;

public class Portfolio implements Observable<String> {
    private final String portfolioId;
    private final String ownerName;
    private final List<Position> positions;
    private final List<Observer<String>> observers;

    public Portfolio(String portfolioId, String ownerName) {
        this.portfolioId = portfolioId;
        this.ownerName = ownerName;
        this.positions = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addPosition(Instrument inst, int qty, double costBasis) {
        Position exist = null;
        for (Position p:positions){
            if (p.getInstrument().getSymbol().equals(inst.getSymbol())){
                exist = p;
                break;
            }
        } 
        if (exist != null){
            exist.addQuantity(qty, costBasis);
        } else {
            positions.add(new Position(inst, qty, costBasis));
        }
        notifyObservers("ADDED: " + inst.getSymbol() + " x" + qty);
    }

    public void removePosition(String symbol) throws PositionNotFoundException {
        Position needRemove = getPosition(symbol);
        positions.remove(needRemove);
        notifyObservers("REMOVE: " + symbol);
    }

    public double totalMarketValue() {
        double resultTotalMarketValue = 0;
        for (Position p : positions){
            resultTotalMarketValue += p.marketValue();
        }
        return resultTotalMarketValue;
    }

    public double totalUnrealizedPnL() {
        double resultTotalUnrealizedPnL = 0;
        for (Position p : positions){
            resultTotalUnrealizedPnL += p.unrealizedPnL();
        }
        return resultTotalUnrealizedPnL;
    }

    public Position getPosition(String symbol) throws PositionNotFoundException {
        for (Position p : positions){
            if (p.getInstrument().getSymbol().equals(symbol)){
                return p;
            }
        }
        throw new PositionNotFoundException("Position not found: " + symbol);
    }

    public List<Position> getPositionsSortedByValue() {
        List<Position> sorted = new ArrayList<>(positions);
        sorted.sort((p1,p2)->Double.compare(p2.marketValue(), p1.marketValue()));
        return sorted;
    }

    public Map<String, Double> allocationByAssetClass() {
        Map<String, Double> allocations = new HashMap<>();
        for (Position p:positions){
            String asset = p.getInstrument().assetClass();
            double value = p.marketValue();
            Double currentTotalValue = allocations.get(asset);
            if (currentTotalValue == null){
                currentTotalValue = 0.0;
            }
            allocations.put(asset, currentTotalValue + value);
        }
        return allocations;
    }

    public void revalueAll(PricingStrategy strategy) {
        for (Position p : positions){
            double fairValue = strategy.calculateFairValue(p.getInstrument());
            p.getInstrument().updatePrice(fairValue);
        }
        notifyObservers("REVALUED: " + strategy.strategyName());
    }

    @Override
    public void addObserver(Observer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<String> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (Observer<String> obs : observers) obs.onEvent(event);
    }

    public String getPortfolioId() {
        return portfolioId;
    }

    public String getOwnerName() {
        return ownerName;
    }
}
