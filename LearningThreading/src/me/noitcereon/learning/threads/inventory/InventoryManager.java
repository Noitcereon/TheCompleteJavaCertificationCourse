package me.noitcereon.learning.threads.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {
    List<Product> soldProducts = new CopyOnWriteArrayList<>();
    List<Product> purchasedProducts = new ArrayList<>();

    public void populateSoldProducts(){
        for(int i = 0; i < 500; i++){
            Product product = new Product(i, "test_product_"+i);
            soldProducts.add(product);
            System.out.println("ADDED: " + product);
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
    public void displaySoldProducts(){
        for(Product product : soldProducts){
            System.out.println("SOLD: " + product);
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
