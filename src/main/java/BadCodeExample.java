public class BadCodeExample {
    public void processOrder(Order order) {
        // Input validation
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order items cannot be empty");
        }

        // Calculate total price
        double totalPrice = 0;
        for (OrderItem item : order.getItems()) {
            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Invalid quantity for item: " + item.getName());
            }
            double itemPrice = item.getPrice();
            if (itemPrice < 0) {
                throw new IllegalArgumentException("Invalid price for item: " + item.getName());
            }
            totalPrice += itemPrice * item.getQuantity();
        }

        // Apply discounts
        if (order.isDiscounted()) {
            double discountPercentage = order.getDiscountPercentage();
            if (discountPercentage < 0 || discountPercentage > 100) {
                throw new IllegalArgumentException("Invalid discount percentage");
            }
            totalPrice *= (1 - discountPercentage / 100);
        }

        // Apply taxes
        double taxRate = 0.1;
        if (order.getCountry().equals("USA")) {
            taxRate = 0.08;
        } else if (order.getCountry().equals("UK")) {
            taxRate = 0.2;
        }
        double taxAmount = totalPrice * taxRate;
        totalPrice += taxAmount;

        // Apply shipping cost
        double shippingCost = 0;
        if (totalPrice >= 100) {
            shippingCost = 5;
        } else if (totalPrice >= 50) {
            shippingCost = 10;
        } else {
            shippingCost = 15;
        }
        totalPrice += shippingCost;

        // Save the order to the database
        OrderDAO.saveOrder(order);

        // Send email notification
        EmailService.sendEmail(order.getCustomerEmail(), "Order Confirmation",
                "Thank you for your order! Your total amount is: $" + totalPrice);
    }

    // ... 200 lines more of other unrelated methods and code
}
