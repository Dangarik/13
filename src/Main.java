import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Product product1 = new Product("Квас", 55.0);
            Product product2 = new Product("Сухарики", 23.0);

            Store store1 = new Store("ATB");
            Store store2 = new Store("Eco-market");

            StoreService service = new StoreService();
            service.addStore(store1);
            service.addStore(store2);

            store1.addProduct(product1, 50.0); // Ціна на Квас в магазині ATB
            store1.addProduct(product2, 20.0); // Ціна на Сухарики в магазині ATB
            store2.addProduct(product1, 30.0); // Ціна на Квас в магазині Eco-market
            store2.addProduct(product2, 25.0); // Ціна на Сухарики в магазині Eco-market

            double minPricePivo = service.findMinPrice("Квас");
            System.out.println("Ціна на Квас: " + minPricePivo);

            double minPriceSuhariki = service.findMinPrice("Сухарики");
            System.out.println("Ціна на Сухарики: " + minPriceSuhariki);

            Set<Store> storesWithMinPricePivo = service.findStoresWithMinPrice("Квас", minPricePivo);
            System.out.println("Магазини з мінімальною ціною на Квас:");
            for (Store store : storesWithMinPricePivo) {
                System.out.println(store.getName());
            }

            Set<Store> storesWithMinPriceSuhariki = service.findStoresWithMinPrice("Сухарики", minPriceSuhariki);
            System.out.println("Магазини з мінімальною ціною на Сухарики:");
            for (Store store : storesWithMinPriceSuhariki) {
                System.out.println(store.getName());
            }

            boolean isStoreWithAllCheaperForPivo = service.checkStoresWithPriceLessThanRecommended("Квас");
            System.out.println("Є магазини з ціною нижче рекомендованої на Квас: " + isStoreWithAllCheaperForPivo);

            boolean isStoreWithAllCheaperForSuhariki = service.checkStoresWithPriceLessThanRecommended("Сухарики");
            System.out.println("Є магазини з ціною нижче рекомендованої на Сухарики: " + isStoreWithAllCheaperForSuhariki);

            try {
                Product invalidProduct = null;
                invalidProduct.getName();
            } catch (NullPointerException e) {
                System.out.println("Виняток: Виявлено NullPointerException.");
            }

            try {
                store1.addProduct(product1, -10.0); // Ціна не може бути <= 0
            } catch (IllegalArgumentException e) {
                System.out.println("Виняток: " + e.getMessage());
            }

            try {
                store1.addProduct(null, 20.0); // Товар не може бути null
            } catch (IllegalArgumentException e) {
                System.out.println("Виняток: " + e.getMessage());
            }

            try {
                Store emptyStore = new Store("EmptyStore");
                if (emptyStore.isEmpty()) {
                    throw new IllegalStateException("Магазин порожній, не можна додавати товари.");
                }
            } catch (IllegalStateException e) {
                System.out.println("Виняток: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Загальний виняток: " + e.getMessage());
        }
    }
}