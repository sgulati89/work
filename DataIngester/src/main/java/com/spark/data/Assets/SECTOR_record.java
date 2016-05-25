package com.spark.data.Assets;

import java.io.Serializable;

public class SECTOR_record implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String LEVEL;

    private String SECTOR_SOURCE;

    private String TYPE;

    private String CODE;

    public String getLEVEL ()
    {
        return LEVEL;
    }

    public void setLEVEL (String LEVEL)
    {
        this.LEVEL = LEVEL;
    }

    public String getSECTOR_SOURCE ()
    {
        return SECTOR_SOURCE;
    }

    public void setSECTOR_SOURCE (String SECTOR_SOURCE)
    {
        this.SECTOR_SOURCE = SECTOR_SOURCE;
    }

    public String getTYPE ()
    {
        return TYPE;
    }

    public void setTYPE (String TYPE)
    {
        this.TYPE = TYPE;
    }

    public String getCODE ()
    {
        return CODE;
    }

    public void setCODE (String CODE)
    {
        this.CODE = CODE;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [LEVEL = "+LEVEL+", SECTOR_SOURCE = "+SECTOR_SOURCE+", TYPE = "+TYPE+", CODE = "+CODE+"]";
    }
}
			
			