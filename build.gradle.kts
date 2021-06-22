
group = "com.sidemash"
version = "1.0.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.3.61"
    //kotlin("multiplatform") version "1.4.31"
    id("maven-publish")
    id("signing")

}


repositories {
    //jcenter()
    mavenCentral()
    gradlePluginPortal() // To use 'maven-publish' and 'signing' plugins in our own plugin
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.fasterxml.jackson.core:jackson-core:2.11.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.11.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.11.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.1")
}

val sonatypeUsername: String? = System.getenv("SONATYPE_USERNAME")
val sonatypePassword: String? = System.getenv("SONATYPE_PASSWORD")
val repositoryId: String? = System.getenv("SONATYPE_REPOSITORY_ID")

// Empty javadoc
val javadocJar = tasks.register("javadocJar", Jar::class.java) {
    archiveClassifier.set("javadoc")
}

publishing {
    publications {
        repositories {
            maven {
                name="oss"
                val releasesRepoUrl = uri("https://oss.sonatype.org/service/local/staging/deployByRepositoryId/$repositoryId/")
                val snapshotsRepoUrl = uri("https://oss.sonatype.org/content/repositories/snapshots/")
                url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
                credentials {
                    username = sonatypeUsername
                    password = sonatypePassword
                }
            }
        }
        withType<MavenPublication> {
            artifact(javadocJar)
            pom {
                name.set("sdk-kotlin")
                description.set("The Official Sidemash Cloud SDK for Kotlin")
                licenses {
                    license {
                        name.set("Apache-2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0")
                    }
                }
                url.set("http://sidemash.com")
//                issueManagement {
//                    system.set("Github")
//                    url.set("https://github.com/Kodein-Framework/Kodein-DI/issues")
//                }
                scm {
                    connection.set("https://github.com/sidemash/sdk-kotlin.git")
                    url.set("https://github.com/sidemash/sdk-kotlin")
                }
                developers {
                    developer {
                        id.set("sidemash")
                        name.set("Sidemash Cloud")
                        email.set("opensource@sidemash.com")
                    }
                }
            }
        }
    }

}
signing {
    useInMemoryPgpKeys(
        System.getenv("GPG_PRIVATE_KEY"),
        System.getenv("GPG_PRIVATE_PASSWORD")
    )
    sign(publishing.publications)
}