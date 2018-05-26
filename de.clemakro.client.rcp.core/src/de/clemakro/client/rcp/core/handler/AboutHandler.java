
package de.clemakro.client.rcp.core.handler;

import org.apache.log4j.Logger;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class AboutHandler {
	private final static Logger LOGGER = Logger.getLogger(AboutHandler.class);
	@Execute
	public void execute(Shell shell) {
		LOGGER.debug("execute()");
		//TODO load/show dialog by id from application model
		MessageDialog.openInformation(shell, "About", "About Message");
	}

}