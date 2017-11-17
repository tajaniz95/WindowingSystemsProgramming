import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;
import java.util.Vector;

class PanelWidget2 extends GridPane {
	public PanelWidget2() {
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
