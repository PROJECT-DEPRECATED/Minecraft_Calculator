package org.projecttl.plugin.minecraft.calculator.utils

import org.projecttl.plugin.minecraft.calculator.CalculatorPlugin

import java.util.Date

class SaveResult(plugin: CalculatorPlugin) {

  def saveResult(getNumber1: Int, getNumber2: Int, getResult: Int, getType: String): Unit = {
    val getDate: Date = new Date()
    var getCount = plugin.getResult.getInt("calculator.count")

    plugin.getResult.set(s"calculator.result.$getCount.formula.first", getNumber1)
    plugin.getResult.set(s"calculator.result.$getCount.formula.second", getNumber2)
    plugin.getResult.set(s"calculator.result.$getCount.formula.type", getType)

    plugin.getResult.set(s"calculator.result.$getCount.answer", getResult)
    plugin.getResult.set(s"calculator.result.$getCount.time", getDate.getTime)

    getCount += 1
    plugin.getResult.set("calculator.count", getCount)
  }
}
