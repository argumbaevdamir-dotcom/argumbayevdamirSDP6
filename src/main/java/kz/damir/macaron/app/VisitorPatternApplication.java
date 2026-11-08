package kz.damir.macaron.app;

import kz.damir.macaron.visitor.CatalogPriceVisitor;
import kz.damir.macaron.visitor.MacaronCatalog;
import kz.damir.macaron.visitor.MacaronGiftSet;
import kz.damir.macaron.visitor.NutritionLabelVisitor;
import kz.damir.macaron.visitor.PackagingInstructionVisitor;
import kz.damir.macaron.visitor.StandardMacaronBox;

public final class VisitorPatternApplication {
    private VisitorPatternApplication() {
    }

    public static void main(String[] args) {
        MacaronCatalog catalog = new MacaronCatalog();
        catalog.addItem(new StandardMacaronBox("raspberry", 6, 850));
        catalog.addItem(new MacaronGiftSet("Celebration", 12, 11500, true));

        CatalogPriceVisitor priceVisitor = new CatalogPriceVisitor();
        NutritionLabelVisitor nutritionVisitor = new NutritionLabelVisitor();
        PackagingInstructionVisitor packagingVisitor = new PackagingInstructionVisitor();

        catalog.accept(priceVisitor);
        catalog.accept(nutritionVisitor);
        catalog.accept(packagingVisitor);

        System.out.println("Total catalog price: " + priceVisitor.getTotalPrice() + " KZT");
        System.out.println("Total calories: " + nutritionVisitor.getTotalCalories() + " kcal");
        for (String instruction : packagingVisitor.getInstructions()) {
            System.out.println(instruction);
        }
    }
}
