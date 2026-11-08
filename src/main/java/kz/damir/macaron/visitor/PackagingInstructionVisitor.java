package kz.damir.macaron.visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class PackagingInstructionVisitor implements MacaronCatalogVisitor {
    private final List<String> instructions = new ArrayList<String>();

    @Override
    public void visitStandardBox(StandardMacaronBox standardBox) {
        instructions.add("Pack " + standardBox.getMacaronCount() + " " + standardBox.getFlavour()
                + " macarons in a standard box.");
    }

    @Override
    public void visitGiftSet(MacaronGiftSet giftSet) {
        String cardInstruction = giftSet.includesGreetingCard() ? " Include a greeting card." : "";
        instructions.add("Pack the " + giftSet.getCollectionName() + " gift set with "
                + giftSet.getMacaronCount() + " macarons." + cardInstruction);
    }

    public List<String> getInstructions() {
        return Collections.unmodifiableList(instructions);
    }
}
