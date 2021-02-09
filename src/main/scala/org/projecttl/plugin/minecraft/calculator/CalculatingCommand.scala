package org.projecttl.plugin.minecraft.calculator

import org.bukkit.ChatColor
import org.bukkit.command.{Command, CommandExecutor, CommandSender}
import org.bukkit.entity.Player
import org.projecttl.plugin.minecraft.calculator.utils._

class CalculatingCommand(plugin: CalculatorPlugin) extends CommandExecutor {

  override def onCommand(sender: CommandSender, command: Command, label: String, args: Array[String]): Boolean = {
    if (!sender.isInstanceOf[Player]) {
      sender.sendMessage(s"<Calculator>${ChatColor.RED} You're not player!")
    } else {
      val player = sender.asInstanceOf[Player]
      val saveResult = new SaveResult(plugin)

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
              val result = add.onFunction(firstResult, secondResult)

              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}Add Result: ${ChatColor.GREEN}$result")
              saveResult.saveResult(firstResult, secondResult, result, "add")

              return true

            case "subtract" =>
              val firstResult = Integer.parseInt(args(1))
              val secondResult = Integer.parseInt(args(2))

              val subtract = new Subtract
              val result = subtract.onFunction(firstResult, secondResult)

              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}Subtract Result: ${ChatColor.GREEN}$result")
              saveResult.saveResult(firstResult, secondResult, result, "subtract")

              return true

            case "multiply" =>
              val firstResult = Integer.parseInt(args(1))
              val secondResult = Integer.parseInt(args(2))

              val multiply = new Multiply
              val result = multiply.onFunction(firstResult, secondResult)

              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}Multiply Result: ${ChatColor.GREEN}$result")
              saveResult.saveResult(firstResult, secondResult, result, "multiply")

              return true

            case "divide" =>
              val firstResult = Integer.parseInt(args(1))
              val secondResult = Integer.parseInt(args(2))

              val divide = new Divide
              val result = divide.onFunction(firstResult, secondResult)

              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}Divide Result: ${ChatColor.GREEN}$result")
              saveResult.saveResult(firstResult, secondResult, result, "divide")

              return true

            case "remainder" =>
              val firstResult = Integer.parseInt(args(1))
              val secondResult = Integer.parseInt(args(2))

              val divideRemainder = new Divide
              val result = divideRemainder.onFunction(firstResult, secondResult)

              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}Remainder Result: ${ChatColor.GREEN}$result")
              saveResult.saveResult(firstResult, secondResult, result, "remainder")

              return true

            case "bit_left" =>
              val firstResult = Integer.parseInt(args(1))
              val secondResult = Integer.parseInt(args(2))

              val bitLeft = new BitLeft
              val result = bitLeft.onFunction(firstResult, secondResult)

              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}BitLeft Result: ${ChatColor.GREEN}$result")
              saveResult.saveResult(firstResult, secondResult, result, "bit_left")

              return true

            case "bit_right" =>
              val firstResult = Integer.parseInt(args(1))
              val secondResult = Integer.parseInt(args(2))

              val bitRight = new BitRight
              val result = bitRight.onFunction(firstResult, secondResult)

              player.sendMessage(s"${ChatColor.LIGHT_PURPLE}BitRight Result: ${ChatColor.GREEN}$result")
              saveResult.saveResult(firstResult, secondResult, result, "bit_right")

              return true
          }
        }
      }
    }

    false
  }
}