package pl.inome.shop.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Component
@ConfigurationProperties(prefix = "shop-price-random-generator")
public class PriceGenerator {

    private double min;
    private double max;


    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    // ************ custom methods ************

    public BigDecimal randomPrice() {
        double range = max - min;
        return BigDecimal.valueOf(min + Math.random() * range).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public String randomPriceFormatted(Double randomPrice) {
        DecimalFormat formater = new DecimalFormat("#0.00");
        return formater.format(randomPrice);
    }


}
