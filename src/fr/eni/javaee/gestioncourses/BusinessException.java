package fr.eni.javaee.gestioncourses;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends Exception {
    private List<Integer> ErrorCodeListing;

    public BusinessException() {
        super();
        this.ErrorCodeListing=new ArrayList<>();
    }

    /**
     *
     * @param code Code de l'erreur. 
     * Doit avoir un message associé dans un fichier properties.
     */
    public void addError(int code)
    {
        if(!this.ErrorCodeListing.contains(code))
        {
            this.ErrorCodeListing.add(code);
        }
    }

    public boolean hasErreurs()
    {
        return this.ErrorCodeListing.size()>0;
    }

    public List<Integer> getErrorCodeListing()
    {
        return this.ErrorCodeListing;
    }


}
