package com.kodilla.testing.shape;

import org.junit.*;
import java.util.Arrays;
import java.util.List;

public class ShapeCollectorTestSuite {

    private ShapeCollector shapeCollect;
    private Shape circle;
    private static int counter;
    private static final int RADIAL_DIMENSION = 5;

    @Before
    public void before(){
        counter++;
        System.out.println(counter + ". Test Case - begin");
        circle = new Circle(RADIAL_DIMENSION);
        shapeCollect = new ShapeCollector();
    }

    @After
    public void after(){
        System.out.println("Test Case: end");
    }

    @Test
    public void testAddFigure(){
        //Given
        //When
        Shape figure = shapeCollect.addFigure(circle);
        System.out.println("Add Figure - Testing");
        //Then
        Assert.assertEquals(circle, figure);
    }

    @Test
    public void testRemoveFigure(){
        //Given
        shapeCollect.addFigure(circle);
        //When
        boolean result = shapeCollect.removeFigure(circle);
        System.out.println("Remove Figure - Testing");
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testRemoveFigureFromEmptyList(){
        //Given
        //When
        boolean result = shapeCollect.removeFigure(circle);
        System.out.println("Removing Figure if List is Empty - Testing");
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testGetFigure(){
        //Given
        shapeCollect.addFigure(circle);
        //When
        Shape figure = shapeCollect.getFigure(0);
        System.out.println("Get Figure - Testing");
        //Then
        Assert.assertEquals(circle, figure);
    }

    @Test
    public void testGetFigureFromEmptyList(){
        //Given
        //When
        Shape figure = shapeCollect.getFigure(2);
        System.out.println("Get Figure From Empty List - Testing");
        //Then
        Assert.assertNull(figure);
    }

    @Test
    public void testGetFigureFromNegativeIndex(){
        //Given
        //When
        Shape figure = shapeCollect.getFigure(-1);
        System.out.println("Get Figure From Negative Index - Testing");
        //Then
        Assert.assertNull(figure);
    }

    @Test
    public void testShowFigures(){
        //Given
        shapeCollect.addFigure(circle);
        //When
        List<Shape> figure = shapeCollect.showFigures();
        System.out.println("Show Figure - Testing");
        //Then
        Assert.assertEquals(Arrays.asList(circle), figure);
    }
}
