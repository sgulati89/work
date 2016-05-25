package com.spark.data.Assets;

import java.io.Serializable;

public class CUSIP_ALIAS_record implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String IDENTIFIER;

    private String CODE;

    private String PURPOSE;

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

    public String getPURPOSE ()
    {
        return PURPOSE;
    }

    public void setPURPOSE (String PURPOSE)
    {
        this.PURPOSE = PURPOSE;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [IDENTIFIER = "+IDENTIFIER+", CODE = "+CODE+", PURPOSE = "+PURPOSE+"]";
    }
}
			