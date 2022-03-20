package assignment_3;

import java.io.*;

public class Q1 {
	
	private static FileInputStream fr;
	private static FileReader fr2;
	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		// byte
		try {
			fr = new 
					 FileInputStream("C:\\Users\\Harpreet\\Desktop\\bar.mp4");
			FileOutputStream fw = 
					new FileOutputStream("bar2.mp4");
			
			int i = 0;
			while ((i = fr.read()) != -1) {
				fw.write(i);
			}
			fw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("time taken : " + (end - start) + " ms");
		
		//char
		try {
			fr2 = new FileReader("C:\\Users\\Harpreet\\Desktop\\bar.mp4");
			FileWriter fw=new FileWriter("C:\\Users\\Harpreet\\Desktop\\bar.mp4");
			int i=0;
			while((i=fr2.read())!=-1) {
				fw.write(i);
			}
			fw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
//		
		System.out.println("file is written");
	}

}
