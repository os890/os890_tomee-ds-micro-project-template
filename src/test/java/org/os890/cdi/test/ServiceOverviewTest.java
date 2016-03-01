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
package org.os890.cdi.test;

import org.os890.cdi.ServiceOverview;
import org.apache.openejb.junit.jee.EJBContainerRule;
import org.apache.openejb.junit.jee.InjectRule;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;

public class ServiceOverviewTest {
    @ClassRule
    public static final EJBContainerRule CONTAINER_RULE = new EJBContainerRule();

    @Rule
    public final InjectRule injectRule = new InjectRule(this, CONTAINER_RULE);

    @Inject
    private ServiceOverview serviceOverview;

    @Test
    public void configLookup() {
        Assert.assertEquals("8080", this.serviceOverview.config("httpPort"));
    }
}
