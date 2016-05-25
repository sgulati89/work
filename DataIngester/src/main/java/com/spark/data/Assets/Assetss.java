package com.spark.data.Assets;

import java.io.Serializable;

public class Assetss implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ASSETS ASSETS;

    public ASSETS getASSETS ()
    {
        return ASSETS;
    }

    public void setASSETS (ASSETS ASSETS)
    {
        this.ASSETS = ASSETS;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ASSETS = "+ASSETS+"]";
    }
}