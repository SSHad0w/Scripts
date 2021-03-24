import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
public class RotationalCypher{
	
	public static void main (String[] args){
        if (args.length < 2){
            System.err.println("Usage: \"java RotationalCypher <filename.txt> <desired rotations>\" \n\nExample: java RotationalCypher testtext.txt 13");
            return;
        }

    try {
      File myObj = new File(args[0]);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(cipher(data, Integer.parseInt(args[1])));
      }
      myReader.close();
    } 
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }


	/*
	DFIWNOAMYWPFFHUWJIBTL
	QOZOWVUZKUMUMBRWZUEZW
	ZCYSGYUKLSSNHHUZNZBES
	ZHYLKTUZUMWKGVHKXBAQN
	LWMDCBKITICKRXAXRNTIT
	PLZETQGJLIIITWMRTRTSN
	EFDMSSNDNFENVEEIHSUGG
	REEDEUZOEWLEOITSREAEE
	AIMSNRESGDNRUEWTDVENE
	RTRTSNEFDMSSNDNFEWVEE
	IHZUGGREEDEUZOIWLEOIT
	SREAEEAIMSNAESGDNRUEW
	TDVENEUSEROIDSSNENUAI

	*/
	public static String cipher(String msg, int shift){
    msg = msg.toLowerCase();
    String s = "";
    int len = msg.length();
    for(int x = 0; x < len; x++){
        // Need to add logic for non A - Z characters to stay the same
        char c = (char)(msg.charAt(x) + shift);
        if (c > 'z')
            s += (char)(msg.charAt(x) - (26-shift));
        else
            s += (char)(msg.charAt(x) );//+ shift);
    }
    return s;
	}

}