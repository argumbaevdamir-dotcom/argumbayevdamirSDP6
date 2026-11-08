package kz.damir.macaron.visitor;

public final class StandardMacaronBox implements MacaronCatalogItem {
    private final String flavour;
    private final int macaronCount;
    private final double pricePerMacaron;

    public StandardMacaronBox(String flavour, int macaronCount, double pricePerMacaron) {
        if (flavour == null || flavour.trim().isEmpty()) {
            throw new IllegalArgumentException("Flavour must not be blank.");
        }
        if (macaronCount <= 0 || pricePerMacaron <= 0) {
            throw new IllegalArgumentException("Count and price must be greater than zero.");
        }
        this.flavour = flavour;
        this.macaronCount = macaronCount;
        this.pricePerMacaron = pricePerMacaron;
    }

    public String getFlavour() {
        return flavour;
    }

    public int getMacaronCount() {
        return macaronCount;
    }

    public double getPricePerMacaron() {
        return pricePerMacaron;
    }

    @Override
    public void accept(MacaronCatalogVisitor visitor) {
        visitor.visitStandardBox(this);
    }
}
