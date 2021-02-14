package projectOverview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class UserPanel extends VBox
{
    @Deprecated
    public UserPanel(User user)
    {
        //Creating Elements
        ComboBox<Date> cmb_date = new ComboBox<>();
        Button btn_reserve = new Button("Reserve");
        Button btn_showReserved = new Button("Show Reserves");
        //creating listView
        ObservableList<Food> items = FXCollections.observableArrayList(FoodHandler.get().get_foodsOnDate(cmb_date.getSelectionModel().getSelectedItem()));
        ListView<Food> listView = new ListView<>(items);
        listView.setCellFactory((ListView<Food> param) -> new ListCell<Food>()
        {
            @Override
            public void updateItem(Food item, boolean empty)
            {
                super.updateItem(item, empty);
                if (!(empty || item == null))
                {
                    setGraphic(new ListCell_user(item.get_name(), item.get_price(), item.get_reserveDate(),false,item));
                } else
                {
                    setGraphic(null);
                }
            }
        });
        //setting up combo box data
        for (int i = 18; i < 25; i++)
        {
            cmb_date.getItems().addAll(new Date(120, Calendar.SEPTEMBER, i + 1));
        }
        cmb_date.getSelectionModel().select(0);
        //setup the elements' behaviour
        cmb_date.setOnAction(event ->
        {
            items.clear();
            items.addAll(new FoodHandler().get_foodsOnDate(cmb_date.getSelectionModel().getSelectedItem()));
            System.out.println(Arrays.toString(new FoodHandler().get_foodsOnDate(cmb_date.getSelectionModel().getSelectedItem()).toArray()));
        });
        btn_reserve.setOnAction(event -> {

            for (int i = 0; i < FoodHandler.get().get_foodsOnDate(cmb_date.getSelectionModel().getSelectedItem()).size(); i++)
            {
                Food food = FoodHandler.get().get_foodsOnDate(cmb_date.getSelectionModel().getSelectedItem()).get(i);
                if (food.is_reserved()){
                    user.add_foods(food);
                }
                System.out.println(food);
            }

        });
        btn_showReserved.setOnAction(event -> {
            user.edit_reservedFoods();
            System.out.println(user.get_reservedFoods());
        });
        //adding elements
        this.getChildren().addAll(cmb_date, listView,btn_reserve,btn_showReserved);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(25);

    }
}
