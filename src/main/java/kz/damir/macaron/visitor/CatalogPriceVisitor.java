package kz.damir.macaron.visitor;

public final class CatalogPriceVisitor implements MacaronCatalogVisitor {
    private double totalPrice;

    @Override
    public void visitStandardBox(StandardMacaronBox standardBox) {
        totalPrice += standardBox.getMacaronCount() * standardBox.getPricePerMacaron();
    }

    @Override
    public void visitGiftSet(MacaronGiftSet giftSet) {
        totalPrice += giftSet.getBasePrice() + (giftSet.includesGreetingCard() ? 500 : 0);
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
