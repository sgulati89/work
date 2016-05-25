package com.spark.data.Assets;

import java.io.Serializable;

public class ISSUE_EXCHANGES_set implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String SIZE;

    private ISSUE_EXCHANGES_record[] ISSUE_EXCHANGES_record;

    public String getSIZE ()
    {
        return SIZE;
    }

    public void setSIZE (String SIZE)
    {
        this.SIZE = SIZE;
    }

    public ISSUE_EXCHANGES_record[] getISSUE_EXCHANGES_record ()
    {
        return ISSUE_EXCHANGES_record;
    }

    public void setISSUE_EXCHANGES_record (ISSUE_EXCHANGES_record[] ISSUE_EXCHANGES_record)
    {
        this.ISSUE_EXCHANGES_record = ISSUE_EXCHANGES_record;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [SIZE = "+SIZE+", ISSUE_EXCHANGES_record = "+ISSUE_EXCHANGES_record+"]";
    }
}