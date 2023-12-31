package org.example.module.impl

import net.weavemc.loader.api.event.SubscribeEvent
import net.weavemc.loader.api.event.TickEvent
import org.example.module.Module
import org.example.setting.*
import org.lwjgl.input.Keyboard

class KillAura(
    private val blatantMode: ModeEntry = ModeEntry("Blatant", "Blatantly attacks entities around you"),
    private val silentMode: ModeEntry = ModeEntry("Silent", "Silently attacks entities around you"),
    private val mode: ModeSelectSetting = ModeSelectSetting("Mode", "Selection of Kill Aura modes",
        emptyArray(), blatantMode, arrayOf(
            blatantMode.name to blatantMode,
            silentMode.name to silentMode
        )
    ),
    private val aps: DoubleSliderSetting = DoubleSliderSetting("APS", "Attacks per second", emptyArray(),
        4.0, 20.0, 4.0, 20.0, 0.1
    ),
    private val range: SliderSetting = SliderSetting("Range", "Range in blocks for attacking", emptyArray(),
        1.0, 1.0, 6.0, 0.1
    ),
    private val smoothing: SliderSetting = SliderSetting("Smoothing", "Amount of smoothing for rotations", emptyArray(),
        0.0, 0.0, 10.0, 0.1
    ),
    private val switchInterval: SliderSetting = SliderSetting("Interval", "Interval at which targets will be switched in milliseconds",
        emptyArray(), 0.0, 0.0, 1000.0, 100.0
    ),
    private val switch: CheckboxSetting = CheckboxSetting("Switch", "Switch targets at a set rate",
        arrayOf(
            switchInterval
        )
    )
): Module(
    "KillAura",
    "Automatically attacks nearby entities",
    Keyboard.KEY_NONE,
    arrayOf(
        mode,
        aps,
        range,
        smoothing,
        switch,
    )
) {
    @SubscribeEvent
    fun onTick(event: TickEvent.Post) {
        when (mode.selected) {
            blatantMode -> {
                // blatant logic
            }
            silentMode -> {
                // silent logic
            }
        }
    }
}