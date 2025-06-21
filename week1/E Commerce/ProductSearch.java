import java.util.*;

public class ProductSearch {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        manager.addProduct(new Product("Blue Running Shoes", "Footwear", "Comfortable shoes for running", 1299));
        manager.addProduct(new Product("Adidas Sports Shoes", "Footwear", "High-quality sportswear", 2499));
        manager.addProduct(new Product("Red T-Shirt", "Apparel", "Cotton casual t-shirt", 599));
        manager.addProduct(new Product("Blue Jeans", "Apparel", "Slim-fit jeans for men", 1199));

        Scanner sc = new Scanner(System.in);
        System.out.print("Search (type something): ");
        String input = sc.nextLine();

        System.out.println("\nAutocomplete Suggestions:");
        for (String s : manager.getSuggestions(input)) {
            System.out.println(" → " + s);
        }

        System.out.println("\nSearch Results:");
        for (Product p : manager.search(input)) {
            System.out.println(" - " + p);
        }

        sc.close();
    }
}
class Product {
    String name;
    String category;
    String description;
    double price;

    public Product(String name, String category, String description, double price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - ₹" + price;
    }

    public String getName() {
        return name.toLowerCase();
    }

    public String getDescription() {
        return description.toLowerCase();
    }
}

class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<String> getSuggestions(String input) {
        input = input.toLowerCase();
        List<String> suggestions = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().contains(input)) {
                suggestions.add(p.name);
            }
        }
        return suggestions;
    }

    public List<Product> search(String input) {
        input = input.toLowerCase();
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().contains(input) || p.getDescription().contains(input)) {
                result.add(p);
            }
        }
        return result;
    }
}
