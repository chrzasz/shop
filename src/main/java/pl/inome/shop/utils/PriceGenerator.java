package pl.inome.shop.utils;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class PriceGenerator {

    private String randomPriceText;

    public PriceGenerator() {
    }

    public PriceGenerator(String randomPrice) {
        this.randomPriceText = randomPrice;
    }

    public String getRandomPrice() {
        return randomPriceText;
    }

    private Double randomPrice(Double min, Double max) {

        double range = max - min;
        return min + Math.random() * range;
    }

    private String randomPriceFormatted(Double randomPrice) {

        DecimalFormat formater = new DecimalFormat("#0.00");
        return formater.format(randomPrice);
    }

    public static void main(String[] args) {

        PriceGenerator priceGenerator = new PriceGenerator();
        System.out.println(priceGenerator.randomPriceFormatted(priceGenerator.randomPrice(50d, 300d)));

    }

}
