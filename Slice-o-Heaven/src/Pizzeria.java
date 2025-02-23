import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public String storePhone;
    public List<String> storeMenu;
    public List<String> pizzaIngredients;
    public double pizzaPrice;
    public List<String> sides;
    public List<String> drinks;  
    private String orderID;
    private double orderTotal;

    public Pizzeria(String storeName, String storeAddress, String storeEmail,String storePhone){
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeEmail = storeEmail;
        this.storePhone = storePhone;
        this.storeMenu = new ArrayList<>();
        this.pizzaIngredients = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();
    } 
     
    public void takeOrder(String pizzaType, List<String> ingredients, double pizzaPrice, List<String> sides, List<String> drinks){
     this.pizzaIngredients = ingredients;
     this.pizzaPrice = pizzaPrice;
     this.sides = sides;
     this.drinks = drinks;
     this.orderID = generateOrderID();
     calculatedOrderTotal();

    }

    
    private String generateOrderID(){
        return "ORD" + System.currentTimeMillis();
    }

    private void calculatedOrderTotal(){
       this.orderTotal = pizzaPrice;
       this.orderTotal += sides.size() * 5;
       this.orderTotal += drinks.size() * 3;
    }
    
    public void printReceipt() {
        System.out.println("\nReceipt for Order ID: " + orderID);
        System.out.println("Pizzeria: " + storeName);
        System.out.println("Address: " + storeAddress);
        System.out.println("Email: " + storeEmail);
        System.out.println("Phone: " + storePhone);
        System.out.println("Pizza Ingredients: " + String.join(", ", pizzaIngredients));
        System.out.println("Sides: " + String.join(", ", sides));
        System.out.println("Drinks: " + String.join(", ", drinks));
        System.out.println("Order Total: $" + orderTotal);
    }
    
    public void makePizza(){
        System.out.println("Making a pizza with the following ingredients:"  +  String.join(", ", pizzaIngredients));
    }

    public static void main(String[] args){
        Pizzeria sliceOHeaven = new Pizzeria("Slice-o-Heaven","123 pizza St,Pizzaville","contact@sliceoheaven.com","123-456-7890");

        List<String> pizzaIngredients = new ArrayList<>();
        pizzaIngredients.add("Cheese");
        pizzaIngredients.add("Tomato");
        pizzaIngredients.add("Pepperoni");
        
        List<String> sides = new ArrayList<>();
        sides.add("Garlic Bread");
        
        List<String> drinks = new ArrayList<>();
        drinks.add("Coke");
        
        sliceOHeaven.takeOrder("Pepperoni Pizza", pizzaIngredients, 10.00, sides, drinks);
        sliceOHeaven.makePizza();
        sliceOHeaven.printReceipt();
    }
    
}
