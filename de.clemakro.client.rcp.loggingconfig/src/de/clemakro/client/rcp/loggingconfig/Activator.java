package de.clemakro.client.rcp.loggingconfig;

import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * 
 * @author clemens
 *
 */
public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	@Override
	public void start(BundleContext bundleContext) {
		configureLog4jInBundle(bundleContext.getBundle());
		Activator.context = bundleContext;
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		LogManager.shutdown();
	}

	private static void configureLog4jInBundle(Bundle bundle) {
		// this assumes that the logback.xml file is in the root of the bundle.
		final URL configFileUrl = FileLocator.find(bundle, new Path("log4j.properties"), null);
		PropertyConfigurator.configure(configFileUrl);

		Logger logger = Logger.getLogger(Activator.class);
		logger.info("Log4J configured");
	}

}
