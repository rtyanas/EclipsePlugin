package com.yanas.eclipse.threadingproject;

import java.util.Random;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.internal.runtime.Log;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class RunMenuContribRandom implements org.eclipse.core.commands.IHandler {
	
	public RunMenuContribRandom() {
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
		Random r = new Random(System.currentTimeMillis());
		int fibEnd1 = nextInt(r);
		int fibEnd2, fibEnd3;
		fibEnd2 = nextInt(r);
		fibEnd3 = nextInt(r);

		ThreadingView.myThreadingView.label.setText( "Random start: "+ fibEnd1 +" Fibonacci set prior: " + 
				ThreadingView.myThreadingView.getFibonacci(fibEnd1) ) ;
		ThreadingView.myThreadingView.label2.setText("Random start: "+ fibEnd2 +" Fibonacci set prior: " + 
				ThreadingView.myThreadingView.getFibonacci(fibEnd2) ) ;
		ThreadingView.myThreadingView.label3.setText("Random start: "+ fibEnd3 +" Fibonacci set prior: " + 
				ThreadingView.myThreadingView.getFibonacci(fibEnd3) ) ;

//		ThreadingRun tr = new ThreadingRun("Thread Test 1", ThreadingView.myThreadingView, 1,  fibEnd1);
//		
//		tr.start();
//		try {
//			tr.join();
//		} catch(Exception e) {
//			System.out.println("Thread error.");
//		}
		
		return null;
	}
	
	private int nextInt(Random r) {
		int iReturn = -1;
		while((iReturn  < 0) || (iReturn > 900) ) {
			iReturn = r.nextInt();
		}
		return iReturn;
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

	class ThreadingRun extends Thread {
		private Thread t;
		public ThreadingView threadingView;
		String fibName;
		int fibEnd;
		int labelNum;
		
		ThreadingRun(String fn, ThreadingView tv, int ln,  int fe) {
			fibName = fn;
			threadingView = tv;
			labelNum = ln;
			fibEnd = fe;
		}
		
		public void run() {
			synchronized (threadingView) {
				System.out.println("End: "+ fibEnd +" Fib: " + threadingView.getFibonacci(fibEnd) );

				Label labelx = threadingView.label; 
				switch(labelNum) {
				case 1:
//					threadingView.getLabel().setText( "Random start: "+ fibEnd +" First Fibonacci prior: "+ fibEnd +
//					" is: "+ Integer.toString(threadingView.getFibonacci(fibEnd) ) );

					threadingView.setLabelData();

					labelx = threadingView.label;
					break;
				case 2: labelx = threadingView.label2;
					break;
				case 3: labelx = threadingView.label3;
					break;
				}
//				labelx.setText( "Random start: "+ fibEnd +" First Fibonacci prior: "+ fibEnd +
//						" is: "+ Integer.toString(threadingView.getFibonacci(fibEnd) ) );

			}
		}
		
		public void start() {
			System.out.println("Thread: "+ fibName);
			if(t == null) {
				t = new Thread(this, fibName);
				t.start();
			}
		}
		
		
	}
}
