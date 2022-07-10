package main.java;
import java.util.ArrayList;

public class Vending_Machine {

    public ArrayList<Items> items = new ArrayList<>();

    public void set_items(ArrayList<Items> items){
        this.items = items;
    }
    public ArrayList<Items> get_items() {
        return items;
    }
    public Items get_item(int number){
        return items.get(number);
    }
    public void add_item(int number, String name, int qty, int price){
        this.items.add(new Items(number, name, qty, price));
    }

    public void print_items(){
        for (Items item : this.items ){
            System.out.println("number: "+item.number+" name: "+item.name+" quantity: "+item.qty+" price: "+item.price);
        }
    }


}