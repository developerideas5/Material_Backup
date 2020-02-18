package controller;

import undo.Change;
import undo.UndoManager;

public class Controller implements UndoManager{

	@Override
	public void registerChange(Change change) {
		
	}

	@Override
	public boolean canUndo() {
		
		return false;
	}

	@Override
	public void undo() {
		
	}

	@Override
	public boolean canRedo() {
		
		return false;
	}

	@Override
	public void redo() {
		
		
	}

}
