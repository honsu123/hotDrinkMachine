package HotDrinkMachine;

import java.util.ArrayList;
import java.util.List;

abstract class Product {

    private String name;
    private int volume;
    private int temp;

    public Product(String name, int volume, int temp) {
        this.name = name;
        this.temp = temp;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", volume=" + volume + '\'' +
                ", temp=" + temp +
                '}';
    }
}

interface VendingMachine {
    Product getDrink(String name, int volume, int temp);
}

class HotDrink extends Product {
    String name;
    double cost;

    public HotDrink(String name, int volume, int temp) {
        super(name, volume, temp);
    }
}


class VenMach implements VendingMachine {
    private ArrayList<Product> hotDrink;

    public void initProducts(ArrayList<Product> hotDrink) {
        this.hotDrink = hotDrink;
    }

    @Override
    public Product getDrink(String prodName, int volume, int temp) {
        for (Product p : hotDrink) {
            if (p.getName().equals(prodName)) {
                return p;
            }
        }
        return null;
    }

}

public class main {
    public static void main(String[] args) {
        ArrayList<Product> prods = new ArrayList<>();
        prods.add(new HotDrink("Капучино", 200, 70 ));
        prods.add(new HotDrink("Горячий Шоколад" , 300, 70 ));
        prods.add(new HotDrink("Американо", 100, 65 ));

        VenMach vendingMachine = new VenMach();
        vendingMachine.initProducts(prods);
        System.out.println(vendingMachine.getDrink("Капучино", 270 , 65));
    }
}