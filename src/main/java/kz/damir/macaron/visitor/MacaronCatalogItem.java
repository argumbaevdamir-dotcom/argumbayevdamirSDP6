package kz.damir.macaron.visitor;

public interface MacaronCatalogItem {
    void accept(MacaronCatalogVisitor visitor);
}
