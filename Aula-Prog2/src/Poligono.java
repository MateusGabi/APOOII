
/**
 *
 * @author mateus
 */
public class Poligono
{
    
    private final int side;
    private final double side_lenght[];

    public Poligono(int side, double[] side_lenght)
    {
        this.side = side;
        this.side_lenght = side_lenght;
    }    
    
    
    public static void print()
    {
        System.out.println("Este é um polígono de:");
        System.out.println("-- " + side +" lados");
    }
    
    public static void main(String[] args)
    {
        Poligono triangulo = new Poligono(3, new double[] {1.0, 1.0, 1.0});
        triangulo.print();
    }
}
