/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.apache.mina.util;

import org.apache.mina.core.service.IoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A default {@link ExceptionMonitor} implementation that logs uncaught
 * exceptions using {@link Logger}.
 * <p>
 * All {@link IoService}s have this implementation as a default exception
 * monitor.
 *
 * @author The Apache MINA Project (dev@mina.apache.org)
 * @version $Rev: 678335 $, $Date: 2008-07-21 03:25:08 +0200 (lun, 21 jui 2008) $
 */
public class DefaultExceptionMonitor extends ExceptionMonitor {
    private final Logger log = LoggerFactory
            .getLogger(DefaultExceptionMonitor.class);

    @Override
    public void exceptionCaught(Throwable cause) {
        if (cause instanceof Error) {
            throw (Error) cause;
        } else {
            log.warn("Unexpected exception.", cause);
        }
    }
}