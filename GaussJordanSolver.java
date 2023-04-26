/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gauss;

import java.util.Scanner;

/**
 *
 * @author luis_
 */
public class GaussJordanSolver {

    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        System.out.println("****Metodo Gauss Jordan****");
        System.out.println("Ingrese los valores de la matriz:");
        double[][] matrix = {{2, 1, -1, 8}, {-3, -1, 2, -11}, {-2, 1, 2, -3}};
        double[][] originalMatrix ={{2, 1, -1, 8}, {-3, -1, 2, -11}, {-2, 1, 2, -3}};
        int rows = matrix.length;
        int cols = matrix[0].length;

        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.println("["+(i+1)+"]["+(j+1)+"]= ");
                originalMatrix[i][j]=entrada.nextInt();
                matrix[i][j]=originalMatrix[i][j];
            }
        }
        // Applying Gauss-Jordan elimination
        for (int i = 0; i < rows; i++) {
            if (matrix[i][i] == 0) {
                // 
                int swapIndex = i + 1;
                while (swapIndex < rows && matrix[swapIndex][i] == 0) {
                    swapIndex++;
                }
                if (swapIndex == rows) {
                    System.out.println("No existe una sola solucion.");
                    return;
                }
                double[] temp = matrix[i];
                matrix[i] = matrix[swapIndex];
                matrix[swapIndex] = temp;
            }
            for (int j = 0; j < rows; j++) {
                if (i != j) {
                    double factor = matrix[j][i] / matrix[i][i];
                    for (int k = 0; k < cols; k++) {
                        matrix[j][k] -= factor * matrix[i][k];
                        
                    }
                    //System.out.println(matrix[j][0]+","+matrix[j][1]+","+matrix[j][2]+","+matrix[j][3]);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            matrix[i][3] = matrix[i][3] / matrix[i][i];
            matrix[i][i] = matrix[i][i] / matrix[i][i];
        }
        System.out.println("");
        System.out.println("Primer matriz:");
        for (int i = 0; i < rows; i++) {
                System.out.println("[ "+originalMatrix[i][0]+" , "+originalMatrix[i][1]+" , "+originalMatrix[i][2]+" , "+originalMatrix[i][3]+" ]");
        }
        System.out.println("");
        System.out.println("Ultima matriz:");
        for (int i = 0; i < rows; i++) {
                System.out.println("[ "+matrix[i][0]+" , "+matrix[i][1]+" , "+matrix[i][2]+" , "+matrix[i][3]+" ]");
        }
        System.out.println("");
        System.out.println("Valores:");
        System.out.println("x= "+matrix[0][3]);
        System.out.println("y= "+matrix[1][3]);
        System.out.println("z= "+matrix[2][3]);
        System.out.println("Comprobacion: ");
        double primerEcuacionResul=(originalMatrix[0][0]*matrix[0][3])+(originalMatrix[0][1]*matrix[1][3])+(originalMatrix[0][2]*matrix[2][3]);
        double segundaEcuacionResul=(originalMatrix[1][0]*matrix[0][3])+(originalMatrix[1][1]*matrix[1][3])+(originalMatrix[1][2]*matrix[2][3]);
        double tercerEcuacionResul=(originalMatrix[2][0]*matrix[0][3])+(originalMatrix[2][1]*matrix[1][3])+(originalMatrix[2][2]*matrix[2][3]);
        System.out.println(originalMatrix[0][0]+"("+matrix[0][3]+")"+"+"+originalMatrix[0][1]+"("+matrix[1][3]+")"+"+"+originalMatrix[0][2]+"("+matrix[2][3]+")"+"="+originalMatrix[0][3]);
        System.out.println(primerEcuacionResul+"="+originalMatrix[0][3]);
        System.out.println("");
        System.out.println(originalMatrix[1][0]+"("+matrix[0][3]+")"+"+"+originalMatrix[1][1]+"("+matrix[1][3]+")"+"+"+originalMatrix[1][2]+"("+matrix[2][3]+")"+"="+originalMatrix[1][3]);
        System.out.println(segundaEcuacionResul+"="+originalMatrix[1][3]);
        System.out.println("");
        System.out.println(originalMatrix[2][0]+"("+matrix[0][3]+")"+"+"+originalMatrix[2][1]+"("+matrix[1][3]+")"+"+"+originalMatrix[2][2]+"("+matrix[2][3]+")"+"="+originalMatrix[2][3]);
        System.out.println(tercerEcuacionResul+"="+originalMatrix[2][3]);
    }
}
