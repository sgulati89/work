package com.spark.data.Assets;

import java.io.Serializable;

public class SECTOR_set implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SECTOR_record[] SECTOR_record;

    private String SIZE;

    public SECTOR_record[] getSECTOR_record ()
    {
        return SECTOR_record;
    }

    public void setSECTOR_record (SECTOR_record[] SECTOR_record)
    {
        this.SECTOR_record = SECTOR_record;
    }

    public String getSIZE ()
    {
        return SIZE;
    }

    public void setSIZE (String SIZE)
    {
        this.SIZE = SIZE;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [SECTOR_record = "+SECTOR_record+", SIZE = "+SIZE+"]";
    }
}
			
			