package fr.eni.javaee.gestioncourses.dal;

import fr.eni.javaee.gestioncourses.BusinessException;
import fr.eni.javaee.gestioncourses.bo.Item;
import fr.eni.javaee.gestioncourses.bo.ShoppingList;

import java.util.List;

public class ShoppingListDAOJdbcImpl implements ShoppingListDAO{

    private static final String SELECT_ALL = "SELECT id, nom FROM LIST";
    private static final String SELECT_BY_ID =	"select " +
            "	l.id as id_list, " +
            "	l.name_list as name_list, " +
            "	i.id as id_item, " +
            "	i.name_item as name_item, " +
            "	i.cecked_box " +
            "from " +
            "	lists l " +
            "	left join items i on l.id=i.id_list "+
            "where l.id=?";
    private static final String INSERT_LIST = "insert into LISTS(nom) values(?);";
    private static final String INSERT_ITEM = "insert into ITEMS(nom, id_list) values(?,?);";
    private static final String DELETE_ITEM = "delete from ITEMS where id=?";
    private static final String DELETE_LIST = "delete from LISTS where id=?";
    private static final String UPDATE_CHECK_ITEMS="update ITEMS set checked_box=1 where id=?";
    private static final String UPDATE_UNCHECK_ITEM="update ITEMS set checked_box=0 where id=?";
    private static final String UPDATE_UNCHECK_ITEMS="update ITEMS set checked_box=0 where id_list=?";

    @Override
    public void insert(ShoppingList shoppingList) throws BusinessException {

    }

    @Override
    public void delete(int id) throws BusinessException {

    }

    @Override
    public List<Item> selectAll() throws BusinessException {
        return null;
    }

    @Override
    public ShoppingList selectById(int id) throws BusinessException {
        return null;
    }

    @Override
    public void deleteItem(int idItem) throws BusinessException {

    }

    @Override
    public void checkedItem(int idItem) throws BusinessException {

    }

    @Override
    public void uncheckedItem(int idItem) throws BusinessException {

    }

    @Override
    public void unCheckedShoppingList(int shoppingList) throws BusinessException {

    }
}
