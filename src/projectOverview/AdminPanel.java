package projectOverview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AdminPanel extends BorderPane
{
    private static ObservableList<Food> items;
    private final BorderPane _root;

    public AdminPanel()
    {
        _root = this;
        //getting available foods from the database ( text file )
        FoodHandler foodHandler = FoodHandler.get();
        items = FXCollections.observableArrayList(
                foodHandler.get_foods());
        //generating listView based on database data
        ListView<Food> list = new ListView<>(items);

        list.setCellFactory(new Callback<ListView<Food>, ListCell<Food>>()
        {
            @Override
            public ListCell<Food> call(ListView<Food> param)
            {
                return new ListCell<Food>()
                {
                    @Override
                    public void updateItem(Food item, boolean empty)
                    {
                        super.updateItem(item, empty);
                        if (!(empty || item == null))
                        {
                            // adding new item
                            setGraphic(new ListCell_admin(item.get_name(), item.get_price(), item.get_reserveDate()));
                        } else
                        {
                            setGraphic(null);
                        }
                    }
                };
            }
        });

        //setup logic
        Button add_btn = new Button("Add New Item");
        add_btn.setOnAction((e) ->
        {

            Stage addStage = new Stage();
            Scene scene = new Scene(new AddFoodForm());
            addStage.setResizable(false);
            addStage.setScene(scene);
            addStage.initModality(Modality.APPLICATION_MODAL);
            addStage.show();

        });
        Button btn_remove = new Button("Remove An Item");
        btn_remove.setOnAction((e) ->
        {
            items.remove(
                    list.getSelectionModel().getSelectedItem()
            );
        });
        //design
        list.setPrefHeight(550);
        HBox holder = new HBox(add_btn, btn_remove);
        holder.setSpacing(8);
        holder.setPadding(new Insets(25));
        holder.setPrefHeight(20);
        holder.setAlignment(Pos.CENTER);
        _root.setCenter(new VBox(list, holder));
        this.setPrefHeight(600);
        this.setPrefWidth(800);

    }

    //return instantiated object from this class
    public BorderPane get_root()
    {
        return _root;
    }

    //add a food to the listView list
    public static void add_item(Food food)
    {
        items.add(food);
    }
}
