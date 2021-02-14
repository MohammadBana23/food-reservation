/*
this singleton is created for handling Foods .
this class reads available foods from database ( text file ) ,
create a Food object for each food ,
write newly added foods in to database,
remove foods from database,
and everything we need from foods.
 */

package projectOverview;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FoodHandler
{
    private final List<Food> _foods = new ArrayList<>();
    private static FoodHandler _foodHandler;

    public FoodHandler()
    {
        getFoodsFromDataBase();
    }

    public void add_food(Food food)
    {
        _foods.add(food);
    }

    public void write_food(Food food)
    {
        try
        {
            File foodsFile = new File("src/Foods.txt");
            FileWriter fileWriter = new FileWriter(foodsFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(food.toString());
            printWriter.close();
        } catch (Exception ignored)
        {
        }
    }

    private void getFoodsFromDataBase()
    {
        try
        {
            File foodsFile = new File("src/Foods.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(foodsFile));
            String line = bufferedReader.readLine();
            while (line != null)
            {
                this.add_food(new Food(line.split(":")[0],
                        Double.parseDouble(line.split(":")[1]),
                        new Date(Date.parse(line.split(":")[2]))));
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    //forcing the program to only have one instance of this class! -> singleton
    public static FoodHandler get()
    {
        if (_foodHandler == null)
        {
            _foodHandler = new FoodHandler();
        }
        return _foodHandler;
    }
    @Deprecated
    public List<Food> get_foodsOnDate(Date date){
        List<Food> foods = new ArrayList<>();
        boolean flag = false;
        try
        {
            for (int i = 0; i < this.get_foods().size(); i++)
            {
                Date foodDate = this.get_foods().get(i).get_reserveDate();
                if (!flag)
                {
                    System.out.println(foodDate.toString());
                    System.out.println(date.toString());
                    flag = true;
                }
                if (foodDate.getYear() == date.getYear() && foodDate.getMonth() == date.getMonth() && foodDate.getDate() == date.getDate())
                    foods.add(this.get_foods().get(i));
            }
        }catch (Exception ignored){}
        return foods;
    }

    public List<Food> get_foods()
    {
        return _foods;
    }

}
