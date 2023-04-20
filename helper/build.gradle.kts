repositories {
    mavenCentral()
    maven("https://maven.citizensnpcs.co/repo")
    maven("https://repo.spongepowered.org/maven")
    maven("https://repo.aikar.co/content/groups/aikar/")

}

dependencies {
    // shadow
    implementation("me.lucko:shadow-bukkit:1.19.3")

    // flowpowered math
    implementation("com.flowpowered:flow-math:1.0.3")

    // expiringmap
    implementation("net.jodah:expiringmap:0.5.10")

    implementation("co.aikar:acf-paper:0.5.1-SNAPSHOT")


    // configurate
    implementation("org.spongepowered:configurate-core:3.7.1") {
        exclude(group = "com.google.guava", module = "guava")
    }
    implementation("org.spongepowered:configurate-yaml:3.7.1") {
        exclude(group = "org.spongepowered", module = "configurate-core")
        exclude(group = "org.yaml", module = "snakeyaml")
    }
    implementation("org.spongepowered:configurate-gson:3.7.1") {
        exclude(group = "org.spongepowered", module = "configurate-core")
        exclude(group = "com.google.code.gson", module = "gson")
    }
    implementation("org.spongepowered:configurate-hocon:3.7.1") {
        exclude(group = "org.spongepowered", module = "configurate-core")
    }

    // text
    implementation("net.kyori:text-api:3.0.4") {
        exclude(group = "org.checkerframework", module = "checker-qual")
    }
    implementation("net.kyori:text-serializer-gson:3.0.4")
    implementation("net.kyori:text-serializer-legacy:3.0.4")
    implementation("net.kyori:text-feature-pagination:3.0.4")
    implementation("net.kyori:text-adapter-bukkit:3.0.6")
    // text legacy
    implementation("me.lucko:textlegacy:1.6.5")

    // event
    implementation("net.kyori:event-api:3.0.0")
    implementation("com.google.code.findbugs:jsr305:3.0.2")

    // protocollib
    compileOnly("com.comphenix.protocol:ProtocolLib:5.0.0-SNAPSHOT")

    // citizens
    compileOnly("net.citizensnpcs:citizens-main:2.0.30-SNAPSHOT") {
        exclude(group = "*", module = "*")
    }

    // viaversion
    compileOnly("us.myles:viaversion:2.1.3") {
        exclude(group = "*", module = "*")

    }
}