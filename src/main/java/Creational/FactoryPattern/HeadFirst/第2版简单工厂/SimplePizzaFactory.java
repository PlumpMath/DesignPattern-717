package Creational.FactoryPattern.HeadFirst.第2版简单工厂;

import Creational.FactoryPattern.HeadFirst.第1版具体类导致脆弱的代码.ConcreteClass.*;
import Creational.FactoryPattern.HeadFirst.第1版具体类导致脆弱的代码.BasePizza.Pizza;

/**
 * Created by sahoo on 16/4/28.
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheessePizza();
        } else if (type.equals("greek")) {
            pizza = new GreekPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}
