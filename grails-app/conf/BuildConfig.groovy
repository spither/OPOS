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
        mavenCentral()

        // uncomment these to enable remote dependency resolution from public Maven repositories
        //mavenCentral()
        //mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.16'
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime(":jquery:1.7.1") {
            exclude 'release'
        }
        runtime ":jquery-ui:1.8.15"
        runtime ":cache-headers:1.1.5"
        runtime ":resources:1.1.5"
        runtime ":cached-resources:1.0"
        runtime ":zipped-resources:1.0"
        runtime ":lesscss-resources:0.6.1"
        runtime ":twitter-bootstrap:1.4.0.14"
        runtime ":mail:1.0"
        runtime ":fixtures:1.1"
        runtime ":fields:1.0.4"

        compile ":spring-security-core:1.2.6"

        build ":tomcat:$grailsVersion"

        test ":build-test-data:1.1.2"
        test ":spock:0.6-SNAPSHOT"
    }
}
