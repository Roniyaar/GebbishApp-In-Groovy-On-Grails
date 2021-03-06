grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
		mavenRepo "https://oss.sonatype.org/content/repositories/releases/"
        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
		
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        // runtime 'mysql:mysql-connector-java:5.1.24'
		// Geb functional test requirements
		test 'org.gebish:geb-spock:0.9.1'
		test 'org.seleniumhq.selenium:selenium-support:2.44.0'
		compile ('org.seleniumhq.selenium:selenium-firefox-driver:2.44.0') {
		//compile ('org.seleniumhq.selenium:selenium-htmlunit-driver:2.31.0'){
			exclude: 'xml-apis'
		}
		test 'org.spockframework:spock-grails-support:0.7-groovy-2.0'
		compile "org.gebish:geb-core:0.9.2"
		//compile "org.seleniumhq.selenium:selenium-support:2.26.0"
		//compile "org.gebish:geb-core:0.9.2"
		//org/grails/plugins/burning-image/0.5.1/burning-image-0.5.1.zip
    }

    plugins {
        // plugins for the build system only
        //build ":tomcat:7.0.47"
		  build ':tomcat:7.0.52.1'
		compile ":burning-image:0.5.1"
        // plugins for the compile step
        //compile ":scaffolding:2.0.1"
        //compile ':cache:1.1.1'
		compile ':scaffolding:2.1.0'
        compile ':cache:1.1.3'
        //compile ':asset-pipeline:1.8.3'

        // plugins needed at runtime but not for compilation
        //runtime ":hibernate:3.6.10.6" // or ":hibernate4:4.1.11.6"
        //runtime ":database-migration:1.3.8"
        //runtime ":jquery:1.10.2.2"
		runtime ':hibernate4:4.3.5.2' // or ':hibernate:3.6.10.14'
        runtime ':database-migration:1.4.0'
        runtime ':jquery:1.11.0.2'
       // runtime ":resources:1.2.1"
        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0.1"
        //runtime ":cached-resources:1.1"
        //runtime ":yui-minify-resources:0.1.5"
		// Required to build functional tests
		//test ':geb:0.9.2'
		/*test(':spock:0.7') {
			exclude 'spock-grails-support'
		}*/
		
		//compile "org.seleniumhq.selenium:selenium-chrome-driver:2.31.0"
    }
}
