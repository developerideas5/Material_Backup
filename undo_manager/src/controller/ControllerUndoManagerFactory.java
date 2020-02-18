package controller;

import undo.Document;
import undo.UndoManager;
import undo.UndoManagerFactory;

public class ControllerUndoManagerFactory implements UndoManagerFactory{

	@Override
	public UndoManager createUndoManager(Document doc, int bufferSize) {
		
		return null;
	}

}
