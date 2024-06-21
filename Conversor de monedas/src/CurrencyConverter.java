public class CurrencyConverter {
    private double usdToEurRate;
    private double usdToDopRate;
    private double eurToDopRate;

    public CurrencyConverter() {
        this.usdToEurRate = 0.0;
        this.usdToDopRate = 0.0;
        this.eurToDopRate = 0.0;
    }

    public void setUsdToEurRate(double rate) {
        this.usdToEurRate = rate;
    }

    public void setUsdToDopRate(double rate) {
        this.usdToDopRate = rate;
    }

    public void setEurToDopRate(double rate) {
        this.eurToDopRate = rate;
    }

    public double convertUsdToEur(double amountInUsd) {
        return amountInUsd * usdToEurRate;
    }

    public double convertEurToUsd(double amountInEur) {
        return amountInEur / usdToEurRate;
    }

    public double convertUsdToDop(double amountInUsd) {
        return amountInUsd * usdToDopRate;
    }

    public double convertDopToUsd(double amountInDop) {
        return amountInDop / usdToDopRate;
    }

    public double convertEurToDop(double amountInEur) {
        return amountInEur * eurToDopRate;
    }

    public double convertDopToEur(double amountInDop) {
        return amountInDop / eurToDopRate;
    }
}
