package model;

import model.interfaces.ICommand;
import model.interfaces.IUndoable;
import model.persistence.ApplicationState;

import java.awt.*;
import java.awt.Point;


public class CreateShape implements ICommand, IUndoable {

    private ShapeType shapeType;
    ApplicationState appState;
    private Point startPoint;
    private Point endPoint;
    private ShapeList shapeList;
    Color pColor;
    Color sColor;
    private ShapeShadingType shapeShadingType;



    public CreateShape(ApplicationState appState, Point startPoint, Point endPoint, ShapeList shapeList, Color pColor, Color sColor, ShapeShadingType shapeShadingType, ShapeType shapeType){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
        this.appState = appState;
        this.pColor = pColor;
        this.sColor = sColor;
        this.shapeShadingType = shapeShadingType;
        this.shapeType = shapeType;
    }

    public void run() {

        Shape shape = new Shape(startPoint,endPoint,appState,pColor,sColor,shapeShadingType,shapeType);
        shapeList.addShape(shape);
        CommandHistory.add(this);
    }


    @Override
    public void undo() {
        shapeList.removeShape();
    }

    @Override
    public void redo() {
        shapeList.redoShape();
    }
}


//        System.out.println("Start Points for x: " + this.startPoint.getX() + ", " + this.startPoint.getY());
//draw rect
//        Rect rect = new Rect(startPoint,endPoint);
//draw triangle
//        Tri tri = new Tri(startPoint,endPoint);
//        shapeList.addShape(tri);
//        Ellip ellip = new Ellip(startPoint,endPoint,appState,pColor,sColor,shapeShadingType);}

//        if(shapeType==ShapeType.RECTANGLE){ Rect rect = new Rect(startPoint,endPoint,appState,pColor,sColor,shapeShadingType); }
//        else if(shapeType==ShapeType.TRIANGLE) {Tri tri = new Tri(startPoint,endPoint,appState,pColor,sColor,shapeShadingType);}
//        else{Ellip ellip = new Ellip(startPoint,endPoint,appState,pColor,sColor,shapeShadingType);}
