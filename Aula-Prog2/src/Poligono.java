import java.util.*;

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
    private final double APOTEMA;
    private final double AREA;

    public Poligono(int side, double sideLenght) {
        this.SIDE = side;
        this.SIDELENGHT = sideLenght;
        this.DIAGONAIS = side - 3;
        this.TRIANGULOS = side - 2;
        this.SOMA_ANG_INTERNO = TRIANGULOS * 180;
        this.ANG_INTERNO = SOMA_ANG_INTERNO / side;
        this.ANG_EXTERNO = 360 / side;
        this.ANG_CENTRAL = 360 / side;
        this.APOTEMA = SIDELENGHT / (2*Math.tan(Math.PI/SIDE));
        this.AREA = SIDE*SIDELENGHT/2.0*APOTEMA;
    }
    
    /**
     * Imprime as seguintes informações:
     *  - lados;
     *  - diagonais;
     *  - triangulos;
     *  - soma dos angulos externos;
     *  - soma dos angulos internos;
     *  - angulo interno;
     *  - angulo externo;
     *  - angulo central;
     *  - apótema; e
     *  - área.
     */
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
        System.out.println("-- apótema = " + APOTEMA +"u");
        System.out.println("-- area = " + AREA +"u²");
        System.out.println();
    }

    public static void main(String[] args) {
       
        List<Poligono> poligonos = new ArrayList<>();
        
        for (int i = 1; i <= 20; i++)
        {
            poligonos.add(new Poligono(i, 1.0));
        }
        
        for (Poligono poligono : poligonos)
        {
            poligono.print();
        }
    }
}
