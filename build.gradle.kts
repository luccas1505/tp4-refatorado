plugins {
    id("java")
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.tp4refatorado"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {

    // --- SPRING ---
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    runtimeOnly("com.h2database:h2")

    // --- TESTES ---
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // Selenium (somente para testes)
    testImplementation("org.seleniumhq.selenium:selenium-java:4.20.0")

    // WebDriver Manager
    testImplementation("io.github.bonigarcia:webdrivermanager:5.8.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
