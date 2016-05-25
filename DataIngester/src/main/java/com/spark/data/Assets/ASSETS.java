package com.spark.data.Assets;

import java.io.Serializable;

public class ASSETS implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ASSET[] ASSET;

    private String RECORDS;

    private String ASOF_DATE;

    private String CREATE_DATE;

    public ASSET[] getASSET ()
    {
        return ASSET;
    }

    public void setASSET (ASSET[] ASSET)
    {
        this.ASSET = ASSET;
    }

    public String getRECORDS ()
    {
        return RECORDS;
    }

    public void setRECORDS (String RECORDS)
    {
        this.RECORDS = RECORDS;
    }

    public String getASOF_DATE ()
    {
        return ASOF_DATE;
    }

    public void setASOF_DATE (String ASOF_DATE)
    {
        this.ASOF_DATE = ASOF_DATE;
    }

    public String getCREATE_DATE ()
    {
        return CREATE_DATE;
    }

    public void setCREATE_DATE (String CREATE_DATE)
    {
        this.CREATE_DATE = CREATE_DATE;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ASSET = "+ASSET+", RECORDS = "+RECORDS+", ASOF_DATE = "+ASOF_DATE+", CREATE_DATE = "+CREATE_DATE+"]";
    }
}
			
			
