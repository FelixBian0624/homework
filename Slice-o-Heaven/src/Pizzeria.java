import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    private static final String DEF_ORDER_ID = "DEF-SOH-099";
    private static final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    private static final double DEF_ORDER_TOTAL = 15.00;

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
    private String specialPizza;
    private String specialSide;
    private double specialPrice;

    public Pizzeria() {
        this.storeName = "Slice-o-Heaven";
        this.storeAddress = "Unknown";
        this.storeEmail = "N/A";
        this.storePhone = "N/A";
        this.storeMenu = new ArrayList<>();
        this.pizzaIngredients = new ArrayList<>();
        this.pizzaIngredients.add(DEF_PIZZA_INGREDIENTS); 
        this.pizzaPrice = 0.0;
        this.sides = new ArrayList<>();
        this.sides.add("None");        
        this.drinks = new ArrayList<>();
        this.drinks.add("None");       
        this.orderID = DEF_ORDER_ID;   
        this.orderTotal = DEF_ORDER_TOTAL; 
    }

    public Pizzeria(String storeName, String storeAddress, String storeEmail, String storePhone) {
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storeEmail = storeEmail;
        this.storePhone = storePhone;
        this.storeMenu = new ArrayList<>();
        this.pizzaIngredients = new ArrayList<>();
        this.pizzaPrice = 0.0;
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.orderID = DEF_ORDER_ID;   
        this.orderTotal = DEF_ORDER_TOTAL; 
    }

    public Pizzeria(String orderID, List<String> pizzaIngredients, double orderTotal) {
        this.storeName = "Slice-o-Heaven";
        this.storeAddress = "Unknown";
        this.storeEmail = "N/A";
        this.storePhone = "N/A";
        this.storeMenu = new ArrayList<>();
        this.pizzaIngredients = pizzaIngredients; 
        this.pizzaPrice = 0.0;
        this.sides = new ArrayList<>();
        this.sides.add("None");
        this.drinks = new ArrayList<>();
        this.drinks.add("None");
        this.orderID = orderID;         
        this.orderTotal = orderTotal;  
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void takeOrder(String pizzaType, List<String> ingredients, double pizzaPrice, List<String> sides, List<String> drinks) {
        this.pizzaIngredients = ingredients;
        this.pizzaPrice = pizzaPrice;
        this.sides = sides;
        this.drinks = drinks;
        this.orderID = generateOrderID();
        calculatedOrderTotal();
    }

    private String generateOrderID() {
        return "ORD" + System.currentTimeMillis();
    }

    private void calculatedOrderTotal() {
        this.orderTotal = pizzaPrice;
        this.orderTotal += sides.size() * 5;
        this.orderTotal += drinks.size() * 3;
    }

    private void printReceipt() {
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

    public void displayReceipt() {
        printReceipt();
    }

    public void makePizza() {
        System.out.println("Making a pizza with the following ingredients: " + String.join(", ", pizzaIngredients));
    }


    public void processCardPayment(String cardNumber, String expiryDate, int cvv) {
        int cardLength = cardNumber.length();
        if (cardLength == 14) {
            System.out.println("Card accepted");
        } else {
            System.out.println("Invalid card");
            return;
        }

        int firstCardDigit = Integer.parseInt(cardNumber.substring(0, 1));
        System.out.println("First digit of card: " + firstCardDigit);

        String blacklistedNumber = "12345678901234"; 
        if (cardNumber.equals(blacklistedNumber)) {
            System.out.println("Card is blacklisted. Please use another card");
            return; 
        }

        int lastFourDigits = Integer.parseInt(cardNumber.substring(cardNumber.length() - 4));
        System.out.println("Last four digits: " + lastFourDigits);

        StringBuilder cardNumberToDisplay = new StringBuilder(cardNumber);
        for (int i = 1; i < cardLength - 4; i++) {
            cardNumberToDisplay.setCharAt(i, '*');
        }
        System.out.println("Card number to display: " + cardNumberToDisplay.toString());
    }

    public void specialOfTheDay(String pizzaOfTheDay, String sideOfTheDay, double specialPrice) {
        this.specialPizza = pizzaOfTheDay;
        this.specialSide = sideOfTheDay;
        this.specialPrice = specialPrice;

        StringBuilder specialInfo = new StringBuilder();
        specialInfo.append("Today's Special: ")
                   .append(pizzaOfTheDay)
                   .append(" with ")
                   .append(sideOfTheDay)
                   .append(" for $")
                   .append(String.format("%.2f", specialPrice));
        System.out.println(specialInfo.toString());
    }

    public static void main(String[] args) {
        Pizzeria defaultPizzeria = new Pizzeria();
        System.out.println("测试默认构造方法：");
        defaultPizzeria.displayReceipt();

        Pizzeria sliceOHeaven = new Pizzeria("Slice-o-Heaven", "123 Pizza St, Pizzaville", "contact@sliceoheaven.com", "123-456-7890");
        List<String> pizzaIngredients = new ArrayList<>();
        pizzaIngredients.add("Cheese");
        pizzaIngredients.add("Tomato");
        pizzaIngredients.add("Pepperoni");
        List<String> sides = new ArrayList<>();
        sides.add("Garlic Bread");
        List<String> drinks = new ArrayList<>();
        drinks.add("Coke");
        sliceOHeaven.takeOrder("Pepperoni Pizza", pizzaIngredients, 10.00, sides, drinks);
        System.out.println("\n测试 takeOrder 方法：");
        sliceOHeaven.makePizza();
        sliceOHeaven.displayReceipt();
        System.out.println("\n测试信用卡支付：");
        sliceOHeaven.processCardPayment("41234567890123", "12/26", 123);

        List<String> customIngredients = new ArrayList<>();
        customIngredients.add("Sausage");
        Pizzeria customPizzeria = new Pizzeria("SOH-999", customIngredients, 20.00);
        System.out.println("\n测试新构造方法：");
        customPizzeria.displayReceipt();

        System.out.println("\n测试每日特价：");
        sliceOHeaven.specialOfTheDay("Margherita Pizza", "Fries", 12.99);
    }
}