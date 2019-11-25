package jpd.hallt.model;

public class Location {

   private int row;
   private int col;

   public Location(int row, int col)
   {
       this.row = row;
       this.col = col;
   }
   
   public boolean equals(Object obj)
   {
       return false;
   }
    
   
   public String toString()
   {
       return row + "," + col;
   }


   public int getRow()
   {
       return row;
   }
    
   public int getCol()
   {
       return col;
   }
 }

	


