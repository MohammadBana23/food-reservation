/*
This is the User-modeled Class
the use of this class is creating a user with user name and password and a list of reserved foods!
 */
package projectOverview;
import java.util.ArrayList;
import java.util.List;

public class User
{
    private final List<Food> _reservedFoods;

    public User(String _username, String _password)
    {
        this._reservedFoods = new ArrayList<>();
    }

    public void edit_reservedFoods()
    {
        for (int i = 0; i <this.get_reservedFoods().size(); i++)
        {
            for (int j = i; j < this.get_reservedFoods().size(); j++)
            {
                try
                {
                    Food food = this.get_reservedFoods().get(this.get_reservedFoods().size() - 1);
                    if (!food.is_reserved())
                    {
                        this.get_reservedFoods().remove(food);
                    }

                } catch (Exception ignored)
                {
                }
            }
        }
    }

    public List<Food> get_reservedFoods()
    {

        return _reservedFoods;

    }

    public void add_foods(Food food)
    {
        this._reservedFoods.add(food);
    }
}

