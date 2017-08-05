package com.openbank.model;

public class Transactions {
	
    private String id;

    private Details details;

    private Other_account other_account;

    private This_account this_account;

    

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Details getDetails ()
    {
        return details;
    }

    public void setDetails (Details details)
    {
        this.details = details;
    }

    public Other_account getOther_account ()
    {
        return other_account;
    }

    public void setOther_account (Other_account other_account)
    {
        this.other_account = other_account;
    }

    public This_account getThis_account ()
    {
        return this_account;
    }

    public void setThis_account (This_account this_account)
    {
        this.this_account = this_account;
    }

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", details=" + details + ", other_account=" + other_account + "]";
	}

   
    
}
