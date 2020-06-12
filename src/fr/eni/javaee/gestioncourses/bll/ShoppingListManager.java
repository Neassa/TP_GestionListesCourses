package fr.eni.javaee.gestioncourses.bll;

import fr.eni.javaee.gestioncourses.BusinessException;
import fr.eni.javaee.gestioncourses.bo.Item;
import fr.eni.javaee.gestioncourses.bo.ShoppingList;
import fr.eni.javaee.gestioncourses.dal.DAOFactory;
import fr.eni.javaee.gestioncourses.dal.ShoppingListDAO;


import java.util.List;

import static fr.eni.javaee.gestioncourses.bll.CodeResultBLL.*;

public class ShoppingListManager {
    private ShoppingListDAO shoppingListDAO;

    public ShoppingListManager() {
        this.shoppingListDAO = DAOFactory.getShoppingListDAO();
    }

    public List<ShoppingList> listingShoppingLists() throws BusinessException {
        return this.shoppingListDAO.selectAll();
    }
    public ShoppingList selectShoppingLists(int idShoppingList) throws BusinessException {
        return this.shoppingListDAO.selectById(idShoppingList);
    }

    public void addItem(int idShoppingList, String nameItem) throws BusinessException {
//FIXME revoir ça
        if (checkName(nameItem)){
            ShoppingList shoppingList = new ShoppingList();
            shoppingList.setId(idShoppingList);

            Item item = new Item(nameItem.trim());
            shoppingList.getItems().add(item);
            this.shoppingListDAO.insert(shoppingList);
        }

    }




    public ShoppingList addList(String name){
        ShoppingList shoppingList = null;
        try {
            checkName(name);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        return shoppingList;
    }

    private boolean checkName(String name) throws BusinessException {
        boolean isGood = true;
        try {
            if (name==null || name.trim().length()>50){
                isGood = false;
            }
        } catch (Exception e){
            BusinessException businessException = new BusinessException();
            businessException.addError(VALIDATION_LIST_NAME_ERREUR);
            throw businessException;
        }
        return isGood;
    }


}
