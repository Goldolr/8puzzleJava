import java.util.Date;
import java.util.Random;

/*
 * Clase principal para la solución
 *
*/
public class codigo {

    // Declaración de variables y matriz vacia como contenedora

    int g, nodosExpandidos;
    int[][] pizarra;
    Date fecha;
    Random random;

    // Definición de cantidad de movimientos máximos
    public static final int MOVIMIENTOS_MAXIMOS = 100;

    /*
     * Constructor para la solución
     */
    public codigo() {
        boolean encontrado;
        int digito, i, j, k;
        int[] ubicacion = new int[9];

        fecha = new Date();
        random = new Random(fecha.getTime());
        for (i = 0; i < 9; i++)
            ubicacion[i] = 0;
        pizarra = new int[3][3];
        g = nodosExpandidos = 0;

        // Bucle para definir las casillas
        for (i = 0; i < 3; i++)
            for (j = 0; j < 3; j++)
                pizarra[i][j] = 0;
        // Bucle para asignación de valor 0 ó casilla vacia
        for (i = 0; i < 9; i++) {
            encontrado = false;
            do {
                digito = random.nextInt(9);
                encontrado = ubicacion[digito] == 0;
                if (encontrado)
                    ubicacion[digito] = 1;
            } while (!encontrado);
            do {
                j = random.nextInt(3);
                k = random.nextInt(3);
                encontrado = pizarra[j][k] == 0;
                if (encontrado)
                    pizarra[j][k] = digito;
            } while (!encontrado);
        }
    }

    int getNodosExpandidos() {
        return nodosExpandidos;
    }

    /*
     * Dibuja la matriz de 3x3
     */
    int expandir(int[][] cuadrado, int[][][] cuadradoTemporal) {
        int b = -1, columna = -1, i, j, k, fila = -1;

        for (i = 0; i < 4; i++)
            for (j = 0; j < 3; j++)
                for (k = 0; k < 3; k++)
                    cuadradoTemporal[i][j][k] = cuadrado[j][k];
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (cuadrado[i][j] == 0) {
                    fila = i;
                    columna = j;
                    break;
                }
            }
        }
        if (fila == 0 && columna == 0) {
            cuadradoTemporal[0][0][0] = cuadradoTemporal[0][0][1];
            cuadradoTemporal[0][0][1] = 0;
            cuadradoTemporal[1][0][0] = cuadradoTemporal[1][1][0];
            cuadradoTemporal[1][1][0] = 0;
            b = 2;
        } else if (fila == 0 && columna == 1) {
            cuadradoTemporal[0][0][1] = cuadradoTemporal[0][0][0];
            cuadradoTemporal[0][0][0] = 0;
            cuadradoTemporal[1][0][1] = cuadradoTemporal[1][1][1];
            cuadradoTemporal[1][1][1] = 0;
            cuadradoTemporal[2][0][1] = cuadradoTemporal[2][0][2];
            cuadradoTemporal[2][0][2] = 0;
            b = 3;
        } else if (fila == 0 && columna == 2) {
            cuadradoTemporal[0][0][2] = cuadradoTemporal[0][0][1];
            cuadradoTemporal[0][0][1] = 0;
            cuadradoTemporal[1][0][2] = cuadradoTemporal[1][1][2];
            cuadradoTemporal[1][1][2] = 0;
            b = 2;
        } else if (fila == 1 && columna == 0) {
            cuadradoTemporal[0][1][0] = cuadradoTemporal[0][0][0];
            cuadradoTemporal[0][0][0] = 0;
            cuadradoTemporal[1][1][0] = cuadradoTemporal[1][1][1];
            cuadradoTemporal[1][1][1] = 0;
            cuadradoTemporal[2][1][0] = cuadradoTemporal[2][2][0];
            cuadradoTemporal[2][2][0] = 0;
            b = 3;
        } else if (fila == 1 && columna == 1) {
            cuadradoTemporal[0][1][1] = cuadradoTemporal[0][1][0];
            cuadradoTemporal[0][1][0] = 0;
            cuadradoTemporal[1][1][1] = cuadradoTemporal[1][0][1];
            cuadradoTemporal[1][0][1] = 0;
            cuadradoTemporal[2][1][1] = cuadradoTemporal[2][1][2];
            cuadradoTemporal[2][1][2] = 0;
            cuadradoTemporal[3][1][1] = cuadradoTemporal[3][2][1];
            cuadradoTemporal[3][2][1] = 0;
            b = 4;
        } else if (fila == 1 && columna == 2) {
            cuadradoTemporal[0][1][2] = cuadradoTemporal[0][0][2];
            cuadradoTemporal[0][0][2] = 0;
            cuadradoTemporal[1][1][2] = cuadradoTemporal[1][1][1];
            cuadradoTemporal[1][1][1] = 0;
            cuadradoTemporal[2][1][2] = cuadradoTemporal[2][2][2];
            cuadradoTemporal[2][2][2] = 0;
            b = 3;
        } else if (fila == 2 && columna == 0) {
            cuadradoTemporal[0][2][0] = cuadradoTemporal[0][1][0];
            cuadradoTemporal[0][1][0] = 0;
            cuadradoTemporal[1][2][0] = cuadradoTemporal[1][2][1];
            cuadradoTemporal[1][2][1] = 0;
            b = 2;
        } else if (fila == 2 && columna == 1) {
            cuadradoTemporal[0][2][1] = cuadradoTemporal[0][2][0];
            cuadradoTemporal[0][2][0] = 0;
            cuadradoTemporal[1][2][1] = cuadradoTemporal[1][1][1];
            cuadradoTemporal[1][1][1] = 0;
            cuadradoTemporal[2][2][1] = cuadradoTemporal[2][2][2];
            cuadradoTemporal[2][2][2] = 0;
            b = 3;
        } else if (fila == 2 && columna == 2) {
            cuadradoTemporal[0][2][2] = cuadradoTemporal[0][2][1];
            cuadradoTemporal[0][2][1] = 0;
            cuadradoTemporal[1][2][2] = cuadradoTemporal[1][1][2];
            cuadradoTemporal[1][1][2] = 0;
            b = 2;
        }
        return b;
    }

    /*
     * Retorna el valor de la posición del método distanciaManhattan
     */
    int heuristica(int[][] cuadrado) {
        return distanciaManhattan(cuadrado);
    }

    /*
     * Método que mueve las piezas asignando las posiciones
     */
    boolean mover() {
        int b, contador, i, j, k, minimo;
        int[] f = new int[4], indice = new int[4];
        int[][][] cuadradoTemporal = new int[4][3][3];

        if (pizarra[0][0] == 1 && pizarra[0][1] == 2 && pizarra[0][2] == 3 && pizarra[1][0] == 4 && pizarra[1][1] == 5
                && pizarra[1][2] == 6 && pizarra[2][0] == 7 && pizarra[2][1] == 8 && pizarra[2][2] == 0)
            return true;
        b = expandir(pizarra, cuadradoTemporal);
        for (i = 0; i < b; i++) {
            f[i] = g + heuristica(cuadradoTemporal[i]);
            for (j = 0; j < 3; j++)
                for (k = 0; k < 3; k++)
                    pizarra[j][k] = cuadradoTemporal[i][j][k];
        }
        minimo = f[0];
        for (i = 1; i < b; i++)
            if (f[i] < minimo)
                minimo = f[i];
        for (contador = i = 0; i < b; i++)
            if (f[i] == minimo)
                indice[contador++] = i;
        i = indice[random.nextInt(contador)];
        g++;
        nodosExpandidos += b;
        for (j = 0; j < 3; j++)
            for (k = 0; k < 3; k++)
                pizarra[j][k] = cuadradoTemporal[i][j][k];
        return false;
    }

    int fueraDeLugar(int[][] cuadrado) {
        int i, j, oop = 0;
        int[][] resultadoFinal = new int[3][3];

        resultadoFinal[0][0] = 1;
        resultadoFinal[0][1] = 2;
        resultadoFinal[0][2] = 3;
        resultadoFinal[1][0] = 4;
        resultadoFinal[1][1] = 5;
        resultadoFinal[1][2] = 6;
        resultadoFinal[2][0] = 7;
        resultadoFinal[2][1] = 8;
        resultadoFinal[2][2] = 0;
        for (i = 0; i < 3; i++)
            for (j = 0; j < 3; j++)
                if (cuadrado[i][j] != resultadoFinal[i][j])
                    oop++;
        System.out.println("" + oop);
        return oop;
    }

    /*
     * Método que verifica la posición y valor
     */
    int distanciaManhattan(int[][] cuadrado) {
        int distanciaManhattan = 0;

        if (cuadrado[0][0] == 1)
            distanciaManhattan += 0;
        else if (cuadrado[0][0] == 2)
            distanciaManhattan += 1;
        else if (cuadrado[0][0] == 3)
            distanciaManhattan += 2;
        else if (cuadrado[0][0] == 4)
            distanciaManhattan += 3;
        else if (cuadrado[0][0] == 5)
            distanciaManhattan += 4;
        else if (cuadrado[0][0] == 6)
            distanciaManhattan += 3;
        else if (cuadrado[0][0] == 7)
            distanciaManhattan += 2;
        else if (cuadrado[0][0] == 8)
            distanciaManhattan += 1;
        if (cuadrado[0][1] == 1)
            distanciaManhattan += 1;
        else if (cuadrado[0][1] == 2)
            distanciaManhattan += 0;
        else if (cuadrado[0][1] == 3)
            distanciaManhattan += 1;
        else if (cuadrado[0][1] == 4)
            distanciaManhattan += 2;
        else if (cuadrado[0][1] == 5)
            distanciaManhattan += 3;
        else if (cuadrado[0][1] == 6)
            distanciaManhattan += 2;
        else if (cuadrado[0][1] == 7)
            distanciaManhattan += 3;
        else if (cuadrado[0][1] == 8)
            distanciaManhattan += 2;
        if (cuadrado[0][2] == 1)
            distanciaManhattan += 2;
        else if (cuadrado[0][2] == 2)
            distanciaManhattan += 1;
        else if (cuadrado[0][2] == 3)
            distanciaManhattan += 0;
        else if (cuadrado[0][2] == 4)
            distanciaManhattan += 1;
        else if (cuadrado[0][2] == 5)
            distanciaManhattan += 2;
        else if (cuadrado[0][2] == 6)
            distanciaManhattan += 3;
        else if (cuadrado[0][2] == 7)
            distanciaManhattan += 4;
        else if (cuadrado[0][2] == 8)
            distanciaManhattan += 3;
        if (cuadrado[1][0] == 1)
            distanciaManhattan += 1;
        else if (cuadrado[1][0] == 2)
            distanciaManhattan += 2;
        else if (cuadrado[1][0] == 3)
            distanciaManhattan += 3;
        else if (cuadrado[1][0] == 4)
            distanciaManhattan += 2;
        else if (cuadrado[1][0] == 5)
            distanciaManhattan += 3;
        else if (cuadrado[1][0] == 6)
            distanciaManhattan += 2;
        else if (cuadrado[1][0] == 7)
            distanciaManhattan += 1;
        else if (cuadrado[1][0] == 8)
            distanciaManhattan += 0;
        if (cuadrado[1][1] == 1)
            distanciaManhattan += 2;
        else if (cuadrado[1][1] == 2)
            distanciaManhattan += 1;
        else if (cuadrado[1][1] == 3)
            distanciaManhattan += 2;
        else if (cuadrado[1][1] == 4)
            distanciaManhattan += 1;
        else if (cuadrado[1][1] == 5)
            distanciaManhattan += 2;
        else if (cuadrado[1][1] == 6)
            distanciaManhattan += 1;
        else if (cuadrado[1][1] == 7)
            distanciaManhattan += 2;
        else if (cuadrado[1][1] == 8)
            distanciaManhattan += 1;
        if (cuadrado[1][2] == 1)
            distanciaManhattan += 3;
        else if (cuadrado[1][2] == 2)
            distanciaManhattan += 2;
        else if (cuadrado[1][2] == 3)
            distanciaManhattan += 1;
        else if (cuadrado[1][2] == 4)
            distanciaManhattan += 0;
        else if (cuadrado[1][2] == 5)
            distanciaManhattan += 1;
        else if (cuadrado[1][2] == 6)
            distanciaManhattan += 2;
        else if (cuadrado[1][2] == 7)
            distanciaManhattan += 3;
        else if (cuadrado[1][2] == 8)
            distanciaManhattan += 2;
        if (cuadrado[2][0] == 1)
            distanciaManhattan += 2;
        else if (cuadrado[2][0] == 2)
            distanciaManhattan += 3;
        else if (cuadrado[2][0] == 3)
            distanciaManhattan += 4;
        else if (cuadrado[2][0] == 4)
            distanciaManhattan += 3;
        else if (cuadrado[2][0] == 5)
            distanciaManhattan += 2;
        else if (cuadrado[2][0] == 6)
            distanciaManhattan += 1;
        else if (cuadrado[2][0] == 7)
            distanciaManhattan += 0;
        else if (cuadrado[2][0] == 8)
            distanciaManhattan += 1;
        if (cuadrado[2][1] == 1)
            distanciaManhattan += 3;
        else if (cuadrado[2][1] == 2)
            distanciaManhattan += 2;
        else if (cuadrado[2][1] == 3)
            distanciaManhattan += 3;
        else if (cuadrado[2][1] == 4)
            distanciaManhattan += 2;
        else if (cuadrado[2][1] == 5)
            distanciaManhattan += 1;
        else if (cuadrado[2][1] == 6)
            distanciaManhattan += 0;
        else if (cuadrado[2][1] == 7)
            distanciaManhattan += 1;
        else if (cuadrado[2][1] == 8)
            distanciaManhattan += 2;
        if (cuadrado[2][2] == 1)
            distanciaManhattan += 4;
        else if (cuadrado[2][2] == 2)
            distanciaManhattan += 3;
        else if (cuadrado[2][2] == 3)
            distanciaManhattan += 2;
        else if (cuadrado[2][2] == 4)
            distanciaManhattan += 1;
        else if (cuadrado[2][2] == 5)
            distanciaManhattan += 0;
        else if (cuadrado[2][2] == 6)
            distanciaManhattan += 1;
        else if (cuadrado[2][2] == 7)
            distanciaManhattan += 2;
        else if (cuadrado[2][2] == 8)
            distanciaManhattan += 3;
        return distanciaManhattan;
    }

    /*
     * Método para aplicar la solución
     */
    public int solucionar(char[][] solucion) {
        boolean encontrado;
        int i, j, k, m = 0;

        do {
            for (i = k = 0; i < 3; i++)
                for (j = 0; j < 3; j++)
                    solucion[m][k++] = (char) (pizarra[i][j] + '0');
            encontrado = mover();
            m++;
        } while (!encontrado && m < MOVIMIENTOS_MAXIMOS);
        for (i = k = 0; i < 3; i++)
            for (j = 0; j < 3; j++)
                solucion[m][k++] = (char) (pizarra[i][j] + '0');
        return m;
    }

    public static void main(String[] args) throws Exception {

        char[][] initial = {{1,2,3},{4,5,6},{7,8,0}};
        codigo codigo = new codigo();
        codigo.solucionar(initial);

    }
}
