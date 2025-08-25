package com.tech.subash.collectors;

class PriceRange {
    String minFruit;
    int minPrice;
    String maxFruit;
    int maxPrice;

    public PriceRange(String minFruit, int minPrice, String maxFruit, int maxPrice) {
        this.minFruit = minFruit;
        this.minPrice = minPrice;
        this.maxFruit = maxFruit;
        this.maxPrice = maxPrice;
    }

    @Override
    public String toString() {
        return String.format("Min: %s = %d, Max: %s = %d",
                minFruit, minPrice, maxFruit, maxPrice);
    }
}
