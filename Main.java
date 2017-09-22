import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException
	{
		Scanner input = new  Scanner (System.in);
		String s = input.nextLine();
			
	File folder = new File(s);
	File[] listOfFiles = folder.listFiles();            //copying files into a list 
	BagofWords obj = new BagofWords();                 // calling object from BagofWords program 
	Stringmatching obj1 = new Stringmatching();       // calling object from Stringmatching program
	Fingerprinting obj3 = new Fingerprinting();      // calling object from fingerprinting program
	int i=0,count = 0;
	int flag=0;
	float BoWper;
	float StrMtchper;
	float fingerpnrt;
	ArrayList<File> files = new ArrayList<File>(Arrays.asList(folder.listFiles()));
	
	for (File file : listOfFiles)
	{
	    if (file.getName().endsWith(".txt"))
	    {
	        count +=1;
	        flag =1;
	    }
	    if (flag ==1)
	    {
	    	files.add(i, file);
	    }
	}
	//objects for calling bag of words programs,stringmatching programs,fingerprinting program
	float[][] BoW = new float[count][count];                //storing results for bag of words of file
	float[][] Srtmat = new float[count][count];            //storing results for stringmatching of file
	float[][] fingerprnt = new float[count][count];       //storing results for fingerprinting of file
	System.out.println(count);	
	for(i=0;i<count;i++)
	{
		for (int j = 0; j < count; j++) 
		{
			System.out.println(files.get(i).getName()+":"+files.get(j).getName());
			BoWper=obj.BoW(files.get(i),files.get(j));
			BoW[i][j]=BoWper;
           System.out.println("Bag of Words of "+files.get(i).getName()+" and "+files.get(j).getName()+" is: "+Math.round(BoWper)+"%");
		    StrMtchper = obj1.Stringmatch(files.get(i),files.get(j));
		    Srtmat[i][j]=StrMtchper;
		    System.out.println("Stringmatching of "+files.get(i).getName()+" and "+files.get(j).getName()+" is: "+Math.round(StrMtchper)+"%");
		    fingerpnrt=obj3.fingerprint(files.get(i),files.get(j));
		    fingerprnt[i][j]=fingerpnrt;
		    System.out.println("Fingerprinting of "+files.get(i).getName()+" and "+files.get(j).getName()+" is: "+Math.round(fingerpnrt)+"%");
		    System.out.println("..............................");
		}
	}
	// display results in a bag of words 
	System.out.print("\t");
	for(i=0;i<count;i++)
	{
		System.out.print("\t"+files.get(i).getName());
	}
	System.out.println();
	for (i =0;i<count;i++)
	{
		System.out.print(files.get(i).getName()+" : "+"\t");
		for (int j =0;j<count;j++)
		{
			System.out.print(+Math.round(BoW[i][j])+"\t");
		}
		System.out.println();
	}
	System.out.println("....................................");
	// display results in a stringmatching program 
		System.out.print("\t");
		for(i=0;i<count;i++)
		{
			System.out.print("\t"+files.get(i).getName());
		}
		System.out.println();
	for (i =0;i<count;i++)
	{
		System.out.print(files.get(i).getName()+" : "+"\t");
		for (int j =0;j<count;j++)
		{
			System.out.print(Math.round(Srtmat[i][j])+"\t");
		}
		System.out.println();
	}
	System.out.println("....................................");
	// display results in a fingermatching program 
			System.out.print("\t\t");
			for(i=0;i<count;i++)
			{
				System.out.print("\t"+files.get(i).getName());
			}
			System.out.println();
	for (i =0;i<count;i++)
	{
		System.out.print(files.get(i).getName()+" : "+"\t");
		for (int j =0;j<count;j++)
		{
			System.out.print(Math.round(fingerprnt[i][j])+"\t");
		}
		System.out.println();
	}
	}
}

