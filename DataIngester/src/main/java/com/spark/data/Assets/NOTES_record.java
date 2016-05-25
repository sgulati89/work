package com.spark.data.Assets;

import java.io.Serializable;

public class NOTES_record implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String EFF_DT;

    private String USER_ID;

    private String SEQ_NUM;

    private String INSTMT;

    public String getEFF_DT ()
    {
        return EFF_DT;
    }

    public void setEFF_DT (String EFF_DT)
    {
        this.EFF_DT = EFF_DT;
    }

    public String getUSER_ID ()
    {
        return USER_ID;
    }

    public void setUSER_ID (String USER_ID)
    {
        this.USER_ID = USER_ID;
    }

    public String getSEQ_NUM ()
    {
        return SEQ_NUM;
    }

    public void setSEQ_NUM (String SEQ_NUM)
    {
        this.SEQ_NUM = SEQ_NUM;
    }

    public String getINSTMT ()
    {
        return INSTMT;
    }

    public void setINSTMT (String INSTMT)
    {
        this.INSTMT = INSTMT;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [EFF_DT = "+EFF_DT+", USER_ID = "+USER_ID+", SEQ_NUM = "+SEQ_NUM+", INSTMT = "+INSTMT+"]";
    }
}
			
			