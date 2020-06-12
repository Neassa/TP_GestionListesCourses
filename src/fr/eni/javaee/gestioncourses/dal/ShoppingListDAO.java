package fr.eni.javaee.gestioncourses.dal;

import fr.eni.javaee.gestioncourses.BusinessException;
import fr.eni.javaee.gestioncourses.bo.ShoppingList;

import java.util.List;

public interface ShoppingListDAO {

    public void insert(ShoppingList listeCourse) throws BusinessException;
    public void delete(int id) throws BusinessException;
    public List<ShoppingList> selectAll() throws BusinessException;
    public ShoppingList selectById(int id) throws BusinessException;
    public void deleteItem(int idArticle) throws BusinessException;
    public void checkedItem(int idArticle) throws BusinessException;
    public void uncheckedItem(int idArticle) throws BusinessException;
    public void unCheckedShoppingList(int listeCourse) throws BusinessException;
}
