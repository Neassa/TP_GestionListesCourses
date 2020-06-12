package fr.eni.javaee.gestioncourses.dal;

public abstract class CodesResultDAL {

    /**
     * Echec général quand tentative d'ajouter un objet null
     */
    public static final int INSERT_OBJECT_NULL=10000;

    /**
     * Echec général quand erreur non gérée à l'insertion
     */
    public static final int INSERT_OBJECT_FAIL=10001;


    /**
     * Echec de la lecture des listes de course
     */
    public static final int READ_LISTS_FAIL = 10002;
    /**
     * Echec de la lecture d'une liste de course
     */
    public static final int READ_LIST_FAIL= 10003;
    /**
     * Liste de course inexistante
     */
    public static final int READ_LIST_UNKNOW = 10004;
    /**
     * Erreur à la suppression d'un article
     */
    public static final int DELETE_ITEM_ERROR = 10005;
    /**
     * Erreur à la suppression d'une liste
     */
    public static final int DELETE_LIST_ERROR = 10006;
    /**
     * Erreur au cochage d'un article
     */
    public static final int CHECKED_ITEM_ERROR = 10007;
    /**
     * Erreur au décochage d'un article
     */
    public static final int UNCHECKED_ITEM_ERROR = 10008;
    /**
     * Erreur au décochage de tous les articles d'une liste
     */
    public static final int UNCHECKED_ITEMS_ERROR = 10009;

}
