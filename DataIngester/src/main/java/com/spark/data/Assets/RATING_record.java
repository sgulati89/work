package com.spark.data.Assets;

import java.io.Serializable;

public class RATING_record implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String VALUE;

    private String DATE;

    private String AGY;

    public String getVALUE ()
    {
        return VALUE;
    }

    public void setVALUE (String VALUE)
    {
        this.VALUE = VALUE;
    }

    public String getDATE ()
    {
        return DATE;
    }

    public void setDATE (String DATE)
    {
        this.DATE = DATE;
    }

    public String getAGY ()
    {
        return AGY;
    }

    public void setAGY (String AGY)
    {
        this.AGY = AGY;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [VALUE = "+VALUE+", DATE = "+DATE+", AGY = "+AGY+"]";
    }
}
			
			