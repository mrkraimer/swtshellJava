/**
 * Copyright - See the COPYRIGHT that is included with this distribution.
 * EPICS pvData is distributed subject to a Software License Agreement found
 * in file LICENSE that is included with this distribution.
 */
package org.epics.swtshell;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.epics.pvdata.misc.Executor;
import org.epics.pvdata.misc.ExecutorFactory;
import org.epics.pvdata.misc.RunnableReady;
import org.epics.pvdata.misc.ThreadCreate;
import org.epics.pvdata.misc.ThreadCreateFactory;
import org.epics.pvdata.misc.ThreadPriority;
import org.epics.pvdata.misc.ThreadReady;


/**
 * A GUI iocshell implemented via Eclipse SWT (Standard Widget Toolkit).
 * The iocshell itype filter texts executed in a low priority thread so that it has low priority.
 * @author mrk
 *
 */
public class SwtshellFactory {
    
    /**
     * Create a SWT (Standard Widget Toolkit) shell for a javaIOC.
     */
    public static void swtshell() {
//       new ThreadInstance();
       ThreadInstance.createGUI();	// NOTE: Mac OS X requires SWT to be run in main() thread
    }
    
    /**
     * Get an Executor that can be shared by swtshell objects.
     * @return A common executor for swtshell windows.
     */
    public static Executor getExecutor() {
        return executor;
    }
   
    static private ThreadCreate threadCreate = ThreadCreateFactory.getThreadCreate();
    static private Executor executor = ExecutorFactory.create("swtshell",ThreadPriority.low);

    static private class ThreadInstance implements RunnableReady {
        
        private ThreadInstance() {  
            threadCreate.create("swtshell", 2, this);
            
        } 
        /* (non-Javadoc)
         * @see org.epics.pvioc.util.RunnableReady#run(org.epics.pvioc.util.ThreadReady)
         */
        @Override
        public void run(ThreadReady threadReady) {
            threadReady.ready();
            createGUI();
        }
        
        public static void createGUI()
        {
            final Display display = new Display();
            Shell shell = new Shell(display);
            shell.setText("swtshell");
            GridLayout layout = new GridLayout();
            layout.numColumns = 1;
            layout.makeColumnsEqualWidth = true;
            shell.setLayout(layout);
            
            Button getFieldDB = new Button(shell,SWT.PUSH);
            getFieldDB.setText("getField");
            getFieldDB.addSelectionListener( new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    GetFieldFactory.init(display);
                }
            });
            
            Button processDB = new Button(shell,SWT.PUSH);
            processDB.setText("process");
            processDB.addSelectionListener( new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    ProcessFactory.init(display);
                }
            });
            Button getDB = new Button(shell,SWT.PUSH);
            getDB.setText("get");
            getDB.addSelectionListener( new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    GetFactory.init(display);
                }
            });
            Button putDB = new Button(shell,SWT.PUSH);
            putDB.setText("put");
            putDB.addSelectionListener( new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    PutFactory.init(display);
                }
            });
            Button putGetDB = new Button(shell,SWT.PUSH);
            putGetDB.setText("putGet");
            putGetDB.addSelectionListener( new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    PutGetFactory.init(display);
                }
            });
            Button channelRPCDB = new Button(shell,SWT.PUSH);
            channelRPCDB.setText("channelRPC");
            channelRPCDB.addSelectionListener( new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    ChannelRPCFactory.init(display);
                }
            });
            Button monitorDB = new Button(shell,SWT.PUSH);
            monitorDB.setText("monitor");
            monitorDB.addSelectionListener( new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    MonitorFactory.init(display);
                }
            });
            Button arrayDB = new Button(shell,SWT.PUSH);
            arrayDB.setText("scalarArray");
            arrayDB.addSelectionListener( new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    ScalarArrayFactory.init(display);
                }
            });
            Button structureArrayDB = new Button(shell,SWT.PUSH);
            structureArrayDB.setText("structureArray");
            structureArrayDB.addSelectionListener( new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    StructureArrayFactory.init(display);
                }
            });
            Button unionArrayDB = new Button(shell,SWT.PUSH);
            unionArrayDB.setText("unionArray");
            unionArrayDB.addSelectionListener( new SelectionAdapter() {
                public void widgetSelected(SelectionEvent e) {
                    UnionArrayFactory.init(display);
                }
            });
            shell.pack();
            shell.open();
            while(!shell.isDisposed()) {
                if(!display.readAndDispatch()) display.sleep();
            }
            display.dispose();
        }
    }
}

