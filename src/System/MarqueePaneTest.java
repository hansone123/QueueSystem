package System;

import System.MarqueePane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MarqueePaneTest extends Application {
  private MarqueePane pane;

  @Override
  public void start(Stage stage) throws Exception {
    VBox root = new VBox();
    root.setPadding(new Insets(50));
    root.setAlignment(Pos.CENTER);
    root.setPrefSize(200, 18);

    pane = new MarqueePane(200, 18, "ABCDEFGabcdefg中文", 8000, 20);
    pane.setTextColor("#00FF00");
    pane.setBackgroundColor("#000000");
    root.getChildren().addAll(pane, getActionBtns());

    stage.setScene(new Scene(root, 300, 200));
    stage.show();
  }

  private HBox getActionBtns() {
    HBox hb = new HBox(10);

    Button btn;

    btn = new Button("play");
    btn.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent arg0) {
        pane.play();
      }
    });
    hb.getChildren().add(btn);

    btn = new Button("pause");
    btn.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent arg0) {
        pane.pause();
      }
    });
    hb.getChildren().add(btn);

    btn = new Button("stop");
    btn.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent arg0) {
        pane.stop();
      }
    });
    hb.getChildren().add(btn);

    return hb;
  }

  public static void main(String[] args) {
    launch();
  }
}
