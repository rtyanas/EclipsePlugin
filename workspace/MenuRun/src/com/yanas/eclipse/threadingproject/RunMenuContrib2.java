package com.yanas.eclipse.threadingproject;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.internal.runtime.Log;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class RunMenuContrib2 implements org.eclipse.core.commands.IHandler {
	
	public RunMenuContrib2() {
		System.out.println("RunMenuContrib debug constructor");
	}

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		System.out.println("RunMenuContrib debug execute");
//        MessageDialog.openInformation(
//	    	      (ThreadingView)event.getApplicationContext(),"Readme Editor","View Action executed");
		int fibStart = 40;

		ThreadingView.myThreadingView.label2.setText( "Start: "+ fibStart +" Fibonacci set prior: " + 
				ThreadingView.myThreadingView.getFibonacci(fibStart) );
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub
		
	}

}
