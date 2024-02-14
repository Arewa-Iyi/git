import java.awt.geom.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Polygon{
  private int npoints
  private ArrayList<Point2D> vertices = new ArrayList<Point2D>();
  private int [][][] edges = null;

  public Polygon(ArrayList<Point2D> newVertices){
    vertices = newVertices;
    edges = findEdges();
  }
  double findSecondElement(double[] d){
      double s1 = d[0];
      double s2 = d[0];
      double s3 = d[0];
      Arrays.sort(d);
      for(int i = 0; i < d.length; i++){
        if(d[i] < s1){ s1 = d[i];}
      }
       
       for(int i = 0; i < d.length; i++){
        if( d[i] < s2 && s2 > s1){ s2 = d[i];}
      }
      
    

        for(int i = 0; i < d.length; i++){
        if( d[i] < s3 && s3 > s2){ s3 = d[i];}
      }
     
     return s3;
  }
  boolean isZero(double d){
    if(Math.abs(0 - d) < .0000001d) return true;
    return false;
  }

  int[][][] findEdges(){
    int[][][] minLocation = new int[vertices.size()][2][2];
    double[][] min = new double[vertices.size()][2];
    double[][] distance = new double[vertices.size()][vertices.size()];

    for(int i = 0; i < vertices.size(); i++){
       for(int j = 0; j < vertices.size(); j++){
         if(i == j) distance[i][j] = 0;
         else{
            distance[i][j] = vertices.get(i).distance(vertices.get(j));
         } 
       }
    }
    
    for(int i = 0; i < distance.length; i++)
       System.out.println(java.util.Arrays.toString(distance[i]));
    System.out.println();

    for(int i = 0; i < distance.length; i++){
      int count = 0;
      int k = 0;
      int l = 0;
      double secondSmallestElement = findSecondElement(distance[i]);
      while(count < distance[i].length){
        if (!isZero(distance[i][count]) && k < 1){ 
           min[i][0] = distance[i][count];
           minLocation[i][0][0] = i;
           minLocation[i][0][1] = count;
           k++;
           l = count + 1;

           
          //System.out.println(min[i][0]);
        }
           count++;          
                
      }
       //System.out.println(count);
       count = l;
       while(count < distance[i].length){
        if(!isZero(distance[i][count])){
           min[i][1] = distance[i][count];
           minLocation[i][1][0] = i;
           minLocation[i][1][1] = count;
           
           //System.out.println(min[i][1]);
           break;
        }
        count++;
      }
      for(int j = 0; j < distance[i].length; j++){
        if(isZero(distance[i][j])) continue;
        else{
          if(distance[i][j] < min[i][0]){
             min[i][0] = distance[i][j];
             minLocation[i][0][0] = i;
             minLocation[i][0][1] = j;
          }
        }
      }
      for(int j = 0; j < distance[i].length; j++){
          //System.out.println("minLocation[i][0][0]: " + minLocation[i][0][0]);
          if(!isZero(distance[i][j]) && 
             minLocation[i][0][1] != j && //distance[i][j] < min[i][1] &&
            (distance[i][j] > min[i][0] || (Math.abs(distance[i][j] - min[i][0]) < .0000001d))&&
            (Math.abs(distance[i][j] - secondSmallestElement) < .0000001d)){
             //System.out.println("i'm here");
             min[i][1] = distance[i][j];
             //System.out.println(min[i][1]);
             minLocation[i][1][0] = i;
             minLocation[i][1][1] = j;
          }
        
      }
      //System.out.println("=================");
    }

    for(int i = 0; i < min.length; i++)
       System.out.println(java.util.Arrays.toString(min[i]));
    System.out.println();

    return minLocation;
  }
   
   String getPolygonType(){
   int size = vertices.size();
   if(size < 3) System.out.print("This is not a polygon");
   else{
     switch(size){
       case 3:
         return "Triangle";
       case 4:
          return "Quadilateral";
       case 5:
          return "Pentagon";
       case 6:
          return "Hexagon";
       case 7:
          return "Heptagon";
       case 8:
          return "Octagon";
       case 9:
          return "Nonagon";
       case 10:
          return "Decagon";
       case 11:
          return "Hendecagon";
       case 12:
          return "Dodecagon";
       case 13:
          return "Triskaidecagon";
       case 14:
          return "Tetrakaidecagon";
       case 15:
          return "Pentagecagon";
       case 16:
          return "Hexakaidecagon";
       case 17:
          return "Heptadecagon";
       case 18:
          return "Octakaidecagon";
       case 19:
          return "Enneadecagon";
       case 20:
          return "Icosagon";
       default: 
          return "n-gon";
     }
   }
   return "Invalid Input";
  }  
  
public static void main(String[] args){
   
    ArrayList<Point2D> vertices = new ArrayList<Point2D>();
        vertices.add(new Point2D.Double(8,5));
        vertices.add(new Point2D.Double(0,5));
        vertices.add(new Point2D.Double(6,0));
        vertices.add(new Point2D.Double(0,0));
    for(int i = 0; i < vertices.size(); i++){
      System.out.println(vertices.get(i));
    }

    Polygon p1 = new Polygon(vertices);
    System.out.println(p1.getPolygonType());
  }
}