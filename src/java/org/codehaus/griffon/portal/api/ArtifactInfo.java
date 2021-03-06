/*
 * Copyright 2011-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codehaus.griffon.portal.api;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

/**
 * @author Andres Almiray
 */
public final class ArtifactInfo {
    private final ZipFile zipFile;
    private final File file;
    private final String artifactName;
    private final String artifactVersion;
    private final String username;
    private final boolean notifications;
    private final boolean email;
    private final boolean twitter;

    public ArtifactInfo(File file, String artifactName, String artifactVersion, String username) throws IOException {
        this(file, artifactName, artifactVersion, username, true, true, true);
    }

    public ArtifactInfo(File file, String artifactName, String artifactVersion, String username, boolean notifications, boolean email, boolean twitter) throws IOException {
        this.file = file;
        this.notifications = notifications;
        this.email = email;
        this.twitter = twitter;
        this.zipFile = new ZipFile(file);
        this.artifactVersion = artifactVersion;
        this.artifactName = artifactName;
        this.username = username;
    }

    public File getFile() {
        return file;
    }

    public ZipFile getZipFile() {
        return zipFile;
    }

    public String getArtifactName() {
        return artifactName;
    }

    public String getArtifactVersion() {
        return artifactVersion;
    }

    public String getUsername() {
        return username;
    }

    public boolean isEmail() {
        return email;
    }

    public boolean isNotifications() {
        return notifications;
    }

    public boolean isTwitter() {
        return twitter;
    }

    @Override
    public String toString() {
        return "ArtifactInfo{" +
                "artifactName='" + artifactName + '\'' +
                ", zipFile=" + zipFile +
                ", file=" + file +
                ", artifactVersion='" + artifactVersion + '\'' +
                ", username='" + username + '\'' +
                ", notifications='" + notifications + '\'' +
                ", email='" + email + '\'' +
                ", twitter='" + twitter + '\'' +
                '}';
    }
}
