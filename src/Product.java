import java.util.*;

class Product {
    private String name;
    private double recommendedPrice;

    public Product(String name, double recommendedPrice) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Назва товару не може бути пустою.");
        }
        if (recommendedPrice <= 0) {
            throw new IllegalArgumentException("Рекомендована ціна повинна бути більшою за 0.");
        }
        this.name = name;
        this.recommendedPrice = recommendedPrice;
    }

    public String getName() {
        return name;
    }

    public double getRecommendedPrice() {
        return recommendedPrice;
    }
}

