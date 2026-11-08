# Software Design Patterns Assignments 5 and 6

**Student:** Argumbayev Damir  
**Course:** Software Design Patterns  
**Domain:** Macaron Shop

This project contains two independent pattern demonstrations in one Macaron Shop domain:

- Assignment 5: Strategy pattern for selecting a macaron preparation recipe at runtime.
- Assignment 6: Visitor pattern for running unrelated operations over a stable catalog structure.

## Assignment 5 — Strategy Pattern

`MacaronOrderService` delegates order preparation to a `MacaronPreparationStrategy`.
The client can switch between classic, vegan, and premium recipes without changing
the service class.

| Role | Class |
|---|---|
| Strategy interface | `MacaronPreparationStrategy` |
| Concrete strategies | `ClassicMacaronStrategy`, `VeganMacaronStrategy`, `PremiumMacaronStrategy` |
| Context | `MacaronOrderService` |
| Client | `MacaronShopApplication` |

Run the example:

```bash
java -cp out kz.damir.macaron.app.MacaronShopApplication
```

## Assignment 6 — Visitor Pattern

The Visitor example models a stable Macaron Shop catalog. The catalog holds two
element types: `StandardMacaronBox` and `MacaronGiftSet`. The client can add new
operations without modifying either element class.

| Role | Class |
|---|---|
| Element interface | `MacaronCatalogItem` |
| Concrete elements | `StandardMacaronBox`, `MacaronGiftSet` |
| Visitor interface | `MacaronCatalogVisitor` |
| Concrete visitors | `CatalogPriceVisitor`, `NutritionLabelVisitor`, `PackagingInstructionVisitor` |
| Object structure | `MacaronCatalog` |
| Client | `VisitorPatternApplication` |

Each element's `accept()` method calls the matching visitor method with `this`.
This is the second dispatch that lets Java select the correct `visit...` method
without `instanceof` or type-checking chains.

Run the example:

```bash
java -cp out kz.damir.macaron.app.VisitorPatternApplication
```

## Clean Code Decisions for Assignment 6

1. **Meaningful names:** `MacaronCatalogItem`, `CatalogPriceVisitor`, and
   `PackagingInstructionVisitor` make element and visitor responsibilities clear.
2. **No type checks:** the code contains no `instanceof` or `switch` on element
   type; double dispatch chooses the appropriate visitor method.
3. **Single Responsibility:** each visitor performs exactly one operation:
   price calculation, calorie calculation, or packaging instructions.
4. **Encapsulation:** element fields stay private. Visitors access only the small
   set of read-only getters required for their algorithms.
5. **Open/Closed Principle:** `PackagingInstructionVisitor` is a third visitor
   added without changing the catalog or either element class.
6. **Validation at boundaries:** catalog items and the catalog reject invalid
   arguments in their constructors and public methods.
7. **Focused object structure:** `MacaronCatalog` owns traversal; elements only
   accept visitors and visitors only implement operations.

## Compile

From the project root:

```bash
mkdir -p out
javac -d out $(find src/main/java -name "*.java")
```

## What to Explain at the Defense

- In Assignment 6, the first dispatch is `item.accept(visitor)` and the second
  dispatch is `visitor.visitStandardBox(this)` or `visitor.visitGiftSet(this)`.
- The visitor interface has one method for each concrete element type.
- A new visitor can be added without changing `StandardMacaronBox`,
  `MacaronGiftSet`, or `MacaronCatalog`.
- Adding a new element type requires adding a visitor-interface method and an
  implementation in each visitor; this is Visitor's trade-off.
