package kz.damir.macaron.strategy;

import kz.damir.macaron.model.MacaronOrder;
import kz.damir.macaron.model.PreparationResult;

public final class PremiumMacaronStrategy implements MacaronPreparationStrategy {
    @Override
    public PreparationResult prepare(MacaronOrder order) {
        int minutes = 32 + order.getQuantity() * 2;
        String ingredients = "almond flour, aged egg whites, Belgian chocolate, "
                + order.getFlavour() + " ganache, edible decoration";
        return new PreparationResult("Premium " + order.getFlavour(), minutes, ingredients);
    }
}
