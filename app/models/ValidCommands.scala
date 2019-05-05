package models

object ValidCommands extends  Enumeration {
  val validCommands = Set("ls /tmp")

  def isValidCommand(command : String): Boolean = {
    !command.isEmpty && validCommands.contains(command)
  }
}