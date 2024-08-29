package me.mraxetv.beasttokens.api;



public enum ActionType
{
  CONSOLE("[console_command]", "- '[console_command] <command with no slash>'"),
  PLAYERCOMMAND("[player_command]", "- '[player_command] <command with no slash>'");
  
  private final String identifier;
  
  private final String description;
  
  ActionType(String identifier, String description) {
    this.identifier = identifier;
    this.description = description;
  }


  
  public static ActionType getType(String s) {
    for (ActionType type : values()) {
      if (s.startsWith(type.getIdentifier()))
        return type; 
    } 
    return null;
  }

  
  public String getIdentifier() {
    return this.identifier;
  }
  
  public String getDescription() {
    return this.description;
  }
}
