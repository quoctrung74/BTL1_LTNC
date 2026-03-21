public class TaxReportVisitor implements InstrumentVisitor {
    private double totalTaxLiability = 0;
    private StringBuilder report = new StringBuilder("Tax Report: ");

    @Override
    public void visit(Stock stock){
        double tax = stock.getCurrentPriceValue() * 0.15;
        totalTaxLiability += tax;
        report.append("[Stock: " + stock.getSymbol() + ", " + tax + "]");
    }

    @Override
    public void visit(Bond bond){
        double tax = bond.annualCouponPayment(1) * 0.3;
        totalTaxLiability += tax;
        report.append("[Bond: " + bond.getSymbol() + ", " + tax + "]");
    }

    @Override
    public void visit(Future future){
        double tax = future.getCurrentPriceValue() * 0.2;
        totalTaxLiability += tax;
        report.append("[Future: " + future.getSymbol() + ", " + tax + "]");
    }

    @Override
    public void visit(Option option){
        double tax = option.getCurrentPriceValue() * 0.2;
        totalTaxLiability += tax;
        report.append("[Option: " + option.getSymbol() + ", " + tax + "]");
    }

    public double getTotalTaxLiability(){
        return totalTaxLiability;
    }

    public String getReport(){
        return report.toString() + ", Total Liability: " + totalTaxLiability;
    }
}