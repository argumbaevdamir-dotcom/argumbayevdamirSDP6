package kz.damir.macaron.visitor;

import java.util.ArrayList;
import java.util.List;

public final class MacaronCatalog {
    private final List<MacaronCatalogItem> items = new ArrayList<MacaronCatalogItem>();

    public void addItem(MacaronCatalogItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Catalog item cannot be null.");
        }
        items.add(item);
    }

    public void accept(MacaronCatalogVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("Visitor cannot be null.");
        }
        for (MacaronCatalogItem item : items) {
            item.accept(visitor);
        }
    }
}
