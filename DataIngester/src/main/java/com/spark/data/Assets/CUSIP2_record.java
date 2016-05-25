package com.spark.data.Assets;

import java.io.Serializable;

public class CUSIP2_record implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String IDENTIFIER;

    private String CODE;

    public String getIDENTIFIER ()
    {
        return IDENTIFIER;
    }

    public void setIDENTIFIER (String IDENTIFIER)
    {
        this.IDENTIFIER = IDENTIFIER;
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
        return "ClassPojo [IDENTIFIER = "+IDENTIFIER+", CODE = "+CODE+"]";
    }
}
			
			