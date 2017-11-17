import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.layout.Priority;
import javafx.scene.paint.CycleMethod;
import javafx.beans.value.*;

import java.util.Vector;

import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;

import javafx.beans.binding.*;

import javafx.event.*;

class PanelWidget extends GridPane {
	public PanelWidget() {
		Vector<Stop> stops = new Vector<Stop>();
		stops.add(new Stop(0.0, Color.DARKRED));
		stops.add(new Stop(0.5, Color.BLACK));
		stops.add(new Stop(1.0, Color.DARKRED));
		//stops are relative to [0,1]
		
		RadialGradient g = new RadialGradient(0.0, 0.0, 0.5, 0.5, 1.0, true, CycleMethod.REFLECT, stops);
	
		Rectangle r = new Rectangle(300.0, 300.0, g);
		add(r, 0, 0);
	}
}