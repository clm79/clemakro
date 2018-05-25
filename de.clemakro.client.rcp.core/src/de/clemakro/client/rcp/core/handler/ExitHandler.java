
package de.clemakro.client.rcp.core.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.widgets.Shell;

public class ExitHandler {
	@Execute
	public void execute(EPartService partService, IWorkbench workbench, Shell shell) {
		if (partService.saveAll(true)) {
			workbench.close();
		}
	}

}