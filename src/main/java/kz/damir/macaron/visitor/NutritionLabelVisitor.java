package kz.damir.macaron.visitor;

public final class NutritionLabelVisitor implements MacaronCatalogVisitor {
    private int totalCalories;

    @Override
    public void visitStandardBox(StandardMacaronBox standardBox) {
        totalCalories += standardBox.getMacaronCount() * 95;
    }

    @Override
    public void visitGiftSet(MacaronGiftSet giftSet) {
        totalCalories += giftSet.getMacaronCount() * 105;
    }

    public int getTotalCalories() {
        return totalCalories;
    }
}
