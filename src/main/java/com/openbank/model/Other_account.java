package com.openbank.model;



public class Other_account
{
    private String id;

    private Holder holder;

    private String number;

    
    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Holder getHolder ()
    {
        return holder;
    }

    public void setHolder (Holder holder)
    {
        this.holder = holder;
    }

    
    public String getNumber ()
    {
        return number;
    }

    public void setNumber (String number)
    {
        this.number = number;
    }

	@Override
	public String toString() {
		return "Other_account [id=" + id + ", number=" + number + "]";
	}

    
   
}
