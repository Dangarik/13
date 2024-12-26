import java.util.*;
class Store {
    private String name;
    private Map<Product, Double> productPrices;

    public Store(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Назва магазину не може бути пустою.");
        }
        this.name = name;
        this.productPrices = new HashMap<>();
    }

    public void addProduct(Product product, double price)
            throws PriceExceedsRecommendedException {
        if (product == null) {
            throw new IllegalArgumentException("Товар не може бути null.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Ціна товару повинна бути більшою за 0.");
        }
        productPrices.put(product, price);
    }

    public Map<Product, Double> getProductPrices() {
        return productPrices;
    }

    public String getName() {
        return name;
    }

    public Double getPriceForProduct(String productName) {
        for (Product product : productPrices.keySet()) {
            if (product.getName().equals(productName)) {
                return productPrices.get(product);
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return productPrices.isEmpty();
    }
}