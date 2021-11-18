
class Oblong
{
    // the attributes are declared first
    private double length;
    private double height;

    // then the methods

    // the constructor
    public Oblong(double lengthIn, double heightIn)
    {
        length = lengthIn;
        height = heightIn;
    }


    // the next method allows us to "read" the length attribute
    public double getLength()
    {
        return length;
    }

    // the next method allows us to "read" the height attribute
    public double getHeight()
    {
        return height;
    }

    // the next method allows us to "write" to the length attribute
    public void setLength(double lengthIn)
    {
         length = lengthIn;
    }

    // the next method allows us to "write" to the height attribute
    public void setHeight(double heightIn)
    {
        height = heightIn;
    }

    // this method returns the area of the oblong
    public double calculateArea()
    {
        return length * height;
    }

    // this method returns the perimeter of the oblong
    public double calculatePerimeter()
   {
        return 2 * (length + height);
   }
}
