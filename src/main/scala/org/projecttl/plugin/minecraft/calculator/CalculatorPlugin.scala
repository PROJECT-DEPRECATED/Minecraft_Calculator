package org.projecttl.plugin.minecraft.calculator

import org.bukkit.plugin.java.JavaPlugin

class CalculatorPlugin extends JavaPlugin {

  override def onEnable(): Unit = {
    getLogger.info("Plugin has enabled.")

    getCommand("calculator").setExecutor(new CalculatingCommand)
    getCommand("calculator").setTabCompleter(new CalculatingArgument)
  }

  override def onDisable(): Unit = {
    getLogger.info("Plugin has disabled.")
  }
}
