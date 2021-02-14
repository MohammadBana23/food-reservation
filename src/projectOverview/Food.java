/*
This is Food-modeled class
the use of this class is to create a food object with name reserveDate price and check if this food is reserved by user.
 */

package projectOverview;

import java.util.Date;

public class Food
{
    private String _name;
    private Date _reserveDate;
    private double _price;
    private boolean _reserved = false;

    @Deprecated
    public Food(String _name, double _price, Date _reserveDate)
    {
        this._name = _name;
        this._price = _price;
        this._reserveDate = _reserveDate;
        this.get_reserveDate().setYear(this.get_reserveDate().getYear() + 20);
    }

    public Food(String _name, double _price)
    {
        this(_name, _price, new Date());
    }

    public Food(String _name)
    {
        this(_name, 0, new Date());
    }

    public String get_name()
    {
        return _name;
    }

    public void set_name(String _name)
    {
        this._name = _name;
    }

    public Date get_reserveDate()
    {
        return _reserveDate;
    }

    public void set_reserveDate(Date _reserveDate)
    {
        this._reserveDate = _reserveDate;
    }

    public double get_price()
    {
        return _price;
    }

    public void set_price(double _price)
    {
        this._price = _price;
    }

    public boolean is_reserved()
    {
        return this._reserved;
    }

    public void set_reserved(boolean bool)
    {
        this._reserved = bool;
    }

    @Override
    public String toString()
    {
        return String.format("%s:%.2f:%s", this._name, this._price, this._reserveDate.toString());
    }
}
