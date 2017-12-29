package com.TestngDemo001;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Object obj[][] = {{1,"a","d"},{2,"c"},{"f",3},{"e","5"}};
       for(int i = 0;i<obj.length;i++){
    	   System.out.println("info:"+obj[i]);
    	   for(int j = 0;j<obj[i].length;j++){
    		   System.out.println("data["+i+j+"]:"+obj[i][j]);
    	   }
       }
    }
}
