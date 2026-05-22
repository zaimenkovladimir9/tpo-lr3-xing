plugins {
    java
}

group = "ru.tpo.lr3"
version = "1.0"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.27.0")
}

tasks.test {
    useJUnitPlatform()

    val browser = providers.gradleProperty("browser").orElse("chrome")
    val baseUrl = providers.gradleProperty("baseUrl").orElse("https://www.xing.com")
    val headed = providers.gradleProperty("headed").orElse("false")
    val chromeBinary = providers.gradleProperty("chromeBinary").orElse("")
    val firefoxBinary = providers.gradleProperty("firefoxBinary").orElse("")

    systemProperty("browser", browser.get())
    systemProperty("baseUrl", baseUrl.get())
    systemProperty("headed", headed.get())
    systemProperty("chrome.binary", chromeBinary.get())
    systemProperty("firefox.binary", firefoxBinary.get())

    testLogging {
        events("passed", "skipped", "failed")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.add("-Xlint:deprecation")
}
