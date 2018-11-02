/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cancer;

/**
 *
 * @author himel9675
 */
public class Cancer {
public static String grid[][];
public static int blobSize;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int row, col;
        //create 2D array sixe 15 x 15
        grid = new String [15][15];
        
        //fill array with blanks
        for (row = 0; row < 15; row++) {
            for (col = 0; col < 15; col++){
                grid [row][col] = "+";
            }
        }
        
      //fill random elements in the array with + and -
      for (int i = 0; i < 80; i++) {
      row = (int) (Math.random() * 14 + 1);
      col = (int) (Math.random() * 14 + 1);
      grid[row][col] = "-";
    }
      
    //display grid
    displayGrid();   
        
    //variable to determine the size of the blob
    blobSize = 0; 
    
    //earse cancer cells 
    int blobRow = (int) (Math.random() * 10 + 1);
    int blobCol = (int) (Math.random() * 10 + 1);


    
    System.out.println("The blob at " + blobRow + "," + blobCol
      + " will be removed.");
    floodFill(blobRow, blobCol);
    System.out.println("The blob had " + blobSize +
      " items in it");
    System.out.println("The new grid is:");
    //Print out the new grid
    displayGrid();
 
        
    }
    //row = i and col = j
    public static void floodFill (int row, int col) {
        if (grid[row][col].equals("-")) {
         grid[row][col] = " "; //assumes blank
         blobSize++;
         
      floodFill(row - 1, col - 1);
      floodFill(row - 1, col);
      floodFill(row - 1, col + 1);
      floodFill(row, col - 1);
      floodFill(row, col + 1);
      floodFill(row + 1, col - 1);
      floodFill(row + 1, col);
      floodFill(row + 1, col + 1);
   
           
    }
}
    
    public static void displayGrid(){
    String output = "";
  
    for (int row = 0; row <= 14; row++){ 
     for (int col = 0; col <= 14; col++) {
        output += grid[row][col];
      }
          output += "\n";
   }
    System.out.println(output);
   }
}
