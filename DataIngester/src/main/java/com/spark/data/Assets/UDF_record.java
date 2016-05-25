package com.spark.data.Assets;

import java.io.Serializable;

public class UDF_record implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String VALUE;

    private String LABEL;

    private String PURPOSE;

    public String getVALUE ()
    {
        return VALUE;
    }

    public void setVALUE (String VALUE)
    {
        this.VALUE = VALUE;
    }

    public String getLABEL ()
    {
        return LABEL;
    }

    public void setLABEL (String LABEL)
    {
        this.LABEL = LABEL;
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
        return "ClassPojo [VALUE = "+VALUE+", LABEL = "+LABEL+", PURPOSE = "+PURPOSE+"]";
    }
}
			