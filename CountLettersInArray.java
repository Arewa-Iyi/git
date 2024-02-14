/******************************************************************************
This code references a class not disclosed in text book.
This code if for furture refrence and will not run

*******************************************************************************/
class RandomCharacter {
  /** Generate a random character between ch1 and ch2 */
  public static char getRandomCharacter(char ch1, char ch2) {
    return (char)(ch1 + Math.random() * (ch2 - ch1 + 1));
  }

  /** Generate a random lowercase letter */
  public static char getRandomLowerCaseLetter() {
    return getRandomCharacter('a', 'z');
  }

  /** Generate a random uppercase letter */
  public static char getRandomUpperCaseLetter() {
    return getRandomCharacter('A', 'Z');
  }

  /** Generate a random digit character */
  public static char getRandomDigitCharacter() {
    return getRandomCharacter('0', '9');
  }

  /** Generate a random character */
  public static char getRandomCharacter() {
    return getRandomCharacter('\u0000', '\uFFFF');
  }
}
public class CountLettersInArray{
    public static char[] createArray(){
        //Declare an array of characters and create it
        char[] chars = new char[100];
        
        //create lowercase letters randomly and assign
        // them to the array
        for(int i = 0; i < chars.length; i++)
          chars[i] = RandomCharacter.getRandomLowerCaseLetter();
          
        // Return the array
        return chars;
    }
    public static void displayArray(char[] chars){
      // display the characters in the array 20 on each line
      for(int i = 0; i < chars.length; i++){
        if((i + 1) % 20 == 0)
          System.out.println(chars[i]);
        else
          System.out.print(chars[i] + " ");
      }
    }
    public static int[] countLetters(char[] chars){
      //Declare and create an array of 26 int
      int[] counts = new int[26];
      
      // for each lowercase letter in the array, count it
      for(int i = 0; i < chars.length; i++)
        counts[chars[i] - 'a']++;
      
      return counts;
    }
    // displayCounts
    public static void displayCounts(int[] counts){
      for(int i = 0; i < counts.length; i++){
          if((i + 1) % 10 == 0)
            System.out.println(counts[i] + " " + (char)(i + 'a'));
          else
           System.out.print(counts[i] + " " + (char)(i + 'a') + " ");
           
      }
    }
	public static void main(String[] args) {
      // Declare and create an array
      char[] chars = createArray();
      
      // Display the array
      System.out.println("The lowercase letters are: ");
      displayArray(chars);
      
      // Count the occurences of each letters
      int[] counts = countLetters(chars);
      
      //Display counts
      System.out.println();
      System.out.println("The occurences of each letter are:");
      displayCounts(counts);
	}
}
