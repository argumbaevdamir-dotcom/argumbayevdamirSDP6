package kz.damir.macaron.visitor;

public final class MacaronGiftSet implements MacaronCatalogItem {
    private final String collectionName;
    private final int macaronCount;
    private final double basePrice;
    private final boolean includesGreetingCard;

    public MacaronGiftSet(String collectionName, int macaronCount, double basePrice, boolean includesGreetingCard) {
        if (collectionName == null || collectionName.trim().isEmpty()) {
            throw new IllegalArgumentException("Collection name must not be blank.");
        }
        if (macaronCount <= 0 || basePrice <= 0) {
            throw new IllegalArgumentException("Count and price must be greater than zero.");
        }
        this.collectionName = collectionName;
        this.macaronCount = macaronCount;
        this.basePrice = basePrice;
        this.includesGreetingCard = includesGreetingCard;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public int getMacaronCount() {
        return macaronCount;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public boolean includesGreetingCard() {
        return includesGreetingCard;
    }

    @Override
    public void accept(MacaronCatalogVisitor visitor) {
        visitor.visitGiftSet(this);
    }
}
