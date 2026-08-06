package com.yourname.configurablesplashes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.client.MinecraftClient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static ModConfig config = load();

    private static Path configPath() {
        Path configDir = MinecraftClient.getInstance().runDirectory.toPath().resolve("config");
        try {
            Files.createDirectories(configDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configDir.resolve("configurablesplashes.json");
    }

    public static ModConfig load() {
        Path path = configPath();
        try {
            if (Files.exists(path)) {
                ModConfig loaded = GSON.fromJson(Files.readString(path), ModConfig.class);
                if (loaded != null) {
                    return loaded;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ModConfig defaultConfig = new ModConfig();
        save(defaultConfig);
        return defaultConfig;
    }

    public static void save(ModConfig config) {
        try {
            Files.writeString(configPath(), GSON.toJson(config));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reload() {
        config = load();
    }
}