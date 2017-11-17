import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import java.util.Vector;
import javafx.geometry.*;

public class Circles extends Pane {
	private Vector<PageRequestHandler> pageHandlers;
	
	private int pageCount;
	private int currentPage;
	
	private double padding;
	private double radius;
	
	public Circles() {
		pageHandlers = new Vector<PageRequestHandler>();
		
		pageCount = 0;
		currentPage = 0;
		padding = 10.0;
		radius = 40.0;
		
		this.setPadding(new Insets(padding));
	}
	
	public void setPageCount(int count) throws CirclesException{
		if(count < 0) {
			throw new CirclesException("Page count out of bounds(can't be negative)");
		}
		
		pageCount = count;
		
		this.getChildren().clear();
		
		Double curCenter = padding;
		for(int i = 0; i < count; i++) {
			Circle circle = new Circle(radius, Color.RED); //radius, paint
			circle.relocate(curCenter, padding); //x,y
			this.getChildren().add(circle);
			
			Integer I = new Integer(i);
			/*
			 circle.setOnMouseClicked(
			 	new EventHandler<MouseEvent>() {
			 		@Override
			 		public void handle(MouseEvent me){
			 			emitPageEvent(I);
			 			}
			 			}
			 			);
			 */
			
			circle.setOnMouseClicked(
					(MouseEvent ev) -> emitPageEvent(I)
				);
			curCenter += radius + radius + padding;
		}
		
		this.setMinWidth(padding + (pageCount * (radius + radius + padding)));
		this.setMinHeight(padding + radius + radius + padding);
	}
	
	//page is 0, count -1
	public void setCurrentPage(int page) throws CirclesException{
		if(page < 0 || page >= pageCount) {
			throw new CirclesException("current page out of range");
		}
		
		int cp = 0;
		
		for(Node n: this.getChildren()) {
			if(n instanceof Circle) {
				Circle c = (Circle) n;
				if(cp < page) {
					c.setFill(Color.GREEN);
				}else if(cp > page) {
					c.setFill(Color.RED);
				}else {
					c.setFill(Color.YELLOW);
				}
				cp += 1;
			}
		}
		
		currentPage = page;
		
	}
	
	public void addPageRequestHandler(PageRequestHandler handler) {
		pageHandlers.add(handler);
	}
	
	public void emitPageEvent(int number) {
		for(PageRequestHandler handler: pageHandlers) {
			handler.handle(number);
		}
	}
}
