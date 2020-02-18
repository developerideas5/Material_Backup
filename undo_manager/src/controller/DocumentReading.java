package controller;

import undo.Document;

public class DocumentReading implements Document {
	
	
	DocumentNode root,current,temp;
		
	@Override
	public void delete(int pos, String s) {
		current=root;
		int deleteNode= 1;
		
		if(pos==1){
			root=current.nextCursor;
			current.nextCursor=null;
			current.previousCursor=null;
		}else{
			while(deleteNode!=pos){
				current=current.nextCursor;
				deleteNode++;
			}
		}
		
		if(current.nextCursor==null){
			current.previousCursor.nextCursor=null;
			current.previousCursor=null;
		}else{
			current.previousCursor.nextCursor=current.nextCursor;
			current.nextCursor.previousCursor=current.previousCursor;
		}
		
		
		
	}

	@Override
	public void insert(int pos, String s) {
		
		DocumentNode doc=new DocumentNode(pos, s);
		current=root;
		String insertNode= null;
		while(insertNode!= s){
			current=current.nextCursor;
			pos++;
		}
		temp=current.nextCursor;
		current.nextCursor=temp;
		temp.previousCursor=doc;
		doc.previousCursor=current;
		
		
	}

	@Override
	public void setDot(int pos) {
		
		DocumentNode doc=new DocumentNode(pos);
		if(root==null){
			
			root=doc;
			root.previousCursor=null;
			root.nextCursor=null;
			
		}else{
			current=root;
			while(current.nextCursor!=null){
				current=current.nextCursor;
			}
			current.nextCursor=doc;
			doc.previousCursor=current;
			doc.nextCursor=null;
		}
	}

}
