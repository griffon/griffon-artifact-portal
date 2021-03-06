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

package griffon.portal

import griffon.portal.values.Platform
import griffon.portal.values.Toolkit

/**
 * @author Andres Almiray
 */
class Plugin extends Artifact {
    static final String DEFAULT_GROUP = 'org.codehaus.griffon.plugins'

    String toolkits = ''
    String platforms = ''
    // String groupId = DEFAULT_GROUP
    boolean framework = false
    // boolean pomRuntime = false
    // boolean pomCompile = false
    // boolean pomTest = false

    static constraints = {
        // groupId(nullable: false)
        toolkits(nullable: false, blank: true)
        platforms(nullable: false, blank: true)
        framework(nullable: false)
    }

    void toolkits(List<Toolkit> values) {
        toolkits = values.collect([]) { it.name.toLowerCase() }.join(',')
    }

    void platforms(List<Platform> values) {
        platforms = values.collect([]) { it.name.toLowerCase() }.join(',')
    }

    String toString() {
        super.toString() + [
            // group: groupId,
            toolkits: toolkits,
            platforms: platforms,
            framework: framework
        ]
    }
}
