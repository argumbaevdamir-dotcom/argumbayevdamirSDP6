package kz.damir.macaron.strategy;

import kz.damir.macaron.model.MacaronOrder;
import kz.damir.macaron.model.PreparationResult;

public final class VeganMacaronStrategy implements MacaronPreparationStrategy {
    @Override
    public PreparationResult prepare(MacaronOrder order) {
        int minutes = 28 + order.getQuantity();
        String ingredients = "almond flour, aquafaba, sugar, plant-based " + order.getFlavour() + " filling";
        return new PreparationResult("Vegan " + order.getFlavour(), minutes, ingredients);
    }
}
