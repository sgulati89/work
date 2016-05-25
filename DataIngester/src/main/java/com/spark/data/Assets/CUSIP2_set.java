package com.spark.data.Assets;

import java.io.Serializable;

public class CUSIP2_set implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CUSIP2_record[] CUSIP2_record;

    private String SIZE;

    public CUSIP2_record[] getCUSIP2_record ()
    {
        return CUSIP2_record;
    }

    public void setCUSIP2_record (CUSIP2_record[] CUSIP2_record)
    {
        this.CUSIP2_record = CUSIP2_record;
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
        return "ClassPojo [CUSIP2_record = "+CUSIP2_record+", SIZE = "+SIZE+"]";
    }
}
			