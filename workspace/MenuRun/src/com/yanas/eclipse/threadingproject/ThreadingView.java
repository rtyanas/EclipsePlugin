package com.yanas.eclipse.threadingproject;


import java.util.Vector;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;


public class ThreadingView extends ViewPart {
   public Label label;
   public Label label2;
   public Label label3;
   static public ThreadingView myThreadingView;

   public ThreadingView() {
   }
   
   public void createPartControl(Composite parent) {
	   parent.setLayout(new GridLayout());
      label  = new Label(parent, SWT.WRAP);
      label2 = new Label(parent, SWT.WRAP);
      label3 = new Label(parent, SWT.WRAP);
      int endFib = 100, endFib2 = 500, endFib3 = 50;
      label .setText("Menu Run Sample 1, Fibonacci set prior: "+ 
    		  			endFib +" is: "+ getFibonacci(endFib) +"\n");
      label.setLocation(0, 0);
      label2.setText("Menu Run Sample 2, Fibonacci set prior: "+ 
	  			endFib2 +" is: "+ getFibonacci(endFib2) +"\n");
      label2.setLocation(0, 1);
      label3.setText("Menu Run Sample 3, Fibonacci set prior: "+ 
	  			endFib3 +" is: "+ getFibonacci(endFib3) +"\n");
      label3.setLocation(0, 2);
//      MessageDialog.openInformation(
//    	      parent.getShell(),"Readme Editor","View Action executed"+ Integer.toString(getFibonacci(endFib)));
      
      myThreadingView = this;
   }
   public void setFocus() {
      // set focus to my widget.  For a label, this doesn't
      // make much sense, but for more complex sets of widgets
      // you would decide which one gets the focus.
   }
   
   public Vector<String> getFibonacci(int endValueIn) {
	   Vector<String> retFib = new Vector<String>();
	   int endValue = 1;
	   
	   int prevFibonacci = 0;
	   int newPrevFibonacci = 0;

	   if(endValueIn > 0) {
		   while(endValue < endValueIn) {
			   newPrevFibonacci = endValue;
			   endValue = endValue + prevFibonacci;
			   prevFibonacci = newPrevFibonacci;
			   retFib.add(Integer.toString(newPrevFibonacci));
		   }
	   }
	   else {
		   prevFibonacci = 0;
	   }
	   
	   return retFib;
   }

	public Label getLabel() {
		return label;
	}
	
	public void setLabelData() {
		this.label.setText("Test This");;
	}
	
	public void setLabel(Label label) {
		this.label = label;
	}
	
	public Label getLabel2() {
		return label2;
	}
	
	public void setLabel2(Label label2) {
		this.label2 = label2;
	}
	
	public Label getLabel3() {
		return label3;
	}
	
	public void setLabel3(Label label3) {
		this.label3 = label3;
	}
	
	public static ThreadingView getMyThreadingView() {
		return myThreadingView;
	}
	
	public static void setMyThreadingView(ThreadingView myThreadingView) {
		ThreadingView.myThreadingView = myThreadingView;
	}
	
	   
	   

//	private void gui() {
////		Display display = new Display ();
////		Shell shell = new Shell (display);
//		FillLayout fillLayout = new FillLayout ();
//		fillLayout.type = SWT.VERTICAL;
//		shell.setLayout (fillLayout);
//	
//		Text text0 = new Text (shell, SWT.BORDER);
//		text0.setText ("text0");
//	
//		Text text1 = new Text (shell, SWT.BORDER);
//		text1.setText ("text1");
//	
//		Text text2 = new Text (shell, SWT.BORDER);
//		text2.setText ("text2");
//	
//		Combo combo3 = new Combo (shell, SWT.NONE);
//		combo3.setItems (new String [] {"Item 1", "Item 2", "Item 2"});
//		combo3.setText ("combo3");
//	
//		Combo combo4 = new Combo (shell, SWT.NONE);
//		combo4.setItems (new String [] {"Item 1", "Item 2", "Item 2"});
//		combo4.setText ("combo4");
//	
//		Combo combo5 = new Combo (shell, SWT.NONE);
//		combo5.setItems (new String [] {"Item 1", "Item 2", "Item 2"});
//		combo5.setText ("combo5");
//	
//		Button button6 = new Button (shell, SWT.PUSH);
//		button6.setText ("button6");
//	
//		shell.pack ();
//		shell.open ();
//	
//		while (!shell.isDisposed ()) {
//			if (!display.readAndDispatch ())
//				display.sleep ();
//		}
//		display.dispose ();
//	
//	}



}

//public class MyLayout {
//	public static void main (String [] args) {
//	}
//}


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

//public class ThreadingView extends ViewPart {
//
//	/**
//	 * The ID of the view as specified by the extension.
//	 */
//	public static final String ID = "com.yanas.eclipse.threadingproject.ThreadingView";
//
//	private TableViewer viewer;
//	private Action action1;
//	private Action action2;
//	private Action doubleClickAction;
//
//	/*
//	 * The content provider class is responsible for
//	 * providing objects to the view. It can wrap
//	 * existing objects in adapters or simply return
//	 * objects as-is. These objects may be sensitive
//	 * to the current input of the view, or ignore
//	 * it and always show the same content 
//	 * (like Task List, for example).
//	 */
//	 
//	class ViewContentProvider implements IStructuredContentProvider {
//		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
//		}
//		public void dispose() {
//		}
//		public Object[] getElements(Object parent) {
//			return new String[] { "One", "Two", "Three" };
//		}
//	}
//	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
//		public String getColumnText(Object obj, int index) {
//			return getText(obj);
//		}
//		public Image getColumnImage(Object obj, int index) {
//			return getImage(obj);
//		}
//		public Image getImage(Object obj) {
//			return PlatformUI.getWorkbench().
//					getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
//		}
//	}
//	class NameSorter extends ViewerSorter {
//	}
//
//	/**
//	 * The constructor.
//	 */
//	public ThreadingView() {
//	}
//
//	/**
//	 * This is a callback that will allow us
//	 * to create the viewer and initialize it.
//	 */
//	public void createPartControl(Composite parent) {
//		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
//		viewer.setContentProvider(new ViewContentProvider());
//		viewer.setLabelProvider(new ViewLabelProvider());
//		viewer.setSorter(new NameSorter());
//		viewer.setInput(getViewSite());
//
//		// Create the help context id for the viewer's control
//		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "ThreadingProject.viewer");
//		makeActions();
//		hookContextMenu();
//		hookDoubleClickAction();
//		contributeToActionBars();
//	}
//
//	private void hookContextMenu() {
//		MenuManager menuMgr = new MenuManager("#PopupMenu");
//		menuMgr.setRemoveAllWhenShown(true);
//		menuMgr.addMenuListener(new IMenuListener() {
//			public void menuAboutToShow(IMenuManager manager) {
//				ThreadingView.this.fillContextMenu(manager);
//			}
//		});
//		Menu menu = menuMgr.createContextMenu(viewer.getControl());
//		viewer.getControl().setMenu(menu);
//		getSite().registerContextMenu(menuMgr, viewer);
//	}
//
//	private void contributeToActionBars() {
//		IActionBars bars = getViewSite().getActionBars();
//		fillLocalPullDown(bars.getMenuManager());
//		fillLocalToolBar(bars.getToolBarManager());
//	}
//
//	private void fillLocalPullDown(IMenuManager manager) {
//		manager.add(action1);
//		manager.add(new Separator());
//		manager.add(action2);
//	}
//
//	private void fillContextMenu(IMenuManager manager) {
//		manager.add(action1);
//		manager.add(action2);
//		// Other plug-ins can contribute there actions here
//		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
//	}
//	
//	private void fillLocalToolBar(IToolBarManager manager) {
//		manager.add(action1);
//		manager.add(action2);
//	}
//
//	private void makeActions() {
//		action1 = new Action() {
//			public void run() {
//				showMessage("Action 1 executed");
//			}
//		};
//		action1.setText("Action 1");
//		action1.setToolTipText("Action 1 tooltip");
//		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
//			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
//		
//		action2 = new Action() {
//			public void run() {
//				showMessage("Action 2 executed");
//			}
//		};
//		action2.setText("Action 2");
//		action2.setToolTipText("Action 2 tooltip");
//		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
//				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
//		doubleClickAction = new Action() {
//			public void run() {
//				ISelection selection = viewer.getSelection();
//				Object obj = ((IStructuredSelection)selection).getFirstElement();
//				showMessage("Double-click detected on "+obj.toString());
//			}
//		};
//	}
//
//	private void hookDoubleClickAction() {
//		viewer.addDoubleClickListener(new IDoubleClickListener() {
//			public void doubleClick(DoubleClickEvent event) {
//				doubleClickAction.run();
//			}
//		});
//	}
//	private void showMessage(String message) {
//		MessageDialog.openInformation(
//			viewer.getControl().getShell(),
//			"Threading View",
//			message);
//	}
//
//	/**
//	 * Passing the focus request to the viewer's control.
//	 */
//	public void setFocus() {
//		viewer.getControl().setFocus();
//	}
//}