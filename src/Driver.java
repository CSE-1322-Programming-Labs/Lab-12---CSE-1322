import java.util.Scanner;
import java.io.*;

public class Driver {
    public static void main(String[] args){
        File file1 = null;
        File file2 = null;
        Scanner sc = null;
        try{
            sc = new Scanner(System.in);
            System.out.println("Please enter the file name for file 1: ");
            String file1Path = sc.nextLine();

            if(!file1Path.endsWith(".txt")) throw new Exception("File 1 is not a txt file!");

            sc = new Scanner(System.in);
            System.out.println("Please enter the file name for file 2: ");
            String file2Path = sc.nextLine();

            if(!file2Path.endsWith(".txt")) throw new Exception("File2 is not a txt file!");

            //Normally we would sanitize these inputs, but this lab asks for them directly.

            file1 = new File("F:\\Java\\Labs Java\\Lab 12\\textFiles\\"+file1Path);
            file2 = new File("F:\\Java\\Labs Java\\Lab 12\\textFiles\\"+file2Path);

            sc = new Scanner(file1);
            Scanner myScan = new Scanner(file2);

            int lineNum = 0;
            while(sc.hasNextLine() && myScan.hasNextLine()) {
                lineNum++;
                String file1String = sc.nextLine();
                String file2String = myScan.nextLine();
                if (!file1String.equals(file2String)) {
                    System.out.println("Line " + lineNum);
                    System.out.println("< " + file1String);
                    System.out.println("> " + file2String);
                }
            }
            if (sc.hasNextLine() || myScan.hasNextLine()) {
                System.out.println("Files have different numbers of lines");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Something went wrong: "+e.getMessage());
        }
        finally{
            if(sc!= null) sc.close();
        }

    }
}
