package kz.damir.macaron.strategy;

import kz.damir.macaron.model.MacaronOrder;
import kz.damir.macaron.model.PreparationResult;

public final class ClassicMacaronStrategy implements MacaronPreparationStrategy {
    @Override
    public PreparationResult prepare(MacaronOrder order) {
        int minutes = 20 + order.getQuantity();
        String ingredients = "almond flour, egg whites, sugar, " + order.getFlavour() + " filling";
        return new PreparationResult("Classic " + order.getFlavour(), minutes, ingredients);
    }
}
