plugins {
    `java-library`
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "com.vertmix.supervisor"
version = "1.0-SNAPSHOT"

rootProject.extra["main"] = "${group}.${rootProject.name}.paper"
rootProject.extra["version"] = version

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}


repositories {
    mavenCentral()
    mavenLocal()

    maven("https://repo.aikar.co/content/groups/aikar/")

}
//
//dependencies {
//    implementation(project(":${rootProject.name}-paper", "shadow"))
//}


tasks.shadowJar {

    mergeServiceFiles()

//    fun reloc(vararg clazz: String) {
//        clazz.forEach { relocate(it, "${project.group}.${rootProject.name}.paper") }
//    }
//
//    project.subprojects.forEach {
//        val path = it.path.toString()
//        val relocationPath = "${project.group}.${project.name}.${path.split("-")[1]}"
//        reloc(relocationPath)
//    }
}



allprojects {
    apply(plugin = "java-library")
    apply(plugin = "com.github.johnrengelman.shadow")


    java {
        withSourcesJar()
        withJavadocJar()
    }

    repositories {
        mavenCentral()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://nexus.lucko.me/repository/maven-snapshots/")
        maven("https://nexus.lucko.me/repository/maven-releases/")
        maven("https://repo.lucko.me/")


    }

    dependencies {

        compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")

    }

    tasks {
        build {
            dependsOn(shadowJar)
        }
    }

    tasks.processResources {

        filesMatching("*.yml") {
            expand(rootProject.properties)
        }
    }


}