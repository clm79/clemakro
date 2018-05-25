package de.clemakro.client.rcp.loggingconfig;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		configureLogbackInBundle(bundleContext.getBundle());
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		final LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		final Logger logger = LoggerFactory.getLogger(Activator.class);
		logger.info("Stopping SLF4J Logging");
		context.stop();
		Activator.context = null;
	}

	private static void configureLogbackInBundle(Bundle bundle) throws JoranException, IOException {
		final LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
		final JoranConfigurator jc = new JoranConfigurator();
		jc.setContext(context);
		context.reset();

		// this assumes that the logback.xml file is in the root of the bundle.
		final URL logbackConfigFileUrl = FileLocator.find(bundle, new Path("logback.xml"), null);
		jc.doConfigure(logbackConfigFileUrl.openStream());

		final Logger logger = LoggerFactory.getLogger(Activator.class);
		logger.info("SLF4J Logging configured");
	}

}
