public class SimplePricingStrategy implements PricingStrategy{
    @Override
    double calculateFairValue(Instrument instrument){
        return instrument.getCurrentPriceValue()*1.05;
    }
    @Override
    String strategyName(){
        return "SimplePricingStrategy";
    }
}