package Testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import controller.DocumentNode;


public class Test_Reading {
	
	 FileReader in = null;
	 BufferedReader br=null;
	   
	@Test
	public void test() throws IOException {
		try {
			  in=new FileReader("Document.txt");
			  
			  int data;
			  String str;
			  while((data=in.read())!=-1 && (str=br.readLine())!=null){
				  System.out.println(str);
					 DocumentNode doc_read= new DocumentNode(data,str);
					 
			  }
			      
		     
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			 in.close();
		}
	}
}
