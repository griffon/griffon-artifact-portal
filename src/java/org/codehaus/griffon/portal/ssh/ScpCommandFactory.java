/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.codehaus.griffon.portal.ssh;

import org.apache.sshd.server.Command;
import org.apache.sshd.server.CommandFactory;
import org.codehaus.griffon.portal.api.ArtifactProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * This <code>CommandFactory</code> can be used as a standalone command factory
 * or can be used to augment another <code>CommandFactory</code> and provides
 * <code>SCP</code> support.
 *
 * @author <a href="mailto:dev@mina.apache.org">Apache MINA SSHD Project</a>
 * @see org.codehaus.griffon.portal.ssh.ScpCommand
 */
public class ScpCommandFactory implements CommandFactory {
    private final ArtifactProcessor artifactProcessor;
    private boolean notifications;
    private boolean email;
    private boolean twitter;

    public ScpCommandFactory(ArtifactProcessor artifactProcessor) {
        this.artifactProcessor = artifactProcessor;
    }

    /**
     * Parses a command string and verifies that the basic syntax is
     * correct. If parsing fails the responsibility is delegated to
     * the configured {@link CommandFactory} instance; if one exist.
     *
     * @param command command to parse
     * @return configured {@link Command} instance
     * @throws IllegalArgumentException
     */
    public Command createCommand(String command) {
        try {
            notifications = true;
            email = true;
            twitter = true;
            final ScpCommand scpCommand = new ScpCommand(splitCommandString(command), artifactProcessor);
            scpCommand.setNotifications(notifications);
            scpCommand.setEmail(email);
            scpCommand.setTwitter(twitter);
            return scpCommand;
        } catch (IllegalArgumentException iae) {
            throw iae;
        }
    }

    private String[] splitCommandString(String command) {
        if (!command.trim().startsWith("scp")) {
            throw new IllegalArgumentException("Unknown command, does not begin with 'scp'");
        }

        String[] args = command.split(" ");
        List<String> parts = new ArrayList<String>();
        parts.add(args[0]);
        for (int i = 1; i < args.length; i++) {
            String arg = args[i].trim();
            if (!arg.startsWith("-")) {
                parts.add(concatenateWithSpace(args, i));
                break;
            } else if ("-no-notifications".equals(arg)) {
                notifications = false;
            } else if ("-no-email".equals(arg)) {
                email = false;
            } else if ("-no-twitter".equals(arg)) {
                twitter = false;
            } else {
                parts.add(arg);
            }
        }
        return parts.toArray(new String[parts.size()]);
    }

    private String concatenateWithSpace(String[] args, int from) {
        StringBuilder sb = new StringBuilder();

        for (int i = from; i < args.length; i++) {
            sb.append(args[i] + " ");
        }
        return sb.toString().trim();
    }
}