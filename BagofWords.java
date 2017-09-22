import java.util.*;
import java.io.*;


public class BagofWords {
	public float BoW(File text1,File text2 ) throws IOException
	{
	BufferedReader tex1 = new BufferedReader(new FileReader(text1));
	BufferedReader tex2 = new BufferedReader(new FileReader(text2));
	// reading the lines form the files to program 
	String s=tex1.readLine();
	String m=tex2.readLine();
	// calling check funtion to check the sentences and replace all the sentences with valid input
	s=check(s);	
	m=check(m);
	System.out.println(s);
    System.out.println(m);
	int i;
	String[] arr1 = s.split(" ");
	//hashmaps to create dictionary of words , removes the duplicates and give no of times a valusis repleted .
	Map<String,Integer> a = new HashMap<String,Integer>();
	for ( i=0;i < arr1.length;i++)
	{
	  a.computeIfPresent(arr1[i],(k,v)->v+1);
	  a.computeIfAbsent(arr1[i],k->1);	
	}	
	// System.out.println(a);	
	
	String[] arr2 = m.split(" ");
	Map<String,Integer> b = new HashMap<String,Integer>();
	for ( i=0;i < arr2.length;i++)
	{
	  
	b.computeIfPresent(arr2[i],(k,v)->v+1);
	  b.computeIfAbsent(arr2[i],k->1);	
	}	
//	 System.out.println(b);	
	 //Dotproduct of text1 and text1
	 int dotprod=0;
	  Set<String>s1= a.keySet();
	  Set<String>s2=b.keySet();
	 for(String ss:s1)
	 {
		 for (String ss1:s2)
		 {
			 if (ss.equals(ss1))
			 {
				 dotprod=dotprod+(a.get(ss)*b.get(ss1));
			 }			
		}
	 }
//	System.out.println(dotprod);
	 //Square roots of values of a and b;
	 int sum=0,sum1=0;
	 Collection<Integer> n= a.values();
	 Collection<Integer> z= b.values();
	 for(Integer in : n)
	 {
		 sum=sum+(in*in);
	 }
	// System.out.println(sum);
	 for (Integer in : z)
	 {
		 sum1= sum1+(in*in);		 
	 } 
	// System.out.println(sum1);
	 double res,res1;
	 res= Math.sqrt(sum);
	 res1=Math.sqrt(sum1);
	 float per;     // per is percent of matching between 2 files using Bag of Words 
	 per = (float) ((dotprod*100)/(res*res1));
	// System.out.println(per);
	 return per;
	
	}
	//function converting upper case charaters and special characters into lower case
	
	public String check(String a)
	{
		int b;
		int i;
		b=a.length();
		String c=a.toLowerCase();
		for (i=0;i<b;i++)
		{
			char e = c.charAt(i);
			int d=(int)a.charAt(i);
			if(d < 97 || d>122 ||d !=32 )
			{
			 break;	
			}
			else
			{
				c=c+e;
			}
		}		
		return c;		
	}
}