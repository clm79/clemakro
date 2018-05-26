 
package de.clemakro.client.rcp.atcvector.handler;

import org.apache.log4j.Logger;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class AtcTest1Handler {
	private final static Logger LOGGER = Logger.getLogger(AtcTest1Handler.class);
	@Execute
	public void execute(Shell parent) {
		LOGGER.debug("execute()");
		MessageDialog.openInformation(parent, "Info", "ATC Test 1");
	}
		
}