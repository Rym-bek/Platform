package plugin.platform

import kz.rymbek.platform.common.base.convention.extensions.applyPlugin
import kz.rymbek.platform.common.base.convention.extensions.implementation
import kz.rymbek.platform.common.base.convention.extensions.platformLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class PlatformFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyPlugin(platformLibs.plugins.convention.library)
            applyPlugin(platformLibs.plugins.convention.library.compose)
            applyPlugin(platformLibs.plugins.dependency.koin)

            dependencies {
                implementation(":common:base:feature")
                implementation(":common:base:model")

                implementation(":common:core:validation")
                implementation(":common:core:navigation")
                implementation(":common:core:toast")
                implementation(":common:core:architecture")
                implementation(":common:core:date")
                implementation(":common:core:file")
                implementation(":common:core:design:compound")

                implementation(":common:business:model:global")
                /**==============================================================================**/
                // koinViewModel
                implementation(platformLibs.koin.androidx.compose)

                //coil
                implementation(platformLibs.coil.compose.core)
            }
        }
    }
}
