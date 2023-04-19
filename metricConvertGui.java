import java.util.Stack;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class metricConvertGui extends Application{

    public double kmToMi(double km){
        return km *  0.62137119;
    }

    public double miToKm(double mi){
        return mi * 1.60934;
    }

    public double kgToLbs(double kg){
        return kg * 2.20462;
    }

    public double lbsToKg(double lbs){
        return lbs * 0.453592;
    }

    public double liToGal(double li){
        return li * 0.264172;
    }

    public double galToLi(double gal){
        return gal * 3.78541;
    }

    public double cToF(double C){
        double F = ((9/5) * C) + 32;
        return F;
    }

    public double fToC(double F){
        double C = (F - 32) * (5/9);
        return C;
    }



    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
            BorderPane pane = new BorderPane();
            ComboBox type = new ComboBox<>();
            type.getItems().addAll("km to mi", "mi to km", "kg to lbs", "lbs to kg", "li to gal", "gal to li", "C to F", "F to C");
            pane.setCenter(type);
            TextField input = new TextField();
            Label write = new Label("input here");
            Button enter = new Button("enter");
            HBox layer = new HBox(10);
            double numIn;
            Label result = new Label();
            layer.getChildren().addAll(write, input, enter);
            pane.setBottom(layer);
            pane.setTop(result);

            input.textProperty().addListener(new ChangeListener<String>() {

                @Override
                public void changed(ObservableValue<? extends String> arg0, String arg1, String newValue) {
                    if (!newValue.matches("/f*")) {
                        input.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });

            enter.setOnAction(e -> {
                // result.setText(" " + input.getText());
                switch((String)type.getValue()){
                    case "km to mi": 
                        result.setText(kmToMi(Double.parseDouble(input.getText())) + " mi");
                        break;
                    case "mi to km":
                        result.setText(miToKm(Double.parseDouble(input.getText())) + " km");
                        break;
                    case "kg to lbs":
                        result.setText(kgToLbs(Double.parseDouble(input.getText())) + " lbs");
                        break;
                    case "lbs to kg":
                        result.setText(lbsToKg(Double.parseDouble(input.getText())) + " kg");
                        break;
                    case "li to gal":
                        result.setText(liToGal(Double.parseDouble(input.getText())) + " gal");
                        break;
                    case "gal to li":
                        result.setText(galToLi(Double.parseDouble(input.getText())) + " li");
                        break;
                    case "C to F":
                        result.setText(cToF(Double.parseDouble(input.getText())) + " F");
                        break;
                    case "F to C":
                        result.setText(fToC(Double.parseDouble(input.getText())) + " C");
                        break;
                }

            });
            EventHandler<ActionEvent> event =
                            new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent e)
                        {
                            System.out.println(type.getSelectionModel());
                            switch((String)type.getValue()){
                                case "km to mi":
                                case "mi to km":
                                case "kg to lbs":
                                case "lbs to kg":
                                case "li to gal":
                                case "gal to li":
                                case "C to F":
                                case "F to C":
                            }
                        }
                    };

            type.setOnAction(event);

            // input.textProperty().addListener(new ChangeListener<Number>() {

            //     @Override
            //     public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            //         System.out.println(oldValue + "   " + newValue);
            //     }
            // });


            Scene scene = new Scene(pane, 300, 200);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            
                @Override
                public void handle(WindowEvent t) {
                    Platform.exit();
                    System.exit(0);
                }
            });
    

        }


}