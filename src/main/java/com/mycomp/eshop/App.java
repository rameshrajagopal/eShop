package com.mycomp.eshop;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * App which gives products details
 *
 */
public class App extends Application<Configuration> {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration conf, Environment env) throws Exception {
        LOG.info("Registering REST resources");

    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
