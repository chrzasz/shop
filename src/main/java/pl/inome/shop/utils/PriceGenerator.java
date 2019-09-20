package pl.inome.shop.utils;

import org.apache.commons.math3.util.Precision;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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

    public Double randomPrice() {
        double range = max - min;
        return Precision.round(min + Math.random() * range, 2);
    }

    public String randomPriceFormatted(Double randomPrice) {
        DecimalFormat formater = new DecimalFormat("#0.00");
        return formater.format(randomPrice);
    }


}
