package kz.damir.macaron.app;

import kz.damir.macaron.context.MacaronOrderService;
import kz.damir.macaron.model.MacaronOrder;
import kz.damir.macaron.strategy.ClassicMacaronStrategy;
import kz.damir.macaron.strategy.PremiumMacaronStrategy;
import kz.damir.macaron.strategy.VeganMacaronStrategy;

public final class MacaronShopApplication {
    private MacaronShopApplication() {
    }

    public static void main(String[] args) {
        MacaronOrder order = new MacaronOrder("pistachio", 12);
        MacaronOrderService service = new MacaronOrderService(new ClassicMacaronStrategy());

        System.out.println(service.prepareOrder(order));
        service.setStrategy(new VeganMacaronStrategy());
        System.out.println(service.prepareOrder(order));
        service.setStrategy(new PremiumMacaronStrategy());
        System.out.println(service.prepareOrder(order));
    }
}
