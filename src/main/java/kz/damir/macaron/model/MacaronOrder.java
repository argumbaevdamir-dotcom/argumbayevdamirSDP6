package kz.damir.macaron.model;

public final class MacaronOrder {
    private final String flavour;
    private final int quantity;

    public MacaronOrder(String flavour, int quantity) {
        if (flavour == null || flavour.trim().isEmpty()) {
            throw new IllegalArgumentException("Flavour must not be blank.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        this.flavour = flavour;
        this.quantity = quantity;
    }

    public String getFlavour() {
        return flavour;
    }

    public int getQuantity() {
        return quantity;
    }
}
