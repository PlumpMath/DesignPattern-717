package Behavioral.Iterator.HeadFirst.第4版系统迭代器.Client;

import Behavioral.Iterator.HeadFirst.第1版餐厅合并菜单.MenuItem;
import Behavioral.Iterator.HeadFirst.第4版系统迭代器.BaseClass.Menu;

import java.util.Iterator;

/**
 * Created by sahoo on 16/5/14.
 */
public class Waitress {
    Menu pancakeHouseMenu;
    Menu dinerMenu;
    Menu cafeMenu;

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu,Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu=cafeMenu;
    }

    public void printMenu(){
        Iterator pancakeIterator=pancakeHouseMenu.createIterator();
        Iterator dinerIterator=dinerMenu.createIterator();
        Iterator cafeIterator=cafeMenu.createIterator();

        System.out.println("MENU\n----\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
        System.out.println("\nDINNER");
        printMenu(cafeIterator);
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()){
            MenuItem menuItem=(MenuItem)iterator.next();
            System.out.print(menuItem.getName()+" ");
            System.out.print(menuItem.getPrice()+" ");
            System.out.println(menuItem.getDescription());
        }
    }
}
