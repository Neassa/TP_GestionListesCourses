package fr.eni.javaee.gestioncourses.dal;

import fr.eni.javaee.gestioncourses.BusinessException;
import fr.eni.javaee.gestioncourses.bo.Item;
import fr.eni.javaee.gestioncourses.bo.ShoppingList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListDAOJdbcImpl implements ShoppingListDAO{

    private static final String SELECT_ALL = "SELECT id, nom FROM LIST";
    private static final String SELECT_BY_ID =	"select " +
            "	l.id as id_list, " +
            "	l.name_list as name_list, " +
            "	i.id as id_item, " +
            "	i.name_item as name_item, " +
            "	i.checked_box " +
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
        if(shoppingList==null)
        {
            BusinessException businessException = new BusinessException();
            businessException.addError(CodesResultDAL.INSERT_OBJECT_NULL);
            throw businessException;
        }

        try(Connection cnx = ConnectionProvider.getConnection())
        {
            try
            {
                cnx.setAutoCommit(false);
                PreparedStatement pstmt;
                ResultSet rs;
                if(shoppingList.getId()==0)
                {
                    pstmt = cnx.prepareStatement(INSERT_LIST, PreparedStatement.RETURN_GENERATED_KEYS);
                    pstmt.setString(1, shoppingList.getName());
                    pstmt.executeUpdate();
                    rs = pstmt.getGeneratedKeys();
                    if(rs.next())
                    {
                        shoppingList.setId(rs.getInt(1));
                    }
                    rs.close();
                    pstmt.close();
                }
                if(shoppingList.getItems().size()==1)
                {
                    pstmt = cnx.prepareStatement(INSERT_ITEM);
                    pstmt.setString(1, shoppingList.getItems().get(0).getName());
                    pstmt.setInt(2, shoppingList.getId());
                    pstmt.executeUpdate();
                    pstmt.close();
                }
                cnx.commit();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                cnx.rollback();
                throw e;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.addError(CodesResultDAL.INSERT_OBJECT_FAIL);
            throw businessException;
        }
    }

    @Override
    public void delete(int id) throws BusinessException {
        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(DELETE_LIST);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.addError(CodesResultDAL.DELETE_LIST_ERROR);
            throw businessException;
        }
    }

    @Override
    public List<ShoppingList> selectAll() throws BusinessException {
        List<ShoppingList> shoppingLists = new ArrayList<>();
        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                shoppingLists.add(new ShoppingList(rs.getInt("id"), rs.getString("name_list")));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.addError(CodesResultDAL.READ_LISTS_FAIL);
            throw businessException;
        }
        return shoppingLists;
    }

    @Override
    public ShoppingList selectById(int id) throws BusinessException {
        ShoppingList shoppingList = new ShoppingList();
        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            boolean premiereLigne=true;
            while(rs.next())
            {
                if(premiereLigne)
                {
                    shoppingList.setId(rs.getInt("id_list"));
                    shoppingList.setName(rs.getString("name_list"));
                    premiereLigne=false;
                }
                if(rs.getString("name_item")!=null)
                {
                    shoppingList.getItems().add(new Item(rs.getInt("id_item"), rs.getString("name_item"), rs.getBoolean("checked_box")));
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.addError(CodesResultDAL.READ_LIST_FAIL);
            throw businessException;
        }
        if(shoppingList.getId()==0)
        {
            BusinessException businessException = new BusinessException();
            businessException.addError(CodesResultDAL.READ_LIST_UNKNOW);
            throw businessException;
        }

        return shoppingList;
    }

    @Override
    public void deleteItem(int idItem) throws BusinessException {
        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(DELETE_ITEM);
            pstmt.setInt(1, idItem);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.addError(CodesResultDAL.DELETE_ITEM_ERROR);
            throw businessException;
        }
    }

    @Override
    public void checkedItem(int idItem) throws BusinessException {
        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(UPDATE_CHECK_ITEMS);
            pstmt.setInt(1, idItem);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.addError(CodesResultDAL.CHECKED_ITEM_ERROR);
            throw businessException;
        }
    }

    @Override
    public void uncheckedItem(int idItem) throws BusinessException {
        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UNCHECK_ITEM);
            pstmt.setInt(1, idItem);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.addError(CodesResultDAL.UNCHECKED_ITEM_ERROR);
            throw businessException;
        }
    }

    @Override
    public void unCheckedShoppingList(int idShoppingList) throws BusinessException {
        try(Connection cnx = ConnectionProvider.getConnection())
        {
            PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UNCHECK_ITEMS);
            pstmt.setInt(1, idShoppingList);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
            businessException.addError(CodesResultDAL.UNCHECKED_ITEMS_ERROR);
            throw businessException;
        }
    }
}
