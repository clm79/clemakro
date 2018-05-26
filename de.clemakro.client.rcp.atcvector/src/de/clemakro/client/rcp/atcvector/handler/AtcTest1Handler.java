 
package de.clemakro.client.rcp.atcvector.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class AtcTest1Handler {
	@Execute
	public void execute(Shell parent) {
		MessageDialog.openInformation(parent, "Info", "ATC Test 1");
	}
		
}