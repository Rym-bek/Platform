plugins {
    alias(platformLibs.plugins.convention.library)
    alias(platformLibs.plugins.convention.library.compose)

    //DI for snackbar
    alias(platformLibs.plugins.dependency.koin)
}

android {
    namespace = "kz.rymbek.platform.common.core.design.foundation"
}

dependencies {
    implementation(projects.platform.common.core.architecture)
    implementation(projects.platform.common.base.model)
    implementation(projects.platform.common.base.feature)
    implementation(projects.platform.common.core.date)

    implementation(projects.platform.common.business.model)

    //Coil
    implementation(platform(platformLibs.coil.bom))
    implementation(platformLibs.coil.compose)
    //Load images from network
    implementation(platformLibs.coil.network.ktor3)
    //Preview for video
    implementation(platformLibs.coil.video)

    implementation(platformLibs.androidx.paging.compose)

    api(platformLibs.androidx.compose.material3)
    implementation(platformLibs.androidx.compose.material3.navigation.suite)
    implementation(platformLibs.androidx.compose.material.iconsExtended)
}