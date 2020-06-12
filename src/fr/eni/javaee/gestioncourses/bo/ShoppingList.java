package fr.eni.javaee.gestioncourses.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList implements Serializable {
    private int id;
    private String name;
    private List<Item> items = new ArrayList<>();


    public ShoppingList(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public ShoppingList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ShoppingList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }


}
