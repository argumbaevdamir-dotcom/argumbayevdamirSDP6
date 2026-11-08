package kz.damir.macaron.visitor;

public interface MacaronCatalogVisitor {
    void visitStandardBox(StandardMacaronBox standardBox);

    void visitGiftSet(MacaronGiftSet giftSet);
}
