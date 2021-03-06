/**
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

package org.apache.openejb.jee.oejb2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for persistence-context-typeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="persistence-context-typeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="transaction-scoped"/>
 *     &lt;enumeration value="extended"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum PersistenceContextTypeType {

    @XmlEnumValue("transaction-scoped")
    TRANSACTION_SCOPED("transaction-scoped"),
    @XmlEnumValue("extended")
    EXTENDED("extended");
    private final String value;

    PersistenceContextTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PersistenceContextTypeType fromValue(String v) {
        for (PersistenceContextTypeType c: PersistenceContextTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
