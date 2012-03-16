grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        grailsRepo("http://svn.codehaus.org/grails-plugins", "grailsCore2")
        mavenCentral()
    }
    dependencies {
        compile 'org.apache.mina:mina-core:2.0.4',
                'org.apache.sshd:sshd-core:0.6.0',
                'org.apache.sshd:sshd-pam:0.6.0'
        compile('org.codehaus.griffon:griffon-rt:0.9.5-rc2',
                'org.codehaus.griffon:griffon-cli:0.9.5-rc2') {
            transitive = false
        }
        runtime 'postgresql:postgresql:9.0-801.jdbc4'
    }

    plugins {
        test    ":code-coverage:1.2.4",
                ":spock:0.6"
        compile ":hibernate:$grailsVersion",
                ":jquery:1.7",
                ":resources:1.1.3",
                ":avatar:0.5.2",
                ":commentable:0.8.1",
                ":email-confirmation:1.0.5",
                ":executor:0.3",
                ":jcaptcha:1.2.1",
                ":mail:1.0",
                ":markdown:1.0.0.RC1",
                ":quartz:0.4.2",
                ":rateable:0.7.0",
                ":taggable:1.0.1",
                ":twitter-bootstrap:1.4.0.12",
                ":twitter4j:0.2",
                ":webxml:1.3.1",
                ":yui:2.8.2.1",
                ":yui-minify-resources:0.1.4",
                ":zipped-resources:1.0",
                ":cached-resources:1.0",
                ":cache-headers:1.1.5"

        build ":tomcat:$grailsVersion"
    }
}
