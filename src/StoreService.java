import java.util.*;

class StoreService {
    private Set<Store> stores;

    public StoreService() {
        this.stores = new HashSet<>();
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public double findMinPrice(String productName) {
        double minPrice = Double.MAX_VALUE;
        for (Store store : stores) {
            Double price = store.getPriceForProduct(productName);
            if (price != null && price < minPrice) {
                minPrice = price;
            }
        }
        return minPrice;
    }

    public Set<Store> findStoresWithMinPrice(String productName, double minPrice) {
        Set<Store> result = new HashSet<>();
        for (Store store : stores) {
            Double price = store.getPriceForProduct(productName);
            if (price != null && price == minPrice) {
                result.add(store);
            }
        }
        return result;
    }

    public boolean checkStoresWithPriceLessThanRecommended(String productName) {
        for (Store store : stores) {
            for (Product product : store.getProductPrices().keySet()) {
                if (product.getName().equals(productName)) {
                    Double price = store.getPriceForProduct(productName);
                    if (price != null && price < product.getRecommendedPrice()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}