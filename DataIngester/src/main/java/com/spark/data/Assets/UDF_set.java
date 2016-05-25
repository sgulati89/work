package com.spark.data.Assets;

import java.io.Serializable;

public class UDF_set implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UDF_record UDF_record;

    private String SIZE;

    public UDF_record getUDF_record ()
    {
        return UDF_record;
    }

    public void setUDF_record (UDF_record UDF_record)
    {
        this.UDF_record = UDF_record;
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
        return "ClassPojo [UDF_record = "+UDF_record+", SIZE = "+SIZE+"]";
    }
}
			
			