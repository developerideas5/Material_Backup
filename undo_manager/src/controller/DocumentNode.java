package controller;

public class DocumentNode {
	
	static int noOfLinkedList=0;
	String str;
	int pos;
	DocumentNode previousCursor;
	DocumentNode currenCursor;
	DocumentNode nextCursor;
	
	
	public DocumentNode(int pos,String str) {
			this.pos=pos;
			this.str=str;
			noOfLinkedList++;
		}


	public DocumentNode(int pos2) {
		this.pos=pos2;
	}


	

}
