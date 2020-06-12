package fr.eni.javaee.gestioncourses.dal;

public abstract  class DAOFactory {

    public static ShoppingListDAO getShoppingListDAO(){
        return new ShoppingListDAOJdbcImpl();
    }
}
