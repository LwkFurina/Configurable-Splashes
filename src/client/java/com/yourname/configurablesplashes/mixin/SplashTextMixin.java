package com.yourname.configurablesplashes.mixin;

import com.yourname.configurablesplashes.ConfigManager;
import net.minecraft.client.gui.screen.SplashTextRenderer;
import net.minecraft.client.resource.SplashTextResourceSupplier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SplashTextResourceSupplier.class)
public class SplashTextMixin {

    @Inject(method = "get", at = @At("HEAD"), cancellable = true)
    private void configurableSplashes$overrideSplash(CallbackInfoReturnable<SplashTextRenderer> cir) {
        cir.setReturnValue(new SplashTextRenderer(ConfigManager.config.splashText));
    }
}