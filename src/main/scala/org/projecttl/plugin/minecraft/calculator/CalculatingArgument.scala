package org.projecttl.plugin.minecraft.calculator

import org.bukkit.command.{Command, CommandSender, TabCompleter}
import org.bukkit.entity.Player

import java.util

class CalculatingArgument extends TabCompleter {

  override def onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array[String]): util.List[String] = {
    if (sender.isInstanceOf[Player]) {

      if (args.length == 1) {
        val commandList = new util.ArrayList[String]
        commandList.add("plus")
        commandList.add("minus")
        commandList.add("multiplied")
        commandList.add("divide")
        commandList.add("bit_left")
        commandList.add("bit_right")

        return commandList
      }
    }

    null
  }
}
