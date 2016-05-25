package com.spark.data.Assets;

import java.io.Serializable;

public class RATING_set implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RATING_record[] RATING_record;

    private String SIZE;

    public RATING_record[] getRATING_record ()
    {
        return RATING_record;
    }

    public void setRATING_record (RATING_record[] RATING_record)
    {
        this.RATING_record = RATING_record;
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
        return "ClassPojo [RATING_record = "+RATING_record+", SIZE = "+SIZE+"]";
    }
}
			