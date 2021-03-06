package Behavioral.Observer.HeadFirst.第2版实现气象站.ConcreteClass;

import Behavioral.Observer.HeadFirst.第2版实现气象站.BaseClass.DisplayElement;
import Behavioral.Observer.HeadFirst.第2版实现气象站.BaseClass.Observer;
import Behavioral.Observer.HeadFirst.第2版实现气象站.BaseClass.Subject;

/**
 * Created by sahoo on 16/4/26.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display() {
        System.err.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }

    public void Update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
