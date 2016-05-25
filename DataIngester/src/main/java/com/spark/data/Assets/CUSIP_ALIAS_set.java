package com.spark.data.Assets;

import java.io.Serializable;

public class CUSIP_ALIAS_set implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CUSIP_ALIAS_record[] CUSIP_ALIAS_record;

    private String SIZE;

    public CUSIP_ALIAS_record[] getCUSIP_ALIAS_record ()
    {
        return CUSIP_ALIAS_record;
    }

    public void setCUSIP_ALIAS_record (CUSIP_ALIAS_record[] CUSIP_ALIAS_record)
    {
        this.CUSIP_ALIAS_record = CUSIP_ALIAS_record;
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
        return "ClassPojo [CUSIP_ALIAS_record = "+CUSIP_ALIAS_record+", SIZE = "+SIZE+"]";
    }
}