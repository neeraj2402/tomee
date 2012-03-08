/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.openejb.config;

import org.apache.openejb.config.rules.Key;
import org.apache.openejb.config.rules.KeyType;
import org.apache.openejb.config.rules.Keys;
import org.apache.openejb.config.rules.ValidationRunner;
import org.apache.openejb.jee.EjbJar;
import org.apache.openejb.jee.ManagedBean;
import org.apache.openejb.jee.MessageDrivenBean;
import org.apache.openejb.jee.StatefulBean;
import org.apache.openejb.test.annotated.Green;
import org.apache.openejb.test.annotated.Red;
import org.apache.openejb.test.annotated.Yellow;
import org.apache.xbean.finder.AnnotationFinder;
import org.apache.xbean.finder.archive.ClassesArchive;
import org.junit.runner.RunWith;

@RunWith(ValidationRunner.class)
public class CheckAnnotationTest {

    @Keys({@Key(value = "annotation.invalid.stateful.webservice", type = KeyType.WARNING)})
    public AppModule testWebServiceWithStateful() {
        EjbJar ejbJar = new EjbJar();
        ejbJar.addEnterpriseBean(new StatefulBean(Green.class));
        EjbModule ejbModule = new EjbModule(ejbJar);
        ejbModule.setFinder(new AnnotationFinder(new ClassesArchive(Green.class)).link());

        AppModule appModule = new AppModule(ejbModule);
        return appModule;
    }

    @Keys({@Key(value = "annotation.invalid.messagedriven.webservice", type = KeyType.WARNING)})
    public AppModule testWebServiceWithMessageDriven() {
        EjbJar ejbJar = new EjbJar();
        ejbJar.addEnterpriseBean(new MessageDrivenBean(Yellow.class));
        EjbModule ejbModule = new EjbModule(ejbJar);
        ejbModule.setFinder(new AnnotationFinder(new ClassesArchive(Yellow.class)).link());

        AppModule appModule = new AppModule(ejbModule);
        return appModule;
    }


    @Keys({@Key(value = "annotation.invalid.managedbean.webservice", type = KeyType.WARNING)})
    public AppModule testWebServiceWithManagedBean() {
        EjbJar ejbJar = new EjbJar();
        ejbJar.addEnterpriseBean(new ManagedBean(Red.class));
        EjbModule ejbModule = new EjbModule(ejbJar);
        ejbModule.setFinder(new AnnotationFinder(new ClassesArchive(Red.class)).link());

        AppModule appModule = new AppModule(ejbModule);
        return appModule;
    }


}