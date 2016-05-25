package com.spark.data.Assets;

import java.io.Serializable;

public class ASSET implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FhlmcModel_BND_CORP FhlmcModel_BND_CORP;

    public FhlmcModel_BND_CORP getFhlmcModel_BND_CORP ()
    {
        return FhlmcModel_BND_CORP;
    }

    public void setFhlmcModel_BND_CORP (FhlmcModel_BND_CORP FhlmcModel_BND_CORP)
    {
        this.FhlmcModel_BND_CORP = FhlmcModel_BND_CORP;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [FhlmcModel_BND_CORP = "+FhlmcModel_BND_CORP+"]";
    }
}
		