package com.example.myapplication;

public class Tower
{
    private Disk top;
    public int count;

    public Tower()
    {
        this.top = null;
        this.count = 0;
    }

    public int getCount()
    {
        return this.count;
    }

    public Disk peek()
    {
        return this.top;
    }

    public Disk pop()
    {
        Disk diskToReturn = this.top;

        if(this.top != null)
        {
            this.top = this.top.getNextDisk();
            diskToReturn.setNextDisk(null);
        }

        this.count--;
        return diskToReturn;
    }

    public boolean push(Disk d)
    {
        if(this.top == null)
        {
            this.top = d;
            this.count++;
            return true;
        }
        else if(d.getSize() < this.top.getSize())
        {
            d.setNextDisk(this.top);
            this.top = d;
            this.count++;
            return true;
        }
        else
        {
            //illegal move
            return false;
        }
    }

    public void display()
    {
        Disk currDisk = this.top;
        while(currDisk != null)
        {
            currDisk.display();
            currDisk = currDisk.getNextDisk();
        }
    }


}
