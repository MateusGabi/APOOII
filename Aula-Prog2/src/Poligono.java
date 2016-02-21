/**
 * @author mateus
 */
public class Poligono {

    private final int SIDE;
    private final double SIDELENGHT;
    private final int DIAGONAIS;
    private final int TRIANGULOS;
    private final double SOMA_ANG_INTERNO;
    private final double SOMA_ANG_EXTERNO = 360;
    private final double ANG_INTERNO;
    private final double ANG_EXTERNO;
    private final double ANG_CENTRAL;

    public Poligono(int side, double sideLenght) {
        this.SIDE = side;
        this.SIDELENGHT = sideLenght;
        this.DIAGONAIS = side - 3;
        this.TRIANGULOS = side - 2;
        this.SOMA_ANG_INTERNO = TRIANGULOS * 180;
        this.ANG_INTERNO = SOMA_ANG_INTERNO / side;
        this.ANG_EXTERNO = 360 / side;
        this.ANG_CENTRAL = 360 / side;
    }

    public double getApotema()
    {
        return SIDELENGHT / (2*Math.tan(Math.PI/SIDE));
    }
    
    public double getArea()
    {
        return SIDE*SIDELENGHT/2.0*getApotema();
    }

    public void print() {
        System.out.println("Este é um polígono de:");
        System.out.println("-- lados = " + SIDE);
        System.out.println("-- diagonais = " + DIAGONAIS);
        System.out.println("-- triangulos = " + TRIANGULOS);
        System.out.println("-- soma dos angulos externos = " + SOMA_ANG_EXTERNO +"°");
        System.out.println("-- soma dos angulos iternos = " + SOMA_ANG_INTERNO +"°");
        System.out.println("-- angulo internos = " + ANG_INTERNO +"°");
        System.out.println("-- angulo externos = " + ANG_EXTERNO +"°");
        System.out.println("-- angulo central = " + ANG_CENTRAL +"°");
        System.out.println("-- apótema = " + getApotema() +"u");
        System.out.println("-- area = " + getArea() +"u²");
        System.out.println();
    }

    public static void main(String[] args) {
        Poligono triangulo = new Poligono(3, 1.0);
        triangulo.print();
        
        Poligono dodecagono = new Poligono(12, 1.0);
        dodecagono.print();
        
        Poligono eneadecágono = new Poligono(19, 1.0);
        eneadecágono.print();
        
        Poligono vintágono = new Poligono(20, 1.0);
        vintágono.print();
    }
}
