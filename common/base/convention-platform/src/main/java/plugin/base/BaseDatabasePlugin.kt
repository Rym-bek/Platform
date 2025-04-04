package plugin.base

import kz.rymbek.platform.common.base.convention.applyPlugin
import kz.rymbek.platform.common.base.convention.implementation
import libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class BaseDatabasePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            applyPlugin(libs.plugins.convention.library)
            applyPlugin(libs.plugins.dependency.room)
            applyPlugin(libs.plugins.dependency.koin)

            dependencies {
                implementation(":common:base:database")
                implementation(":common:core:architecture")
                implementation(":common:business:converter")
                /**==============================================================================**/
                implementation(libs.kotlinx.datetime)
            }
        }
    }
}