public class RiskAdjustedPricingStrategy implements PricingStrategy{
    @Override
    double calculateFairValue(Instrument instrument){
        double risk = instrument.riskScore();
        return instrument.getCurrentPriceValue()*(1+0.1*risk);
    }
    @Override
    String strategyName(){
        return "RiskAdjustedPricingStrategy";
    }
}