package com.spark.data.Assets;

import java.io.Serializable;

public class NOTES_set implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String SIZE;

    private NOTES_record NOTES_record;

    public String getSIZE ()
    {
        return SIZE;
    }

    public void setSIZE (String SIZE)
    {
        this.SIZE = SIZE;
    }

    public NOTES_record getNOTES_record ()
    {
        return NOTES_record;
    }

    public void setNOTES_record (NOTES_record NOTES_record)
    {
        this.NOTES_record = NOTES_record;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [SIZE = "+SIZE+", NOTES_record = "+NOTES_record+"]";
    }
}
			