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

import griffon.portal.auth.User

/**
 * @author Andres Almiray
 */
class Profile {
    String bio
    String gravatarEmail
    String website
    String twitter
    User user
    Notifications notifications = new Notifications()

    static belongsTo = User

    static embedded = ['notifications']

    static constraints = {
        bio(nullable: true, blank: false, maxSize: 1000)
        gravatarEmail(nullable: true, email: true)
        website(nullable: true, blank: false, url: true)
        twitter(nullable: true, blank: false)
    }

    String toString() {
        [
                id: id,
                gravatarEmail: gravatarEmail,
                website: website,
                twitter: twitter,
                bio: bio,
                user: user
        ]
    }
}

class Notifications {
    boolean watchlist = true
    boolean content = true
    boolean comments = true

    String toString() {
        [
                watchlist: watchlist,
                content: content,
                comments: comments
        ]
    }
}