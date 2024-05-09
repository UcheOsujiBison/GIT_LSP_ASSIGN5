package org.howard.edu.lsp.oopfinal.question3;

import static org.junit.Assert.*;
import org.junit.Test;

// Shape class
public interface Shape {
    void draw();
}

// Circle class
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("I'm a Circle!!!");
    }
}

// Rectangle class
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("I'm a Rectangle!!!");
    }
}

// CreateShape class
public class NewShape {
    public static Shape createShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Shape c = NewShape.createShape("Circle");
        c.draw();
        
        Shape r = NewShape.createShape("Rectangle");
        r.draw();
    }
}

// ShapeTest class
public class ShapeTest {

    @Test
    public void testCircle() {
        Shape c = ShapeFactory.createShape("Circle");
        assertNotNull(c);
        assertTrue(c instanceof Circle);
        c.draw();
    }

    @Test
    public void testRectangle() {
        Shape r = ShapeFactory.createShape("Rectangle");
        assertNotNull(r);
        assertTrue(r instanceof Rectangle);
        r.draw();
    }
}