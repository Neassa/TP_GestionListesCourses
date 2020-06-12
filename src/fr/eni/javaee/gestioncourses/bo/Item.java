package fr.eni.javaee.gestioncourses.bo;

import java.util.List;

public class Item {
    private int id;
    private String name;
    protected boolean checkedBox;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item() {
    }

    public Item(int id, String name, boolean checkedBox) {
        this.id = id;
        this.name = name;
        this.checkedBox = checkedBox;
    }

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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

    public boolean isCheckedBox() {
        return checkedBox;
    }

    public void setCheckedBox(boolean checkedBox) {
        this.checkedBox = checkedBox;
    }
}
