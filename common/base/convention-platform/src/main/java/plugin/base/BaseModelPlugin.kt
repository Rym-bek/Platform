package plugin.base

import kz.rymbek.platform.common.base.convention.applyPlugin
import kz.rymbek.platform.common.base.convention.implementation
import libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class BaseModelPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyPlugin(libs.plugins.convention.library)

            dependencies {
                implementation(":common:base:model")
                implementation(":common:core:architecture")
                implementation(":common:core:date")
            }
        }
    }
}