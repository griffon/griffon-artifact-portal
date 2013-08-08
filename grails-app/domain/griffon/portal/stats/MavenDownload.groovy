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

package griffon.portal.stats

import griffon.portal.Release

/**
 * @author Andres Almiray
 */
class MavenDownload {
    Release release
    String filename
    Date dateCreated

    String userAgent
    String ipAddress

    static constraints = {
        release(nullable: false)
        filename(nullable: false, blank: false)
        userAgent(nullable: true, blank: true)
        ipAddress(nullable: true, blank: true)
    }
}