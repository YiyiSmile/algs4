package miscellaneous.sparse_array;

/**
 * @Author Tom
 * @Date 2020/6/23 22:03
 * @Version 1.0
 * @Description
 */
public class SparseArray {
    public static void main(String[] args) {
        // create an original 2-dimensional array. 11*11
        //0: no chess piece 1: blue piece 2: black piece
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][5] = 2;
        //print original array.
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //1. traverse the original array, get the total number of element whose value isn't 0.
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArray[i][j] != 0)
                    sum++;
            }
        }
        //2. create the corresponding sparse array.
        int[][] sparseArray = new int[sum+1][3];

        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArray[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                }
            }
        }

        //print sparse array.
        System.out.println("********************SPARSE ARRAY IS: *****************");
        for (int i = 0; i <sparseArray.length ; i++) {
            System.out.printf("%d\t%d\t%d\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }

        //restore the original array based on the spare array.
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //print the restored array.
        System.out.println("**************5******Restored ARRAY IS: *****************");
        for (int[] row : chessArray2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
