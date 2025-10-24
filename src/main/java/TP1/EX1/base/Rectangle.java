package TP1.EX1.base;

public class Rectangle {
    private float height;
    private float width;

    public Rectangle(float height, float width) {
        this.height = height;
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getArea() {
        return height * width;
    }

    public float getPerimeter() {
        return (height + width) * 2;
    }

}
