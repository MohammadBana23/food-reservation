package projectOverview;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Date;

public class ListCell_admin extends HBox
{
    private final VBox _infoHolder;
    private final Text _foodName;

    public ListCell_admin(String name, double price, Date date)
    {
        super();
        //creating elements
        _foodName = new Text("Name : "+name);
        Text _foodPrice = new Text("Price : $" + price);
        Text _foodDate = new Text(String.format("%d/%d/%d", date.getYear() + 1900, date.getMonth(), date.getDate()));
        _infoHolder = new VBox(_foodName, _foodPrice, _foodDate);
        designElements();
        this.getChildren().addAll(_infoHolder);
    }

    //design
    private void designElements(){
        _infoHolder.setPadding(new Insets(12));
        _infoHolder.setSpacing(20);
        _foodName.setFont(Font.font("B Titr",22));
    }

}
