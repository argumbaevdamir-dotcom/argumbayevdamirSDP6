package kz.damir.macaron.context;

import kz.damir.macaron.model.MacaronOrder;
import kz.damir.macaron.model.PreparationResult;
import kz.damir.macaron.strategy.MacaronPreparationStrategy;

public final class MacaronOrderService {
    private MacaronPreparationStrategy strategy;

    public MacaronOrderService(MacaronPreparationStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(MacaronPreparationStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Macaron preparation strategy cannot be null.");
        }
        this.strategy = strategy;
    }

    public PreparationResult prepareOrder(MacaronOrder order) {
        return strategy.prepare(order);
    }
}
