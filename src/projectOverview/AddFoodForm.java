package projectOverview;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Date;

public class AddFoodForm extends VBox
{
    public AddFoodForm()
    {

        // Creating Holders
        HBox nameHolder = new HBox();
        HBox priceHolder = new HBox();
        HBox dateHolder = new HBox();

        //Creating Elements
        Label lbl_name = new Label("Name :");
        Label lbl_price = new Label("Price :");
        Label lbl_date = new Label("Date :");

        TextField txt_name = new TextField();
        TextField txt_price = new TextField();
        ComboBox<Integer> cmb_year = new ComboBox<>();
        ComboBox<Integer> cmb_month = new ComboBox<>();
        ComboBox<Integer> cmb_day = new ComboBox<>();

        Button btn_apply = new Button("Apply");

        //Initializing ComboBoxes
        for (int i = 0; i < 100; i++)
        {
            int year = 2020 + i;
            cmb_year.getItems().add(year);
        }

        for (int i = 0; i < 30; i++)
        {
            int day = i + 1;
            cmb_day.getItems().add(day);
        }

        for (int i = 0; i < 12; i++)
        {
            int month = i + 1;
            cmb_month.getItems().add(month);
        }

        cmb_year.setValue(new Date().getYear() + 1900);
        cmb_month.setValue(new Date().getMonth());
        cmb_day.setValue(new Date().getDate());

        //Adding to Holders
        nameHolder.getChildren().addAll(lbl_name, txt_name);
        priceHolder.getChildren().addAll(lbl_price, txt_price);
        dateHolder.getChildren().addAll(lbl_date, cmb_year, cmb_month, cmb_day);

        //Add to Root
        this.getChildren().addAll(nameHolder, priceHolder, dateHolder, btn_apply);

        //design
        this.setPrefHeight(300);
        this.setPrefWidth(400);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(40));
        this.setSpacing(12);
        nameHolder.setAlignment(Pos.CENTER);
        nameHolder.setSpacing(8);
        priceHolder.setAlignment(Pos.CENTER);
        priceHolder.setSpacing(8);
        dateHolder.setAlignment(Pos.CENTER);
        dateHolder.setSpacing(8);

        //Initializing Apply Button
        btn_apply.setOnAction(event ->
        {
            Date date = new Date(cmb_year.getValue()-1900,cmb_month.getValue(),cmb_day.getValue());
            Food food = new Food(txt_name.getText(),Double.parseDouble(txt_price.getText()),date);
            FoodHandler.get().write_food(food);
            AdminPanel.add_item(food);
            this.getScene().getWindow().hide();
        });

    }
}
