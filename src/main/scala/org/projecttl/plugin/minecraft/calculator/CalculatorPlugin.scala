package org.projecttl.plugin.minecraft.calculator

import org.bukkit.ChatColor
import org.bukkit.configuration.file.{FileConfiguration, YamlConfiguration}
import org.bukkit.plugin.java.JavaPlugin

import java.io.File

class CalculatorPlugin extends JavaPlugin {

  private var file: File = _
  private var configuration: FileConfiguration = _

  override def onEnable(): Unit = {
    getLogger.info("Plugin has enabled.")

    getCommand("calculator").setExecutor(new CalculatingCommand(this))
    getCommand("calculator").setTabCompleter(new CalculatingArgument)
  }

  override def onDisable(): Unit = {
    getLogger.info("Plugin has disabled.")
  }

  def load(): Unit = {
    file = new File(getDataFolder, "result.yml")
    configuration = YamlConfiguration.loadConfiguration(file)

    try {
      if (!file.exists()) {
        configuration.save(file)
      }

      configuration.load(file)
    } catch {
      case exception: Exception => exception.printStackTrace()
    }
  }

  def save(): Unit = {
    try {
      configuration.save(file)
      println(s"<Calculator> ${ChatColor.GREEN}Config has successful saved!")
    } catch {
      case exception: Exception => exception.printStackTrace()
    }
  }

  def getResult: FileConfiguration = {
    configuration
  }
}
