package org.projecttl.plugin.minecraft.calculator

import org.bukkit.ChatColor
import org.bukkit.command.{Command, CommandExecutor, CommandSender}
import org.bukkit.entity.Player
import org.projecttl.plugin.minecraft.calculator.utils._

class CalculatingCommand extends CommandExecutor {

  override def onCommand(sender: CommandSender, command: Command, label: String, args: Array[String]): Boolean = {
    if (!sender.isInstanceOf[Player]) {
      sender.sendMessage(s"<Calculator>${ChatColor.RED} You're not player!")
    } else {
      val player = sender.asInstanceOf[Player]

      if (command.getName.equalsIgnoreCase("calculator")) {
        if (args.length == 0) {
          player.sendMessage(s"<Calculator>${ChatColor.GOLD} Arguments is null! Please type some arguments!")
          return false
        }

        else if (args.length > 0) {
          args(0) match {
            case "add" =>
              val firstResult = Integer.parseInt(args(1))
              val secondResult = Integer.parseInt(args(2))

              val add = new Add
              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}Add Result: ${ChatColor.GREEN}${add.onFunction(firstResult, secondResult)}")
              return true

            case "subtract" =>
              val firstResult = Integer.parseInt(args(1))
              val secondResult = Integer.parseInt(args(2))

              val subtract = new Subtract
              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}Subtract Result: ${ChatColor.GREEN}${subtract.onFunction(firstResult, secondResult)}")

              return true

            case "multiply" =>
              val firstResult = Integer.parseInt(args(1))
              val secondResult = Integer.parseInt(args(2))

              val multiply = new Multiply
              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}Multiply Result: ${ChatColor.GREEN}${multiply.onFunction(firstResult, secondResult)}")

              return true

            case "divide" =>
              val firstResult = Integer.parseInt(args(1))
              val secondResult = Integer.parseInt(args(2))

              val divide = new Divide
              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}Divide Result: ${ChatColor.GREEN}${divide.onFunction(firstResult, secondResult)}")

              return true

            case "remainder" =>
              val firstResult = Integer.parseInt(args(1))
              val secondResult = Integer.parseInt(args(2))

              val divideRemainder = new Divide
              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}Remainder Result: ${ChatColor.GREEN}${divideRemainder.onRemainderFunction(firstResult, secondResult)}")

              return true

            case "bit_left" =>
              val firstResult = Integer.parseInt(args(1))
              val secondResult = Integer.parseInt(args(2))

              val bitLeft = new BitLeft
              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}BitLeft Result: ${ChatColor.GREEN}${bitLeft.onFunction(firstResult, secondResult)}")

            case "bit_right" =>
              val firstResult = Integer.parseInt(args(1))
              val secondResult = Integer.parseInt(args(2))

              val bitRight = new BitRight
              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}BitRight Result: ${ChatColor.GREEN}${bitRight.onFunction(firstResult, secondResult)}")
          }
        }
      }
    }

    false
  }
}