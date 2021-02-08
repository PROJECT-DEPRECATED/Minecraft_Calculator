plugins {
    id("com.github.johnrengelman.shadow") version "6.1.0"
    scala
    java
    `maven-publish`
}

group = properties["group"]!!
version = properties["version"]!!

allprojects {
    repositories {
        jcenter()
        maven("https://jitpack.io")
    }
}

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    implementation("org.scala-lang:scala-library:2.11.1")
    compileOnly("com.destroystokyo.paper:paper-api:1.16.3-R0.1-SNAPSHOT")
    compileOnly("com.github.ProjectTL12345:Warp:2.3v")
}

tasks {
    javadoc {
        options.encoding = "UTF-8"
    }

    compileJava {
        options.encoding = "UTF-8"
    }

    compileScala {
        scalaCompileOptions.isOptimize = true
    }

    create<Jar>("sourceJar") {
        archiveClassifier.set("source")
        from(sourceSets["main"].allSource)
    }

    shadowJar {
        from("sourceJar")
    }
}

publishing {
    publications {
        create<MavenPublication>("Minecraft_Calculator") {
            artifact(tasks["sourceJar"])
            from(components["java"])
        }
    }
}