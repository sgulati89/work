package com.spark.data.Assets;

import java.io.Serializable;

public class ISSUE_EXCHANGES_record implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String EXCHANGE;

    public String getEXCHANGE ()
    {
        return EXCHANGE;
    }

    public void setEXCHANGE (String EXCHANGE)
    {
        this.EXCHANGE = EXCHANGE;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [EXCHANGE = "+EXCHANGE+"]";
    }
}
			