package kz.damir.macaron.model;

public final class PreparationResult {
    private final String recipeName;
    private final int preparationMinutes;
    private final String ingredients;

    public PreparationResult(String recipeName, int preparationMinutes, String ingredients) {
        this.recipeName = recipeName;
        this.preparationMinutes = preparationMinutes;
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return recipeName + " macarons: " + preparationMinutes + " min; ingredients: " + ingredients;
    }
}
