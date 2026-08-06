package com.yourname.configurablesplashes;

import net.fabricmc.api.ClientModInitializer;

public class ConfigurableSplashesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ConfigManager.reload();
    }
}