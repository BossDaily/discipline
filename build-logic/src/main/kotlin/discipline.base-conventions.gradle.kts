plugins {
    id("net.kyori.indra")
    id("net.kyori.indra.git")
    id("net.kyori.indra.checkstyle")
    id("net.kyori.indra.publishing")
    id("net.kyori.indra.license-header")
}

indra {
    gpl3OnlyLicense()

    javaVersions {
        target(11)
    }

    github(GITHUB_ORGANIZATION, GITHUB_REPO)
}

license {
    header.set(resources.text.fromFile(rootProject.file("LICENSE_HEADER")))
}

tasks {
    withType<JavaCompile> {
        // disable 'warning: No processor claimed any of these annotations' spam
        options.compilerArgs.add("-Xlint:-processing")
        options.compilerArgs.add("-parameters")
    }
}

dependencies {
    checkstyle(libs.stylecheck)
}
