package io.soffa.foundation.gradle.spring

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.springframework.boot.gradle.plugin.SpringBootPlugin

class SpringBootDependencyPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.dependencies {
            implementation(platform(SpringBootPlugin.BOM_COORDINATES))
            implementation(platform('org.springframework.cloud:spring-cloud-dependencies:2021.0.1'))
            // implementation platform('org.springframework.boot:spring-boot-dependencies:2.6.4')
            testImplementation("org.springframework.boot:spring-boot-starter-test") {
                exclude(group: "com.vaadin.external.google")
            }
        }

        project.test {
            useJUnitPlatform()
        }

        if (project.plugins.hasPlugin("kotlin")) {
            project.plugins.apply("kotlin-spring")
        }

    }


}