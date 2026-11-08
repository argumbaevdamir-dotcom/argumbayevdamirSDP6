package kz.damir.macaron.strategy;

import kz.damir.macaron.model.MacaronOrder;
import kz.damir.macaron.model.PreparationResult;

public interface MacaronPreparationStrategy {
    PreparationResult prepare(MacaronOrder order);
}
