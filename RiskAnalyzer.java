import java.util.*;

public class RiskAnalyzer<T extends Instrument> {
    private final List<T> instruments = new ArrayList<>();

    public void add(T instrument) {
        if (instrument != null){
            instruments.add(instrument);
        }
    }

    public double averageRisk() {
        if (instruments.isEmpty()){
            return 0;
        }
        double totalRiskScore = 0;
        for (T inst : instruments){
            totalRiskScore += inst.riskScore();
        }
        return totalRiskScore / instruments.size();
    }

    public T highestRisk() {
        if (instruments.isEmpty()){
            return null;
        }
        T instHighestRiskScore = instruments.get(0);
        long size = instruments.size();
        for (int i=1; i<size; i++){
            if (instruments.get(i).riskScore() > instHighestRiskScore.riskScore()){
                instHighestRiskScore = instruments.get(i);
            }
        }
        return instHighestRiskScore;
    }

    public T lowestRisk() {
        if (instruments.isEmpty()){
            return null;
        }
        T instLowestRiskScore = instruments.get(0);
        long size = instruments.size();
        for (int i=1; i<size; i++){
            if (instruments.get(i).riskScore() < instLowestRiskScore.riskScore()){
                instLowestRiskScore = instruments.get(i);
            }
        }
        return instLowestRiskScore;
    }

    public List<T> getAboveRiskThreshold(double threshold) {
        if (instruments.isEmpty()){
            return new ArrayList<>();
        }
        List<T> instAboveRiskThreshold = new ArrayList<>();
        for (T inst : instruments){
            if (inst.riskScore() > threshold){
                instAboveRiskThreshold.add(inst);
            }
        }
        return instAboveRiskThreshold;
    }
}
