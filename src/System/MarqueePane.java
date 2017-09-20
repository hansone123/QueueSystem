/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

/**
 *
 * @author hanson
 */


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

import com.sun.javafx.tk.Toolkit;

/**
 * 
 * 用途：<br>
 * 文字跑馬燈 <br>
 * 說明：<br>
 * 文字會從右至左進行水平移動 <br>
 * <br>
 */
public class MarqueePane extends Pane {
  private Timeline timeline;
  private Pane clipPane;
  private Text TText;

 
  public MarqueePane(Pane pane,Text text) {
      
      TText = text;
//      TText.setStrokeWidth(0);
      clipPane = pane;
//      clipPane.getChildren().add(TText);
      timeline = new Timeline();
      timeline.setCycleCount(Animation.INDEFINITE);
      timeline.setAutoReverse(false);
  }

  /**
   * 
   * @param width
   *          元件長度
   * @param height
   *          元件寬度
   * @param text
   *          顯示文字
   * @param speed
   *          文字移動速度
   * @param fontSize
   *          文字大小
   */
  public void init(double width, double height, String text, int speed) {

    TText.setText(text);
    clipPane.setClip(new Rectangle(width, height));
    double textWidth = getTextWidth(TText);
    KeyValue value = new KeyValue(TText.layoutXProperty(), -textWidth);
    KeyFrame frame = new KeyFrame(Duration.millis(speed), value);
    timeline.getKeyFrames().add(frame);
    double textHeight = getTextHeight(TText);
    TText.relocate(width, (height / 2) - (textHeight / 2));
  }
  
  private double getTextWidth(Text text) {
    return Toolkit.getToolkit().getFontLoader().computeStringWidth(text.getText(), text.getFont());
  }

  private double getTextHeight(Text text) {
    return Toolkit.getToolkit().getFontLoader().getFontMetrics(text.getFont()).getLineHeight();
  }

  /**
   * 切換背景顏色
   * 
   * @param color
   */
  public void setBackgroundColor(String color) {
    if (clipPane == null) {
      return;
    }

    clipPane.setStyle("-fx-background-color:" + color);
  }

  /**
   * 切換文字顏色
   * 
   * @param color
   */
  public void setTextColor(String color) {
    if (TText == null) {
      return;
    }

    TText.setFill(Color.web(color));
    TText.setStyle("-fx-stroke:" + color);
  }

  /**
   * 撥放
   */
  public void play() {
    if (timeline == null) {
      return;
    }

    timeline.play();
  }

  /**
   * 暫停
   */
  public void pause() {
    if (timeline == null) {
      return;
    }

    timeline.pause();
  }

  /**
   * 暫停並且初始化文字位置
   */
  public void stop() {
    if (timeline == null) {
      return;
    }

    pause();
    timeline.jumpTo(Duration.ZERO);
  }
}
