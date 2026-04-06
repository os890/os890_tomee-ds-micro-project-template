/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.os890.cdi;

import org.apache.deltaspike.core.api.config.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import java.util.logging.Logger;

/**
 * Logs service metadata at application startup.
 *
 * <p>Observes the {@link Initialized} event for {@link ApplicationScoped}
 * and prints the service name, version, and URL to the JUL logger.</p>
 */
public class StartupLogger {
    private static final Logger LOG = Logger.getLogger(StartupLogger.class.getName());

    @Inject
    @ConfigProperty(name = "serviceName")
    private String serviceName;

    @Inject
    @ConfigProperty(name = "serviceVersion")
    private String serviceVersion;

    @Inject
    @ConfigProperty(name = "serviceRoot")
    private String serviceRoot;

    @Inject
    @ConfigProperty(name = "httpPort")
    private Integer httpPort;

    /**
     * Called when the application scope is initialized.
     *
     * @param startupEvent the CDI lifecycle event
     */
    public void onStartup(@Observes @Initialized(ApplicationScoped.class) Object startupEvent) {
        LOG.info("service '" + serviceName + "' started in version " + this.serviceVersion + "");
        LOG.info("info-page at http://localhost:" + httpPort + "/" + this.serviceRoot + "");
    }
}
