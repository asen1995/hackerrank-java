public class BadCodeExample {
    public void processOrder(Order order) {

        validateOrder(order);

        double totalPrice = getTotalPricesOfItemsInOrder(order);

        if (orderIsDiscounted(order)) {

            double discountPercentage = order.getDiscountPercentage();
            if (invalidDiscountPercentage(discountPercentage)) {
                throw new IllegalArgumentException("Invalid discount percentage");
            }
            totalPrice = applyDiscountPercantage(totalPrice, discountPercentage);
        }

        double taxRate = determineTaxRate(order);

        double taxAmount = calculateTaxAmount(totalPrice, taxRate);

        totalPrice += taxAmount;

        double shippingCost = determineShippingCostBasedOnTotalPrice(totalPrice);
        totalPrice += shippingCost;
        saveOrder(order);
        sendEmailNotification(order, totalPrice);
    }

    private void sendEmailNotification(Order order, double totalPrice) {
        EmailService.sendEmail(order.getCustomerEmail(), "Order Confirmation",
                "Thank you for your order! Your total amount is: $" + totalPrice);
    }

    private void saveOrder(Order order) {
        // Save the order to the database
        OrderDAO.saveOrder(order);
    }

    private double determineShippingCostBasedOnTotalPrice(double totalPrice) {
        double shippingCost = 0;
        if (totalPrice >= 100) {
            shippingCost = 5;
        } else if (totalPrice >= 50) {
            shippingCost = 10;
        } else {
            shippingCost = 15;
        }
        return shippingCost;
    }

    private double calculateTaxAmount(double totalPrice, double taxRate) {
        return totalPrice * taxRate;
    }

    private double determineTaxRate(Order order) {
        double taxRate = 0.1;
        if (order.getCountry().equals("USA")) {
            taxRate = 0.08;
        } else if (order.getCountry().equals("UK")) {
            taxRate = 0.2;
        }
        return taxRate;
    }

    private double applyDiscountPercantage(double totalPrice, double discountPercentage) {
        totalPrice *= (1 - discountPercentage / 100);
        return totalPrice;
    }

    private boolean invalidDiscountPercentage(double discountPercentage) {
        return discountPercentage < 0 || discountPercentage > 100;
    }

    private boolean orderIsDiscounted(Order order) {
        return order.isDiscounted();
    }

    private void validateOrder(Order order) {
        if (orderIsNull(order)) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (orderNotContainAnyItems(order)) {
            throw new IllegalArgumentException("Order items cannot be empty");
        }
    }

    private double getTotalPricesOfItemsInOrder(Order order) {
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
        return totalPrice;
    }

    private boolean orderNotContainAnyItems(Order order) {
        return order.getItems() == null || order.getItems().isEmpty();
    }

    private boolean orderIsNull(Order order) {
        return order == null;
    }


}
